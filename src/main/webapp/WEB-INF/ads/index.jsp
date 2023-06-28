<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container-fluid">
    <h1 class="text-center my-3">Here Are all the ads!</h1>
</div>

<div class="container-fluid">
    <div class="row d-flex justify-content-around">
        <c:forEach var="ad" items="${ads}">
            <div class="card col-sm-4 m-2" style="width: 18rem;">
                <div class="card-body" onclick="handleClick(${ad.id})">
                    <h4 id="title-${ad.id}">${ad.title}</h4>
                    <p>${ad.description}</p>
                        <%--                <a class="card-link" href="/ads">View Details</a>--%>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%--hidden form--%>
<form action="/ads" method="POST" name="detailsForm">
    <input id="adTitle" name="adTitle" type="hidden" value="">
</form>

<script type="text/javascript">
    function handleClick(clickedId) {
        let clickedTitle = document.getElementById('title-' + clickedId).innerText;
        document.getElementById('adTitle').value = clickedTitle;
        document.detailsForm.submit();
    }
</script>
</body>
</html>
