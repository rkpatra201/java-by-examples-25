package com.example.services;

// here C is concrete: must implemente abstract methods from B i.e m1()
public class C extends B{
  @Override
  public void m1() {
    System.out.println(this.getClass());
  }

  @Override
  public void m3() {
    System.out.println("from cls C"+this.getClass());
  }
}
