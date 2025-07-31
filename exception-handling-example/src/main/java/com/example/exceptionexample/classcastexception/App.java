package com.example.exceptionexample.classcastexception;

public class App {
    public static void main(String[] args) {
        Object val = 0 ;
        System.out.printf((String) val);
    }
}
/*
* ClassCastException
* Thrown to indicate that the code has attempted to cast an
* object to a subclass of which it is not an instance.
* */
