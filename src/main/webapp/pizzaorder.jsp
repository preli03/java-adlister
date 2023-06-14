<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Pizza Order Confirmation</title>
</head>
<body>
<h1>Pizza Order Confirmation</h1>
<p>Thank you for your order!</p>

<h2>Order Details:</h2>
<p>Crust: <%= request.getParameter("crust") %></p>
<p>Sauce: <%= request.getParameter("sauce") %></p>
<p>Size: <%= request.getParameter("size") %></p>
<p>Toppings:</p>
<ul>
  <% String[] toppings = request.getParameterValues("toppings");
    if (toppings != null) {
      for (String topping : toppings) { %>
  <li><%= topping %></li>
  <% }
  } %>
</ul>
<p>Delivery Address: <%= request.getParameter("address") %></p>
</body>
</html>
