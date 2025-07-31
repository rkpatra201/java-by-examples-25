package com.example.app;

// empty abstract class
public class App11 {
  public static void main(String[] args) {
    Animal animal = new Dog();
  }

  private static abstract class Animal{

  }

  private static class Dog extends Animal{

  }
}
