package com.example.set.app;

import java.util.Iterator;
import java.util.TreeSet;

public class App3 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        // add element to the tree set
        treeSet.add(10);
        treeSet.add(11);
        treeSet.add(12);

        System.out.println(treeSet);

        // remove element from tree set
        treeSet.remove(10);
        System.out.println(treeSet);

        // validate element from set
        int num = 12 ;
        System.out.println(treeSet.contains(num));

        // iterate over set
        Iterator<Integer> integerIterator = treeSet.iterator();
        while (integerIterator.hasNext()){
            System.out.print(integerIterator.next()+" ");
        }
    }
}
