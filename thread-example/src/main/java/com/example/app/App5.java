package com.example.app;

class MythreadJoin implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " -> Running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" finished ");

    }
}


public class App5 {
    public static void main(String[] args) {

        System.out.println("main thread started ");

        MythreadJoin mythreadJoin = new MythreadJoin();

        Thread t1 = new Thread(mythreadJoin , "Thread-1");
        Thread t2 = new Thread(mythreadJoin ,"Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();       // main thread waits for worker-1
            t2.join();       // main thread waits for worker-2
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println("main thread finishes ");
    }
}
