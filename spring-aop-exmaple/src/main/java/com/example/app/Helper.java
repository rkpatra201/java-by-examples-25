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
