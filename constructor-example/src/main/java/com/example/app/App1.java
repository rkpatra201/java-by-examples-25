package com.example.app;

import com.example.models.Employee;

// default constructor. but why you need constructor
public class App1 {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    Employee e2 = new Employee();
    // 1.  please create object of type Employee
    // state: default value
    // id: 0
    // name: null

    System.out.println(e1); // Alexa
    System.out.println(e2); // Alexa

    e1.name = "John";

    System.out.println(e1 == e2); // false
    System.out.println(e1.equals(e2)); // false
  }
}
