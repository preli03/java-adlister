package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsCategoriesDao implements AdsCategories{

    private Connection connection;
    public MySQLAdsCategoriesDao(Config config) {
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
    public List<String> fetchCategoryNamesForAd(long adId) {
        List<String> categories = new ArrayList<>();
        PreparedStatement stmt = null;
        String sql = "SELECT category FROM ads_categories JOIN categories ON ads_categories.category_id = id WHERE ad_id = ?;";
            try {
                stmt = connection.prepareStatement(sql);
                stmt.setLong(1,adId);
                ResultSet results = stmt.executeQuery();
                while (results.next()) {
                    categories.add(results.getString("category"));
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error retrieving all categories.", e);
            }
        return categories;
    }
    @Override
    public void insertCategories(Ad ad) {
        for (int i = 0; i < ad.getCategories().size(); i++) {
            Long catId = DaoFactory.getCategoriesDao().fetchCategoryId(ad.getCategories().get(i));
            try {
                String insertQuery = "INSERT INTO ads_categories(ad_id, category_id) VALUES (?, ?)";
                PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, ad.getId());
                stmt.setLong(2, catId);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error creating a new ad.", e);
            }
        }
    }

}
