<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="apple-touch-icon" sizes="180x180" href="/assets/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/assets/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/assets/favicon/favicon-16x16.png">
        <link rel="manifest" href="/assets/favicon/site.webmanifest">
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />

    <link rel="stylesheet" href="css/logout.css" />
    <title>IoTBay - Logout</title>
</head>

<%
  session.invalidate();
%>

<body>
    <nav>
        <div class="container navbar">
          <a href="/index.jsp"
            ><img src="/assets/logo.png" alt="logo" class="logo"
          /></a>
        </div>
      </nav>

      <main>
        <div class="container log-out-div">
          <h1>You're now logged out!</h1>
        </div>
        <div class="container" style="display: flex; gap: 20px; margin-top: 100px;">
          <a href="/login.jsp" style="background-color: #d22020; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 25px;">Login again</a>
          <a href="/index.jsp" style="background-color: #d22020; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 25px;">Go to Homepage</a>
        </div>
      </main>
</body>
</html>