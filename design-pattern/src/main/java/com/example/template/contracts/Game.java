package com.example.template.contracts;

public abstract class Game {
    // Template method (final to prevent overriding)
    public final void play() {
        start();
        playTurn();
        end();
    }

    public abstract void start();
    public abstract void playTurn();
    public abstract void end();
}

