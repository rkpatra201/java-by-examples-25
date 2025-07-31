package com.example.app;

import java.lang.reflect.Constructor;

// constructor inspection example
public class App5 {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Class constructor = Bike.class ;

        Constructor[] constructors = constructor.getConstructors();
        for (Constructor constructor1 : constructors){
            System.out.println(constructor1);
        }
    }
}
class Bike{

    public String name ;
    public String colour ;
    public int gear ;

    public Bike() {
    }

    public Bike(String name){

    }
    public Bike(String name , String colour){

    }

    public Bike(String name, String colour, int gear) {
        this.name = name;
        this.colour = colour;
        this.gear = gear;
    }
}
