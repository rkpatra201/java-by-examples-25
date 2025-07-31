package com.example.app;

import com.example.models.Car;

public class App1 {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = car1;
        System.out.println(car1==car2);  //false
        System.out.println(car1==car3);  //true
        System.out.println(car2==car3);  //false

        //.equals
        //This will throw NullPointerException without the car.model assignment as in .equals() I have compared model.
        //.equals() can not compare null
        car1.model = "Toyota";
        car2.model = "Toyota";
        System.out.println(car1.equals(car2)); //true
        System.out.println(car1.equals(car3)); //true
        System.out.println(car2.equals(car3)); //true
    }
}
