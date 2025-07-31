package com.example.template.models;

import com.example.template.contracts.Game;

public class Football extends Game {
    @Override
    public void start() {
        System.out.println("Football Game Started.");
    }

    @Override
    public void playTurn() {
        System.out.println("Playing Football.");
    }

    @Override
    public void end() {
        System.out.println("Football Game Ended.");
    }
}


