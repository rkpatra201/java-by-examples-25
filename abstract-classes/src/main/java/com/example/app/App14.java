package com.example.app;

// partial abstract class with few abstract methods and few concrete methods
public class App14 {
  public static void main(String[] args) {
    Animal animal = new Dog();
    System.out.println(animal.getClass());
    animal.run();
    animal.speak();
    animal.move();

    Animal bird = new Bird();
    bird.run();
    bird.speak();
    bird.move();
  }

  private static abstract class Animal {
    protected abstract void speak(); // abstract methods does not have body

    protected abstract void run(); // abstract methods does not have body

    // here move is a concrete method, we can say it is common logic/implementation for all teh child classes
    // optionally child classes are free to implement/override move method
    protected void move() {
      System.out.println(this + ":" + "IS moving");
      run();
    }
  }

  private static class Dog extends Animal {
    // concrete child class must implement/override abstract methods from parent

    @Override
    protected void speak() {
      System.out.println(this + ":" + "speak");
    }

    @Override
    protected void run() {
      System.out.println(this + ":" + "run");
    }

  }

  private static class Bird extends Animal{
    @Override
    protected void speak() {
      System.out.println(this+":"+"speak");
    }

    @Override
    protected void run() {
      System.out.println(this+":"+"flying");
    }
  }
}
