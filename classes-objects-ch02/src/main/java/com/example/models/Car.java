package com.example.models;

import java.util.Objects;

public class Car {
    public String color;
    public String model;
    public int year;

    public void startEngine(){
        System.out.println("Engine started for "+ model +", it's color is "+color+" and made in "+year);
    }
    @Override
    public String toString(){
        return "This is a "+ color +" color "+ model+" from "+year+"...";
    }

    @Override
    public boolean equals(Object obj){
        Car compare = (Car) obj;
        return this.model.equals(compare.model);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.year);
    }
}
