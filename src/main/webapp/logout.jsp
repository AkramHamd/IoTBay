<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/layout.css">
    <style>
      .log-out-div {
          padding: 70px 0;
      }
  
      .log-out-div h1 {
          font-size: 40px;
          font-weight: 700;
      }

    </style>
    <title>IoTBay - Logout</title>
</head>

<body>
  <%@ include file="assets/nav.jsp" %>

  <%
    session.invalidate();
  %>

  <main>
    <div class="container log-out-div">
      <h1>You're now logged out!</h1>
    </div>
    <div class="container log-out-div">
      <p>Please visit localhost:8080/index to establish connection with database and set all the DAOs</p>
    </div>
    <div class="container" style="display: flex; gap: 20px; margin-top: 100px;">
      <a href="/index.jsp" style="background-color: #d22020; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 25px;">Go to Homepage</a>
    </div>
  </main>

  <%@ include file="assets/footer.jsp" %>
</body>
</html>