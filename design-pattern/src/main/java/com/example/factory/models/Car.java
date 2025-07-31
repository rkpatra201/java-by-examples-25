package com.example.factory.models;

import com.example.factory.contracts.Vehicle;

public class Car implements Vehicle {
    @Override
    public void start(){
        System.out.println("car is starting...");
    }
}
