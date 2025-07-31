package com.example.singleton.app;

import com.example.singleton.models.EagerSingleton;
import com.example.singleton.models.LazySingleton;

public class App {
    public static void main(String[] args) {
        // Eager Singleton
        EagerSingleton eager = EagerSingleton.getInstance();
        eager.showMessage();

        // Lazy Singleton (not thread-safe)
        LazySingleton lazy = LazySingleton.getInstance();
        lazy.showMessage();

        // Confirm they return same instance
        System.out.println("Eager same instance? " + (eager == EagerSingleton.getInstance()));
        System.out.println("Lazy same instance? " + (lazy == LazySingleton.getInstance()));
    }
}
