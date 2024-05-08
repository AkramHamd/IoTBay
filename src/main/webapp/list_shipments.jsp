<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Shipments</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>

<h1>List of Shipments</h1>

<%-- Retrieve the list of shipments from the session attribute --%>
<%@ page import="java.util.List" %>
<%@ page import="uts.isd.model.Shipment" %>
<%
    List<Shipment> shipments = (List<Shipment>) session.getAttribute("shipments");
%>

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
            </tr>
        </thead>
        <tbody>
            <c:forEach var="shipment" items="${shipments}">
                <tr>
                    <td>${shipment.shipment_Id}</td>
                    <td>${shipment.order_Id}</td>
                    <td>${shipment.customer_Id}</td>
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

</body>
</html>
