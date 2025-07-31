package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(int id, String name){
        jdbcTemplate.update("INSERT INTO users (id, name) VALUES (?, ?)", id, name);
    }

    public void updateUser(int id, String name){
        jdbcTemplate.update("UPDATE users SET name = ? WHERE ID = ?", name, id);
    }
    public String getUser(int id){
        return jdbcTemplate.queryForObject("SELECT name FROM users WHERE id = ?", String.class, id);
    }
}
