package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLog(String message){
        jdbcTemplate.update("INSERT INTO logs (message) VALUES (?)", message);
    }

    public List<String> getLogs(){
        return  jdbcTemplate.query("SELECT message FROM logs", (rs, rowNum) -> rs.getString("message"));
    }
}
