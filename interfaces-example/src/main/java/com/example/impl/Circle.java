package com.example.impl;

import com.example.contracts.Shape;

// is-A relationship
public class Circle extends AbstractShape implements Shape {
  private int radius;

  public Circle(int radius) {
    super("Circle"); // super constrcutor is the very first line of constructor
    this.radius = radius;
  }

  @Override
  public double area() {
    return Math.PI * Math.pow(this.radius, 2);
  }
}
