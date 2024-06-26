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

    <title>IoTBay - View All Logs</title>
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

              <% if(user != null && "true".equals(user.getIs_staff())) { %>

              <% String view_all_logsDateEmpty = (String) session.getAttribute("view_all_logsDateEmpty"); %>

              <% ArrayList<Log> searchedAllLogs = (ArrayList<Log>) session.getAttribute("searchedAllLogs"); %>

            <div>
              <h2 style="margin-bottom: 50px;">View all Logs</h2>

              <form action="SearchAllLogsServlet" method="post" style="margin-bottom: 25px;">
                <% if(view_all_logsDateEmpty != null) { %>
                  <p style="color: red;"><%=view_all_logsDateEmpty%></p>
                <% } %>
                <label for="date">Search for logs </label>
                <input type="date" name="date">
                <input type="submit" value="Search">
              </form>

              <div>
                <% if (searchedAllLogs != null) { %>
                  <h3 style="margin-bottom: 25px;">Searched logs</h3>

                  <% if (searchedAllLogs.size() == 0) { %>
                    <p>No logs found for that date</p>
                  <% } %>
                  <% for (Log log : searchedAllLogs) { %>
                    <div style="display: flex; gap: 30px; background-color: #fdfdfd; border: 1px solid var(--border-colour); border-radius: 10px; padding: 20px; margin-bottom: 10px;">
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
                    <% } %>

                    <form action="ClearSearchAllLogsServlet" method="post">  
                      <input type="hidden" name="user_id" value="<%= user.getUser_id() %>">
                      <input type="submit" value="Clear search">
                    </form>
                <% } %>
              </div>
 
                <% ArrayList<Log> allLogs = (ArrayList<Log>) session.getAttribute("allLogs"); %>

                <div>
                  <% if(searchedAllLogs == null) { %>
                    <h3 style="margin-bottom: 25px;">All your logs</h3>

                    <% for (Log log : allLogs) { %>
                      <div style="display: flex; gap: 30px; background-color: #fdfdfd; border: 1px solid var(--border-colour); border-radius: 10px; padding: 20px; margin-bottom: 10px;">
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
                    <% } %>
                  <% } %>
                </div>
              </div>
              <% } else { %>
                <h1>You are not a staff</h1>
              <% } %>
            </div>
          </div>
        </div>
      </main>
      
    <% } %>

    <%@ include file="assets/footer.jsp" %>

  </body>
</html>
