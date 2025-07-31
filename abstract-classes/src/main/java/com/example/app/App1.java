package com.example.app;

import com.example.services.B;
import com.example.services.C;
import com.example.services.D;
import com.example.services.E;

// inheritance gives you IS-A relationship and always involves non-static methods
// understand Abstract class and abstract methods
public class App1 {
  public static void main(String[] args) {
    // abstract classes: B<-A (A is abstract)
    // concrete classes: A<-D (D concrete)
    // concrete classes: B<-C (C concrete)

    // parent = child
    B d = new D();// D - A -  B
    B c = new C();
//    System.out.println(d.m1());
    d.m1();
    c.m1();

    d.m2(); // D - B. B or D ? D
    c.m2(); // C - B.  B or C ? C

    d.m3(); // D - A - B but it found m3 in A.
    c.m3(); // C - B but it found m3 in C itself

    B e = new E(); // E - C - B
    e.m2(); // E
    e.m3(); // E
  }
}
