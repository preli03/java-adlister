package com.codeup.adlister.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class MySQLCategoriesDao implements Categories{
    private Connection connection;
    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    @Override
    public ArrayList<String> fetchCategoriesList() {
        ArrayList< String> categories = new ArrayList<>();

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet results = stmt.executeQuery();
            while(results.next()) {
                categories.add( results.getString("category"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
        return categories;
    }
    @Override
    public Long fetchCategoryId(String category) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT id FROM categories WHERE category = ? LIMIT 1");
            stmt.setString(1, category);
            ResultSet results = stmt.executeQuery();
            results.next();
            return results.getLong("id");
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }
}
