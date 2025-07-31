package com.example.app;

import com.example.models.Employee;

public class App4 {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    e1.id = 100;
    Employee e2 = new Employee();
    e2.id = 100;

    Employee e3 = new Employee();
    e3.id = 200;

    Employee e4 = new Employee();
    e4.id = 200;

    System.out.println(e1 == e2); // False
    System.out.println(e1.equals(e2)); // True
    System.out.println(e3.equals(e4)); // True
    System.out.println(e3 == e4); // False
  }
}
