# java-by-examples-25

## 1. Class & Objects
1. How to create class and its object with attributes and behaviours. Print content using toString()
2. Creating multiple objects but why?
3. Comparing objects (reference) using == and show .equals method of object class
4. Comparing objects using custom equals()
5. Object hashCode() and Custom hashCode method
6. Object class methods: toString(), equals(), hashCode(), getClass()
7. Add behaviours(methods) to class or objects. Example designation by salary

## 2. Methods 
1. Why methods required. counting vowels in a word.
2. Static and Non-Static Methods. Role of this keyword for access non-static member
3. Parameterized methods: primitive, object, array
4. Method return type: void, primitive, object, array
5. Method calling another method
6. NullPointer Exception: Null.anyNonStaticMember(method/variable)
7. Method Overloading

## 3. Constructors
1. Why Constructors. Default Constructor
2. Parameterized Constructor. The this keyword.
3. this() constructor
4. this() param constructor
5. Does calling this() constructor create a new object
6. Constructor calling constructor
7. Properties of constructor
8. Constructor overloading

## 4. Interfaces
1. Define interface and its contracts(methods)
2. Define implementation class for interface
3. Define multiple implementation for interface
4. Conditionally choose one of the implementation
5. Interface extending other interfaces *
6. Marker interfaces: Cloneable, Serializable, RandomAccess
7. Class implementing multiple interfaces *
8. Strategy design pattern *

## 5. Abstract Classes
1. Why do we need abstract classes. Define abstract class. Empty abstract class. All Concrete abstract class. Partial concrete abstract class
2. Keep Common logic in abstract class. Allow subclass(s) to implement abstract methods.
3. Non-Static variable and constructor in abstract class. Abstract class object creation not allowed.
4. Understanding this object in abstract class.
5. Abstract class implementing interface.
6. Template method design pattern.

## 6. Inheritance
1. Reuse parent members in child class.
2. Calling parent class constructor using super constructor
3. Accessing parent class member from child using super. Can we access private members?
4. Does creating child class object create parent class object.
5. Method overriding.
6. Can variables overridden.

## 7. Exception Handling
1. Understanding exception hierarchy.
2. Checked Exception and Unchecked Exception. Java provided exception classes
3. What is Error. Java provided error types.
4. Writing custom exception classes.
5. Understanding exception stacktrace.

## 8. Arrays
1. Primitive type 1d array, 2d array, 3d array. And display them.
2. Complex type 1d array, 2d array, 3d array, And display them with toString()
3. Iteration of 1d array using for loop, for index loop. while loop, do while loop
4. Accessing 1d array and 2d array elements by index or position.
5. binary search, fnd max, fid min, segregate even and odd numbers

## 9. Collections

### **1. `ArrayList`**

* **Basic Operations:** `add()`, `addAll()`, `get(index)`, `remove()`, `removeAll()`, `retainAll()`
* **Cloning:** Using `clone()` or copy constructor
* **Sorting:** Using `Comparable` or `Comparator`
* **Utility Methods:** `size()`, `clear()`
* **Working with Complex Types:** Storing and manipulating custom objects
* **Traversal Techniques:** `Iterator`, `ListIterator`, enhanced for-loop, traditional for-loop

---

### **2. `LinkedList`**

* **Basic Operations:** `add()`, `addFirst()`, `addLast()`, `remove()`, `removeFirst()`, `removeLast()`
* **Utility Methods:** `size()`, `clear()`
* **Traversal Techniques:** `Iterator`, `ListIterator`, enhanced for-loop, traditional for-loop

---

### **3. `Stack`**

* **Core Methods:** `push()`, `peek()`, `pop()`, `isEmpty()`
* **Utility Methods:** `size()`, `clear()`

---

### **4. `Queue` (e.g., `LinkedList`, `PriorityQueue`)**

* **Core Methods:** `add()`, `offer()`, `peek()`, `poll()`, `isEmpty()`
* **Utility Methods:** `size()`, `clear()`
* **Traversal Techniques:** `Iterator`, `ListIterator`, loops

---

### **5. `Set` Implementations**

#### - `HashSet`, `LinkedHashSet`, `TreeSet`

* **Core Methods:** `add()`, `contains()`, `remove()`
* **Traversal Techniques:** `Iterator`, enhanced for-loop
  *(Note: `ListIterator` is not supported as `Set` does not maintain index-based order)*

---

### **6. `Map` Implementations**

#### - `HashMap`, `LinkedHashMap`, `TreeMap`

* **Core Methods:** `put()`, `get()`, `remove()`, `containsKey()`
* **Extended Methods:** `putIfAbsent()`, `putAll()`
* **Utility Methods:** `size()`, `clear()`
* **Traversal Techniques:** Using `entrySet()`, `keySet()`, `values()` with `Iterator` or loops

---

### **7. `Hashtable` & `Properties`**

* **Thread-safe legacy implementations**
* Used for key-value storage; `Properties` is often used for config files (supports only `String` keys and values)

---

### **8. Concurrent Collections**

* Examples: `ConcurrentHashMap`, `CopyOnWriteArrayList`, `ConcurrentLinkedQueue`
* Safe for use in multi-threaded environments

---

### **9. Synchronized Collections**

* Wrappers using `Collections.synchronizedList()`, `synchronizedSet()`, etc.

---

### **10. Read-Only Collections**

* Unmodifiable collections using `Collections.unmodifiableList()`, `unmodifiableSet()`, etc.

---

### **11. Cloning Collections**

* Using `clone()` or parameterized constructor for deep/shallow copy

---

### **12. Comparison of Collection Types**

* **`ArrayList` vs `LinkedList` vs `Stack` vs `Queue`:**
  Performance differences, use-cases, and data access patterns

* **`HashSet` vs `LinkedHashSet` vs `TreeSet`:**
  Ordering, performance, and null value handling

* **`HashMap` vs `LinkedHashMap` vs `TreeMap` vs `Hashtable`:**
  Order preservation, thread safety, and performance

---

### **13. Legacy Collections**

* Includes `Vector`, `Stack`, `Hashtable`, `Enumeration`
* Mostly synchronized and superseded by modern alternatives

## 10. MultiThreading Basics

1. **Processes vs. Threads**
2. **Context Switching in Processes – Why It Is Required**
3. **Context Switching in Threads – Why It Is Required**
4. **Concurrency vs. Parallelism**
5. **Does a Single-Core CPU Support Concurrency and Parallelism?**
6. **Creating Threads in Java – Extending `Thread` vs. Implementing `Runnable`**
7. **Thread States**
8. **Thread Join**
9. **Synchronization – Why It Is Required (With Example)**
10. **Object Lock in the Context of Synchronization**
11. **Synchronized Blocks vs. Synchronized Methods**
12. **`volatile` and Atomic Variables**
13. **Producer-Consumer Problem**
14. **Even-Odd Number Printer Problem**
15. **Thread Sleep**

## 11. Serialization

## 12. Clone & Immutable

## 13. File IO

## 14. Functional Programming

## 15. Streams API

## 16. Completable Feature

## 17. Reflections

## 18. AutoBoxing and AutoUnboxing
1. Wrapper classes
2. Type casting with Objects
3. Primitive to object and vice verse
4. Methods of wrapper classes

## 19. String / StringBuilder / StringBuffer
1. String constructor(s)
2. chartAt(), toCharArray(), length(), toLowerCase(), toUpperCase(), isEmpty()
3. StringBuilder, reverse, append
4. StringBuffer
5. Difference between String, StringBuilder, StringBuffer
6. String constant pool. String in heap. String interning
7. String to byte array and vice versa