package com.example.authservletjwt.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
    Claims validateToken(String token);
}