package uts.isd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Customer;
import uts.isd.model.dao.CustomerDAO;

public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        Customer customer = (Customer) session.getAttribute("customer");

        String given_name = request.getParameter("given_name");
        String family_name = request.getParameter("family_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");

        customer.setGiven_name(given_name);
        customer.setFamily_name(family_name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhone(phone);
        customer.setDob(dob);

        try {
            customerDAO.updateCustomer(customer);
            session.setAttribute("customer", customer);
            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
