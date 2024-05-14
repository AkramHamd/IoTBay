<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.Log"%>
<%@page import="uts.isd.model.Address"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="uts.isd.model.dao.ProductDAO"%>
<%@page import="uts.isd.model.dao.DBConnector"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="java.sql.*"%>  
<%@page import="javax.sql.*" %>

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
    <link rel="stylesheet" href="css/style.css" />
    <title>IoTBay - View Product</title>
  </head>

  <body>
    <%@ include file="assets/nav.jsp" %>

    <% if(user == null) { %>
      <div class="container dashboard-div">
        <h1>You are not authenticated</h1>
      </div>
    <% } else if(user.getIs_staff() != "true") { %>
      <main>
        <div class="container dashboard-div">
          <h1>View Products</h1>
        </div>
        <div class="container main-wrapper">         
          <div class="main-div">
            <div class="main-container-product-view">
              <%@ include file="assets/sidebarNav.jsp" %>
              <div class="product-staff-container">
                <div>
                  <p style="font-size: 30px;">View Active Products</p>
                </div>
                <%
                DBConnector conn = new DBConnector(); %>
                <% //open a connection
                Connection con = conn.openConnection(); %>
                <% //use the connection to create a productDAO controller
                ProductDAO productDAO = new ProductDAO(con); %>
                <%-- <% productDAO.setUpProduct(); %> --%>
                <%-- <% productDAO.setUpProduct(); %> --%>
                <% //and use the controller to fetch a list of all of the products and store it in "products" for later use.
                ArrayList<Product> products = productDAO.fetchProducts(); %>
                <div class="staff-product-view heading-view">
                    <p>Id</p>
                    <p>Name</p>
                    <p>Brand</p>
                    <p>Price</p>
                    <p>SOH</p>
                    <p>On Order</p>
                </div>
                <% for(Product product : products) { %>
                    <div class="staff-product-view">
                        <p><%= product.getProductId() %></p>
                        <a href="product_details.jsp?id=<%= product.getProductId() %>"><%= product.getProductName() %></a>
                        <p><%= product.getProductBrand() %></p>
                        <p><%= product.getProductPrice() %></p>
                        <p><%= product.getProductStock() %></p>
                        <p><%= product.getProductOrderQty() %></p>
                    </div>
                <% } %>
            </div>
          </div>
        </div>
      </main>
    <% } else { %>
    <p>You are not staff</p>
    <% } %>

    <%@ include file="assets/footer.jsp" %>
  </body>
</html>
