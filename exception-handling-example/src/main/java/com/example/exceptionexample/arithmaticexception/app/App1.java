package com.example.exceptionexample.arithmaticexception.app;

import com.example.exceptionexample.arithmaticexception.models.Calculator;

public class App1 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addtion();
    }
}

/*
* o/p it will give exception "ArithmeticException"
*
* because an integer devided by 0 throws an instance of this class
*
* */

