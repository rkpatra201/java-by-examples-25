package com.example.app;

import com.example.models.Employee;

public class App1 {
  public static void main(String[] args) {
    Employee e1 = new Employee(); // default constructor
    // e1 is a reference variable
    // e1 is holding the reference of the object of datatype ? Employee

    // refVar.attr = someValue
    e1.id = 100;
    e1.name = "John";
    e1.salary = 1234;

    // fully qualified className@hexaDecimal representation of hashCode
    System.out.println(e1); // e1.toString()
    // Object class parent of all classes

    System.out.println(e1.getDesignation());
    System.out.println(e1.getClass()); // object class method
    System.out.println(e1.hashCode()); // object class method

    int hashCode = e1.hashCode();
    String hexStr = Integer.toHexString(hashCode); // 0-9, A-F
    System.out.println(hexStr);
  }
}
