import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class pickcolor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String favoriteColor = request.getParameter("color");

        // Redirect to the ViewColorServlet with the favorite color as a query parameter
        response.sendRedirect("view color?color=" + favoriteColor);
    }
}
