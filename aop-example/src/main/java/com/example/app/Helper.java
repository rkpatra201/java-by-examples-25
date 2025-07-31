package com.example.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Helper {

    @Pointcut("execution(* com.example.app.HelloService.*(..))")
    public void helloMethods(){}

    @Before("helloMethods()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before: "+ joinPoint.getSignature().getName());
    }

    @After("helloMethods()")
    public void after(JoinPoint joinPoint){
        System.out.println("After: "+ joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "helloMethods()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("AfterReturning: "+ joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "helloMethods()", throwing= "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("AfterThrowing: "+ joinPoint.getSignature().getName());
    }

    @Around("helloMethods()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around - Before: "+ proceedingJoinPoint.getSignature().getName());
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
            System.out.println("Around - After: "+ proceedingJoinPoint.getSignature().getName());
        } catch (Throwable e){
            System.out.println("Around - Exception: "+ proceedingJoinPoint.getSignature().getName());
            throw e;
        }
        return result;
    }
}
