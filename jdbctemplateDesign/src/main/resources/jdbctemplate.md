# Spring JdbcTemplate and Transaction Management 

## What is JdbcTemplate?

JdbcTemplate is a core Spring class for simplifying JDBC operations, removing boilerplate code like connection handling, statement creation, and result set iteration.

### Common JdbcTemplate Methods:

* `query()`: Executes a SQL query and maps ResultSet rows to objects.
* `queryForObject()`: Executes a SQL query expected to return a single object.
* `update()`: Executes insert, update, or delete operations.
* `batchUpdate()`: Executes batch updates for performance.

**Implementation:**
Injected as a Spring bean using:

```java
@Bean
public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
}
```

---

## What is a Transaction?

A transaction is a sequence of operations performed as a single logical unit of work. It ensures:

* **Atomicity:** All operations complete, or none do.
* **Consistency:** Data remains consistent.
* **Isolation:** Concurrent transactions do not interfere.
* **Durability:** Changes persist after commit.

### Transaction Control in Spring:

* Managed using `@Transactional` annotation.
* Managed under the hood using `PlatformTransactionManager`.

### Methods in `PlatformTransactionManager`:

* `getTransaction()`: Starts a transaction.
* `commit()`: Commits a transaction.
* `rollback()`: Rolls back a transaction.

Spring automatically calls these based on method success or failure.

---

## 2. Why `@Bean` was used?

* `@Bean` is used to register **infrastructure beans**:

    * `DataSource`: Configures DB URL, credentials, pooling.
    * `JdbcTemplate`: Executes SQL queries.
    * `PlatformTransactionManager`: Manages transaction boundaries for `@Transactional`.
* **Cannot use stereotype annotations (`@Component`, `@Service`, `@Repository`) for these since they  used for object creation inside configuration classes rather than for layered component scanning.**

## Without @Bean, we were using stereotype annotations. Can't we achieve the same thing just using stereotype annotations here?

- No. Stereotype annotations are for layered components (DAO, Service, Controller) allowing Spring to auto-scan and inject dependencies.
- @Bean methods are required for creating and configuring objects like JdbcTemplate, DataSource, 
- And TransactionManager, where you need to pass constructor arguments and configurations explicitly.

## 3. Why Stereotype Annotations (`@Service`, `@Repository`)?

Used for **layered beans (DAO, Service, Controller)** allowing Spring to auto-scan and inject dependencies, maintaining clean architecture and loose coupling.

## 4. Who handles rollback after an exception?

* Spring's **Transaction Management** handles rollback automatically:

    * On encountering an **unchecked exception (`RuntimeException`) inside a `@Transactional` method**, Spring **automatically rolls back** the transaction.
    * You do **not need manual rollback code**.

## 5. Who handles commit when no failure occurs?

* Spring's Transaction Manager **automatically commits** the transaction when:

    * `@Transactional` method **executes fully without exceptions**.

## 6. How does MySQL commit and rollback work?

* MySQL (InnoDB) transactions:

    * **Start Transaction:** `SET autocommit=0` or `START TRANSACTION;`
    * Operations (INSERT, UPDATE, DELETE) are staged.
    * `COMMIT`: Saves changes.
    * `ROLLBACK`: Discards changes.
* Spring manages these calls under the hood using `DataSourceTransactionManager`.
  - Calls connection.setAutoCommit(false) to start the transaction.
  - Calls commit() or rollback() automatically.

## 7. Difference between `REQUIRED` and `REQUIRES_NEW`

* **`REQUIRED`:**

    * Joins the existing transaction if available, else creates a new one.
    * If any method in the transaction fails, **everything is rolled back**.
* **`REQUIRES_NEW`:**

    * **Suspends any existing transaction and starts a new independent transaction.**
    * Rollback in this transaction **does not affect the outer transaction**.

## 8. How isolation and propagation control transactions

* **Propagation:** Controls *transaction participation across method calls*:

    * E.g., `REQUIRED`, `REQUIRES_NEW`, `NESTED`.
* **Isolation:** Controls *data consistency and visibility across concurrent transactions*:

    * E.g., `READ_COMMITTED`, `REPEATABLE_READ`, `SERIALIZABLE`.

Together, they ensure safe concurrent access and proper transactional boundaries.

## 9. Why Transaction Manager is used?

* `PlatformTransactionManager` is essential for:

    * Starting, committing, and rolling back transactions.
    * Working with `@Transactional` annotations, ensuring Spring correctly handles transactions for `JdbcTemplate` operations.

Without it, Spring cannot manage transactional boundaries in non-Spring Boot setups.

## 10. Rollback Explanation

