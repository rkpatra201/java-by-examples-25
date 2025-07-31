package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS accounts (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), balance DECIMAL)");
    }

    public void addAccount(String name, double balance) {
        jdbcTemplate.update("INSERT INTO accounts (name, balance) VALUES (?, ?)", name, balance);
    }
}

