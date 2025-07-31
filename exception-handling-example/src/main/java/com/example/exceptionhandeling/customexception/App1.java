package com.example.exceptionhandeling.customexception;

public class App1 {
    public static void main(String[] args) throws MyCustomRuntimeException {
        m1(10,0);
    }
    private static void m1(int a , int b) throws MyCustomRuntimeException {
        try {
            int r = a/b ;
        } catch (ArithmeticException e) {
            throw new MyCustomRuntimeException("division operation failed",e);
        }
    }
}
