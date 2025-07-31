### What is jdbcTemplate
- JdbcTemplate is a Spring-provided helper class that simplifies JDBC operations by managing resource cleanup, exception translation, and parameter handling while letting you execute SQL directly in a clean, consistent way.
- Reduces boilerplate code while working with relational databases.

**Why is JdbcTemplate needed?**
- Using plain JDBC, you typically need to: Get a database connection ,Create statements,Handle SQL exceptions, Close connections, statements, and result sets in finally blocks.
- Simplifies CRUD operations: update() for INSERT, UPDATE, DELETE . query() for SELECT operations. queryForObject() to fetch single results. batchUpdate() for batch inserts/updates.

**Does JdbcTemplate manage transactions?**
- No, JdbcTemplate itself does not manage transactions.
- It participates in transactions managed by: Spring’s @Transactional
- Programmatic transaction management via PlatformTransactionManager.
- When you annotate your method with @Transactional, Spring manages transaction boundaries, and JdbcTemplate uses the same connection within that transaction.

### What is Transaction
- A transaction is a logical unit of work ensuring ACID properties, so either all database operations succeed together, maintaining consistency, or all fail without partial updates, preserving integrity.

**What happens when you annotate a method with @Transactional?**
- At method entry:
- Spring AOP proxy intercepts the method call (using JDK dynamic proxies or CGLIB).
- It checks your @Transactional settings (propagation, isolation, readOnly, etc.).
- Calls:
  ```TransactionStatus status = transactionManager.getTransaction(transactionDefinition);```

- Fetches a database connection from your DataSource.
- Sets autoCommit = false on the connection.
- Begins a transaction in the database.

**Now your JDBC or JdbcTemplate operations execute within this transactional connection.**
- During method execution:
- You perform inserts/updates/queries.
- The operations execute within the same connection and transactional context.

**At method exit:**
- If no unchecked (RuntimeException) or Error is thrown:
- The AOP proxy calls:
- transactionManager.commit(status);

```Calls connection.commit() on the underlying JDBC connection.```
- Returns the connection to the pool with autoCommit=true restored.

**Your data changes are now permanently saved in the database.**
- If an exception occurs:
- If an unchecked (RuntimeException) or Error is thrown:
- The proxy calls:
  ```transactionManager.rollback(status);```

- Calls connection.rollback(), discarding all changes made during the transaction.
- Returns the connection to the pool.
- Your data changes are NOT persisted in the database.




**What is @Bean**
- @Bean marks a method as a factory for creating and configuring a Spring-managed object (a "bean").
- The object returned by this method will be registered in the Spring application context.

**Method-Level Annotation:**
- Unlike annotations like @Component, @Service, or @Repository which are class-level annotations used for component scanning, @Bean is applied at the method level.
- This gives you explicit control over how a specific object is instantiated and configured.

**Difference from Stereotype Annotations:**
- Stereotype annotations in Spring, such as @Component, @Service, @Repository, and @Controller, are used for component scanning and auto-detection of beans.
- When a class is annotated with a stereotype annotation, Spring automatically detects it during component scanning and registers an instance of that class as a bean in the container.

### 1) Without @Bean, we were using stereotype annotations. Can't we achieve the same thing just using stereotype annotations here?

- No. Stereotype annotations are for layered components (DAO, Service, Controller) allowing Spring to auto-scan and inject dependencies.
- @Bean methods are required for creating and configuring objects like JdbcTemplate, DataSource,
- And TransactionManager, where you need to pass constructor arguments and configurations explicitly.

**2 )who handles rollback after an exception**
- the Spring Framework's transaction management infrastructure handles rollbacks after an exception, with @Transactional annotation.

**Here's how it works:**
- @Transactional Annotation:
- When a method or class is annotated with @Transactional, Spring creates a proxy around it.
- This proxy manages the transaction lifecycle.

**Exception Detection:**
- If an exception occurs within the transactional method:
- Runtime Exceptions (Unchecked Exceptions): By default, Spring's transaction infrastructure automatically marks the transaction for rollback if a RuntimeException (or any of its subclasses) or an Error occurs.
- This is because runtime exceptions typically indicate unrecoverable error conditions.
- Checked Exceptions: By default, checked exceptions do not trigger an automatic rollback.
- If you want a checked exception to cause a rollback, you must explicitly configure it using the rollbackFor attribute of the @Transactional annotation.

**Rollback Execution:**
- If the transaction is marked for rollback, the transaction manager performs the rollback operation, ensuring that all database changes made within that transaction are undone.

**3). Who handles commit when no failure occurs?**

- Spring’s **PlatformTransactionManager** automatically calls commit() on the underlying JDBC connection when a @Transactional method completes without exceptions, ensuring your database changes are persisted without requiring explicit commit calls in your business logic.

**6) How does MySQL commit and rollback work?**

- **START TRANSACTION or BEGIN:**

- MySQL starts a new transaction.
- Changes made are visible only to the current session until committed.

**During the transaction:**

