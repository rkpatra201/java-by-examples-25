package com.example.exceptionexample.classnotfoundexception;

public class App1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.ab.abc.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
