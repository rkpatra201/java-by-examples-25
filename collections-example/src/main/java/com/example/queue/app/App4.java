package com.example.queue.app;

import java.util.concurrent.ConcurrentLinkedQueue;

public class App4 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> concurrentQueueExample = new ConcurrentLinkedQueue<>();
        concurrentQueueExample.add(10);
        concurrentQueueExample.add(11);
        concurrentQueueExample.add(12);
        concurrentQueueExample.add(13);

        // iterate over ConcurrentLinkedQueue
        for (Integer value : concurrentQueueExample){
            System.out.println(value);
        }
    }
}
