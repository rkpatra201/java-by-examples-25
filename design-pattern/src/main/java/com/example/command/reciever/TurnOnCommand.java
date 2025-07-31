package com.example.command.reciever;

import com.example.command.contracts.Command;
import com.example.command.contracts.Device;

public class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}