package com.example.adaptor.app;

import com.example.adaptor.models.PenAdapter;
import com.example.adaptor.models.Painter;


public class App {
    public static void main(String[] args) {
        PenAdapter adapter = new PenAdapter();
        Painter painter = new Painter(adapter);
        painter.draw("Drawing with adapter pattern!");
    }
}


