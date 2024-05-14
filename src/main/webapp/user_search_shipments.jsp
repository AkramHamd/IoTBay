<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/list_shipments.css">
    <title>Search Shipments</title>
</head>
<body>
    <%@ include file="assets/nav.jsp" %>
    
    <% if(user == null) { %>
        <div class="container dashboard-div">
            <h1>You are not authenticated</h1>
        </div>
    <% } else { %>
        <h1>Search Shipments</h1>
        
        <form action="UserSearchShipmentServlet" method="post">
            <label for="shipmentId">Shipment ID:</label>
            <input type="text" id="shipmentId" name="shipmentId">
            <br>
            <label for="dateShipped">Date Shipped:</label>
            <input type="date" id="dateShipped" name="dateShipped">
            <br>
            <input type="submit" value="Search">
        </form>
        
        <c:if test="${not empty searchResults}">
            <table>
                <thead>
                    <tr>
                        <th>Shipment ID</th>
                        <th>Order ID</th>
                        <th>Customer ID</th>
                        <th>Address ID</th>
                        <th>Courier ID</th>
                        <th>Date Shipped</th>
                        <th>Date Delivered</th>
                        <th>Tracking Number</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="shipment" items="${searchResults}">
                        <tr>
                            <td>${shipment.shipment_Id}</td>
                            <td>${shipment.order_Id}</td>
                            <td>${shipment.user_id}</td>
                            <td>${shipment.address_Id}</td>
                            <td>${shipment.courier_Id}</td>
                            <td>${shipment.date_Shipped}</td>
                            <td>${shipment.date_Delivered}</td>
                            <td>${shipment.tracking_Number}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    <% } %>

    <%@ include file="assets/footer.jsp" %>
</body>
</html>
