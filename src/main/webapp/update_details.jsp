<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.Log"%>
<%@page import="uts.isd.model.Address"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="css/layout.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/dashboard.css" type="text/css">

    <link rel="apple-touch-icon" sizes="180x180" href="/assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="/assets/favicon/site.webmanifest">
    <script type="text/javascript" src="js/index.js"></script>
    <%-- jquery for enabling bootstrap --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <%-- enabling bootstrap --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />

    <title>IoTBay - Update Details</title>
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
                <h2>Update details</h2>
                <br>
                <br>
                <br>

                <%
                  String dateTimeStr = user.getDob();
                  String trimmedDateStr = dateTimeStr.substring(0, 10);
                %>

                <form action="/UpdateUserServlet" method="post" style="display: flex; flex-direction: column; gap: 20px;">                  
                    <input type="text" name="given_name" value="<%= user.getGiven_name()%>">
                    <input type="text" name="family_name" value="<%= user.getFamily_name()%>">
                    <input type="text" name="email" value="<%= user.getEmail()%>">
                    <input type="text" name="password" value="<%= user.getPassword()%>">
                    <input type="text" name="phone" value="<%= user.getPhone()%>">
                    <input type="date" name="dob" value="<%= trimmedDateStr %>">
                    <input type="submit" value="Update Details">
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
