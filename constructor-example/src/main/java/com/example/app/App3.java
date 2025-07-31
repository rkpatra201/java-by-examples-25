package com.example.app;

import com.example.models.Product;

// this() constructor
public class App3 {
  public static void main(String[] args) {
    Product p1 = new Product("Tea", -1); // 1
    System.out.println(p1.hashCode());

    Product p2 = new Product("Mobile", 20); // 20

    System.out.println(p1);
    System.out.println(p2);

  }
}
