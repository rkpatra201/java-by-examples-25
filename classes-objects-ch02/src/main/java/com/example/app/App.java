package com.example.app;

import com.example.models.Car;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.model = "Volkswagen";
        car1.color = "Red";
        car1.year = 1978;

        car1.startEngine(); //Engine started for Volkswagen, it's color is Red and made in 1978

        System.out.println(car1.toString());  //This is a Red color Volkswagen from 1978...


    }
}
