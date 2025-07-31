package com.example.adaptor.models;

import com.example.adaptor.contracts.Pen;

public class PenAdapter implements Pen {
    MarkerPen markerPen = new MarkerPen();

    public void write(String text) {
        markerPen.mark(text);
    }
}

