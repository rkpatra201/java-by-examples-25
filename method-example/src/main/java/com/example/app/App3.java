package com.example.app;

import com.example.models.Calculator;

// static and non-static

// static: Use class name to access it
// non-static: Use object to access it
public class App3 {

  public static void main(String[] args) {
    int result1 = Calculator.sum(100);
    System.out.println(result1);
    Calculator c = new Calculator();
    int result2 = c.sumInstanceMethod(100);
    System.out.println(result2);
  }
}
