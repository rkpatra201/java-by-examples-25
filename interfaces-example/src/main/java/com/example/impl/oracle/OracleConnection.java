package com.example.impl.oracle;

import com.example.contracts.Connection;
import com.example.contracts.Statement;

public class OracleConnection implements Connection {
  @Override
  public Statement getStatement() {
    // Employee emp = new Employee();
    Statement statement = new OracleStatement();
    // interface type can hold object reference of its implementation class;
//    statement = new Statement();
    return statement;
  }
}
