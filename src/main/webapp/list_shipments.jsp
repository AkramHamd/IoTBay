<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="uts.isd.model.Shipment" %>
<%@ page import="uts.isd.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Shipments</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        //response.sendRedirect("login.jsp"); 
        //return; 
    }

    List<Shipment> shipments = (List<Shipment>) session.getAttribute("shipments");
%>

<h1>List of Shipments</h1>

<c:if test="${empty shipments}">
    <p>No shipments available.</p>
</c:if>

<c:if test="${not empty shipments}">
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
                <th>Update Tracking</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="shipment" items="${shipments}">
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
                        <form action="<c:url value='/UpdateTrackingNumberServlet'/>" method="post">
                            <input type="hidden" name="shipmentId" value="${shipment.shipment_Id}" />
                            <input type="text" name="trackingNumber" value="${shipment.tracking_Number}" />
                            <input type="submit" value="Update" />
                        </form>
                    </td>
                    <td>
                        <form action="/DeleteShipmentServlet" method="post">
                            <input type="hidden" name="shipmentId" value="${shipment.shipment_Id}" />
                            <input type="submit" value="Delete" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<br>
<a href="create_shipment.jsp">Create New Shipment</a>
<br>
<a href="search_shipments.jsp">Search Shipments</a>

</body>
</html>
