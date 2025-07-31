package com.example.app;

import com.example.contracts.Shape;
import com.example.providers.ShapeMaker;

public class App3 {
  public static void main(String[] args) {
    ShapeMaker shapeMaker = ShapeMaker.getINSTANCE(); //new ShapeMaker();
    Shape[] shapes = {
        shapeMaker.createCircle(10),
        shapeMaker.createSquare(10),
        shapeMaker.createRectangle(20, 10),
    };

    for(Shape shape: shapes){
      System.out.println(shape.shapeName()+":"+shape.area());
    }
  }
}
