
package com.example.authservletjwt.service;

import com.example.authservletjwt.daos.UserDAO;
import com.example.authservletjwt.daos.UserDAOInterface;
import com.example.authservletjwt.exceptions.UserCreationException;
import com.example.authservletjwt.exceptions.ValidationException;
import com.example.authservletjwt.models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserService {
    private final UserDAOInterface userDAO;

    // Constructor Injection (for test)
    public UserService(UserDAOInterface userDAO) {
        this.userDAO = userDAO;
    }

    // Default constructor (production)
    public UserService() {
        this.userDAO = new UserDAO();

    }

    public void signup(String email, String password) {
        validateSignupInput(email, password);

        User existingUser = null;
        try {
            existingUser = userDAO.findByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (existingUser != null) {
            throw new ValidationException("Email already exists.");
        }

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(email, hashed, "USER");

        try {
            userDAO.saveUser(user);
        } catch (Exception e) {
            throw new UserCreationException("Failed to save user: " + e.getMessage(), e);
        }
    }

    private void validateSignupInput(String email, String password) {
        if (email == null || password == null) {
            throw new ValidationException("Email and password are required.");
        }

        email = email.trim();
        password = password.trim();

        if (email.isEmpty()) {
            throw new ValidationException("Email cannot be empty.");
        }

        if (password.isEmpty()) {
            throw new ValidationException("Password cannot be empty.");
        }

        if (!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new ValidationException("Invalid email format.");
        }

        if (password.length() < 6) {
            throw new ValidationException("Password must be at least 6 characters long.");
        }
    }

    public User login(String email, String password) {
        if (email == null || password == null) {
            throw new ValidationException("Email and password are required.");
        }

        email = email.trim();
        password = password.trim();

        if (email.isEmpty()) {
            throw new ValidationException("Email cannot be empty.");
        }

        if (password.isEmpty()) {
            throw new ValidationException("Password cannot be empty.");
        }

        if (!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new ValidationException("Invalid email format.");
        }

        try {
            User user = userDAO.findByEmail(email);
            if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
                return user;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Database error during login: " + e.getMessage(), e);
        }
    }
}
