package com.example.map.app;

import java.util.HashMap;
import java.util.Map;

public class App1 {
    public static void main(String[] args) {
        Map<String , Integer> hashMap = new HashMap<>();

        // add key value to the map
        hashMap.put("mohamod ali" , 1);
        hashMap.put("mike tyson" , 2);
        hashMap.put("no one" , 3);

        // it is called changing the element as well
        hashMap.put("no one" , 4);            // here it will update the value
        hashMap.put("abc" , 4);               // now it is new element in the map

        System.out.println(hashMap);

        // removing element
        hashMap.remove(new String("no one"));
        System.out.println(hashMap);

        // get the element from the map . it will return the value in place of key
        System.out.println(hashMap.get("mohamod ali"));

        // true if this map contains a mapping for the specified key
        System.out.println(hashMap.containsKey("mike tyson"));

        //it will update the map only if the element is not present in the map
        hashMap.putIfAbsent("abcd" , 4);
        System.out.println(hashMap);

    }
}
