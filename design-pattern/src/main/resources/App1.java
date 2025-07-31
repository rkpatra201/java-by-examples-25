package com.example.factory.app;

import com.example.factory.contracts.Vehicle;
import com.example.factory.factorymodel.VehicleFactory;

public class App1 {
    public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.getVehicle("Car");
        vehicle1.start();

        Vehicle vehicle2 = VehicleFactory.getVehicle("Truck");
        vehicle2.start();

        Vehicle vehicle3 = VehicleFactory.getVehicle("Bike");
        vehicle3.start();
    }
}
