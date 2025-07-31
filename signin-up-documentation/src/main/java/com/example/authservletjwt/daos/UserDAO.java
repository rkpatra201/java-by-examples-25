////package com.example.authservletjwt.daos;
////
////import com.example.authservletjwt.models.User;
////import com.example.authservletjwt.util.DBUtil;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////
////public class UserDAO {
////
////    public UserDAO() {}
////    public void saveUser(User user) throws SQLException {
////        String sql = "INSERT INTO users (email, password_hash, role) VALUES (?, ?, ?)";
////        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
////            ps.setString(1, user.getEmail());
////            ps.setString(2, user.getPasswordHash());
////            ps.setString(3, user.getRole());
////            ps.executeUpdate();
////        }
////    }
////
////    public User findByEmail(String email) throws SQLException {
////        String sql = "SELECT * FROM users WHERE email = ?";
////        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
////            ps.setString(1, email);
////            ResultSet rs = ps.executeQuery();
////            if (rs.next()) {
////                return new User(
////                        rs.getInt("id"),
////                        rs.getString("email"),
////                        rs.getString("password_hash"),
////                        rs.getString("role")
////                );
////            }
////        }
////        return null;
////    }
////}
//
//
//package com.example.authservletjwt.daos;
//
//import com.example.authservletjwt.models.User;
////import com.example.authservletjwt.util.ConnectionProvider;
////import com.example.authservletjwt.util.DBUtil;
//import com.example.authservletjwt.listener.FlywayMigrationListener;
//
//import java.sql.*;
//
//public class UserDAO implements UserDAOInterface{
////    private final ConnectionProvider connectionProvider;
//    private final FlywayMigrationListener contextInitialized ;
//
//    public UserDAO(FlywayMigrationListener contextInitialized) {
//        this.contextInitialized = contextInitialized;
//    }
//
//    // Default constructor for app — uses real DBUtil
//    public UserDAO() {
//        this.contextInitialized = new FlywayMigrationListener();
////        this.connectionProvider = new DBUtil(); // no impact on existing code
//    }
//
//    public void saveUser(User user) throws SQLException {
//        String sql = "INSERT INTO users (email, password_hash, role) VALUES (?, ?, ?)";
//        try (Connection conn = FlywayMigrationListener.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getPasswordHash());
//            ps.setString(3, user.getRole());
//            ps.executeUpdate();
//        }
//    }
//
//    public User findByEmail(String email) throws SQLException {
//        String sql = "SELECT * FROM users WHERE email = ?";
//        try (Connection conn = FlywayMigrationListener.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, email);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new User(
//                        rs.getInt("id"),
//                        rs.getString("email"),
//                        rs.getString("password_hash"),
//                        rs.getString("role")
//                );
//            }
//        }
//        return null;
//    }
//}
package com.example.authservletjwt.daos;

import com.example.authservletjwt.models.User;
import com.example.authservletjwt.util.ConnectionProvider;

import java.sql.*;

public class UserDAO implements UserDAOInterface {

    private final ConnectionProvider connectionProvider;

    // Constructor for test (mocked provider)
    public UserDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    // Default constructor (production)
    public UserDAO() {
        this.connectionProvider = new com.example.authservletjwt.util.DBUtil();
    }

    @Override
    public void saveUser(User user) throws SQLException {
        String sql = "INSERT INTO users (email, password_hash, role) VALUES (?, ?, ?)";
        try (Connection conn = connectionProvider.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
        }
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = connectionProvider.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getString("role")
                );
            }
        }
        return null;
    }
}
