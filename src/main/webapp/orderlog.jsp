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
    
    <style>
        main {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-align: center;
        }

        .search-div {
            margin-bottom: 20px; 
        }
    </style>
</head>

<body>
<%@ include file="assets/nav.jsp" %>
<main>
    <%
    //Set up for the product fetching to display the products that are on the page.
    //initiate a connection using DBConnector (connect to the db)
    DBConnector conn = new DBConnector();
    Connection con = conn.openConnection();
    ProductDAO productDAO = new ProductDAO(con);
    OrderTableDAO ordertableDAO = new OrderTableDAO(con);
    ArrayList<OrderTable> currentItems = ordertableDAO.getInactiveOrders((Integer) session.getAttribute("user_id"));
    %>
    <% String bothEmpty = (String) session.getAttribute("bothEmpty"); %>
    <form method="post" action="/OrderTableSearchServlet">
        <input type="text" id="id" name="id" placeholder="Input Order ID" />
        <input type="submit" value="Search">
    </form>
    <% if(bothEmpty != null) { %>
        <p style="color: red;"><%=bothEmpty%></p>
    <% } %>

    <% OrderTable searchedOrder = (OrderTable) session.getAttribute("searchedOrder"); %>
    <% if (searchedOrder != null) { %>
        <h3 style="color: red;">  Order: <%= searchedOrder.getOrder_id()%> </h3>
        <h4 style="color: red;">Order: <%= searchedOrder.getStatus() %></h4>
        <h4 style="color: red;">Order: <%= searchedOrder.getOrderDate() %></h4>
    <% } %>


    <h3>All Orders:</h3>
    <% for (OrderTable ordertable : currentItems) { %>
        <div>
            <h4>Order: <%= ordertable.getOrder_id() %></h4>
            <h4>Status: <%= ordertable.getStatus() %></h4>
            <h4>Ordered: <%= ordertable.getOrderDate() %></h4>
        </div>
    <% } %>
    
</main>

<%@ include file="assets/footer.jsp" %>
</body>
</html>
