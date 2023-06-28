package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);

    Boolean checkIfUsernameExists(String username);

    void updateUsername(User user, String newUsername);
    void updateEmail(User user, String newEmail);
    void updatePassword(User user, String newPassword);
}
