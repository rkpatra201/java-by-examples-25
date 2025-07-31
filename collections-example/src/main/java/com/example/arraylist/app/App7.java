package com.example.arraylist.app;

import java.util.concurrent.CopyOnWriteArrayList;

// CopyOnWriteArrayList example
public class App7 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> integerCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        integerCopyOnWriteArrayList.add(10);
        integerCopyOnWriteArrayList.add(11);
        integerCopyOnWriteArrayList.add(12);


        // will show no concurrentmodification Exception
        for (Integer value : integerCopyOnWriteArrayList){
            if (integerCopyOnWriteArrayList.contains(10)){
                integerCopyOnWriteArrayList.add(13);
            }
        }
        System.out.println(integerCopyOnWriteArrayList);

    }
}
