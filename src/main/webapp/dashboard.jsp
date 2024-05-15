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
                <div>
                  <p style="font-size: 30px; margin-bottom: 100px;">Hi welcome back, <%= user.getGiven_name()%></p>
                </div>

                <h2 style="margin-bottom: 50px;">Personal details</h2>

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
                    <p>Is staff:</p>
                  </div>
                  <div class="details-div">
                    <p><%= user.getUser_id()%></p>
                    <p><%= user.getGiven_name()%></p>
                    <p><%= user.getFamily_name()%></p>
                    <p><%= user.getEmail()%></p>
                    <p><%= user.getPassword()%></p>
                    <p><%= user.getDob()%></p>
                    <p><%= user.getPhone()%></p>
                    <p><%= user.getCreated_at()%></p>
                    <p><%= user.getVerification_code()%></p>
                    <p><%= user.getIs_verified()%></p>
                    <p><%= user.getIs_staff()%></p>
                  </div>
                </div>

                <% ArrayList<Address> addresses = (ArrayList<Address>) session.getAttribute("addresses"); %>

                <h2 style="margin-top: 100px; margin-bottom: 50px;">Addresses</h2>

                <div style="display: grid; grid-template-columns: repeat(2, 1fr); gap: 10px;">
                  <% if(addresses != null && !addresses.isEmpty()) { %>
                    <% for(Address address : addresses) { %>
                    
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
                              <p><%= address.getUser_id() %></p>
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
                            <button><a style="text-decoration: none; color: #000;" href="/update_address.jsp?address_id=<%= address.getAddress_id() %>&customer_id=<%= address.getUser_id() %>&unit_number=<%= address.getUnit_number() %>&street_number=<%= address.getStreet_number() %>&street_name=<%= address.getStreet_name() %>&suburb=<%= address.getSuburb() %>&state=<%= address.getState() %>&postcode=<%= address.getPostcode() %>&country=<%= address.getCountry() %>">Update Address</a></button>
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