import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewColorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        // Retrieve the favorite color from the query parameter
        String favoriteColor = request.getParameter("color");

        // Set the response content type to HTML
        response.setContentType("text/html");

        // Create the HTML content with the background color set to the favorite color
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>View Color</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: " + favoriteColor + ";\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Your Favorite Color: " + favoriteColor + "</h1>\n" +
                "</body>\n" +
                "</html>";

        // Write the HTML content to the response
        response.getWriter().write(htmlContent);
    }
}
