package com.example.command.reciever;

import com.example.command.contracts.Command;
import com.example.command.contracts.Device;

public class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

