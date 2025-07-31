package com.example.services;

// this is concrete class: you can create object calling new with constructor

// if A want to conrete: A must implement the abstract method m1() from B
// if A want to be abstarct: Just declare A as abstract in class definition
public abstract class A extends B{
  @Override
  public void m3() {
    System.out.println("---from cls A---"+this.getClass());
  }
}
