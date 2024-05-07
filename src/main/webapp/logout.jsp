<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
    <div class="container" style="display: flex; gap: 20px; margin-top: 100px;">
      <a href="/login.jsp" style="background-color: #d22020; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 25px;">Login again</a>
      <a href="/index.jsp" style="background-color: #d22020; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 25px;">Go to Homepage</a>
    </div>
  </main>

  <%@ include file="assets/footer.jsp" %>
</body>
</html>