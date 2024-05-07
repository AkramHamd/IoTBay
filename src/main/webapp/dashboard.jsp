<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.Log"%>
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
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />

    <link rel="stylesheet" href="css/dashboard.css" />
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

      .dashboard-div {
        padding: 70px 0;
      }

      .dashboard-div h1 {
        font-size: 50px;
        font-weight: 700;
      }

      .main-wrapper {
        display: flex;
        gap: 80px;
        margin-bottom: 200px;
      }

      .main-div {
        flex-grow: 1;
        display: flex;
        flex-direction: column;
        gap: 80px;
      }

      .welcome-div h1 {
        font-size: 22px;
        font-weight: 600;
        margin-bottom: 15px;
      }

      .welcome-div p {
        font-size: 16px;
        font-weight: 300;
      }
    </style>
    <title>IoTBay - Dashboard</title>
  </head>

  <body>
    <%@ include file="assets/nav.jsp" %>

    <% if(customer == null) { %>
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
            <div class="welcome-div">
                <h1>Hi welcome back, <%= customer.getGiven_name()%></h1>
            </div>

            <div>
              <h2>Your details</h2>
              <br>
              <p>Customer ID: <%= customer.getCustomer_id()%></p>
              <p>Given Name: <%= customer.getGiven_name()%></p>
              <p>Family name:  <%= customer.getFamily_name()%></p>
              <p>Email: <%= customer.getEmail()%></p>
              <p>Password: <%= customer.getPassword()%></p>
              <p>Date of Birth: <%= customer.getDob()%></p>
              <p>Phone: <%= customer.getPhone()%></p>
              <p>Registered Date: <%= customer.getCreated_at()%></p>
            </div>

            <%
              String dateTimeStr = customer.getDob();
              String trimmedDateStr = dateTimeStr.substring(0, 10);
            %>
            
            <form action="/UpdateCustomerServlet" method="post">
              <h2>Update details</h2>
              <br>
              
              <input type="text" name="given_name" value="<%= customer.getGiven_name()%>">
              <input type="text" name="family_name" value="<%= customer.getFamily_name()%>">
              <input type="text" name="email" value="<%= customer.getEmail()%>">
              <input type="text" name="password" value="<%= customer.getPassword()%>">
              <input type="text" name="phone" value="<%= customer.getPhone()%>">
              <input type="date" name="dob" value="<%= trimmedDateStr %>">
              <input type="submit" value="Update Details">
            </form>

            <% ArrayList<Log> customerLogs = (ArrayList<Log>) session.getAttribute("customerLogs"); %>

            <div>
              <h2>Logs</h2>
              <br>
              <% for (Log log : customerLogs) { %>
                <p>Log ID: <%= log.getLog_id() %></p>
                <p>Customer ID: <%= log.getCustomer_id() %></p>
                <p>Type: <%= log.getType() %></p>
                <p>Timestamp: <%= log.getTimestamp() %></p>
                <br>
              <% } %>
            </div>
          </div>
        </div>
      </main>
    <% } %>

    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
