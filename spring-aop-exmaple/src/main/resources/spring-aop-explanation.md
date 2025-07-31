### Spring Aop
- Spring AOP provides a lightweight proxy-based approach to implementing AOP efficiently in enterprise applications .
- A simpler, proxy-based framework that integrates with the Spring Framework, using XML configurations or annotations to define aspects and pointcuts.

**Understanding AOP Concepts**
- **Aspect:** An Aspect is a modular unit of cross-cutting concerns(aspect). 
- For example, a logging aspect can be applied across various methods in different classes.
- **Advice:** This is the action taken by an aspect at a particular join point. There are five types of advice:
    - **Before:** Executed before the method call.
    - **After:** Executed after the method call, regardless of its outcome.
    - **AfterReturning:** Executed after the method returns a result, but not if an exception occurs.
    - **Around:** Surrounds the method execution, allowing you to control the method execution and its result.
    - **AfterThrowing:** Executed if the method throws an exception.
    - **Join Point:** A specific point in the execution of a program, such as method execution or exception handling, where an aspect can be applied.
    - **Pointcut:** A Pointcut is a predicate that defines where advice should be applied. It matches join points using expressions.

### Advice
- Advice is an action performed by an aspect at a particular join-points. 
- There are 4 types of advices in Spring 1.2 Old Style AOP:
  - **Before Advice:** It is executed before the actual method call.
  - **After Advice:** It is executed after the actual method call.
  - **Around Advice:** It is executed before and after the actual method call.
  - **Throws Advice**: It is executed if the actual method throws an exception.

**@Around Advice annotation**
- Runs before and after the method execution in a single advice.
- Uses ProceedingJoinPoint which allows:
- Calling proceed() to execute the method.
- Skipping proceed() to block execution.
- Modifying arguments before execution.
- Modifying return values before returning.
- Handling exceptions inside the advice.

**Let's understand this with a practical example** 
- main class 
```
package com.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        AopExample a1 = applicationContext.getBean(AopExample.class);
        a1.show();
    }
}
```

- Config class 
```
package com.example.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example.app")
public class AppConfig {
}
```
- Service class
```
package com.example.app;

import org.springframework.stereotype.Component;

// Aspect oriented programming (it supports oops)
// cross-cutting-concerns -> aspect

@Component
public class AopExample {

    public void show(){
//        security();
        System.out.println("hello world");
//        throw new RuntimeException("Testing exception to trigger AfterThrowing");
    }
}
```
- Helper Class
```
package com.example.app;


import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

// Advice-> What (you want to call) , type of advice (before , after)
// PointCut -> Where

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {

    // it will call before execution of show method
    @Before("execution(public void show())")
    public void log(){
        System.out.println("log called");
    }

    // after return, after throwing
    @After("execution(public void show())")
    public static void security(){
        System.out.println("security called");
    }

    @AfterReturning("execution(public void show())")
    public static void transaction(){
        System.out.println("transaction called");
    }

    @AfterThrowing("execution(public void show())")
    public static void close(){
        System.out.println("close called");
    }
}
```
**what is AOP in simple terms?**
- In large projects, certain concerns are needed everywhere: logging, security, transactions, validation.
- Instead of writing these repeatedly inside every method, AOP lets you write them once (in an Aspect) and apply them wherever needed.
- This keeps business logic clean and modular.

**App1 (main runner):**
- Initializes Spring context using AppConfig.
- Fetches AopExample bean and calls a1.show().

**Aspect**
- Aspect is a class where you write cross-cutting concerns like logging, security, transactions.
- In code : Helper is your Aspect.
- Marked with @Aspect so Spring knows it contains AOP logic.
- Marked with @Component so it is managed by Spring.

**Advice**
- Advice is the action you want to take at a specific point during method execution.
- In my code : log() is Before Advice: runs before show() executes.
- similarly for all other advices .

**Pointcut**
- Pointcut tells where the advice should apply (which methods).
- In code : ```@Before("execution(public void show())")``` 
- This pointcut says: Apply this advice on any method with public void show() signature in any class.
- You used: execution(public void show()) as your Pointcut expression for all advice.

