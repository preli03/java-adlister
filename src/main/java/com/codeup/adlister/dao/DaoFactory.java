package com.codeup.adlister.dao;


import javax.servlet.jsp.jstl.core.Config;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(new Config());
        }
        return adsDao;
    }

}
