package com.example.command.app;


import com.example.command.contract.Command;
import com.example.command.invoker.RemoteControl;
import com.example.command.models.LightOffCommand;
import com.example.command.models.LightOnCommand;
import com.example.command.receiver.Light;

public class App1 {
    public static void main(String[] args) {
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();  // Output: Light is ON

        remote.setCommand(lightOff);
        remote.pressButton();  // Output: Light is OFF
    }
}
