package com.example.exceptionhandeling.usingthrows;

public class App1 {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "com.uuv.student";
        Class.forName(className);
    }

}
