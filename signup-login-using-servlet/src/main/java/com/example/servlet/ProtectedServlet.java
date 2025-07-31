package com.example.servlet;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.util.ApiException;
import com.example.util.JWTUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/protected")
public class ProtectedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String authHeader = req.getHeader("Auth-Token");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ApiException("Authorization header missing or invalid","HEADER_INVALID",400);
        }
        try {
            if(authHeader != null && authHeader.startsWith("Bearer ")){
                System.out.println("1");
                String token = authHeader.substring(7);
                System.out.println("token - "+token);
                System.out.println("token status - "+JWTUtil.validateToken(token));
                    if (JWTUtil.validateToken(token)) {
                        System.out.println("2");
                        String username = JWTUtil.getUsername(token);
                        res.getWriter().write("Welcome to protected endpoint, " + username + "!");
                        return;
                    }
                }
            }catch (Exception e) {
            throw new ApiException("Unknown Exception","UNKNOWN",501);
        }
    }
}
