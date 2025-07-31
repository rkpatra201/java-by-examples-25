package com.example.providers;

import com.example.contracts.Shape;
import com.example.impl.Circle;
import com.example.impl.Rectangle;
import com.example.impl.Square;

public class ShapeMaker {

  // early singleton
  private static final ShapeMaker INSTANCE = new ShapeMaker();

  private ShapeMaker(){
    // no-code
  }

  public static ShapeMaker getINSTANCE() {
    return INSTANCE;
  }

  public Shape createCircle(int radius){
    return new Circle(radius);
  }

  public Shape createSquare(int side){
    return new Square(side);
  }

  public Shape createRectangle(int length, int breadth){
    return new Rectangle(length, breadth);
  }
}
