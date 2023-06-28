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
import java.util.Arrays;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            // add a return statement to exit out of the entire method.
            return;
        }
        request.setAttribute("categoryList", DaoFactory.getCategoriesDao().fetchCategoriesList());
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User loggedInUser = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            loggedInUser.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        //getting the categories selected
        ad.setCategories(Arrays.asList(request.getParameterValues("categories")));
        //getting the id of the newly created ad and assigning it to the object that will be based to database
        Long id = DaoFactory.getAdsDao().insert(ad);
        ad.setId(id);
        //inserting the categories into the ads_categories table based on ad/ad id
        DaoFactory.getAdsCategoriesDao().insertCategories(ad);
        response.sendRedirect("/ads");
    }
}
