package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
//        request.setAttribute("ads", DaoFactory.getAdsDao().byCategory("Clothes"));

        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int adId = Integer.parseInt(request.getParameter("adId"));
        String option = request.getParameter("option");

        Ad currentAd = DaoFactory.getAdsDao().fetchAdById(adId);

        if(option.equals("edit")) {
            // validate input
            boolean inputHasErrors = title.isEmpty()
                    || description.isEmpty();

            if (inputHasErrors) {
                response.sendRedirect("/ads");
                return;
            }

            if (!title.equals(currentAd.getTitle())) {
                DaoFactory.getAdsDao().updateTitle(currentAd, title);
                currentAd.setTitle(title);
            }
            if (!description.equals(currentAd.getDescription())) {
                DaoFactory.getAdsDao().updateDescription(currentAd, description);
                currentAd.setDescription(description);
            }
        }
        if(option.equals("delete")) {
            DaoFactory.getAdsDao().delete(currentAd);
        }

        response.sendRedirect("/ads");
    }

}


/*
this if for the drop down thing again. pls ignore
    String attributeName = request.getParameter("attributeName");
        String attributeValue = request.getParameter("attributeValue");
        System.out.println(attributeValue);
        System.out.println(attributeName);
*/

