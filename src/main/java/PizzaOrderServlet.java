import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PizzaOrderServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String crustType = request.getParameter("crust");
        String sauceType = request.getParameter("sauce");
        String sizeType = request.getParameter("size");
        String[] toppings = request.getParameterValues("toppings");
        String deliveryAddress = request.getParameter("address");

        System.out.println("Crust: " + crustType);
        System.out.println("Sauce: " + sauceType);
        System.out.println("Size: " + sizeType);
        if (toppings != null) {
            System.out.println("Toppings:");
            for (String topping : toppings) {
                System.out.println("- " + topping);
            }
        }
        System.out.println("Delivery Address: " + deliveryAddress);

        // Forward the request to the JSP for displaying a response
        request.getRequestDispatcher("/pizza-order.jsp").forward(request, response);
    }
}