package com.example.impl;

import com.example.contracts.Shape;

public abstract class AbstractShape implements Shape {
  private String shapeName;

  public AbstractShape(String shapeName) {
    this.shapeName = shapeName;
  }

  @Override
  public String shapeName() {
    return this.shapeName;
  }
}
