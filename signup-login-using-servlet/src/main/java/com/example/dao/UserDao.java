package com.example.dao;

import com.example.model.User;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public void save(User user) throws Exception{
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        System.out.println(sql);

        try (Connection connection = DBUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
            if (count > 0){
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        }
    }

    public User findByUsername(String username) throws Exception{
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = DBUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password") );
            }
            return null;
        }
    }
}
