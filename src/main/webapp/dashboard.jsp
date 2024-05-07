<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>

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

      .sidebar-div {
        width: 350px;
        background-color: var(--background-colour);
        border: 1px solid var(--border-colour);
        border-radius: 25px;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-self: flex-start;
      }

      .sidebar-items {
        display: flex;
        justify-content: space-between;
        align-items: center;
      }

      .sidebar-items a {
        text-decoration: none;
        font-weight: 600;
        color: #212121;
      }

      .sidebar-items:hover {
        cursor: pointer;
      }

      #sidebar-item-arrow {
        color: var(--font-colour);
        font-size: 36px;
      }

      .sidebar-items:hover a,
      .sidebar-items:hover #sidebar-item-arrow {
        color: #d22020;
      }

      .arrow-icon {
        width: 15px;
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

      .recommended-div h1 {
        font-size: 22px;
        font-weight: 600;
        margin-bottom: 40px;
      }

      .carousel-div {
        height: 300px;
        display: flex;
        align-items: center;
        gap: 60px;
        justify-content: space-between;
      }

      .carousel-arrow-right,
      .carousel-arrow-left {
        width: 50px;
      }

      .carousel-arrow-right {
        transform: rotate(180deg);
      }

      .products-div {
        flex-grow: 1;
        display: flex;
        gap: 20px;
      }

      .product {
        flex-grow: 1;
        height: 300px;
        background-color: grey;
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
          <!-- <div class="sidebar-div">
            <div class="sidebar-items">
              <a href="/">Home</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Personal Details</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Payment Details</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Active Orders</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Order History</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
            <div class="sidebar-items">
              <a href="/">Wish List</a>
              <i class="material-icons" id="sidebar-item-arrow">chevron_right</i>
            </div>
          </div> -->
         
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
              <p>Address ID: <%= customer.getAddress_id()%></p>
              <p>Log ID: <%= customer.getLog_id()%></p>
              <p>Payment ID: <%= customer.getPayment_id()%></p>
              <p>Order ID: <%= customer.getOrder_id()%></p>
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

            <!-- <div class="recommended-div">
              <h1>Recommended Products</h1>
              <div class="carousel-div">
                <img
                  src="/assets/carousel-icons.png"
                  alt="arrow icon"
                  class="carousel-arrow-left"
                />
                <div class="products-div">
                  <div class="product"></div>
                  <div class="product"></div>
                </div>
  
                <img
                  src="/assets/carousel-icons.png"
                  alt="arrow icon"
                  class="carousel-arrow-right"
                />
              </div>
            </div> -->
          </div>
        </div>
      </main>
    <% } %>

    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
