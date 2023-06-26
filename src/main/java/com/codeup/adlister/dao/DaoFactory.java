package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;

import java.sql.Connection;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Connection connection;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao((Config) connection);
        }
        return adsDao;
    }

    public static Users getUsersDao(){
        if(usersDao == null){
            usersDao = new MySQLUsersDao(connection) {
                @Override
                public Long insert(User user) {
                    return null;
                }
            };

        }
        return usersDao;

}}
