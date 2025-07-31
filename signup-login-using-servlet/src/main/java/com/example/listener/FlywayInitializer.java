package com.example.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.flywaydb.core.Flyway;

@WebListener
public class FlywayInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String jdbcUrl = "jdbc:mysql://localhost:3306/user_db?createDatabaseIfNotExist=true";

            Flyway flyway = Flyway.configure()
                    .dataSource(jdbcUrl, "root", "subhasmita")
                    .locations("classpath:db/migration")
                    .load();

            flyway.migrate();
//            flyway.repair();


            System.out.println("Flyway migration completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
