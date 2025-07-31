
package com.example.authservletjwt.util;

import com.example.authservletjwt.listener.FlywayMigrationListener;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil implements ConnectionProvider {
    @Override
    public Connection getConnection() throws SQLException {
        return FlywayMigrationListener.getConnection(); // actual source of DB connection
    }
}

