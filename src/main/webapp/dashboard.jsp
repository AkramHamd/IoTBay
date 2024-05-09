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
                  <a href="/dashboard.jsp" style="color: #d22020;">Your Details</a>
                  <i class="material-icons" id="sidebar-item-arrow" style="color: #d22020;">chevron_right</i>
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
                  <a href="/view_logs.jsp">View logs</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
              </div>

              <div>
                <h2>Your details</h2>
                <br>
                <br>
                <div class="details-div-wrapper">
                  <div class="details-div details-div-title">
                    <p>Customer ID:</p>
                    <p>Given Name:</p>
                    <p>Family name:</p>
                    <p>Email:</p>
                    <p>Password:</p>
                    <p>Date of Birth:</p>
                    <p>Phone:</p>
                    <p>Registered Date:</p>
                    <p>Verification Code:</p>
                    <p>Is verified:</p>
                  </div>
                  <div class="details-div">
                    <p><%= customer.getCustomer_id()%></p>
                    <p><%= customer.getGiven_name()%></p>
                    <p><%= customer.getFamily_name()%></p>
                    <p><%= customer.getEmail()%></p>
                    <p><%= customer.getPassword()%></p>
                    <p><%= customer.getDob()%></p>
                    <p><%= customer.getPhone()%></p>
                    <p><%= customer.getCreated_at()%></p>
                    <p><%= customer.getVerification_code()%></p>
                    <p><%= customer.getIs_verified()%></p>
                  </div>
                </div>

                <% Address address = (Address) session.getAttribute("address"); %>

                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <h2>Your Address</h2>
                <br>
                <br>
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
                  <% } else { %>
                    <p>No address added</p>
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
