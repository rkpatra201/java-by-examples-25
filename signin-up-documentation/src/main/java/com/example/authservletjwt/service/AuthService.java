//package com.example.authservletjwt.service;
//
//import com.example.authservletjwt.exceptions.UnauthorizedException;
//import com.example.authservletjwt.util.JwtUtil;
//import io.jsonwebtoken.Claims;
//
//public class AuthService {
//
//    public Claims validateAuthorizationHeader(String authHeader) {
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            throw new UnauthorizedException("Missing or invalid Authorization header");
//        }
//
//        String token = authHeader.substring(7).trim();
//
//        if (token.isEmpty()) {
//            throw new UnauthorizedException("Authorization token missing after Bearer");
//        }
//
//        try {
//            return JwtUtil.validateToken(token);
//        } catch (Exception e) {
//            throw new UnauthorizedException("Invalid or expired token");
//        }
//
//    }
//}
package com.example.authservletjwt.service;

import com.example.authservletjwt.daos.UserDAO;
import com.example.authservletjwt.daos.UserDAOInterface;
import com.example.authservletjwt.exceptions.UnauthorizedException;
import com.example.authservletjwt.models.User;
import com.example.authservletjwt.util.JwtUtil;
import io.jsonwebtoken.Claims;

import java.sql.SQLException;

public class AuthService {

    private final UserDAOInterface userDAO;
    private final JwtService jwtService;

    public AuthService(UserDAOInterface userDAO, JwtService jwtService) {
        this.userDAO = userDAO;
        this.jwtService = jwtService;
    }


    public AuthService() {
       this.userDAO = new UserDAO();
       this.jwtService = new JwtServiceImpl();
    }


    public Claims validateAuthorizationHeader(String authHeader) throws SQLException {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7).trim();

        if (token.isEmpty()) {
            throw new UnauthorizedException("Authorization token missing after Bearer");
        }

        Claims claims;
        try {
            claims = JwtUtil.validateToken(token);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid or expired token");
        }

        // New validation: Check if user still exists
        String userEmail = claims.getSubject(); // Assuming email is the subject
        User user = userDAO.findByEmail(userEmail);

        if (user == null) {
            throw new UnauthorizedException("Token is valid but user no longer exists");
        }

        return claims;
    }
}
