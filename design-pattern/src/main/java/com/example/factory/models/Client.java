package com.example.factory.models;

import com.example.factory.contracts.Vehicle;
import com.example.factory.contracts.VehicleFactory;

public class Client {
    private Vehicle pVehicle;

    public Client(VehicleFactory factory) {
        pVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}
