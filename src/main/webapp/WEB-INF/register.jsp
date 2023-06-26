
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h1>User Registration</h1>
<form action=${pageContext.request.contextPath}/register method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>

  <input type="submit" value="Register">
</form>
</body>
</html>
</form>
</body>
</html>
