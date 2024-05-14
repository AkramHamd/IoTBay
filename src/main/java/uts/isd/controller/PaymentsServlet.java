package uts.isd.controller;

import uts.isd.controller.model.Payments;
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
import java.util.List;
import java.util.Objects;

public class PaymentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User customer = (User) request.getSession().getAttribute("user");
        if (Objects.nonNull(customer)) {
            List<Payment> paymentList = getPayments(request, customer);
            PaymentMethod paymentMethod = getPaymentMethod(request, customer.getUser_id());

            Payments payments = new Payments(paymentList, paymentMethod);

            request.setAttribute("payments", payments);
            request.getRequestDispatcher("payments.jsp").include(request, response);
        } else {
            response.sendRedirect("index.jsp");

        }
    }

    private List<Payment> getPayments(HttpServletRequest request, User customer) {
        PaymentDAO paymentDAO = (PaymentDAO) request.getSession().getAttribute("paymentDAO");
        return paymentDAO.getAll(customer.getUser_id());
    }

    private PaymentMethod getPaymentMethod(HttpServletRequest request, int customer_id) {
        PaymentMethodDAO paymentMethodDAO = (PaymentMethodDAO) request.getSession().getAttribute("paymentMethodDAO");
        return paymentMethodDAO.getByCustomer(customer_id);
    }
}
