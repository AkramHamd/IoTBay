<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="uts.isd.model.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
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

<%-- Create a new user object using session data --%>


<body>
<%@ include file="assets/nav.jsp" %>

<main>

    <div class="container pull-right">
        <h3>Payments Summary</h3>
        <table class="table">
            <thead>
            <tr>
                <th>Payment Id</th>
                <th>Order Id</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Card Number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${payments.payments}" var="payment">
                <tr>
                    <td>${payment.getPaymentId()}</td>
                    <td>${payment.getOrderId()}</td>
                    <td>${payment.getAmount()}</td>
                    <td>${payment.getPaymentDate()}</td>
                    <td>${payments.getPaymentMethod().getNumber()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%@ include file="assets/footer.jsp" %>
</body>
</html>