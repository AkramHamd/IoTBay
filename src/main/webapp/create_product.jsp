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

    <title>IoTBay - Create Product</title>
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
          <h1>Create Product</h1>
        </div>
        <div class="container main-wrapper">
          <div class="main-div">
            <div class="main-container">

              <%@ include file="assets/sidebarNav.jsp" %>

              <div>
                <div>
                  <p style="font-size: 30px;">Create a Product</p>
                </div>
                 <form action="/CreateProductServlet" method="post" class="createProductForm">
                 <br>
                 <p>Product Name</p>
                 <span>Omit brand from product name</span>
                  <input type="text" name="product_name" placeholder="E.g. Nest-Mini">
                  <p>Product Brand</p>
                  <input type="text" name="product_brand" placeholder="E.g. Google">
                  <p>Product Description</p>
                  <input type="text" name="product_description" placeholder="Long description including product features">
                  <p>Product Image URL</p>
                  <input type="text" name="product_img" placeholder="Provide either a local URL e.g. assets/imgs/---.png or an internet URL">
                  <p>Product Price</p>
                  <input type="number" name="product_price">
                  <p>Product Price when it is on Special</p>
                  <input type="number" name="product_special_price">
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
                  <input type="number" name="product_stock">
                  <p>Amount of stock on order from supplier</p>
                  <input type="text" name="product_order_qty">
                  <p>Short description for the product</p>
                  <input type="text" name="product_short_description">
                  <input type="submit" value="Create Product">
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
