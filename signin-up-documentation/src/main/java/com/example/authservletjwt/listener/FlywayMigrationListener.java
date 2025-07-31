package com.example.authservletjwt.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.flywaydb.core.internal.configuration.ConfigUtils.PASSWORD;

@WebListener
public class FlywayMigrationListener implements ServletContextListener {

    static String jdbcUrl = "jdbc:mysql://localhost:3306/jwt_auth_demo?createDatabaseIfNotExist=true";
    static String username = "root";
    static String password = "Biswajit@408";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Flyway flyway = Flyway.configure()
                    .dataSource(jdbcUrl, username, password)
                    .locations("classpath:db/migration")
                    .load();
            flyway.migrate();
            System.out.println("Flyway migration completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.exit();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // No cleanup required
    }
}
