package com.example.singleton.models;

public class LazySingleton {

    private static LazySingleton lazySingleton ;

    // so that we can't create the constructor outside of class
    private LazySingleton(){
        System.out.println("lazy singleton");
    }

    public static LazySingleton getLazySingleton(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if (lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton ;
    }
}
