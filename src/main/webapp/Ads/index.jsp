<%@ page import="ListAdsDao.java" %>
<%@ page import="your.package.Ad" %> <!-- Replace "your.package" with the actual package containing your classes -->

<!DOCTYPE html>
<html>
<head>
    <title>All Ads</title>
</head>
<body>
<h1>All Ads</h1>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <!-- Add more columns as per your Ad object properties -->
    </tr>
    </thead>
    <tbody>
    <%
        List<Ad> ads = ListAdsDao.all(); // Retrieve all ads using the ListAdsDao class

        for (Ad ad : ads) {
    %>
    <tr>
        <td><%= ad.getTitle() %></td>
        <td><%= ad.getDescription() %></td>
        <!-- Add more cells to display other ad properties -->
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
