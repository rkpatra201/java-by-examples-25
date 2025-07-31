package com.example.models;

public class Product {
  public String name;
  public int quantity;

  public Product(){
    this.quantity = 1;
    System.out.println("no-param: "+this.hashCode());
  }

  // the default this() constructor place is the very first line inside constructor
  public Product(String name, int quantity){
    this(); // current class or object default constructor will be invoked
    this.name = name;
    if(quantity > 0) {
      this.quantity = quantity;
    }
    System.out.println("param: "+this.hashCode());
  }

  @Override
  public String toString() {
    return "{" +
        "name="+this.name +
        ",quantity="+this.quantity +
        "}";
  }
}
