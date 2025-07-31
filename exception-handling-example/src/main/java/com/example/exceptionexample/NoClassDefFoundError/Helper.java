package com.example.exceptionexample.NoClassDefFoundError;

public class Helper {
    static {
        if (true) {
            throw new RuntimeException("Boom!");
        }
    }

    public static void sayHi() {
        System.out.println("Hello");
    }
}
