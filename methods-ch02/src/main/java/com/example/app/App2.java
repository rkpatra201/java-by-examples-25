package com.example.app;

import com.example.models.Student;

public class App2 {
    public static void main(String[] args) {
        System.out.println(Student.studentCount(250));
        Student studentCount = new Student();
        System.out.println(studentCount.studentName("Alice Walker"));

    }

}