**Joinpoint**
- Joinpoint is the actual point during execution where the advice is applied.
- In Spring AOP, only method execution is supported as joinpoints.
- When a1.show() is called, it becomes the joinpoint.
- advice (log(), security(), etc.) executes at this joinpoint as per the advice type.

**Proxy**
- Spring creates a proxy around your AopExample bean to apply the advice without modifying your original class.
- When you call: ```a1.show();``` 
- Spring actually calls: ```proxy.show();```
- The proxy: Runs @Before advice.
   - Calls your show() method.
   - Runs @After / @AfterReturning depending on method completion.
   - Runs @AfterThrowing if an exception is thrown.

**How execution flow happens in this example**
- You call a1.show() ➔ triggers proxy.
- Proxy sees @Before ➔ "log called" printed.
- Actual show() runs ➔ "hello world" printed.
- Since no exception:
  - @AfterReturning ➔ "transaction called" printed.
  - @After ➔ "security called" printed.
  - @AfterThrowing ➔ NOT CALLED (since no exception).

- If exception occurs :
  - @Before advice runs
  - Method show() executes
  - Prints: hello world
  - Immediately throws RuntimeException.
  - @AfterThrowing advice runs : Since the method threw an exception, @AfterThrowing executes.
  - @After advice runs : Runs regardless of whether the method succeeded or failed.
  - @AfterReturning does NOT run : Because the method did not complete successfully (it threw an exception), @AfterReturning does not execute.
  - Final output when exception occurs:
   ```
  log called
  hello world
  close called
  security called
  ```


### How to create Custom Annotation in java 
- An annotation in Java is metadata you can attach to classes, methods, fields, etc., to give additional instructions to the compiler or frameworks.
- A custom annotation is:
  - An annotation you define yourself. 
  - It does nothing by itself. 
  - You need reflection or a framework (Spring AOP, custom processors) to act upon it.

**Why do we use custom annotations?**
- Mark methods that require validation (@ValidateParams).
- Mark methods that need to be logged (@LogExecutionTime).

**Structure of a custom annotation**
```
@Target(ElementType.METHOD)          // Where it can be used (e.g., METHOD, FIELD, TYPE)
@Retention(RetentionPolicy.RUNTIME) // Available during runtime for reflection
public @interface MyAnnotation {
}
```

**Common meta-annotations:**
- @Target: where you can use it (METHOD, FIELD, TYPE, etc.).
- @Retention: how long it is retained (SOURCE, CLASS, RUNTIME).

**Why do we use @interface to create annotations in Java?**
- **What does @interface mean?**
 - In Java, annotations are a type of interface.
 - When you write:
   - ```public @interface MyAnnotation { }```
   - you are telling Java: “I am defining a new annotation type named MyAnnotation.”

**Why not use class, interface, or enum?**
- Java needs a specific syntax to differentiate annotations from normal interfaces.
- Using: ```public interface MyAnnotation { }``` : would create a normal interface, not an annotation and likewise for class. 
- Annotations need to be processed by the compiler and frameworks (Spring, JUnit, etc.) in a special way.
- Hence, Java introduced the @interface keyword to clearly signal:
- "This is an annotation definition, not a regular interface, class, or enum."

**What does @interface generate internally?**
- When you define:
```
public @interface MyAnnotation {
    String value();
}
```
- Java implicitly creates an interface that extends java.lang.annotation.Annotation.
- Under the hood: 
```
public interface MyAnnotation extends java.lang.annotation.Annotation {
    String value();
}
```
- But you do not write this manually. 
- The compiler handles it, ensuring consistent annotation parsing and processing during compile-time and runtime.

**Let's understand through a example** 

**Main App**
```
package com.example.customanotation;
import com.example.app.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App11 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CustomAppConfig.class);

        AopCustomExample a1 = applicationContext.getBean(AopCustomExample.class);

        // Valid call
        a1.show("Biswajit", 25);

        // Invalid calls to test validation:
        // a1.show("", 25);            // Will throw IllegalArgumentException: String parameter cannot be empty.
        // a1.show("Biswajit", -5);    // Will throw IllegalArgumentException: Integer parameter cannot be negative.
    }
}
```
- This is your main method:
- Creates a Spring container using CustomAppConfig.
- Fetches AopCustomExample bean.
- Calls show():
- For valid input ➔ prints parameter validation success, then method executes. 
- For invalid input ➔ throws validation exception, method is not executed.

