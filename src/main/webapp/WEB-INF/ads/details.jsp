<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing Ad Details"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container-fluid">
    <h1 class="text-center my-3">Ad Details</h1>
</div>

<div class="container-fluid">
    <c:forEach var="ad" items="${ads}">
        <div class="card text-center">
            <div class="card-body">
                <div>
                <img src="http://placekitten.com/300/200" class="card-img-top" alt="..." style="width: 300px; height: 200px;">
                </div>
                <h4 id="title-${ad.id}">${ad.title}</h4>
                <p>${ad.description}</p>
                <a class="card-link" href="/ads">Return to Ads</a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
