package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdDetailsServlet", urlPatterns = "/details")
public class AdDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titleDetails = (String) request.getSession().getAttribute("title");

        if (titleDetails == null) {
            response.sendRedirect("/ads");
            return;
        } else {
            request.setAttribute("ads", DaoFactory.getAdsDao().findByAdTitle(titleDetails));
            request.getRequestDispatcher("/WEB-INF/ads/details.jsp").forward(request, response);
        }
    }
}
