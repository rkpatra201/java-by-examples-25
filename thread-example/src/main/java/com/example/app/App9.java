package com.example.app;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicExample implements Runnable{

    static  AtomicInteger counter = new AtomicInteger(0);
    static  int counter1 = 0;
    @Override
    public void run() {
        increment();
    }

    private static void increment(){
        for (int i =0 ; i < 1000 ; i++){
            counter.incrementAndGet();
            counter1++;
        }
    }
}

public class App9 {
    public static void main(String[] args) {

         AtomicExample atomicExample = new AtomicExample();

         Thread t1 = new Thread(atomicExample,"Thread-1");
         Thread t2 = new Thread(atomicExample,"Thread-2");

         t1.start();
         t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("final count is " + AtomicExample.counter.get());

        // without atomic it will not show proper count value
        System.out.println("final count is " + AtomicExample.counter1 );

    }
}
