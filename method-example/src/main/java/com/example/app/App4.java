package com.example.app;

import com.example.models.Calculator;

// primitive type as method params
public class App4 {
  public static void main(String[] args) {
    Calculator c = new Calculator();
    int result1 = c.evenSum(10, 50);
    System.out.println(result1);

    int result2 = Calculator.oddSum(10, 50);
    System.out.println(result2);
  }
}
