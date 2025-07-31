package com.example.map.app;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class App5 {
    public static void main(String[] args) {
        Map<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("odisha" , "bbsr");
        linkedHashMap.put("karnataka" , "bnlr");
        linkedHashMap.put("westbegal" , "kolkata");

        // remove element from the linkedhashmap
        linkedHashMap.remove("odisha");
        System.out.println(linkedHashMap);

        // contains key
        System.out.println(linkedHashMap.containsKey("abc"));

        // iterate over linkedHashset
        Iterator<Map.Entry<String , String>> linkedHashSetIterator = linkedHashMap.entrySet().iterator();
        while (linkedHashSetIterator.hasNext()){
            Map.Entry<String , String> entry = linkedHashSetIterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:"+ key + " value:"+ value);
        }
    }
}
