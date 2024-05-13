<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.Log"%>
<%@page import="uts.isd.model.Address"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="apple-touch-icon" sizes="180x180" href="/assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="/assets/favicon/site.webmanifest">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/dashboard.css" />
    <title>IoTBay - Dashboard</title>
  </head>

  <body>
    <%@ include file="assets/nav.jsp" %>

    <% if(user == null) { %>
      <div class="container dashboard-div">
        <h1>You are not authenticated</h1>
      </div>
    <% } else { %>
      <main>
        <div class="container dashboard-div">
          <h1>Dashboard</h1>
        </div>
        <div class="container main-wrapper">
         
          <div class="main-div">

            <div class="main-container">

              <%@ include file="assets/sidebarNav.jsp" %>

              <div>
                <h2>Delete account</h2>
                <br>
                <p>This will account your account and anything associated with this account BUT we will keep your logs history for security reasons :)</p>
                <br>
                <br>
                <br>
                <br>
                <p>Are you sure you want to delete your account? This can not be reversed</p>
                <br>

                <form action="/DeleteUserServlet" method="post">
                  <input type="submit" value="Delete account">
                </form>
              </div>
            </div>
          </div>
        </div>
      </main>
    <% } %>

    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
