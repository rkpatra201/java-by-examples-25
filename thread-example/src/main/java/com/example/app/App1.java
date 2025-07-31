package com.example.app;


// it will print the main thread that is main
// when a class created in .java file that main class is main thread
// from that thread we can define multithread and run concurrently
public class App1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}
