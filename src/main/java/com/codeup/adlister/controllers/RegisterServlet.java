package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // TODO: show the registration form
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws IOException {
            // Retrieve user input from the registration form
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Validate the user input
            if (username.isEmpty() || password.isEmpty()) {
                response.sendRedirect("register.jsp"); // Redirect back to registration page with error message
            } else {
                // (e.g., create a new user in the database)
                // Redirect to a success page or login page
                response.sendRedirect("login.jsp");
            }
        } // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to the login page
    }

