package com.example.models;

public class MyThreads extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Started running....");
        try {
            Thread.sleep(102);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " Started") ;

    try

    {
        Thread.sleep(200);
    } catch(
    InterruptedException e)

    {
        throw new RuntimeException(e);
    }
        System.out.println(Thread.currentThread().getName() + " Finished");

}
}
