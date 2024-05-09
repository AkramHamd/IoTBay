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
                <div class="sidebar-items">
                  <a href="/delete_account.jsp">Delete Account</a>
                  <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
                </div>
              </div>

              <div style="width: 100%;">
                <h2>Personal details</h2>
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

                <% ArrayList<Address> customerAddresses = (ArrayList<Address>) session.getAttribute("customerAddresses"); %>

                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <h2>Addresses</h2>
                <br>
                <br>
                <div style="display: grid; grid-template-columns: repeat(4, 1fr);">
                  <% if(customerAddresses != null && !customerAddresses.isEmpty()) { %>
                    <% for(Address address : customerAddresses) { %>
                    
                        <div style="width: 350px; background-color: #fdfdfd; border: 1px solid var(--border-colour); border-radius: 10px; padding: 20px; margin-bottom: 20px;">
                          <div class="details-div-wrapper" >
                            <div class="details-div details-div-title">
                              <p>Address ID:</p>
                              <p>Customer ID:</p>
                              <p>Unit Number:</p>
                              <p>Street Number:</p>
                              <p>Name Name:</p>
                              <p>Suburb:</p>
                              <p>State:</p>
                              <p>Postcode:</p>
                              <p>Country:</p>
                            </div>
                            <div class="details-div">
                              <p><%= address.getAddress_id() %></p>
                              <p><%= address.getCustomer_id() %></p>
                              <p><%= address.getUnit_number() %></p>
                              <p><%= address.getStreet_number() %></p>
                              <p><%= address.getStreet_name() %></p>
                              <p><%= address.getSuburb() %></p>
                              <p><%= address.getState() %></p>
                              <p><%= address.getPostcode() %></p>
                              <p><%= address.getCountry() %></p>
                            </div>
                          </div>
  
                          <div style="display: flex; justify-content: space-between; gap: 10px; margin-top: 20px;">
                            <button><a style="text-decoration: none; color: #000;" href="/update_address.jsp?address_id=<%= address.getAddress_id() %>&customer_id=<%= address.getCustomer_id() %>&unit_number=<%= address.getUnit_number() %>&street_number=<%= address.getStreet_number() %>&street_name=<%= address.getStreet_name() %>&suburb=<%= address.getSuburb() %>&state=<%= address.getState() %>&postcode=<%= address.getPostcode() %>&country=<%= address.getCountry() %>">Update Address</a></button>
                            <form action="/DeleteAddressServlet" method="post">
                              <input type="hidden" name="address_id" value="<%= address.getAddress_id() %>">
                              <input type="submit" value="Delete address">
                            </form>
                          </div>
                          
                        </div>
                    
                      
                        
                    <% } %>
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
