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

            <div class="main-container">

              <div class="sidebar-div">
                <div class="sidebar-items">
                  <a href="/dashboard.jsp">Your Details</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
                <div class="sidebar-items">
                  <a href="/update_details.jsp">Update Details</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
                <div class="sidebar-items">
                  <a href="/add_address.jsp">Add Address</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
                <div class="sidebar-items">
                  <a href="/update_address.jsp">Update Address</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
                <div class="sidebar-items">
                  <a href="/view_logs.jsp" style="color: #d22020;">View logs</a>
                  <i class="material-icons" id="sidebar-item-arrow" style="color: #d22020;">chevron_right</i>
                </div>
              </div>

              <div>
                <h2>View Logs</h2>
                <br>
                <br>
 
                <% ArrayList<Log> customerLogs = (ArrayList<Log>) session.getAttribute("customerLogs"); %>

                <div>
                  <% for (Log log : customerLogs) { %>
                    <div style="display: flex; gap: 30px; background-color: #fdfdfd; border: 1px solid var(--border-colour); border-radius: 10px; padding: 20px;">
                      <div style="display: flex; flex-direction: column; gap: 10px;">
                        <p style="font-weight: 600;">Log ID:</p>
                        <p style="font-weight: 600;">Customer ID:</p>
                        <p style="font-weight: 600;">Type:</p>
                        <p style="font-weight: 600;">Timestamp:</p>
                      </div>
                      <div style="display: flex; flex-direction: column; gap: 10px;">
                        <p><%= log.getLog_id() %></p>
                        <p><%= log.getCustomer_id() %></p>
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
