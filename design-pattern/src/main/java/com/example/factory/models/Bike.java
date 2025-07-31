package com.example.factory.models;

import com.example.factory.contracts.Vehicle;

public class Bike implements Vehicle {
    @Override
    public void start(){
        System.out.println("bike is starting ....");
    }
}
