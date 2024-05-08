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
              <p>Verification Code: <%= customer.getVerification_code()%></p>
              <p>Is verified: <%= customer.getIs_verified()%></p>
            </div>

            <% Address address = (Address) session.getAttribute("address"); %>

            <div>
              <% if(address != null) { %>
                <p>Address ID: <%= address.getAddress_id() %></p>
                <p>Customer ID: <%= address.getCustomer_id() %></p>
                <p>Unit Number: <%= address.getUnit_number() %></p>
                <p>Street Number: <%= address.getStreet_number() %></p>
                <p>Name Name: <%= address.getStreet_name() %></p>
                <p>Suburb: <%= address.getSuburb() %></p>
                <p>State: <%= address.getState() %></p>
                <p>Postcode: <%= address.getPostcode() %></p>
                <p>Country: <%= address.getCountry() %></p>
              <% } %>
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
            
            <% if(address == null) { %>
              <form action="/AddAddressServlet" method="post">
                <h2>Add address</h2>
                <br>

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
            <% } else { %>
              <form action="/UpdateAddressServlet" method="post">
                <h2>Update address</h2>
                <br>

                <input type="hidden" name="address_id" value="<%= address.getAddress_id() %>">
                <input type="number" name="unit_number" value="<%= address.getUnit_number() %>">
                <input type="number" name="street_number" value="<%= address.getStreet_number() %>">
                <input type="text" name="street_name" value="<%= address.getStreet_name() %>">
                <input type="text" name="suburb" value="<%= address.getSuburb() %>">
                <input type="text" name="state" value="<%= address.getState() %>">
                <input type="number" name="postcode" value="<%= address.getPostcode() %>">
                <input type="text" name="country" value="<%= address.getCountry() %>">
                <input type="submit" value="Update Address">
              </form>
            <% } %>

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
