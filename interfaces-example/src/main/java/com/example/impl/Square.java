package com.example.impl;

import com.example.contracts.Shape;

public class Square extends AbstractShape implements Shape {

  private int side;

  public Square(int side) {
    super("Square");
    this.side = side;
  }

  @Override
  public double area() {
    return this.side * this.side;
  }
}
