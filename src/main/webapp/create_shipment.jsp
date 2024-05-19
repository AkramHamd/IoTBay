<!DOCTYPE html>
<html>
<head>
    <title>Create Shipment</title>
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/list_shipments.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>

<%@ include file="assets/nav.jsp" %>

<%
    if (user == null) {
%>
        <h1>You're Not authenticated</h1>
<%
    } else {
        if (!"true".equals(user.getIs_staff())) {
%>
            <h1>You're NOT a staff member.</h1>
<%
        } else {
%>

<h1>Create New Shipment (Staff Access)</h1>

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

<%
        }
    }
%>

<%@ include file="assets/footer.jsp" %>

</body>
</html>
