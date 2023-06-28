package com.codeup.adlister.dao;

import java.util.ArrayList;

public interface Categories {
    //gets a list of all possible categories
    ArrayList<String> fetchCategoriesList();
    //gets the id of a category by name
     Long fetchCategoryId(String category);
}
