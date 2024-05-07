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

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");

        if (customerDAO == null) {
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            try {
                Customer customer = customerDAO.validateCustomer(email, password);
                if (customer != null) {
                    session.setAttribute("customer", customer);
                    response.sendRedirect("dashboard.jsp");
                } else {
                    session.setAttribute("loginErr", "Invalid email or password");
                    request.getRequestDispatcher("index.jsp").include(request, response);
                }
            } catch (SQLException | IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
}
