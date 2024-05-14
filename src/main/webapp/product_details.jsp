<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="java.sql.*"%>  
<%@page import="javax.sql.*" %>
<%@page import="uts.isd.model.dao.ProductDAO"%>
<%@page import="uts.isd.model.dao.DBConnector"%>

<html>
    <head>
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
    
    <%-- Create a new user object using session data --%>
    <%-- <% User user = (User) session.getAttribute("authUser"); %> --%>

    <body>
        <%@ include file="assets/nav.jsp" %>
          <main>
            <div class="product-details-container">
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
            Integer productId = Integer.parseInt(productIdString);
            %>
            <% 
            //and use the controller to fetch a list of all of the products and store it in "products" for later use.
            Product product = productDAO.selectSpecificProduct(productId); %>
                <div class="product-details-container-upper-flex">
                    <img src="<%= product.getProductImg() %>">
                    <div class="product-details-heading">
                        <h1><%= product.getProductName() %> </h1>
                        <p><%= product.getProductShortDesc() %></p>
                    </div>
                    
                </div>
                
                <div class="product-details-container-lower-flex">
                    <p><%= product.getProductDescription() %></p>
                </div>
            </div>
          </main>
        <%@ include file="assets/footer.jsp" %>
    </body>
</html>