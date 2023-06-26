package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    String findByUsername(String username);
    Long insert(User user);

    void createUser(User user);
}
