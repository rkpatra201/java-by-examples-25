package com.example.authservletjwt.servlet;

import com.example.authservletjwt.daos.UserDAOInterface;
import com.example.authservletjwt.exceptions.UserCreationException;
import com.example.authservletjwt.exceptions.ValidationException;
import com.example.authservletjwt.models.User;
import com.example.authservletjwt.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;
    private UserDAOInterface mockUserDAO;

    @BeforeEach
    public void setUp() {
        mockUserDAO = mock(UserDAOInterface.class);
        userService = new UserService(mockUserDAO);
    }

    // ─── SIGNUP TESTS ───────────────────────────────────────

    @Test
    public void testSignupWithValidData() throws Exception {
        String email = "user@example.com";
        String password = "securePass";

        when(mockUserDAO.findByEmail(email)).thenReturn(null);
        doNothing().when(mockUserDAO).saveUser(any(User.class));

        userService.signup(email, password);

        verify(mockUserDAO).saveUser(any(User.class));
    }

    @Test
    public void testSignupWithNullEmail() {
        try {
            userService.signup(null, "validPassword");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Email and password are required.", ex.getMessage());
        }
    }

    @Test
    public void testSignupWithNullPassword() {
        try {
            userService.signup("user@example.com", null);
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Email and password are required.", ex.getMessage());
        }
    }

    @Test
    public void testSignupWithEmptyEmail() {
        try {
            userService.signup(" ", "validPassword");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Email cannot be empty.", ex.getMessage());
        }
    }

    @Test
    public void testSignupWithEmptyPassword() {
        try {
            userService.signup("user@example.com", " ");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Password cannot be empty.", ex.getMessage());
        }
    }

    @Test
    public void testSignupWithInvalidEmail() {
        try {
            userService.signup("invalidEmail", "validPassword");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Invalid email format.", ex.getMessage());
        }
    }

    @Test
    public void testSignupWithDuplicateEmail() throws Exception {
        Mockito.when(mockUserDAO.findByEmail("existing@example.com")).thenReturn(new User());
        try {
            userService.signup("existing@example.com", "validPassword");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Email already exists.", ex.getMessage());
        }
    }

    @Test
    public void testSignupThrowsUserCreationExceptionOnDBError() throws Exception {
        Mockito.when(mockUserDAO.findByEmail("new@example.com")).thenReturn(null);
        Mockito.doThrow(new SQLException("DB failure")).when(mockUserDAO).saveUser(Mockito.any());
        try {
            userService.signup("new@example.com", "password");
            fail("Expected UserCreationException to be thrown");
        } catch (UserCreationException ex) {
            assertTrue(ex.getMessage().contains("DB failure"));
        }
    }


    // ─── LOGIN TESTS ───────────────────────────────────────

    @Test
    public void testLoginWithValidCredentials() throws Exception {
        String email = "user@example.com";
        String password = "securePass";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        User mockUser = new User(1, email, hashed, "USER");

        when(mockUserDAO.findByEmail(email)).thenReturn(mockUser);

        User result = userService.login(email, password);

        assertNotNull(result);
        assertEquals(email, result.getEmail());
    }

    @Test
    public void testLoginWithNullEmail() {
        try {
            userService.login(null, "password");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Email and password are required.", ex.getMessage());
        }
    }


    @Test
    public void testLoginWithNullPassword() {
        try {
            userService.login("user@example.com", null);
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Email and password are required.", ex.getMessage());
        }
    }


    @Test
    public void testLoginWithEmptyEmail() {
        try {
            userService.login(" ", "password");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Email cannot be empty.", ex.getMessage());
        }
    }

    @Test
    public void testLoginWithEmptyPassword() {
        try {
            userService.login("user@example.com", " ");
            fail("Expected ValidationException to be thrown");
        } catch (ValidationException ex) {
            assertEquals("Password cannot be empty.", ex.getMessage());
        }
    }

    @Test
    public void testLoginWithInvalidEmailFormat() throws Exception {
        try {
            userService.login("invalidEmail", "password");
            fail("Expected ValidationException");
        } catch (ValidationException e) {
            assertEquals("Invalid email format.", e.getMessage());
        }
    }

    @Test
    public void testLoginWithWrongPassword() throws Exception {
        String email = "user@example.com";
        String password = "wrongPass";
        String correctHashed = BCrypt.hashpw("correctPass", BCrypt.gensalt());

        when(mockUserDAO.findByEmail(email)).thenReturn(new User(1, email, correctHashed, "USER"));

        User result = userService.login(email, password);
        assertNull(result);
    }

    @Test
    public void testLoginWithUnknownEmail() throws Exception {
        when(mockUserDAO.findByEmail("notfound@example.com")).thenReturn(null);

        User result = userService.login("notfound@example.com", "somepass");
        assertNull(result);
    }

    @Test
    public void testLoginThrowsSQLException() throws Exception {
        Mockito.when(mockUserDAO.findByEmail("user@example.com")).thenThrow(new SQLException("DB failure"));
        try {
            userService.login("user@example.com", "password");
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException ex) {
            assertEquals("Database error during login: DB failure", ex.getMessage());
        }
    }
}