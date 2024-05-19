<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="uts.isd.model.Shipment" %>
<%@ page import="uts.isd.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Shipments</title>
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
            List<Shipment> shipments = (List<Shipment>) session.getAttribute("shipments");
%>

            <h1 style="text-align: center">List of Shipments</h1>

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

            <div class="center-links">
            <a href="create_shipment.jsp">Create New Shipment</a>
            <br>
            <a href="search_shipments.jsp">Search Shipments</a>
            </div>

<%
        }
    }
%>

<%@ include file="assets/footer.jsp" %>

</body>
</html>
