package com.example.exceptionexample.illegalargument;

public class App1 {
    public static void main(String[] args) {
        int val = Integer.parseInt("abc");
    }
}
/*
* NumberFormatException
*
* Thrown to indicate that the application has attempted to convert a string
* to one of the numeric types, but hat the string does not have the appropriate format.
*
* */