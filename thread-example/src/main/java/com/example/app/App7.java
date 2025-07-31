package com.example.app;

class ObjectLockExample implements Runnable{

    private static final Object lock = new Object();
    static int counter = 0;
    public void run(){
        for (int i = 0 ; i< 1000 ; i++){
            increment();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void increment(){

        synchronized (lock){
            counter++;
            System.out.println(Thread.currentThread().getName() + " increment counter to " + counter);
        }
    }
}


public class App7 {
    public static void main(String[] args) {
        ObjectLockExample objectLockExample = new ObjectLockExample();

        Thread t1 = new Thread(objectLockExample , "Thread-1");
        Thread t2 = new Thread(objectLockExample , "Thread-2");

        t1.start();
        t2.start();
    }
}
