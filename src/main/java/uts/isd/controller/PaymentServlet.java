package uts.isd.controller;

import uts.isd.model.User;
import uts.isd.model.PaymentMethod;
import uts.isd.model.dao.PaymentMethodDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //getting customer object from the session

        User customer = (User) request.getSession().getAttribute("user");
        if (Objects.nonNull(customer)) {

        //storing the orderid into the session parameters

            request.getSession().setAttribute("orderId", request.getParameter("orderId"));

            //getting the paymentmethodDAO and the payment method for the customer

            PaymentMethodDAO paymentMethodDAO = (PaymentMethodDAO) request.getSession().getAttribute("paymentMethodDAO");
            PaymentMethod paymentMethod = paymentMethodDAO.getByCustomer(customer.getUser_id());

            //if there is an existing payment method, it sets the attributes

            if (Objects.nonNull(paymentMethod)) {
                request.setAttribute("paymentMethod", paymentMethod);

                //send the payment to jsp
            }
            request.getRequestDispatcher("payment.jsp").include(request, response);
//            response.sendRedirect("payment.jsp");
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