- Data modifications (INSERT, UPDATE, DELETE) are logged in the redo log and the undo log:
- Redo log for ensuring durability.
- Undo log for supporting rollback and consistent reads.
- Changes are not visible to other sessions depending on the isolation level (e.g., READ COMMITTED, REPEATABLE READ).

**On COMMIT:**

- MySQL: Flushes redo logs to disk to ensure durability.
- Deletes corresponding undo logs.
- Releases any row/table locks held during the transaction.
- Changes become permanently visible to all other sessions.

**On ROLLBACK:**

- MySQL: Uses the undo log to restore the previous state of rows.
- Discards changes made during the transaction.
- Releases any row/table locks held during the transaction.

### What is Propagation (Controls when and where transactions start and join) in Transaction Management?
- Propagation defines how a transactional method should behave when it is called by another transactional method.
- It determines: Whether the method should run in an existing transaction, Or create a new transaction, Or execute non-transactionally even if the caller has a transaction.
- Propagation in transactions defines how methods interact with existing transactions when invoked.
- It allows control over whether a method should join the caller’s transaction, create a new one, or run without a transaction, enabling fine-grained transactional behavior across layered architectures.

**Why is propagation needed?**
- In layered applications:
- Service methods often call other service/DAO methods.
- You need control over transaction boundaries:
- Should all operations participate in the same transaction?
- Should inner operations run in their own independent transactions (committing/rolling back independently)?
- Should some methods run outside transactions for performance?
- Propagation levels give you this control declaratively.

### 7) Difference between `REQUIRED` and `REQUIRES_NEW`

**What is Propagation.REQUIRED?**
- Joins the existing transaction if one exists.
- If there is no existing transaction, it creates a new transaction.
- All operations execute within the same transaction boundary.

**Behavior:**
- If the outer transaction commits, all changes persist.
- If the outer transaction rolls back, all changes, including those in the inner method, roll back.

**Use case:**
- When all operations should succeed or fail as a single unit.

**What is Propagation.REQUIRES_NEW?**
- Suspends any existing transaction.
- Always creates a new, independent transaction for the method.
- The inner transaction commits or rolls back independently of the outer transaction.

**Behavior:**
- If the inner (REQUIRES_NEW) transaction commits but the outer transaction rolls back, the inner changes remain in the DB.
- If the inner transaction throws an exception, it rolls back, but this does not affect the outer transaction (unless you rethrow the exception).

**Use case:**
- When a part of your workflow must commit even if the outer transaction fails.

**Example:**
- Sending out notifications after a critical update, regardless of the outer transaction’s fate.

### What is Isolation (Controls how transactions interact with each other)
- Isolation in transactions defines how concurrent transactions interact and whether they can see each other’s intermediate changes.
- It helps prevent problems like dirty reads, non-repeatable reads, and phantom reads.
- SQL provides four isolation levels — READ UNCOMMITTED, READ COMMITTED, REPEATABLE READ, and SERIALIZABLE — each providing different levels of consistency and concurrency trade-offs.
- It is the “I” in ACID (Atomicity, Consistency, Isolation, Durability).
- It controls concurrency behavior to prevent: Dirty reads, Non-repeatable reads ,Phantom reads.

**Why is Isolation needed?**
- In multi-user systems, multiple transactions may:
- Read the same data simultaneously.
- Update the same rows simultaneously.
- Isolation ensures consistency while allowing concurrency by managing:
- When a transaction can see changes made by others.
- When locks are held and on what data.

### 8) How isolation and propagation control transactions
- Isolation in transactions controls how and when the changes of one transaction become visible to others, ensuring data consistency during concurrency.
- Propagation controls how transactions behave across method calls, defining whether methods should join existing transactions, create new ones, or execute without transactions.
- Together, isolation and propagation control the consistency, concurrency, and structure of transactions in layered applications.

### What is two phase commit process
- The two-phase commit (2PC) process is a distributed algorithm that ensures atomicity in distributed transactions.
- It guarantees that either all participating systems in a transaction commit their changes, or none do, preventing inconsistencies.
- The process involves two distinct phases: prepare and commit, coordinated by a central "coordinator" node.

**1. Prepare Phase:**
- The coordinator sends a "prepare" request to all participating nodes (also known as resource managers or participants).
- Each participant attempts to prepare for the transaction by validating the changes and making them durable (e.g., writing to a transaction log).
- If a participant successfully prepares, it sends a "ready" or "vote-commit" message back to the coordinator.
- If a participant cannot prepare (e.g., due to an error or resource conflict), it sends an "abort" or "vote-abort" message.
  **2. Commit Phase:**
- If the coordinator receives "ready" messages from all participants, it initiates the commit phase by sending a "commit" request to all participants.
- Each participant then permanently applies the changes to its local data and acknowledges the commit to the coordinator.
- If the coordinator receives even one "abort" message during the prepare phase, or if it times out waiting for responses, it initiates an "abort" phase by sending an "abort" request to all participants.
- Participants then discard any partial changes and undo any locks they may have acquired.

**spring transaction management flow with jdbctemplate.**

![Image](https://github.com/user-attachments/assets/b3b617dd-aec3-43a6-9285-fb72599b5d2f)

