package com.example.authservletjwt.daos;

import com.example.authservletjwt.models.User;
import java.sql.SQLException;

public interface UserDAOInterface {
    void saveUser(User user) throws SQLException;
    User findByEmail(String email) throws SQLException;
}
