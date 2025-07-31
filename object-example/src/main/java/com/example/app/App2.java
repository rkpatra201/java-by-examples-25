package com.example.app;

import com.example.models.Employee;

public class App2 {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    e1.id = 100;
    e1.name = "John";
    e1.salary = 2345;
    e1.deptName = "PHY";

    Employee e2 = new Employee();
    e2.id = 101;
    e2.name = "Alex";
    e2.salary = 2345;
    e2.deptName = "CS"; // not safe to use static. As they belong to 2 dfnt departments
    e2.increment();

    System.out.println(e1);
    System.out.println(e2);
  }
}
