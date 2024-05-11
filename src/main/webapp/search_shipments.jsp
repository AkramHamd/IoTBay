<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Shipments</title>
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

<h1>Search Shipments</h1>

<form action="/SearchShipmentServlet" method="post">
    <label for="userId">Search by User ID:</label>
    <input type="number" name="userId" id="userId"><br><br>

    <label for="shipmentId">Search by Shipment ID:</label>
    <input type="number" name="shipmentId" id="shipmentId"><br><br>

    <label for="dateShipped">Search by Date Shipped (yyyy-mm-dd):</label>
    <input type="date" name="dateShipped" id="dateShipped"><br><br>

    <input type="submit" value="Search Shipments">
</form>

<hr>

<c:if test="${empty searchResults}">
    <p>No shipments found.</p>
</c:if>

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

</body>
</html>
