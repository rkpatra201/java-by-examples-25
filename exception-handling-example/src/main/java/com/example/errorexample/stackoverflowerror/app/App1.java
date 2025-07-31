package com.example.errorexample.stackoverflowerror.app;

import com.example.errorexample.stackoverflowerror.models.StackOverFlow;

public class App1 {
    public static void main(String[] args) {
        StackOverFlow stackOf= new StackOverFlow();
        stackOf.stackOverFlow();
    }
}
/*
* StackOverflowError
* Thrown when a stack overflow occurs because an application recurses too deeply.
* */