package com.example.map.app;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class App6 {
    public static void main(String[] args) {
        Map<String , String > treeMap = new TreeMap<>();
        treeMap.put("jordan","nike jordan");
        treeMap.put("lebron","nike lebron");
        treeMap.put("curry","ua curry");

        // check the key is available or not
        System.out.println(treeMap.containsKey("jordan"));

        // iterate over treeMap

        Iterator<Map.Entry<String , String>> treeMapIterator = treeMap.entrySet().iterator();
        while (treeMapIterator.hasNext()){
            Map.Entry<String , String> entry = treeMapIterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + " value:"+ value);
        }
    }

}
