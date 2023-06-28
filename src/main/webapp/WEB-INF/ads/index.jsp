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

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        <c:forEach var="cat" items="${ad.getCategories()}">
            <p>${cat}</p>
        </c:forEach>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editModal${ad.title}">
                Edit Listing
            </button>
            <!-- Modal -->
            <div class="modal fade" id="editModal${ad.title}" tabindex="-1" aria-labelledby="editModalLabel${ad.title}" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editModalLabel${ad.title}">Edit Listing</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action="/ads?adId=${ad.id}&option=edit" method="POST">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="title${ad.title}">Title</label>
                                    <input id="title${ad.title}" name="title" class="form-control" type="text" value="${ad.title}">
                                </div>
                                <div class="form-group">
                                    <label for="description${ad.title}">Description</label>
                                    <input id="description${ad.title}" name="description" class="form-control" type="text" value="${ad.description}">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#deleteModal${ad.title}">
                Delete Listing
            </button>
            <!-- Modal -->
            <div class="modal fade" id="deleteModal${ad.title}" tabindex="-1" aria-labelledby="deleteModalLabel${ad.title}" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="deleteModalLabel${ad.title}">Edit Listing</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action="/ads?adId=${ad.id}&option=delete" method="POST">
                            <div class="modal-body">
                                <p>Are you sure want to delete the ad for ${ad.title}</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-primary">Continue</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
<%-- this is for that drop down thing, needed to make sure it was possible. --%>
<%-- <a href="/ads?attributeName=exampleValue&attributeValue=123">Click me</a> --%>
