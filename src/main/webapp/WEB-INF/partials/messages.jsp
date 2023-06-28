


<% String error = (String) request.getAttribute("error");
    if (error != null) { %>
<div class="alert alert-danger" role="alert">
    <%= error %>
</div>
<% } %>
