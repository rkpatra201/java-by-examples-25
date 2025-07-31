package com.example.singleton.models;

public class LazySingleton {
    // Instance is not created until needed
    private static LazySingleton instance;

    // Private constructor
    private LazySingleton() {
        System.out.println("LazySingleton instance created");
    }

    // Global access point
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from LazySingleton!");
    }
}

