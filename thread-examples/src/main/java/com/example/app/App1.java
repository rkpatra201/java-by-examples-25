package com.example.app;

import com.example.models.MyThreads;
import com.example.models.RunnableThread;

public class App1 {
    public static void main(String[] args) {
        MyThreads thread1 = new MyThreads();
        thread1.start();
        RunnableThread runnableThread = new RunnableThread();
        Thread thread2 = new Thread(runnableThread);
        thread2.start();
    }
}
