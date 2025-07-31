package com.example.command.models;

import com.example.command.contracts.Device;

public class TV implements Device {
    private boolean isOn = false;

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("TV is turned ON.");
        } else {
            System.out.println("TV is already ON.");
        }
    }
    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("TV is turned OFF.");
        } else {
            System.out.println("TV is already OFF.");
        }
    }
}
