package com.example.app;

import com.example.models.Car;

public class App3 {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = car1;

        //to get the runtime class of an object
        System.out.println("Car1 getClass: "+ car1.getClass());  //class com.example.models.Car
        System.out.println("Car2 getClass: "+ car2.getClass());  //class com.example.models.Car
        System.out.println("Car3 getClass: "+ car3.getClass());  //class com.example.models.Car
        System.out.println("Car3 getName: "+ car3.getClass().getName());  //com.example.models.Car
    }
}
