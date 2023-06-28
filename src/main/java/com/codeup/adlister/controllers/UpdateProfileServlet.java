package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateProfileServlet", urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String currentPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

        //reset attributes if they were set in a previous screen
        session.setAttribute("updateError", false);
        session.setAttribute("updateSuccess", false);

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || currentPassword.isEmpty();

        if (inputHasErrors) {
            session.setAttribute("updateError", true);
            session.setAttribute("updateErrorMessage", "You cannot leave username, email, or current password field blank.");
            response.sendRedirect("/updateProfile");
            return;
        }



        User user = (User) request.getSession().getAttribute("user");
        boolean validPassword = Password.check(currentPassword, user.getPassword());

        boolean profileUpdated = false;

        if(validPassword) {
            //update username only if it changed
            if(!username.equals(user.getUsername())) {
                if(DaoFactory.getUsersDao().checkIfUsernameExists(username)) {
                    session.setAttribute("updateError", true);
                    session.setAttribute("updateErrorMessage", "Username already exists");
                    response.sendRedirect("/updateProfile");
                    return;
                } else {
                    DaoFactory.getUsersDao().updateUsername(user, username);
                    user.setUsername(username);
                    profileUpdated = true;
                }
            }
            //update email only if it changed
            if(!email.equals(user.getEmail())) {
                DaoFactory.getUsersDao().updateEmail(user, email);
                user.setEmail(email);
                profileUpdated = true;
            }
            //update password only if they filled it out
            if(!newPassword.isEmpty() && !confirmNewPassword.isEmpty()) {
                if(!newPassword.equals(confirmNewPassword)) {
                    session.setAttribute("updateError", true);
                    session.setAttribute("updateErrorMessage", "Your new passwords do not match!");
                } else {
                    String hash = Password.hash(newPassword);
                    DaoFactory.getUsersDao().updatePassword(user, hash);
                    user.setPassword(hash);
                    profileUpdated = true;
                }
            }
        } else {
            session.setAttribute("updateError", true);
            session.setAttribute("updateErrorMessage", "Your password was incorrect.");
        }

        if(profileUpdated) {
            session.setAttribute("updateSuccess", true);
            session.setAttribute("updateSuccessMessage", "Your profile was successfully updated!");
        }
        response.sendRedirect("/updateProfile");
    }

}
