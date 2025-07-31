
package com.example.authservletjwt.servlet;

import com.example.authservletjwt.dtos.UserLoginDTO;
import com.example.authservletjwt.models.User;
import com.example.authservletjwt.service.UserService;
import com.example.authservletjwt.util.JsonResponseUtil;
import com.example.authservletjwt.util.JwtUtil;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Gson gson = new Gson();
    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserService(); // Production
    }

    public LoginServlet(UserService userService) {
        this.userService = userService; // Test
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!"application/json".equalsIgnoreCase(request.getContentType())) {
            JsonResponseUtil.writeResponse(response, 415, "Content-Type must be application/json", "UNSUPPORTED_MEDIA_TYPE");
            return;
        }

        try (BufferedReader reader = request.getReader()) {
            UserLoginDTO dto = gson.fromJson(reader, UserLoginDTO.class);

            User user = userService.login(dto.email, dto.password);

            if (user != null) {
                String token = JwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
                JsonResponseUtil.writeResponse(response, 200, "{\"token\": \"" + token + "\"}", null);
            } else {
                JsonResponseUtil.writeResponse(response, 401, "Invalid email or password", "INVALID_CREDENTIALS");
            }
        }
    }
}
