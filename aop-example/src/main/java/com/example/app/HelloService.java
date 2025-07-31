package com.example.app;

public class HelloService {
    public String sayHello(String name){
        System.out.println("Hello, "+ name);
        return "Hello "+ name;
    }

    public void throwError(){
        throw new RuntimeException("Something went wrong. ");
    }
}
