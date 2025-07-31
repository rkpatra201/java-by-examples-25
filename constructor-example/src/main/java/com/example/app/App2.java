package com.example.app;

import com.example.models.Student;

// adding param constructor and default constructor
public class App2 {
  public static void main(String[] args) {
    Student s1 = new Student(10, 67);
    Student s2 = new Student(11, 87);
    Student s3 = new Student(); // compilation error when calling default constructor

    System.out.println(s1);
    System.out.println(s2);
  }
}
