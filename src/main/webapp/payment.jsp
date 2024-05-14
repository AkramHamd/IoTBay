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

    <div class="container" style="padding-left: 40px;">
        <h3>Order Number # <%=session.getAttribute("orderId") %></h3>
        <c:choose>
            <c:when test="${errorMessage!=null}">
                <h5 style="color:red;">${errorMessage}</h5>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${successMessage!=null}">
                <h5 style="color:green;">${successMessage}</h5>
            </c:when>
        </c:choose>
        <form method="post" action="/submit-payment">
            <div class="form-group row">
                <div class="col-xs-4">
                    <label class="control-label">Credit Card Number</label>
                    <c:choose>
                        <c:when test="${paymentMethod!=null}">
                            <input class="form-control" name="number" type="text" value="${paymentMethod.number}">
                        </c:when>
                        <c:otherwise>
                            <input class="form-control" name="number" type="text" placeholder="Credit Card Number">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xs-4">
                    <label class="control-label">Credit Card Holder Name</label>
                    <c:choose>
                        <c:when test="${paymentMethod!=null}">
                            <input class="form-control" name="name" type="text" value="${paymentMethod.name}">
                        </c:when>
                        <c:otherwise>
                            <input class="form-control" name="name" type="text" placeholder="Credit Card Holder Name">
                        </c:otherwise>
                    </c:choose>
                </div>

            </div>
            <div class="form-group row">
                <div class="col-xs-3">
                    <label class="control-label">Credit Card Expiry</label>
                    <c:choose>
                        <c:when test="${paymentMethod!=null}">
                            <input class="form-control" name="expiry" type="text" value="${paymentMethod.expiry}">
                        </c:when>
                        <c:otherwise>
                            <input class="form-control" name="expiry" type="text" placeholder="Credit Card Expiry">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-xs-3">
                    <label class="control-label">Credit Card CVV</label>
                    <c:choose>
                        <c:when test="${paymentMethod!=null}">
                            <input class="form-control" name="cvv" type="text" value="${paymentMethod.cvv}">
                        </c:when>
                        <c:otherwise>
                            <input class="form-control" name="cvv" type="text" placeholder="Credit Card CVV">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <input name="orderId" type="hidden" value=<%=session.getAttribute("orderId")%> />
            <div class="row">
                <div class="col-xs-1">
                    <a href="/dashboard.jsp" class="btn btn-primary">Cancel</a>
                </div>
                <div class="col-xs-2">
                    <button type="submit" class="btn btn-primary">Pay</button>
                </div>
                <div class="col-xs-3">
                    <a href="/payments" class="btn btn-primary pull-right">See Payment History</a>
                </div>
            </div>
        </form>
    </div>

</main>
<%@ include file="assets/footer.jsp" %>
</body>
</html>