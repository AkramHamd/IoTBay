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

        <h1>You are not authenticated</h1>
      </div>
    <% } else { %>
      <main>
        <div class="container dashboard-div">
          <h1>Dashboard</h1>
        </div>
        <div class="container main-wrapper">
          <div class="sidebar-div">
            <div class="sidebar-items">
              <a href="/">Home</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Personal Details</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Payment Details</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Active Orders</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Order History</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Wish List</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
          </div>
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
            <div class="recommended-div">
              <h1>Recommended Products</h1>
              <div class="carousel-div">
                <img
                  src="/assets/carousel-icons.png"
                  alt="arrow icon"
                  class="carousel-arrow-left"
                />
                <div class="products-div">
                  <div class="product"></div>
                  <div class="product"></div>
                </div>
  
                <img
                  src="/assets/carousel-icons.png"
                  alt="arrow icon"
                  class="carousel-arrow-right"
                />
              </div>
            </div>
          </div>
        </div>
      </main>
    <% } %>
    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
