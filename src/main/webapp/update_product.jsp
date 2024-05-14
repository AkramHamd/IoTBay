<%                                                      

//          Created for ISD 41025 Assignment Two        //
//          This file is a part of feature Two          //
//          Authored by Bradley Madgwick 14249522       //

                                                        %>
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
    <title>IoTBay - Update Product</title>
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

    <title>IoTBay - Update Product</title>
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
          <h1>Update Product</h1>
        </div>
        <div class="container main-wrapper">
          <div class="main-div">
            <div class="main-container">
              <%@ include file="assets/sidebarNav.jsp" %>
              <div>
                <div>
                  <p style="font-size: 30px;">Update Product</p>
                </div>
                <br>
                <p>Product Id to be updated</p>
                <form action="/update_product.jsp" method="get"> 
                    <input type="number" name="id" placeholder="Enter product ID here">
                    <input type="submit">
                </form>
                <form action="/UpdateProductServlet" method="post" class="createProductForm">
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
                    <p>Product Name</p>
                    <span>Omit brand from product name</span>
                    <input type="text" name="product_name" value="<%= product.getProductName() %>">
                    <p>Product Brand</p>
                    <input type="text" name="product_brand" value="<%= product.getProductBrand() %>">
                    <p>Product Description</p>
                    <input type="text" name="product_description" value="<%= product.getProductDescription() %>">
                    <p>Product Image URL</p>
                    <input type="text" name="product_img" value="<%= product.getProductImg() %>">
                    <p>Product Price</p>
                    <input type="number" name="product_price" value="<%= product.getProductPrice() %>">
                    <p>Product Price when it is on Special</p>
                    <input type="number" name="product_special_price" value="<%= product.getProductPrice() %>">
                    <p>Is the Product on Special?</p>
                    <div class="form-inline">
                        <label for="product_on_special_true">True</label>
                        <input type="radio" name="product_on_special" value="true">
                    </div>
                    <div class="form-inline">
                        <label for="product_on_special_false">False</label>
                        <input type="radio" name="product_on_special" value="false">
                    </div>
                    <p>Product Stock</p>
                    <input type="number" name="product_stock" value="<%= product.getProductStock() %>">
                    <p>Amount of stock on order from supplier</p>
                    <input type="text" name="product_order_qty" value="<%= product.getProductOrderQty() %>">
                    <p>Short description for the product</p>
                    <%-- <input type="text" name="product_short_description" placeholder="<%= product.getProductShortDesc() %>"> --%>
                    <input type="submit" value="Update Product '<%= product.getProductName() %>'">
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
