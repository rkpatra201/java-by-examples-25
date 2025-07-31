package com.example.impl.mysql;

import com.example.contracts.Statement;

public class MysqlStatement implements Statement {
  @Override
  public boolean executeQuery(String query) {
    System.out.println(this + ":" + query);
    return true;
  }
}
