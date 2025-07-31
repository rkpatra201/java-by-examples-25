package com.example.exceptionexample.indexoutofbound.app;

public class App2 {
    public static void main(String[] args) {
        String val = "biswa";
        System.out.printf(String.valueOf(val.charAt(7)));
    }
}
/*
* StringIndexOutOfBoundsException
* Thrown by String methods to indicate that an index is either negative or
* greater than the size of the string.
* For some methods such as the charAt method, this exception also is thrown
* when the index is equal to the size of the string.
*
* */