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
import uts.isd.model.dao.LogDAO;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");
    
        try {
            Customer customer = customerDAO.validateCustomer(email, password);

            if (customer != null) {
                logDAO.addLog(customer.getCustomer_id(), "login");
                session.setAttribute("customer", customer);

                response.sendRedirect("DashboardServlet");
            } else {
                session.setAttribute("login_emailPasswordErr", "Invalid email or password");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
        
    }
}
