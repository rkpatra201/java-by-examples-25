package com.example.app;

import com.example.contracts.Connection;
import com.example.contracts.Statement;
import com.example.impl.mysql.MysqlConnection;
import com.example.impl.oracle.OracleConnection;
import com.example.providers.ConnectionProvider;

public class App1 {
  public static void main(String[] args) {
    ConnectionProvider connectionProvider = new ConnectionProvider("mongodb");
    // business logic is designed using interface
    Connection connection = connectionProvider.getConnection();
    Statement statement = connection.getStatement();
    statement.executeQuery("select * from emp");
  }

}
