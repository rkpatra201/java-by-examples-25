package com.example.command.app;

import com.example.command.contracts.Command;
import com.example.command.invoker.RemoteControl;
import com.example.command.models.TV;
import com.example.command.reciever.TurnOffCommand;
import com.example.command.reciever.TurnOnCommand;

public class App {
    public static void main(String[] args) {
        TV tv = new TV();

        Command turnOnTVCommand = new TurnOnCommand(tv);
        Command turnOffTVCommand = new TurnOffCommand(tv);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnTVCommand);
        remote.pressButton();  // Outputs: TV is turned ON
        remote.pressButton();  // Outputs: TV is already ON.



        remote.setCommand(turnOffTVCommand);
        remote.pressButton(); // Outputs: TV is turned OFF
        remote.pressButton(); // Outputs: TV is already OFF
    }
}
