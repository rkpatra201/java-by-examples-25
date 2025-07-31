### Difference between ClassNotFoundException vs NoClassDefError 

**ClassNotFoundException**
- Checked Exception (must be handled with try-catch or declared)
- You try to load a class dynamically at runtime using Class.forName() or a similar method, 
   and the class is not found in the classpath.

**Example**
```java
public class App1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.ab.abc.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
- Missing .class file or JAR at runtime for dynamically loaded class.
- Yes, must be caught or declared
- Ensure the correct class/JAR is on the runtime classpath

**NoClassDefFoundError**
- Error (unchecked, typically indicates a serious problem)
- The class was available at compile-time, but not available at runtime.

**Example**
```java
public class Helper {
    static {
        if (true) {
            throw new RuntimeException("Boom!");
        }
    }

    public static void sayHi() {
        System.out.println("Hello");
    }
}
```
___
```java


public class App1 {
    public static void main(String[] args) {
       Helper.sayHi();
    }
}
/*
* o/p NoClassDefFoundError
*
*  ExceptionInInitializerError
*  RuntimeException
* */
```
- .class file was available during compilation but is missing or corrupted at runtime.
- Usually not handled — indicates misconfiguration or a critical deployment issue
- A class used in code is not present in the deployment environment
- Ensure all required classes are correctly deployed and match compile-time setup