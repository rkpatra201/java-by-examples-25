package com.example.factory.factorymodel;

import com.example.factory.contracts.Vehicle;
import com.example.factory.models.Bike;
import com.example.factory.models.Car;
import com.example.factory.models.Truck;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType){
       switch (vehicleType){
           case "Car":
               return new Car();
           case "Truck":
               return new Truck();
           case "Bike":
               return new Bike();
           default:
               throw new IllegalArgumentException("unknown vehicle type");
       }
    }
}
