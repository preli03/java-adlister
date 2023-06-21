package com.codeup.adlister.dao;

/*
rename this class to Config
and plug our real db hostname, your db, username, and pw in where appropriate
 */
public class Config {
    public String getUrl() {
        return "jdbc:mysql://students.fulgentcorp.com:3306/cerberus_patrick?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public String getUsername() {
        return "Mary";
    }


    public String getPassword() {
        return "info1";
    }}
