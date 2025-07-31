package com.example.app;

import com.example.models.Employee;

public class App3 {
  public static void main(String[] args) {
    Employee e1 = new Employee(); // 101
    Employee e2 = new Employee(); // 102
    Employee e3 = e2; // 102

    System.out.println(e1 == e2); // false
    System.out.println(e2 == e3); // true
    System.out.println(e1 == e3); // false

    // calling object class equals method. doing reference comparison
    System.out.println(e1.equals(e2)); // false
    System.out.println(e2.equals(e3)); // true
    System.out.println(e1.equals(e3)); // false
  }
}
