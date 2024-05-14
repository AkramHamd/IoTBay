<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.Log"%>
<%@page import="uts.isd.model.Address"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="java.sql.*"%>  
<%@page import="javax.sql.*" %>
<%@page import="uts.isd.model.dao.ProductDAO"%>
<%@page import="uts.isd.model.dao.DBConnector"%>

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
    <title>IoTBay - Delete Product</title>
  </head>

  <body>
    <%@ include file="assets/nav.jsp" %>

    <% if(user == null) { %>
      <div class="container dashboard-div">
        <h1>You are not authenticated</h1>
      </div>
    <% } else if(user.getIs_staff() == "false") { %>
        <h1>You are not staff </h1>
    <% } else { %>
      <main>
        <div class="container dashboard-div">
          <h1>Delete Product</h1>
        </div>
        <div class="container main-wrapper">
          <div class="main-div">
            <div class="main-container">
              <%@ include file="assets/sidebarNav.jsp" %>
              <div class="container-delete-product">
                <div>
                  <p style="font-size: 30px;">Update Product</p>
                </div>
                <br>
                <p>Product ID to be deleted</p>
                <form action="/delete_product.jsp" method="get"> 
                    <input type="number" name="id" placeholder="Enter product ID here">
                    <input type="submit">
                </form>
                <form action="/DeleteProductServlet" method="post" class="DeleteProductForm">
                <br>
                <br>
                <% 
                //Set up for the product fetching to display the products that are on the page.
                %>
                <% //initiate a connection using DBConnector (connect to the db)
                DBConnector conn = new DBConnector(); %>
                <% //open a connection
                Connection con = conn.openConnection(); %>
                <% //use the connection to create a productDAO controller
                ProductDAO productDAO = new ProductDAO(con); %>
                <% 
                String productIdString = request.getParameter("id"); 
                Integer productID;
                if(productIdString == null) {
                    productID = 0;
                } else {
                    productID = Integer.parseInt(productIdString);
                }
                %>
            <%
                if (productID != 0) {
                Product product = productDAO.selectSpecificProduct(productID); %>
                    <input type="hidden" name="product_id" value="<%= product.getProductId() %>">
                    <div class="delete-product-table">
                        <p>Product ID: </p><p><%= product.getProductId() %></p>
                    </div>
                    <div class="delete-product-table">
                        <p>Product Name: </p><p><%= product.getProductName() %></p>
                    </div>
                    <div class="delete-product-table">
                        <p>Product Brand: </p><p><%= product.getProductBrand() %></p>
                    </div>
                    <%-- <div class="delete-product-table">
                        <p>Product Image URL: </p><p><%= product.getProductImg() %></p>
                    </div> --%>
                    <div class="delete-product-table">
                        <p>Product Price: </p><p><%= product.getProductPrice() %></p>
                    </div>
                    <div class="delete-product-table">
                        <p>Product Special Price: </p><p><%= product.getProductSpecialPrice() %></p>
                    </div>
                    <div class="delete-product-table">
                        <p>Special Status: </p><p><%= product.getProductOnSpecial() %></p>
                    </div>
                    <br>
                    <br>
                    <input type="submit" value="Delete Product '<%= product.getProductName() %>'">
                    </form>
                    <% } else { %>
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
