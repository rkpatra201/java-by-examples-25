package com.example.app;

class SynchonizationExample implements Runnable{
    static int counter =0 ;
    public synchronized void run(){
      for (int i =0 ; i< 1000; i++){
          increment();
      }
        System.out.println("final counter value " + counter);
    }
    private static void increment(){
        counter ++ ;
    }
}

public class App6 {
    public static void main(String[] args) {

        System.out.println("main thread starting");
        SynchonizationExample synchonizationExample = new SynchonizationExample();
         Thread t1 = new Thread(synchonizationExample , "Thread-1");
         Thread t2 = new Thread(synchonizationExample , "Thread-2");

         t1.start();
         t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread completer");
    }
}
