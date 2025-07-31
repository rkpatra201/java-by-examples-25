package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.util.JWTUtil;

public class AuthService {
    private final UserDao userDao = new UserDao();

    public void register(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userDao.save(user);
    }

    public String login(String username, String password) throws Exception {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            return JWTUtil.generateToken(username);
        }
        return null;
    }
}
