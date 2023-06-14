<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Pick Color</title>
</head>
<body>
<h1>Pick Your Favorite Color</h1>
<form action="${pageContext.request.contextPath}/PickColorServlet" method="POST">
  <label for="color">Favorite Color:</label>
  <input type="text" id="color" name="color" required>
  <br>
  <input type="submit" value="Submit">
</form>
</body>
</html>
