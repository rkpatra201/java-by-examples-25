package com.example.exceptionhandeling.customexception;

public class MyCustomRuntimeException extends Exception {
    public MyCustomRuntimeException(String message){
        super(message);
    }
    public MyCustomRuntimeException(String message , Throwable cause){
        super(message,cause);
    }
}
