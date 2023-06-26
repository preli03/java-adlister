package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MySQLUsersDao implements Users{

    private Connection connection;

    public MySQLUsersDao(Connection connection){
        this.connection = connection;

    }


    @Override
    public String findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        User user = null;


        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return username;
    }




    @Override
    public void createUser(User user) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ... Implement other interface methods

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String username = rs.getString("username");
        String password = rs.getString("password");

        return new User();
    }
}

