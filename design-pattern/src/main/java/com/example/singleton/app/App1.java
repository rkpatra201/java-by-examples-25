package com.example.singleton.app;


import com.example.singleton.models.EagerSingleton;
import com.example.singleton.models.LazySingleton;

public class App1 {
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getLazySingleton();
        System.out.println(lazySingleton);

        EagerSingleton eagerSingleton = EagerSingleton.getEagerSingleton();
        System.out.println(eagerSingleton);


    }
}
