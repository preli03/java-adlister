<%@ page import="java.util.List" %>


<% List<String> errorMessages = (List<String>) session.getAttribute("errorMessages");
    if (errorMessages != null && !errorMessages.isEmpty()) { %>
<div class="alert alert-danger" role="alert">
    <ul>
        <% for (String errorMessage : errorMessages) { %>
        <li><%= errorMessage %></li>
        <% } %>
    </ul>
</div>
<% } %>
