package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;



public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao() {
        try {
            System.out.println("Creating connection...");
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

            Statement st = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        String query = "SELECT * FROM ads";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("username");
                String content = resultSet.getString("password");

                Ad ad = new Ad(id, username, password);
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
    }

        @Override
        public List<Ad> all() {
            return null;
        }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}

 /*} catch (SQLException e) {
         throw new RuntimeException(e);
         } finally {
         System.out.println("Closing connection...");
         try {
         connection.close();
         } catch (SQLException e) {
//                throw new RuntimeException(e);
         }
         }
*/