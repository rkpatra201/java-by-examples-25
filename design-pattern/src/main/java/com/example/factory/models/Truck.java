package com.example.factory.models;

import com.example.factory.contracts.Vehicle;

public class Truck implements Vehicle {
    @Override
    public void start(){
        System.out.println("truck is starting ...");
    }
}
