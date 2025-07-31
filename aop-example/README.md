### Spring Aop
- Spring AOP (Aspect-Oriented Programming) is a feature in the Spring Framework that helps you keep your code clean by separating out repetitive stuff — like logging, security checks, or performance tracking from your actual business logic.
- Instead of writing that same logging code inside every method, you write it once in a separate class called an aspect, and Spring automatically runs it before, after, or around the methods you choose.
- This way, your main code stays focused on what it needs to do, and the extra concerns (like "log this" or "check permissions") are handled automatically in the background.

### Aspect 
- An aspect is a class where you put code that you want to run alongside your main code, without mixing it into every method.
- It’s used to handle things like logging, security, timing, or error handling.
- The kind of stuff that happens in many places but isn't part of the actual business logic.

### Advice
- advice is the actual code you want to run at certain moments during your program like before, after, or around a method call.
- So aspect is the whole class and advice is a specific action it takes.

### Types of Advice
- There are five types of advice in Spring AOP.

**1. @Before Advice:**
- It runs before the actual method runs.
- It's used for logging, authentication checks, input validation, etc.

**2. @After Advice:**
- It runs after the method finishes whether it succeeds or throws an error.
- It's used for cleanup tasks, releasing resources, final logging.

**3. @AfterReturning Advice:**
- It runs only after the method successfully returns with no exception.
- It's used for logging results and returned values. It double-checks the result before anyone uses it.

**4. @AfterThrowing Advice:**
- It runs only if the method throws an exception.
- It's used for error logging, alerting, custom exception handling.

**5. @Around Advice:**
- It wraps before and after the method.
- @Around advice is like having full control over when a method runs.

### @Pointcut
- A pointcut is like a rule or filter that tells Spring where to apply your advice.
- It defines which methods your aspect should watch, like a spotlight focusing only on certain parts of your code.

### JoinPoint
- A JoinPoint is a specific moment in your program where Spring AOP can insert your custom behavior/advice.
- It's when a method is called, that’s the join point Spring AOP uses.