* **Rollback = undo all DB operations done in the current transaction.**
* Triggered when an exception occurs inside `@Transactional`.
* Ensures **data consistency and prevents partial updates.**

## 11. Flow Summary with Commit and Rollback

### Commit:

* Transaction starts.
* Operations execute successfully.
* Spring commits automatically.
* Changes persist.

### Rollback:

* Transaction starts.
* An exception occurs during operations.
* Spring rolls back automatically.
* Changes are discarded.
.
 **Apply correct isolation level:** Default (`READ_COMMITTED`) is often enough but adjust if you face concurrency issues.
 **Use `REQUIRES_NEW` carefully:** Only when you need independent commits (e.g., logging/audit during failures).

---

# Spring Transaction Management: Key Concepts README

##  Difference between `commit` and `rollback`

 **`commit`**: Finalizes and permanently saves all changes made in the current transaction to the database.

 **`rollback`**: Undoes all changes made in the current transaction, returning the database to its previous state before the transaction began.

---

##  What is propagation in Spring?

 Propagation defines how transactions behave when a method annotated with `@Transactional` calls another `@Transactional` method.

**Key propagation types:**

* **`REQUIRED` (default):** Joins an existing transaction if available; else creates a new one.
* **`REQUIRES_NEW`:** Always suspends any existing transaction and starts a new independent transaction.
* **`NESTED`:** Creates a nested transaction within the existing one, allowing partial rollbacks.

---

##  What is isolation?

 Isolation controls how transactions interact with each other, particularly regarding visibility of data changes made by other transactions before committing.

**Common isolation levels:**

* **`READ_UNCOMMITTED`**: Can see uncommitted changes (dirty reads allowed).
* **`READ_COMMITTED`** (default in many DBs): Only sees committed data.
* **`REPEATABLE_READ`**: Ensures the same rows remain consistent during a transaction.
* **`SERIALIZABLE`**: Highest isolation, fully isolates transactions but with lower concurrency.

---

##  What happens if an exception occurs in a `@Transactional` method?

 By default, Spring **automatically rolls back the transaction if an unchecked exception (`RuntimeException` or `Error`) is thrown** within a `@Transactional` method.

 If a checked exception occurs, Spring does not roll back automatically unless explicitly configured using `rollbackFor` in `@Transactional`.

---

##  How to handle independent transactions inside an existing transaction?

 Use:

```java
@Transactional(propagation = Propagation.REQUIRES_NEW)
```

 This:

* Suspends the outer transaction.
* Starts a new, independent transaction for the inner method.
* Commits/rolls back the inner transaction independently without affecting the outer transaction.

**Use cases:**

* Logging actions to a table even if the main transaction fails.
* Sending out email notifications within a transaction.

---

##  Can `JdbcTemplate` handle transactions itself?

  - No.

 `JdbcTemplate` only simplifies JDBC operations but **does not manage transactions**.

 Transaction management is handled by Spring’s `PlatformTransactionManager`, which:

* Begins transactions.
* Commits on success.
* Rolls back on failure.

When using `@Transactional`, Spring manages these automatically around your `JdbcTemplate` operations.

---

##  Why use `JdbcTemplate`?

 To **reduce boilerplate JDBC code** and focus on SQL and data mapping.

 **Benefits:**

* Automatic connection/resource management.
* Cleaner, readable, maintainable code.
* Easier exception translation (`DataAccessException` hierarchy).

 It integrates seamlessly with Spring’s transaction management for **clean, production-grade data access layers in Spring applications**.

---


---

**spring transaction management flow with jdbctemplate.**

![Image](https://github.com/user-attachments/assets/b3b617dd-aec3-43a6-9285-fb72599b5d2f)


**Explanation of Each Block:**
- **START**: Transactional Method Call
- User or framework invokes your service method.

**Is @Transactional present?**

- Yes: Spring AOP intercepts and manages the transaction.
- No: Executes normally with no transaction.

**Spring AOP intercepts call**
- Spring prepares to manage transaction boundaries using PlatformTransactionManager.

**Begin transaction**

- Acquires DB connection from the pool.
- Sets auto-commit = false to control commit/rollback manually.

**Execute business logic with JdbcTemplate**
- Your service executes insert/update/query operations.

**Did Exception Occur?**
- No Exception: Proceed to commit.
- Exception (RuntimeException by default): Proceed to rollback.

**Commit transaction**
- Spring calls connection.commit() internally to persist changes.

**Rollback transaction**
- Spring calls connection.rollback() internally, discarding all changes.

**End transactional method / Propagate exception**

- After commit, control returns to the caller normally.
- After rollback, the exception is re-thrown for the caller to handle.

**END**


