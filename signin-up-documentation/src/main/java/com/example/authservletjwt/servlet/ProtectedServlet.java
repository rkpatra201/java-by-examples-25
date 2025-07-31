
package com.example.authservletjwt.servlet;

import com.example.authservletjwt.daos.UserDAO;
import com.example.authservletjwt.service.AuthService;
import com.example.authservletjwt.util.JsonResponseUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/protected")
public class ProtectedServlet extends HttpServlet {

    private final AuthService authService;
    public ProtectedServlet() {
        this.authService = new AuthService(); // For production
    }
    public ProtectedServlet(AuthService authService) {
        this.authService = authService; // For testing
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Claims claims = null;
        try {
            claims = authService.validateAuthorizationHeader(request.getHeader("Authorization"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String userId = claims.getSubject();
        String role = (String) claims.get("role");

        JsonResponseUtil.writeResponse(response, 200,
                "Protected resource accessed by userId: " + userId + " with role: " + role, null);
    }
}
