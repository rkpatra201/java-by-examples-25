package com.example.models;

public class Student {
  public int id;
  public int score;

  // when param constructro is present in a class,
  // the compiler by default wont inject the default constructor
  public Student(int id, int score) {
    this.id = id;
    this.score = score;
  }

  // manually developer can add a default constructor
  public Student(){

  }
  @Override
  public String toString() {
    return "{" +
        "id=" + this.id +
        ",score=" + this.score +
        "}";
  }
}
