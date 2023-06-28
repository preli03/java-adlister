<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Adlister</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownAds" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">View Ads</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownAds">
                        <li><a class="dropdown-item" href="/ads">Clothes</a></li>
                        <li><a class="dropdown-item" href="/ads">Electronics</a></li>
                        <li><a class="dropdown-item" href="/ads">Vehicles</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/ads">View all Ads</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ads/create">Create Ad</a>
                </li>
            </ul>
            <form class="d-flex my-auto">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
            <c:choose>
                <c:when test="${user == null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <div class="dropdown">
                    <li class="nav navbar-nav navbar-right">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownUser" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">${sessionScope.user.username}</a>
                        <ul class="dropdown-menu dropdown-menu-lg-end" aria-labelledby="navbarDropdownUser">
                            <li><a class="dropdown-item" href="/profile">Profile</a></li>
                            <li><a class="dropdown-item" href="/ads/create">Create Ad</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/logout">Logout</a></li>
                        </ul>
                    </li>
            </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>


