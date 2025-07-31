package com.example.app;

import com.example.models.Car;

public class App2 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.model = "Volkswagen";
        car1.year = 2000;
        Car car2 = new Car();
        Car car3 = car1;
        System.out.println("Car1 model's hashcode : "+ car1.model.hashCode()); //344569803
        System.out.println("Car1's hashcode : "+ car1.hashCode());  //2031
        System.out.println("Car2's hashcode : "+ car2.hashCode());  //31
        System.out.println("Car3's hashcode : "+ car3.hashCode());  //2031
    }
}

