### Exception handling hierarchy

---
![Image](https://github.com/user-attachments/assets/56cb3caf-dc11-4dcd-989e-2ade80f2c05d)
---

- An Exception is an unwanted or unexpected event that occurs during the execution of a program (i.e., at runtime) and 
  disrupts the normal flow of the program's instructions.
- It occurs when something unexpected happens, like accessing an invalid index, dividing by zero, or trying to open a 
  file that does not exist.

### Java Exception Hierarchy
- All exception and error types are subclasses of the class Throwable, which is the base class of the hierarchy. 

**Exceptions can occur due to several reasons, such as:**
- Invalid user input
- Device failure
- Loss of network connection
- Physical limitations (out-of-disk memory)
- Code errors
- Out of bound
- Null reference
- Type mismatch
- Opening an unavailable file
- Database errors
- Arithmetic errors

**Errors**
- It represent irrecoverable conditions such as Java virtual machine (JVM) running out of memory, memory leaks, 
 stack overflow errors, library incompatibility, infinite recursion, etc. 
- Errors are usually beyond the control of the programmer, and we should not try to handle errors.

### Difference between Error and Exception

**Error**
- An Error indicates a serious problem that a reasonable application should not try to catch.
- Caused by issues with the JVM or hardware.
- ex: OutOfMemoryError , StackOverFlowError.

**Exception**
- Exception indicates conditions that a reasonable application might try to catch
- Caused by conditions in the program such as invalid input or logic errors.
- IOException , NullPointerException.

### What is Checked/compiletime  And unchecked/runtime exception

**Checked Exceptions**
- Checked exceptions are called compile-time exceptions because these exceptions are checked at compile-time by the compiler.

**Example**
- **ClassNotFoundException:** Throws when the program tries to load a class at runtime but the class is not found because 
    it'sbelong not present in the correct location or it is missing from the project.
- **InterruptedException:** Thrown when a thread is paused and another thread interrupts it.
- **IOException:** Throws when input/output operation fails.
- **FileNotFoundException:** Thrown when the program tries to open a file that doesn’t exist.

**Unchecked Exceptions**
- Checked exceptions are called run-time exceptions.

**Example**
- **ArithmeticException:** It is thrown when there's an illegal math operation.
- **ClassCastException:** It is thrown when you try to cast an object to a class it does not belongs to.
- **NullPointerException:** t is thrown when you try to use a null object (e.g. accessing its methods or fields)
- **ArrayIndexOutOfBoundsException:** This occurs when we try to access an array element with an invalid index.
- **ArrayStoreException:** This happens when you store an object of the wrong type in an array.
- **IllegalThreadStateException:** It is thrown when a thread operation is not allowed in its current state.

### Exception Handling

**Using try-catch**
- A try-catch block in Java is a mechanism to handle exception. 
- The try block contains code that might thrown an exception and the catch block is used to handle the exceptions if it occurs.

**Syntax**
```
try {

    // Code that may throw an exception

} catch (ExceptionType e) {

    // Code to handle the exception

}
```

**Using finally Block**
- The finally Block is used to execute important code regardless of whether an exception occurs or not.
- It will not execute when we terminate the system using **System.exit()**.

**Syntax**
```
try {

    // Code that may throw an exception

} catch (ExceptionType e) {

    // Code to handle the exception

}finally{

// cleanup code

}
```

**Handling Multiple Exception**
- We can handle multiple type of exceptions in Java by using multiple catch blocks, each catching a different type of exception.

**Syntax**
```
try {

    // Code that may throw an exception

} catch (ArithmeticException e) {

    // Code to handle the exception

} catch(ArrayIndexOutOfBoundsException e){

    //Code to handle the anothert exception

}catch(NumberFormatException e){

     //Code to handle the anothert exception

}
```

**How Does JVM Handle an Exception?**
- When an Exception occurs, the JVM Creates an exception object containing the error name, description, and program state.
- Creating the Exception Object and handling it in the run-time system is called throwing an Exception.
- There might be a list of the methods that had been called to get to the method where an exception occurred.
- This ordered list of methods is called Call Stack.

```
The run-time system searches the call stack for an Exception handler
It starts searching from the method where the exception occurred and proceeds backward through the call stack.
If a handler is found, the exception is passed to it.
If no handler is found, the default exception handler terminates the program and prints the stack trace.
```

---
![Image](https://github.com/user-attachments/assets/01303708-948a-4026-84e7-9cfc39a81d1b)
---

### Advantages of Exception Handling
- Provision to Complete Program Execution
- Easy Identification of Program Code and Error-Handling Code
- Propagation of Errors
- Meaningful Error Reporting
- Identifying Error Types