package com.example.providers;

import com.example.contracts.Connection;
import com.example.impl.mysql.MysqlConnection;
import com.example.impl.oracle.OracleConnection;

public class ConnectionProvider {
  private String connectionType;

  public ConnectionProvider(String connectionType) {
    this.connectionType = connectionType;
  }

  public Connection getConnection() {
    switch (this.connectionType) {
      case "oracle":
        return new OracleConnection();
      case "mysql":
        return new MysqlConnection();
      default:
        throw new IllegalArgumentException("Unsupported connection type: " + this.connectionType);
    }
  }
}
