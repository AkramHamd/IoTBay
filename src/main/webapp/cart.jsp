<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*"%>

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

    <link rel="stylesheet" href="css/dashboard.css" />
    <title>IoTBay - Dashboard</title>
  </head>

  <% User isAuthenticated = (User) session.getAttribute("authUser"); %>

  <% if(isAuthenticated == null) { %>
    <%
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("email");
      String password1 = request.getParameter("password1");
      String password2 = request.getParameter("password2");

      if (email != null || firstName != null){
        User user1 = new User(firstName, lastName, email, password1, password2);
        session.setAttribute("authUser", user1);
      }
    %>
  <% } %>


  <body>
    <%@ include file="assets/nav.jsp" %>

    <% if(user == null) { %>
      <div class="container" style="margin-top: 100px; margin-bottom: 100px;">

        <h1>You are not signed in, sign in to save items to cart</h1>
      </div>
    <% } else { %>
      <main>
        <div class="container dashboard-div">
          <h1>Cart</h1>
        </div>
        <div class="container main-wrapper">
          <div class="main-div">
            <div class="welcome-div">
              
              <%
                String authEmail = user.getEmail();
                String authFirstName = user.getFirstName();
              %>
              
              <% if(authFirstName == null) { %>
                <h1>Hi welcome back, <%= authEmail%></h1>
              <% } else { %>
                <h1>Hi welcome back, <%= authFirstName%></h1>
              <% } %>

              <p>You last sign into your account on 31/03/2024</p>       
            </div>
          </div>
        </div>
      </main>
    <% } %>
    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
