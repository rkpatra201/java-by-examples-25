package com.example.app;

// pure abstract class with all abstract methods
public class App13 {
  public static void main(String[] args) {
    Animal animal = new Dog();
    System.out.println(animal.getClass());
    animal.run();
    animal.speak();
  }

  private static abstract class Animal{
    protected abstract void speak(); // abstract methods does not have body
    protected abstract void run(); // abstract methods does not have body
  }

  private static class Dog extends Animal{
    // concrete child class must implement/override abstract methods from parent

    @Override
    protected void speak() {
      System.out.println(this+":"+"speak");
    }

    @Override
    protected void run() {
      System.out.println(this+":"+"run");
    }
  }
}
