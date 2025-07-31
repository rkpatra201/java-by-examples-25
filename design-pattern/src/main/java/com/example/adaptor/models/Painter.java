package com.example.adaptor.models;

import com.example.adaptor.contracts.Pen;

public class Painter {
    private Pen pen;

    public Painter(Pen pen) {
        this.pen = pen;
    }

    public void draw(String message) {
        pen.write(message);
    }
}

