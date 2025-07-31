package com.example.set.app;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class App2 {
    public static void main(String[] args) {
        Set<Integer> linkedHasSet = new LinkedHashSet<>();

        // add element in linked hasSet

        linkedHasSet.add(10);
        linkedHasSet.add(11);
        linkedHasSet.add(12);
        linkedHasSet.add(12);

        // it doesn't allow duplicate . even i add 12 two times in set it will only add once in set
        System.out.println(linkedHasSet);

        // remove the element from set

        linkedHasSet.remove(10);
        System.out.println(linkedHasSet);

        // validate element is present in set or not
        int num = 10 ;
        System.out.println(linkedHasSet.contains(num));

        // iterate over linked hashset
        Iterator<Integer> integerIterator = linkedHasSet.iterator();
        while (integerIterator.hasNext()){
            System.out.print(integerIterator.next()+" ");
        }

    }
}
