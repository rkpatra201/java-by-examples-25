package com.example.superexample.models;

public class Mercedies extends Car{

    public Mercedies(){
        super(4);
    }
    public void carDetails(){

    }

    @Override
    public String toString() {
        return "Mercedies{" +
                "gear=" + super.gear +
                ", tyres" + super.tyres+
                ", colour='" + super.colour + '\'' +
                '}';
    }
}
