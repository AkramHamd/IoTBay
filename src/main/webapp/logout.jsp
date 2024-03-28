<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />

    <link rel="stylesheet" href="css/logout.css" />
    <title>IoTBay - Logout</title>
</head>

<%
  if (session != null) {
    session.invalidate();
  }
%>

<body>
    <nav>
        <div class="container navbar">
          <a href="/index.jsp"
            ><img src="/assests/logo.png" alt="logo" class="logo"
          /></a>
        </div>
      </nav>

      <main>
        <div class="container log-out-div">
          <h1>You're now logged out!</h1>
        </div>
      </main>
</body>
</html>