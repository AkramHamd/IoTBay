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
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');

            * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Inter', sans-serif;
            letter-spacing: 0.7px;
            }

            :root {
            --primary: #d22020;
            --border-colour: #d1d1d1;
            --background-colour: #f1f3f5;
            --font-colour: #858585;
            }

            .container {
            width: 80%;
            margin: 0 auto;
            }

            main {
                padding: 100px 0;
                display: flex;
                flex-direction: column;
                gap: 20px;
            }
        </style>
        <title>Index Page</title>
    </head>

    <body >
        <%@ include file="assets/nav.jsp" %>

        <main class="container">
            <h1>Home page still under construction</h1>
                
            <% if(customer == null) { %>
                <p>You are NOT authenticated</p>
            <% } else { %>
                <p>You are authenticated</p>
            <% } %>
        </main>

        <%@ include file="assets/footer.jsp" %>
    </body>
</html>
