package com.example.superexample.models;

public class Car {

    public int gear = 4;
    public String colour = "blue";

    // we can't access private member since it has only class acess
    // even if
//    private int tyres = 4 ;
    public int tyres;

    public Car(int tyres){
        this.tyres = tyres;
        System.out.println("sports car");
    }
}
