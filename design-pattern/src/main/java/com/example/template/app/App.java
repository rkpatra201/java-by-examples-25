package com.example.template.app;

import com.example.template.contracts.Game;
import com.example.template.models.Cricket;
import com.example.template.models.Football;

public class App {
    public static void main(String[] args) {
        Game game1 = new Football();
        game1.play();

        System.out.println();

        Game game2 = new Cricket();
        game2.play();
    }
}

