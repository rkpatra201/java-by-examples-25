package com.example.map.app;

import java.util.HashMap;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        Map<String , Integer> targetMap = new HashMap<>();
        targetMap.put("usa" , 1);
        targetMap.put("china" , 2);
        targetMap.put("russia" , 3);

        Map<String , Integer> sourceMap = new HashMap<>();
        sourceMap.put("london" , 4);
        sourceMap.put("Austrelia" , 5);
        sourceMap.put("France" , 6);
        System.out.println(sourceMap);

        // putall method will copy all the content from sourceMap to targetMAp
        targetMap.putAll(sourceMap);
        System.out.println(targetMap);


        // size method checks the number of element present in the map
        System.out.println(targetMap.size());


        // clear method delete all the content from the map
        targetMap.clear();
        System.out.println(targetMap);

    }
}
