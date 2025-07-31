### What is Singleton design pattern

**Why Singleton design pattern:**
- Ensure only one instance of a class exists throughout the application — like a single config manager.
- database connection pool, or logger.

**Where to Use It:**
- Logger classes
- Config or settings manager
- Cache manager
- Database connection pool
- License manager (1 instance only allowed)

**Real-World Analogy:**
- Your Operating System has only one task manager
- A company has only one CEO

**Pros**
- Ensures only one instance exists (memory efficiency).
- Provides global access point (like a global config or logger).
- Useful for shared resources like DB connections or caches.

**Cons**
- Makes unit testing harder (tight coupling, global state).
- Can become a god object (doing too many things).
- Breaks Single Responsibility Principle.
- Not thread-safe by default (unless handled carefully).


