package com.example.app;

// template method design pattern

/**
 * The Template Method design pattern defines the skeleton of an algorithm
 * in a method, deferring some steps to subclasses.
 * It allows subclasses to redefine certain steps
 * without changing the algorithm's structure.
 * <p>
 * Here’s an example using an Animal abstract class:
 */

/**
 * We want each animal to follow
 * a routine like "wake up → make sound → eat → sleep",
 * but each animal makes a different sound and eats differently.
 */
public class App61 {
  public static void main(String[] args) {
    Animal dog = new Dog();
    Animal cat = new Cat();

    System.out.println("Dog's Routine:");
    dog.dailyRoutine();

    System.out.println("\nCat's Routine:");
    cat.dailyRoutine();
  }

  // Abstract Class: Template
  private static abstract class Animal {

    // Template Method
    public final void dailyRoutine() {
      wakeUp();
      makeSound();
      eat();
      sleep();
    }

    private void wakeUp() {
      System.out.println("Waking up...");
    }

    protected abstract void makeSound(); // To be implemented by subclasses

    protected abstract void eat();       // To be implemented by subclasses

    private void sleep() {
      System.out.println("Sleeping...");
    }
  }

  private static class Dog extends Animal {

    @Override
    protected void makeSound() {
      System.out.println("Barks: Woof Woof!");
    }

    @Override
    protected void eat() {
      System.out.println("Eating dog food.");
    }
  }


  private static class Cat extends Animal {

    @Override
    protected void makeSound() {
      System.out.println("Meows: Meow Meow!");
    }

    @Override
    protected void eat() {
      System.out.println("Eating cat food.");
    }
  }


}
