package com.example.app;

import java.lang.reflect.Method;

// Object class details example .
public class App2 {
    public static void main(String[] args) {
        Method[] methods = App2.class.getMethods();
        for (Method method : methods){
            System.out.println("Methods : " + method.getName());
        }
    }
}
