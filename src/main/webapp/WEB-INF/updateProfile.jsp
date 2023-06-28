<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Your Profile" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1 style="text-align: center;">Update your profile!</h1>
</div>

<div class="container">
  <h5>Please edit any information you would like to change and enter your password to confirm the changes.</h5>
  <form action="/updateProfile" method="POST">
    <div class="form-group">
      <label for="username">Username</label>
      <input id="username" name="username" class="form-control" type="text" value="${sessionScope.user.username}">
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input id="email" name="email" class="form-control" type="text" value="${sessionScope.user.email}">
    </div>
    <div class="form-group">
      <label for="oldPassword">Current Password</label>
      <input id="oldPassword" name="oldPassword" class="form-control" type="password">
    </div>
    <div class="form-group">
      <label for="newPassword">New Password</label>
      <input id="newPassword" name="newPassword" class="form-control" type="password">
    </div>
    <div class="form-group">
      <label for="confirmNewPassword">New Confirm Password</label>
      <input id="confirmNewPassword" name="confirmNewPassword" class="form-control" type="password">
    </div>
    <c:choose>
      <c:when test="${updateError == true}">
        <p style="color: red;">${updateErrorMessage}</p>
      </c:when>
      <c:when test="${updateSuccess == true}">
        <p style="color: green;">${updateSuccessMessage}</p>
      </c:when>
      <c:otherwise>
        <p></p>
      </c:otherwise>
    </c:choose>
    <input type="submit" class="btn btn-primary btn-block" value="Save">
  </form>
</div>

</body>
</html>
