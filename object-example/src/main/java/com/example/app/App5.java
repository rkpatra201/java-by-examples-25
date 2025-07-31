package com.example.app;

import com.example.models.Employee;

public class App5 {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    e1.id = 210;
    Employee e2 = new Employee();
    e2.id = 210;

    // why people use 31 while generating hashCode?
    // these 2 objects are equal by business use case
    // these 2 objects are not equals as per the JVM
    System.out.println(e1.hashCode()); // 245257410
    System.out.println(e2.hashCode()); // 1705736037


    // contract of hashCode and equals: hashMap
    // 2 objects has same hashCode but they are not equal (hash) -> k1,k2,k3
    // 2 objects are equals(equal method) then they must have same hashCode(hashCode method)
  }
}
