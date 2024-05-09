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
                  <a href="/add_address.jsp" style="color: #d22020;">Add Address</a>
                  <i class="material-icons" id="sidebar-item-arrow" style="color: #d22020;">chevron_right</i>
                </div>
                <div class="sidebar-items">
                  <a href="/update_address.jsp">Update Address</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
                <div class="sidebar-items">
                  <a href="/view_logs.jsp">View logs</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
              </div>

              <div>
                <h2>Add address</h2>
                <br>
                <br>
  
                <% Address address = (Address) session.getAttribute("address"); %>

                <form action="/AddAddressServlet" method="post" style="display: flex; flex-direction: column; gap: 20px;">
                  <input type="hidden" name="customer_id" value="<%= customer.getCustomer_id() %>">
                  <input type="number" name="unit_number" placeholder="unit_number">
                  <input type="number" name="street_number" placeholder="street_number">
                  <input type="text" name="street_name" placeholder="street_name">
                  <input type="text" name="suburb" placeholder="suburb">
                  <input type="text" name="state" placeholder="state">
                  <input type="number" name="postcode" placeholder="postcode">
                  <input type="text" name="country" placeholder="country">
                  <input type="submit" value="Add Address">
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
