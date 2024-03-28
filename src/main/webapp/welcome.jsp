<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <% 
       String favcol = request.getParameter("favcol");
    %>
    <body bgcolor="<%= favcol%>" >
        <%
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String tos = request.getParameter("tos");
        %>
        <h1>Welcome</h1>
        <h2>Email: <%= email%></h2>
        <h2>Name: <%= name%></h2>
        <% if (tos == null){ %>
                <h2>You have not accepted the terms of service!</h2>
        <% }else { %>
                <h2>You have succesfully created an accoutn!</h2>
        <% } %>
    </body>
</html>
