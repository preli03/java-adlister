<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container-fluid">
    <h1 class="text-center my-3">Here Are all the ads!</h1>
</div>

<div class="container-fluid">
    <div class="row d-flex justify-content-around">
    <c:forEach var="ad" items="${ads}">
        <div class="card col-sm-4 m-2" style="width: 18rem;">
            <div class="card-body">
                <h4>${ad.title}</h4>
                <p>${ad.description}</p>
                <a href="/ads" class="card-link">View Ad</a>
            </div>
        </div>
    </c:forEach>
    </div>
</div>

</body>
</html>
