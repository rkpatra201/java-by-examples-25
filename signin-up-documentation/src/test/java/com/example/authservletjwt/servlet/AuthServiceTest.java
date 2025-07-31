package com.example.authservletjwt.servlet;

import com.example.authservletjwt.daos.UserDAOInterface;
import com.example.authservletjwt.exceptions.UnauthorizedException;
import com.example.authservletjwt.service.AuthService;
import com.example.authservletjwt.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    private AuthService authService;
//    private UserDAO mockUserDAO;
    private UserDAOInterface mockUserDAO;
    private JwtService jwtServiceMock;

    @BeforeEach
    public void setUp() {
        jwtServiceMock = mock(JwtService.class);
        mockUserDAO = mock(UserDAOInterface.class);
        authService = new AuthService(mockUserDAO,jwtServiceMock);
    }

    @Test
    public void testMissingAuthorizationHeader() {
        try {
            authService.validateAuthorizationHeader(null);
            fail("Expected UnauthorizedException");
        } catch (UnauthorizedException | SQLException e) {
            assertEquals("Missing or invalid Authorization header", e.getMessage());
        }
    }

    @Test
    public void testInvalidAuthorizationHeaderFormat() {
        try {
            authService.validateAuthorizationHeader("Token abc123");
            fail("Expected UnauthorizedException");
        } catch (UnauthorizedException | SQLException e) {
            assertEquals("Missing or invalid Authorization header", e.getMessage());
        }
    }

    @Test
    public void testEmptyTokenAfterBearer() {
        try {
            authService.validateAuthorizationHeader("Bearer ");
            fail("Expected UnauthorizedException");
        } catch (UnauthorizedException | SQLException e) {
            assertEquals("Authorization token missing after Bearer", e.getMessage());
        }
    }

    @Test
    public void testInvalidJwtToken() {
        String fakeToken = "invalid.token.here";
        Mockito.when(jwtServiceMock.validateToken(fakeToken)).thenThrow(new RuntimeException("Invalid token"));

        try {
            authService.validateAuthorizationHeader("Bearer " + fakeToken);
            fail("Expected UnauthorizedException");
        } catch (UnauthorizedException | SQLException e) {
            assertEquals("Invalid or expired token", e.getMessage());
        }
    }

//    @Test
//    public void testValidTokenAndUserExists() throws SQLException {
//        String token = "valid.token.here";
//
//        Claims mockClaims = Mockito.mock(Claims.class);
//        Mockito.when(mockClaims.getSubject()).thenReturn("user@example.com");
//
//        Mockito.when(jwtServiceMock.validateToken(token)).thenReturn(mockClaims);
//        Mockito.when(mockUserDAO.findByEmail("user@example.com")).thenReturn(new User("user@example.com", "hashed", "USER"));
//
//        Claims result = authService.validateAuthorizationHeader("Bearer " + token);
//
//        assertNotNull(result);
//        assertEquals("user@example.com", result.getSubject());
//    }
}
