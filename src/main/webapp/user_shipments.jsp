<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="uts.isd.model.Shipment" %>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.Address"%>
<%@page import="uts.isd.model.dao.ShipmentDAO"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="css/dashboard.css"> 
    <title>My Shipments</title>   
</head>
<body>

<%@ include file="assets/nav.jsp" %>

<% if(user == null) { %>
  <div class="container dashboard-div">
    <h1>You are not authenticated</h1>
  </div>
<% } else { %>
    <%  List<Shipment> userShipments = (List<Shipment>) session.getAttribute("userShipments"); %>
   <h1>My Shipments</h1>
   <c:if test="${empty userShipments}">
        <p>No shipments available for this user.</p>
    </c:if>

    <c:if test="${not empty userShipments}">
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
                <c:forEach var="shipment" items="${userShipments}">
                    <tr>
                    <td>${shipment.shipment_Id}</td>
                    <td>${shipment.order_Id}</td>
                    <td>${shipment.user_id}</td>
                    <td>${shipment.address_Id}</td>
                    <td>${shipment.courier_Id}</td>
                    <td>${shipment.date_Shipped}</td>
                    <td>${shipment.date_Delivered}</td>
                    <td>${shipment.tracking_Number}</td>
                    <td>
                            
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <div class="center-links">
        <a href="user_search_shipments.jsp">Search Shipments</a>
    </div>


    <%@ include file="assets/footer.jsp" %>
    
<% } %>
</body>
</html>
