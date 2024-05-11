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
                <h2>Search logs</h2>
                <br>
                <br>
                <label for="date">Search for logs </label>
                <input type="date" name="date">
                <br>
                <br>
                <br>
                <br>
 
                <% ArrayList<Log> logs = (ArrayList<Log>) session.getAttribute("logs"); %>

                <div>
                  <% for (Log log : logs) { %>
                    <div style="display: flex; gap: 30px; background-color: #fdfdfd; border: 1px solid var(--border-colour); border-radius: 10px; padding: 20px;">
                      <div style="display: flex; flex-direction: column; gap: 10px;">
                        <p style="font-weight: 600;">Log ID:</p>
                        <p style="font-weight: 600;">User ID:</p>
                        <p style="font-weight: 600;">Type:</p>
                        <p style="font-weight: 600;">Timestamp:</p>
                      </div>
                      <div style="display: flex; flex-direction: column; gap: 10px;">
                        <p><%= log.getLog_id() %></p>
                        <p><%= log.getUser_id() %></p>
                        <p><%= log.getType() %></p>
                        <p><%= log.getTimestamp() %></p>
                      </div>
                    </div>
                    <br>
                  <% } %>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    <% } %>

    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
