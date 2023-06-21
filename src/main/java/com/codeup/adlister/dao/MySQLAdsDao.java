package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLAdsDao implements Ads {
    private Connection connection;


    public MySQLAdsDao(Config config) {
        try {
            System.out.println("Creating connection...");
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ad> all() {
        // 0. declare new array list
        List<Ad> ads = new ArrayList<>();

        try {
            // 1. make a statement
            Statement st = connection.createStatement();


            ResultSet adData = st.executeQuery("SELECT * FROM ads");

            while (adData.next()) {

                Ad ad = makeAdFromResultSet(adData);
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 5. return array list
        System.out.println(ads);
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
       long newId;

       try {

//            String query = "INSERT INTO ads (id, title, user_id, description) VALUES (11, 'nintendo46 for sale', 1, 'brand new in box')";
            Statement st = connection.createStatement();
            String query = "INSERT INTO ads (user_id, title, description) VALUES ('"
                    + ad.getUserId() + "', "
                    + ad.getTitle() + ", '"
                    + ad.getDescription()
                    + "')";
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys =  st.getGeneratedKeys();
            keys.next();
            newId = keys.getLong(1);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}