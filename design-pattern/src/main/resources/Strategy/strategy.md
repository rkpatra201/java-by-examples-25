### What is Strategy design pattern

**Why Use It:**
- Allow an object to choose behavior (algorithm) at runtime. Instead of if-else or switch.
- use interchangeable strategy classes.

**Where to Use It:**
- Payment systems (Visa, MasterCard, UPI)
- Sorting algorithms (QuickSort, MergeSort, BubbleSort)
- Compression strategies (ZIP, RAR, 7z)
- Validation engines
- Game behavior (easy, medium, hard AI)

**Real-World Analogy:**
- You can choose your payment method: Credit Card, UPI, PayPal.
- Google Maps lets you choose your route: fastest, shortest, no toll.

**Pros**
- Promotes open/closed principle — new strategies without changing existing code.
- Removes if-else/switch logic clutter.
- Makes code easily extendable and testable.
- Supports runtime switching of behaviors.

**Cons**
- More classes to manage (every strategy needs its own class).
- Client must understand which strategy to use.
- Can be overkill for very simple scenarios.