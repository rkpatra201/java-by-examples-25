package com.example.app;


// class to implement runnable
class MyTask implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+ "-> Running");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ " -> finished -> terminated");
    }
}

// main class to start the tread
public class App4 {
    public static void main(String[] args) {

        MyTask myTask = new MyTask();

        // create a thread and pass runnable (thread is still n NEW state )
        Thread t1 = new Thread(myTask , "Thread-1");
        Thread t2 = new Thread(myTask , "Thread-2");


        // starts the thread moves to runnable
        t1.start();   // Runnable - running ( decides by os scheduler )
        t2.start();


    }
}
