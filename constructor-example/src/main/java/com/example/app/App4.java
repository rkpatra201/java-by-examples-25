package com.example.app;

import com.example.models.Sidecar;

// chaining this constructors
public class App4 {
  public static void main(String[] args) {
    Sidecar s1 = new Sidecar();
    System.out.println(s1);

    Sidecar s2 = new Sidecar("100GB", "8CORE");
    System.out.println(s2);
  }
}
