package com.example.exceptionexample.arithmaticexception.models;

public class Calculator {
    public void addtion(){
        add(5,'m');
    }

    private void add(int num , Character letter){
        int sum = num+letter;
        division(num);
    }
    private void division(int num1){
        int result = num1/0;
    }
}
