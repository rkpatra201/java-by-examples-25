package com.example.classcastexception.app;

import com.example.classcastexception.models.A;
import com.example.classcastexception.models.B;
import com.example.classcastexception.models.C;

public class App1 {
    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();

        B b = (B)a2; // ClassCastException, what if we place a1 here?
        a1 = a2;
        System.out.println(a1.getClass());
    }
}
