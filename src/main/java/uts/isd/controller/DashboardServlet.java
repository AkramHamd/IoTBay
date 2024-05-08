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
import uts.isd.model.Customer;
import uts.isd.model.dao.LogDAO;

public class DashboardServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");

        System.out.println("inside dashboard servlet");

        try {
            ArrayList<Log> customerLogs = logDAO.getLogs(customer.getCustomer_id());
            session.setAttribute("customerLogs", customerLogs);

            response.sendRedirect("dashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
