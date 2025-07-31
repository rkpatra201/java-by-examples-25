package com.example.app;

class DeadlockExample implements Runnable{

    public final Object lock1 = new Object();
    public final Object lock2 = new Object();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-1")){
            synchronized (lock1){
                System.out.println("Thread-1 : holding lock1....");
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    System.out.println("Thread-1 waiting lock2..");

                }
                synchronized (lock2){
                    System.out.println("Thread-1 waiting lock2 ..");
                }
            }
        }
        else {
            synchronized (lock2){
                System.out.println("Thread-2 : holding lock2..");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread-2 waiting lock1");

                }
                synchronized (lock1){
                    System.out.println("Thread-2 acquired lock ");
                }
            }
        }
    }
}

public class App10 {
    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();

        Thread t1 = new Thread(deadlockExample , "Thread-1");
        Thread t2 = new Thread(deadlockExample , "Thread-2");

        t1.start();
        t2.start();
    }
}
