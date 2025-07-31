package com.example.models;

public class Employee {

  // new Constructor()-> jvm please create object of this class.
  // jvm: I have created objected. Do you have some initialization logic?
  // yes please call the constructor which I have given with the new keyword to finish the initialization
  public int id; // primitive
  public String name; // reference

  // if you dont write any constructor in the class,
  // by default the compiler injects default constructor

  public Employee(){
    this.id = 10;
    this.name = "Alexa";
  }

  @Override
  public String toString() {
    return "{" +
        "id="+this.id+
        ",name="+this.name+
        "}";
  }
}
