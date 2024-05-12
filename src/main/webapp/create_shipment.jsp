<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Shipment</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<h1>Create New Shipment</h1>

<form action="/CreateShipmentServlet" method="post">
    <label for="orderId">Order ID:</label>
    <input type="number" name="orderId" id="orderId" required><br><br>

    <label for="customerId">Customer ID:</label>
    <input type="number" name="customerId" id="customerId" required><br><br>

    <label for="addressId">Address ID:</label>
    <input type="number" name="addressId" id="addressId" required><br><br>

    <label for="courierId">Courier ID:</label>
    <input type="number" name="courierId" id="courierId" required><br><br>

    <label for="dateShipped">Date Shipped (yyyy-mm-dd):</label>
    <input type="date" name="dateShipped" id="dateShipped" required><br><br>

    <label for="dateDelivered">Date Delivered (optional, yyyy-mm-dd):</label>
    <input type="date" name="dateDelivered" id="dateDelivered"><br><br>

    <label for="trackingNumber">Tracking Number:</label>
    <input type="text" name="trackingNumber" id="trackingNumber"><br><br>

    <input type="submit" value="Create Shipment">
</form>

</body>
</html>
