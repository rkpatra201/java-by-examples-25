package com.example.set.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App1 {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();

        // adding element to set
        integerSet.add(10);
        integerSet.add(11);
        integerSet.add(12);

        System.out.println(integerSet);

        // accessing element from  set
        int num = 17 ;
        System.out.println("element present in set :" + integerSet.contains(num));

        // removing the values from the set

        integerSet.remove(12);
        System.out.println(integerSet);

        // iterating through the set
        for (int value : integerSet)
            System.out.print(value + ", ");

        System.out.println();
        // iterate using Iterator

        Iterator<Integer> integerIterator = integerSet.iterator();
        while (integerIterator.hasNext()){
            System.out.print(integerIterator.next()+ ", ");
        }
    }
}
