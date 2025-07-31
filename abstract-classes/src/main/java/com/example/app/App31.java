package com.example.app;

// Non-Static variable and constructor in abstract class. Abstract class object creation not allowed
public class App31 {
  public static void main(String[] args) {
    Animal animal = new Dog("DOG");
    System.out.println(animal);

//    Animal animal1 = new Animal("dog"); // not allowed object creation of abstract class
  }

  private static abstract class Animal{
    private String name; // non-static variable

    public Animal(String name) {
      this.name = name;
      System.out.println(this);
    }
  }

  private static class Dog extends Animal{
    public Dog(String name) {
      super(name);
    }
  }
}
