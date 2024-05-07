package uts.isd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Customer;
import uts.isd.model.dao.LogDAO;

public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");

        if (customer != null && logDAO != null) {
            try {
                logDAO.addLog(customer.getCustomer_id(), "logout");
                session.invalidate();
                response.sendRedirect("logout.jsp");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            response.sendRedirect("index.jsp");
            
        }
    }
}