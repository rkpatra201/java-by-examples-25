package com.example.map.app;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Flow;

// concurrentHashMap example
public class App7 {
    public static void main(String[] args) {
        ConcurrentHashMap<String , Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("football" , 1) ;
        concurrentHashMap.put("cricket" , 2) ;
        concurrentHashMap.put("basketball" , 3) ;

        // iterate over cuncurrent hashMap
        // now it will not show any ConcurrentModificationException because ConcurrentHashMap thread safty allow
        // modification during run time.
        for (String key : concurrentHashMap.keySet()){
            if(concurrentHashMap.containsKey("football")){
                concurrentHashMap.put("vollyball" , 4) ;
            }
            System.out.println("key:"+ key + " value:"+ concurrentHashMap.get(key));
        }
    }
}
