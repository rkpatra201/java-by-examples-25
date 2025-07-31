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