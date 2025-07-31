
package com.example.authservletjwt.servlet;

import com.example.authservletjwt.dtos.UserSignupDTO;
import com.example.authservletjwt.service.UserService;
import com.example.authservletjwt.util.JsonResponseUtil;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private static final Gson gson = new Gson();
    private final UserService userService;

    // Default constructor for production
    public SignupServlet() {
        this.userService = new UserService(); // to be injected eventually
    }

    // Constructor for testing (mocked UserService)
    public SignupServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!"application/json".equalsIgnoreCase(request.getContentType())) {
            JsonResponseUtil.writeResponse(response, 415, "Content-Type must be application/json", "UNSUPPORTED_MEDIA_TYPE");
            return;
        }

        try (BufferedReader reader = request.getReader()) {
            UserSignupDTO dto = gson.fromJson(reader, UserSignupDTO.class);

            userService.signup(dto.email, dto.password); // ❗ all validation + error throwing done inside service layer

            JsonResponseUtil.writeResponse(response, 201, "User created successfully", null);
        }
    }
}
