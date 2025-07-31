### What is command design pattern

**Why Use It:**
- Encapsulate a request (command) as an object — useful for undo/redo, queueing, or logging actions.

**Where to Use It:**
- Remote control systems (e.g., TV on/off)
- Undo/redo in text editors
- GUI button actions (Save, Load, Print)
- Job/task scheduling
- Macro recording systems

**Real-World Analogy:**
- A remote control sends commands to devices
- A restaurant waiter takes an order (command) to the chef (receiver)
- Undo/redo in MS Word

**Pros**
- Encapsulates all details of a request in one object.
- Supports undo/redo, logging, queueing, macro commands.
- Follows open/closed principle — add new commands easily.

**Cons**
- More boilerplate code (lots of command classes).
- Can be overkill if you're only triggering simple actions.
- Commands can become difficult to manage if not well organized.