<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="java.sql.*"%>  
<%@page import="javax.sql.*" %>
<%@page import="uts.isd.model.dao.ProductDAO"%>
<%@page import="uts.isd.model.dao.UserDAO"%>
<%@page import="uts.isd.model.dao.DBConnector"%>
<%@page import="uts.isd.model.dao.OrderTableDAO"%>

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
            <%
            //Set up for the product fetching to display the products that are on the page.
            //initiate a connection using DBConnector (connect to the db)
            DBConnector conn = new DBConnector();
            Connection con = conn.openConnection();
            ProductDAO productDAO = new ProductDAO(con);
            OrderTableDAO ordertableDAO = new OrderTableDAO(con);
            ArrayList<OrderLineItem> currentItems = ordertableDAO.getCurrentItems((Integer) session.getAttribute("user_id"));
            %>
            <div class="container-products">
                <% for (OrderLineItem orderlineitem : currentItems) { %>
                    <% Product product = productDAO.selectSpecificProduct(orderlineitem.getProduct_id()); %>
                    <div>
                        <h2>Product: <%= product.getProductName() %></h2>
                        <h3>Quantity: <%= orderlineitem.getQuantity() %></h3>
                        <form action="/IncrementServlet" method="post">
                            <input type="hidden" name="product_id" value="<%= product.getProductId() %>">
                            <button>+</button>
                        </form>
                        <form action="/DecreaseServlet" method="post">
                            <input type="hidden" name="product_id" value="<%= product.getProductId() %>">
                            <button>-</button>
                        </form>
                    </div>
                <% } %>
            </div> 
            <button> order log</button>
            <button> cancel order</button>
            <button> submit order</button>
        </main>

        <%@ include file="assets/footer.jsp" %>
    </body>
</html>
