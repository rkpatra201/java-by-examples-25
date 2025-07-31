package com.example.services;

public abstract class B {
  // thr must be no object creation for class B
  // But class B contains some common logic as part of its constructor or method
  // which its child class like A or C can utilize
  // you can create object for concrete child classes ex A or C but not for abstrct class B

  // a class can be abstract with just abstract keyword in its class definition
  // it means a class is abstract without an abstract method.

  // all methods in the interface are abstract in nature. interface is purely abstract.
  // abstract class supports (optionally) concrete as well as abstract methods.
  // abstract class in partially abstract as they allow some concrete method but interfaces dont allow concrete methods

  // abstract methods dont have body
  public abstract void m1();

  // a concrete method
  public void m2(){
    System.out.println(this.getClass());
  }

  public void m3(){
    System.out.println(this.getClass());
  }

  // abstract class can have attributes (static / non-static)
}
