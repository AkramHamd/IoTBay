package uts.isd.controller;

import uts.isd.model.User;
import uts.isd.model.Payment;
import uts.isd.model.PaymentMethod;
import uts.isd.model.dao.PaymentDAO;
import uts.isd.model.dao.PaymentMethodDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SubmitPaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        User customer = (User) request.getSession().getAttribute("user");
        System.out.println(customer);
        if (Objects.nonNull(customer)) {
            PaymentMethod paymentMethod = (PaymentMethod) request.getAttribute("paymentMethod");
            
            if (Objects.isNull(paymentMethod)) {
                try {
                    paymentMethod = getPaymentMethod(request, customer);
                } catch (NullPointerException e) {
                    request.setAttribute("errorMessage", e.getMessage() + " cannot be empty");
                    request.getRequestDispatcher("payment.jsp").include(request, response);
                    return;
                }
                paymentMethod = savePaymentMethod(request, paymentMethod);
            }
            int paymentId = savePayment(request, paymentMethod.getId(), customer.getUser_id());
            request.setAttribute("successMessage", "Payment # " + paymentId + " successful.");
            request.getRequestDispatcher("payment.jsp").include(request, response);
        } else {
            response.sendRedirect("index.jsp");

        }
    }

    private PaymentMethod getPaymentMethod(HttpServletRequest request, User customer) {
        String number = requireNotEmpty(request.getParameter("number"), "Credit Card Number");
        String name = requireNotEmpty(request.getParameter("name"), "Credit Card Name");
        String expiry = requireNotEmpty(request.getParameter("expiry"), "Credit Card Expiry");
        String cvv = requireNotEmpty(request.getParameter("cvv"), "Credit Card Cvv");

        return new PaymentMethod(
                null,
                customer.getUser_id(),
                number,
                name,
                expiry,
                cvv
        );

    }

    private String requireNotEmpty(String string, String message) {
        if (string == null || string.isEmpty()) {
            throw new NullPointerException(message);
        }
        return string;
    }

    private PaymentMethod savePaymentMethod(HttpServletRequest request, PaymentMethod paymentMethod) {
        return ((PaymentMethodDAO) request.getSession().getAttribute("paymentMethodDAO")).add(paymentMethod);
    }

    private int savePayment(HttpServletRequest request, Integer paymentMethodId, Integer customer_id) {
        Payment payment = new Payment(
                Integer.parseInt((String) request.getSession().getAttribute("orderId")),
                customer_id,
                paymentMethodId,
                "1000",
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        );
        return ((PaymentDAO) request.getSession().getAttribute("paymentDAO")).add(payment);
    }
}
