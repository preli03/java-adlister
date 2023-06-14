<%--
  Created by IntelliJ IDEA.
  User: patrickmireles
  Date: 6/13/23
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% //created a login and password that will redirect to login page if incorrect or will load the profile page if login is correct
  String username = request.getParameter("username");
  String password = request.getParameter("password");

  if (username != null && password != null && username.equals("admin") && password.equals("password")){
    response.sendRedirect("profile.jsp");
  } else {
    response.sendRedirect("login.jsp");
  }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <title>Login</title>
  <%@ include file="partials/head.jsp" %>
</head>
<body>
<h2>Login</h2>
<h4>Please Login:</h4>
<form action="login.jsp" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username"><br><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password"><br><br>

  <input type="submit" value="Log In">
</form>

</body>
</html>
