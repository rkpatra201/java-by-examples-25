package com.example.factory.app;

import com.example.factory.contracts.Vehicle;
import com.example.factory.contracts.VehicleFactory;
import com.example.factory.models.Client;
import com.example.factory.models.FourWheelerFactory;
import com.example.factory.models.TwoWheelerFactory;

public class App {
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Client fourWheelerClient = new Client(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();
    }
}
