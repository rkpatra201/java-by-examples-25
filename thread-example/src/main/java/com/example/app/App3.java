package com.example.app;

class Mythread extends Thread{
    public void run(){
        try {
            System.out.println("Running");
            Thread.sleep(1000);              // time waited
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("terminated ");
    }
}

public class App3 {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();    // New
        t1.start();                      // Runnable
    }
}
