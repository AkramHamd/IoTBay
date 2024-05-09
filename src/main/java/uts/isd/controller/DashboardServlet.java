package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Log;
import uts.isd.model.Address;
import uts.isd.model.Customer;
import uts.isd.model.dao.AddressDAO;
import uts.isd.model.dao.CustomerDAO;
import uts.isd.model.dao.LogDAO;

public class DashboardServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int customer_id = (int) session.getAttribute("authorisedCustomer_id");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");
        AddressDAO addressDAO = (AddressDAO) session.getAttribute("addressDAO");
        CustomerDAO CustomerDAO = (CustomerDAO) session.getAttribute("customerDAO");

        System.out.println("inside dashboard servlet");

        try {
            ArrayList<Log> customerLogs = logDAO.getLogs(customer_id);
            Customer customer = CustomerDAO.fetchCustomer(customer_id);
            ArrayList<Address> customerAddresses = addressDAO.getAddressesByCustomerId(customer_id);
            
            session.setAttribute("customerLogs", customerLogs);
            session.setAttribute("customerAddresses", customerAddresses);
            session.setAttribute("customer", customer);

            response.sendRedirect("dashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
