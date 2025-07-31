package com.example.singleton.models;

public class EagerSingleton {
    // Instance is created during class loading
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor
    private EagerSingleton() {
        System.out.println("EagerSingleton instance created");
    }

    // Global access point
    public static EagerSingleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from EagerSingleton!");
    }
}

