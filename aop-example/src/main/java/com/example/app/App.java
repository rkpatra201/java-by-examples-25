package com.example.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService service = context.getBean(HelloService.class);
        service.sayHello("Eric");

        try {
            service.throwError();
        } catch (Exception ignored){
            System.out.println("Exception throw ignored...");
        }

        context.close();
    }
}

/*
 Output:

Around - Before: sayHello
Before: sayHello
Hello, Eric
AfterReturning: sayHello
After: sayHello
Around - After: sayHello
Around - Before: throwError
Before: throwError
AfterThrowing: throwError
After: throwError
Around - Exception: throwError
Exception throw ignored...

 */

