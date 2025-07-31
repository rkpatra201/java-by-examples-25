package com.example.app;

// Understanding this object in abstract class.
public class App41 {
  public static void main(String[] args) {
    Animal animal = new Dog("DOG1");
    System.out.println(animal);

//    Animal animal1 = new Animal("dog"); // not allowed object creation of abstract class
    Animal animal1 = new Dog("DOG2");

    System.out.println(animal.isSame(animal)); // true
    System.out.println(animal.isSame(animal1)); // false
  }

  private static abstract class Animal{
    private String name; // non-static variable

    public Animal(String name) {
      this.name = name;
      System.out.println(this);
    }

    public boolean isSame(Animal animal){
      return this == animal; // this refers to the object who called isSame method
    }
  }

  private static class Dog extends Animal{
    public Dog(String name) {
      super(name);
    }
  }
}
