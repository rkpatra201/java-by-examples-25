package com.example.app;

import com.example.models.Student;

public class App6 {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.studentDescription();
        System.out.println();
        st1.studentDescription("John Doe", 7, 184);
    }

}
