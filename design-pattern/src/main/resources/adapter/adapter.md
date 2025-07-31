### What is adapter design pattern

### Why adapter design pattern 

**Why Use It:**
- To make incompatible interfaces work together without changing their code.
- It’s like a translator between two systems.

**Where to Use It:**
- Using an old API with a new system
- Legacy system integration
- USB-to-HDMI, Lightning-to-USB adapter logic
- Adapting third-party libraries

**Real-World Analogy:**
- iPhone charger using Android adapter
- Plug adapter when you travel (US to EU)
- Translator in a meeting where two people speak different languages

**Pros**
- Allows integration of legacy or third-party code without modifying it.
- Supports reusability and interoperability.
- Follows Single Responsibility Principle — separates adaptation logic.

**Cons**
- Adds extra layer of complexity/indirection.
- Adapter code can become messy if the interfaces are too incompatible.
- You are dependent on the legacy interface (not ideal for long-term use).

