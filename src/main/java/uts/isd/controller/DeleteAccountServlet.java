package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Customer;
import uts.isd.model.dao.CustomerDAO;

public class DeleteAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        Customer customer = (Customer) session.getAttribute("customer");
        
        try {
            customerDAO.deleteCustomer(customer.getCustomer_id());
            resp.sendRedirect("logout.jsp"); // Redirect to logout page after account deletion
        } catch (SQLException e) {
            throw new ServletException("Could not delete customer", e);
        }
    }
}
