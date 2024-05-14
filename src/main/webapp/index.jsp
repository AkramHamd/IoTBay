<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="180x180" href="/assets/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/assets/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/assets/favicon/favicon-16x16.png">
        <link rel="manifest" href="/assets/favicon/site.webmanifest">
        <link rel="stylesheet" href="css/layout.css" type="text/css">
        <link rel="stylesheet" href="css/index.css" type="text/css">
        <title>Index Page</title>
    </head>

    <body >
        <%@ include file="assets/nav.jsp" %>

        <main class="container">
            <h1>Home page still under construction</h1>

            <p style="margin-top: 50px; margin-bottom: 50px;">You need to visit localhost:8080/index in order for the system to connect to the database and set all the DAOs</p>

                
            <% if(user == null) { %>
                <p>You are NOT authenticated</p>
            <% } else { %>
                <p>You are authenticated</p>
            <% } %>
        </main>

        
        <form method="post" action="/pay">
            <div class="input-div">
                <input name="orderId" type="hidden" value=100 />


            </div>
            <div class="submit-div">
                <input type="submit" value="Pay" />

            </div>
        </form>

        <%@ include file="assets/footer.jsp" %>
    </body>
</html>
