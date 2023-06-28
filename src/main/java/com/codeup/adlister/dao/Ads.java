package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);


    List<Ad> findByAdTitle(String title);

    List<Ad> findByUserId(Long userId);

    List<Ad> byCategory(String categoryName);

    void delete(Ad ad);

    void updateTitle(Ad ad, String newTitle);

    void updateDescription(Ad ad, String newDescription);

    Ad fetchAdById(int id);

}
