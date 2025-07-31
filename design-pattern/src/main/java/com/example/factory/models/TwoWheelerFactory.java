package com.example.factory.models;

import com.example.factory.contracts.Vehicle;
import com.example.factory.contracts.VehicleFactory;

public class TwoWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}
