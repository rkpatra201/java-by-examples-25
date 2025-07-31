package com.example.servlet;

import com.example.service.AuthService;
import com.example.util.ApiException;
import com.example.util.DBUtil;
import com.example.util.JWTUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || password == null || "".equals(username) || "".equals(password)) {
            throw new ApiException("Missing credentials", "VALIDATION_ERROR", 400);
        }
        try {
            String storedHash = DBUtil.getPasswordHash(username);
            System.out.println("stored hash "+storedHash);
            String token = authService.login(username,storedHash);
            if (storedHash != null && BCrypt.checkpw(password, storedHash) && token != null){
                res.setHeader("Auth-token", token);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("token", token);
                jsonObject.addProperty("msg", "Login successful!");
                res.getWriter().write(String.valueOf(jsonObject));
            }
            else {
                throw new ApiException("Invalid username or password", "INVALID_CREDENTIALS", 401);
            }
        } catch (Exception e) {
            throw new ApiException("Login failed", "LOGIN_ERROR", 500);
        }
    }
}
