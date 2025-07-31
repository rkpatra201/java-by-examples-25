package com.example.exceptionhandeling.usingtrycatch;

public class App1 {
    public static void main(String[] args) {
        int result = 0;
        try {
            result = 10/0;
        } catch (Exception e) {
            System.out.println("found run time exception");
            System.out.println(result);
        }

    }
}
