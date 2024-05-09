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
            <div id="myCarousel" class="carousel" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <div class="carousel-inner">
                    <div class="item active">
                        <img src="assets/imgs/desk.jpg" class style="width: 100vw; height:80vh; object-fit: cover;">
                    </div>

                    <div class="item">
                        <img src="assets/imgs/fiber.jpg" style="width: 100vw; height:80vh; object-fit: cover;">
                    </div>
                    
                    <div class="item">
                        <img src="assets/imgs/internet.jpg" style="width: 100vw; height:80vh; object-fit: cover;">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
                </a>

                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
                </a>
            </div>
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
            <% productDAO.setUpProduct(); %>
            <%-- <% productDAO.setUpProduct(); %> --%>
            <% //and use the controller to fetch a list of all of the products and store it in "products" for later use.
            ArrayList<Product> products = productDAO.fetchProducts(); %>
                <%-- <% for(Product product : products) { %>
                <p><%= product.getProductName() %></p>
                <% } %> --%>
            </div>
            <div class="container-products">
                <% 
                for (Product product : products) { %>
                    <jsp:include page="assets/product-card.jsp">
                        <jsp:param name="imageURL" value="<%= product.getProductImg() %>"/>
                        <jsp:param name="productName" value="<%= product.getProductName() %>"/>
                        <jsp:param name="productDescription" value="<%= product.getProductDescription() %>"/>
                        <jsp:param name="productPrice" value="<%= product.getProductPrice() %>"/>
                    </jsp:include>
                <% } %>
            </div>

            
          </main>
    
        <%@ include file="assets/footer.jsp" %>
    </body>
</html>