**Custom Annotation (ValidateParams)**
```
package com.example.customanotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)              // usable on methods
@Retention(RetentionPolicy.RUNTIME)     // available at runtime for AOP reflection
public @interface ValidateParams {
}
```
**What this does:**
- You are creating your own annotation named @ValidateParams.
- @Target(ElementType.METHOD) ➔ can only be used above methods.
- @Retention(RetentionPolicy.RUNTIME) ➔ available during runtime so AOP can detect it.
- Think of this as labeling specific methods to say: “I need validation on my parameters.”

**Aspect (ValidationAspect)**
```
package com.example.customanotation;


import com.example.customanotation.ValidateParams;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    @Around("@annotation(com.example.customanotation.ValidateParams)")
    public Object validateParams(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof String && ((String) arg).trim().isEmpty()) {
                throw new IllegalArgumentException("String parameter cannot be empty.");
            }
            if (arg instanceof Integer && ((Integer) arg) < 0) {
                throw new IllegalArgumentException("Integer parameter cannot be negative.");
            }
        }

        System.out.println(" Parameters validated for method: " + joinPoint.getSignature().getName());
        return joinPoint.proceed(); // proceed with actual method call if validation passes
    }
}
```
- This is your AOP aspect for validation.
- @Aspect ➔ declares this class as an aspect. 
- @Component ➔ registers it as a Spring bean.
- Advice:
  - @Around("@annotation(com.example.customanotation.ValidateParams)")
- Tells Spring to apply this method as @Around advice on any method annotated with @ValidateParams.
- Runs before and after the method.

**What the advice does:**
- Object[] args = joinPoint.getArgs(); ➔ retrieves method parameters.
- Loops through parameters:
- If parameter is String and empty ➔ throws exception.
- If parameter is Integer and negative ➔ throws exception.
- Prints validation success message.
- Calls joinPoint.proceed() to execute your show() method if validation passes.
- If validation fails, your method does not run, and you get a clear exception.

**Config Class (CustomAppConfig)**
```
package com.example.customanotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan("com.example.customanotation")
@Configuration
public class CustomAppConfig {
}
```
- Enables component scanning in com.example.customanotation so:
- AopCustomExample, ValidationAspect, and other beans are detected automatically.
- Annotated with @Configuration so Spring recognizes it as a Java-based config class.

**Component class (AopCustomExample)**
```
package com.example.customanotation;

import com.example.customanotation.ValidateParams;
import org.springframework.stereotype.Component;

@Component
public class AopCustomExample {

    @ValidateParams
    public void show(String name, int age) {
        System.out.println("Inside show: name = " + name + ", age = " + age);
    }
}
```
**This is your business class.**
- You annotated show() with @ValidateParams ➔ indicating this method should have parameter validation.
- When you call show("Biswajit", 25), Spring AOP will check:
- Is there an annotation @ValidateParams on this method?
- If yes ➔ execute validation logic before calling show().

**What Happens Internally When You Run:**
- a1.show("Biswajit", 25);
- Step-by-step:
- You call a1.show(...).
- Spring AOP proxy intercepts the call:
- Checks for @ValidateParams.
- Triggers ValidationAspect.validateParams(...).
- Validates parameters:
- Name is non-empty.
- Age is non-negative.
- Passes validation ➔ prints validation success message.
- Calls joinPoint.proceed(), executing:
```
Output:
System.out.println("Inside show: name = Biswajit, age = 25");
```

- Parameters validated for method: show
- Inside show: name = Biswajit, age = 25

- a1.show("", 25);
 - Step-by-step:
- Fails validation (empty String).

```
Throws:
Exception in thread "main" java.lang.IllegalArgumentException: String parameter cannot be empty.
```
- method does not execute.
