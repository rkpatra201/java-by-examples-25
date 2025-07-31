package com.example.app;

class VolatileExample implements Runnable{

    static volatile boolean running = true;
    @Override
    public void run() {
        threadRunning();
    }
    private static void threadRunning(){
        while (running){

        }
        System.out.println("stopped");
    }
}

public class App8 {
    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        Thread t1 = new Thread(volatileExample,"Threafd-1");
        Thread t2 = new Thread(volatileExample,"Threafd-2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        VolatileExample.running = false;
    }
}
