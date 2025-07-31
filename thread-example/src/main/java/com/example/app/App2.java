package com.example.app;

class MyThread extends Thread{
    public void run(){
        System.out.println(" thread running via thread class");
    }
}

class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println(" thread running via runnable ");
    }
}

public class App2 {
    public static void main(String[] args) {

        // thread object created
        MyThread t1 = new MyThread();

        // here jvm will create new thread and calls run()
        t1.start();

        RunnableThread runnableThread = new RunnableThread();
        Thread t = new Thread(runnableThread); //  pass the runnable to thread
        t.start();                             // start the thread
    }
}
