package com.example.authservletjwt.service;

import com.example.authservletjwt.util.JwtUtil;
import io.jsonwebtoken.Claims;

public class JwtServiceImpl implements JwtService {

    @Override
    public Claims validateToken(String token) {
        try {
            return JwtUtil.validateToken(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
