<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="css/layout.css">-->
        <script type="text/javascript" src="js/index.js"></script>
        <title>Index Page</title>
    </head>
    <body onload="startTime()" >
        <h1>Home Page</h1>
        <a href="/register.jsp">Register an Account</a>
        <br>

        <a href="/login.jsp">Login</a>
        <br>

        <a href="/dashboard.jsp">Dashboard</a>
        
        <% User user = (User) session.getAttribute("authUser"); %>

        <% if(user == null) { %>
            <p>You are not registered or authenticated</p>
        <% } else { %>
            <p>You are authenticated <%=user.getFirstName() %></p>
        <% } %>
            
    </body>
</html>
