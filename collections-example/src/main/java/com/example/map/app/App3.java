package com.example.map.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App3 {
    public static void main(String[] args) {
        Map<String , Integer> iterateMap = new HashMap<>();
        iterateMap.put("sachin" , 1);
        iterateMap.put("virat" , 2);
        iterateMap.put("yuvi" , 3);


        // Using entrySet()
        Iterator<Map.Entry<String,Integer >> mapIterator = iterateMap.entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String , Integer> entry= mapIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("key :"+ key + " value:"+ value);
        }

        System.out.println();


        // using keySet() . it will show ConcurrentModificationException modification
        // because i'm trying to modify the code during rum without Iterator
        for (String key : iterateMap.keySet()){
            Integer value = iterateMap.get(key);
            if(iterateMap.containsKey("sachin")){
                iterateMap.put("rohit" , 4);
            }
            System.out.println("key :"+ key + " value:"+ value);
        }

    }
}
