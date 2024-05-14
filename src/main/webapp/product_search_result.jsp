<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="java.sql.*"%>  
<%@page import="javax.sql.*" %>
<%@page import="uts.isd.model.dao.ProductDAO"%>
<%@page import="uts.isd.model.dao.DBConnector"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="apple-touch-icon" sizes="180x180" href="/assets/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/assets/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/assets/favicon/favicon-16x16.png">
        <link rel="manifest" href="/assets/favicon/site.webmanifest">
        <link rel="stylesheet" href="css/layout.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>IoTBay</title>
        <%-- jquery for enabling bootstrap --%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <%-- enabling bootstrap --%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>

    <body >
        <%@ include file="assets/nav.jsp" %>
        <main>
            <div>
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
            ArrayList<Integer> productsID = (ArrayList<Integer>) session.getAttribute("searchIDResult");
            ArrayList<Product> products = productDAO.selectArrayProduct(productsID);
            %>
            </div>
            <div class="container-products">
                <% 
                for (Product product : products) { %>
                        <a href="product_details.jsp?id=<%= product.getProductId() %>" class="product-card-a">
                            <div class="product-card">
                                <img src="<%= product.getProductImg() %>" alt="<%= product.getProductName() %>">
                                <div class="product-details">
                                    <h3><%= product.getProductName() %></h3>
                                    <p><%= product.getProductBrand() %> </p>
                                    <p><%= product.getProductShortDesc() %> </p>
                                    <p class="price">$<%= product.getProductPrice() %></p>
                                    <a href="#" class="btn">Add to cart</a>
                                </div>
                            </div>
                        </a>
                <% } %>
            </div>
        </main>
        <%@ include file="assets/footer.jsp" %>
    </body>
</html>
