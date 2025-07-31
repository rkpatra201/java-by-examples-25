package com.example.contracts;

// interfaces are abstract in nature. so we cant create object of interface.
public interface Statement {
  public boolean executeQuery(String query);
}
