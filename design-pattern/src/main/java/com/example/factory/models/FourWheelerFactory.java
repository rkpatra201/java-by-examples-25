package com.example.factory.models;

import com.example.factory.contracts.Vehicle;
import com.example.factory.contracts.VehicleFactory;

public class FourWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}
