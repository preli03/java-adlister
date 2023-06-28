package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface AdsCategories {
    //get a list of all categories that belong to an ad
    List<String> fetchCategoryNamesForAd(long adId);
    //insert ads_categories records for a new ad
    void insertCategories(Ad ad);
}
