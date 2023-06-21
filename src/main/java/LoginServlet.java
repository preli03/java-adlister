import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.FileStore;
import java.util.List

import static java.lang.System.out;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            request.getSession().setAttribute("user", username); // Set "user" attribute in session
            response.sendRedirect("/profile");
            FileStore session;
            String loggedInUser = (String) session.getAttribute("user");
            if (loggedInUser != null) {
                out.println("Welcome"); // Modify UserUtils.getUserFullName to retrieve the full name or appropriate user information
            }
%>
        } else {
            response.sendRedirect("/login");
        }

    }
}
