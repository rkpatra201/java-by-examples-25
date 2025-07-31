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

