package com.example.impl.oracle;

import com.example.contracts.Statement;

public class OracleStatement implements Statement {
  @Override
  public boolean executeQuery(String query) {
    System.out.println(this + ":" + query);
    return true;
  }
}
