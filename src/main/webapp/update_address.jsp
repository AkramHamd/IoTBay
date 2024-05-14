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
                <h2>Update address</h2>
                <br>
                <br>

                <%
                String addressIdParam = request.getParameter("address_id");
                int addressId = 0;
                int customerId = 0;
                int unitNumber = 0;
                int streetNumber = 0;
                String streetName = null;
                String suburb = null;
                String state = null;
                int postcode = 0;
                String country = null;

                if(addressIdParam != null) {
                    addressId = Integer.parseInt(request.getParameter("address_id"));
                    customerId = Integer.parseInt(request.getParameter("customer_id"));
                    unitNumber = Integer.parseInt(request.getParameter("unit_number"));
                    streetNumber = Integer.parseInt(request.getParameter("street_number"));
                    streetName = request.getParameter("street_name");
                    suburb = request.getParameter("suburb");
                    state = request.getParameter("state");
                    postcode = Integer.parseInt(request.getParameter("postcode"));
                    country = request.getParameter("country"); 
                } 
                %>

                <% if(addressIdParam != null) { %>

                <form action="/UpdateAddressServlet" method="post" style="display: flex; flex-direction: column; gap: 20px;">
                  <input type="hidden" name="address_id" value="<%= addressId %>">
                  <input type="hidden" name="customer_id" value="<%= customerId %>">
                  <input type="number" name="unit_number" value="<%= unitNumber %>">
                  <input type="number" name="street_number" value="<%= streetNumber %>">
                  <input type="text" name="street_name" value="<%= streetName %>">
                  <input type="text" name="suburb" value="<%= suburb %>">
                  <input type="text" name="state" value="<%= state %>">
                  <input type="number" name="postcode" value="<%= postcode %>">
                  <input type="text" name="country" value="<%= country %>">
                  <input type="submit" value="Update Address">
                </form>

                <% } else { %>
                  <p>No address is added to be updated</p>
                <% } %>

                
              </div>
            </div>
          </div>
        </div>
      </main>
    <% } %>

    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
