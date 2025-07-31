package com.example.methodoveriding.app;

import com.example.methodoveriding.models.AutonomousCollege;
import com.example.methodoveriding.models.University;

public class App1 {

    public static void main(String[] args) {
        University university = new AutonomousCollege();
        university.university();
    }

}
