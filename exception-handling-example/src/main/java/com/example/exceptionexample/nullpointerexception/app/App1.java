package com.example.exceptionexample.nullpointerexception.app;

public class App1 {
    public static void main(String[] args) {
        String val = null;
        System.out.printf(String.valueOf(val.charAt(0)));
    }
}
/*
* NullPointerException
* Applications should throw instances of this class to indicate other illegal
* uses of the null object.
* objects may be constructed by the virtual machine as if suppression were disabled
*  and/or the stack trace was not writable.
* */