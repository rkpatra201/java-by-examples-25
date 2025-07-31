package com.example.exceptionexample.indexoutofbound.app;

public class App1 {
    public static void main(String[] args) {
        int[] val = new int[2];
        System.out.printf(String.valueOf(val[5]));
    }
}
/*
 * ArrayIndexOutOfBoundsException
 * Thrown to indicate that an array has been accessed with an illegal index.
 * The index is either negative or greater than or equal to the size of the array.
 *
 * */