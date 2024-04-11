<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="180x180" href="/assets/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/assets/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/assets/favicon/favicon-16x16.png">
        <link rel="manifest" href="/assets/favicon/site.webmanifest">
        
        <link rel="stylesheet" href="css/index.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Index Page</title>
    </head>


    <body >
        <%@ include file="assets/nav.jsp" %>
          <main class="container">
            <h1>Home page still under construction</h1>
                
            <% if(user == null) { %>
                <p>You are NOT authenticated</p>
            <% } else { %>
                <p>You are authenticated</p>
            <% } %>
          </main>
          <%@ include file="assets/footer.jsp" %>
    </body>
</html>
