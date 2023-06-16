<%--
  Created by IntelliJ IDEA.
  User: patrickmireles
  Date: 6/14/23
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
  <h1>Enter your name below!</h1>
  <form action="${pageContext.request.contextPath}/hello" method="POST">
    <div class="form-group">
      <label for="name">Enter your name:</label>
      <!--Parameter name = "name"-->
      <input id="name" name="name" class="form-control" type="text">
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Submit">
  </form>
</div>

</body>
</html>
