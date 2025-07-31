package com.example.app;

import org.springframework.stereotype.Component;

// Aspect oriented programming (it supports oops)
// cross-cutting-concerns -> aspect

@Component
public class AopExample {

    public void show(){
//        security();
        System.out.println("hello world");
    }
}
