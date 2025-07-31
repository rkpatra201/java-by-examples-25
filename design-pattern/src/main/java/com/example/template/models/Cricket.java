package com.example.template.models;

import com.example.template.contracts.Game;

public class Cricket extends Game {
    @Override
    public void start() {
        System.out.println("Cricket Game Started.");
    }

    @Override
    public void playTurn() {
        System.out.println("Playing Cricket.");
    }

    @Override
    public void end() {
        System.out.println("Cricket Game Ended.");
    }
}


