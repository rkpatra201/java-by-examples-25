package com.example.impl;

import com.example.contracts.Shape;

public class Rectangle extends  AbstractShape implements Shape {
  private int length;
  private int breadth;

  public Rectangle(int length, int breadth) {
    super("Rectangle");
    this.length = length;
    this.breadth = breadth;
  }

  @Override
  public double area() {
    return this.length * this.breadth;
  }
}
