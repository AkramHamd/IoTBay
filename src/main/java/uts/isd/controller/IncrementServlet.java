package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.OrderLineItem;
import uts.isd.model.dao.OrderTableDAO;

public class IncrementServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int product_id = Integer.parseInt(request.getParameter("product_id")); 
        int user_id = (int) session.getAttribute("user_id"); 

        OrderTableDAO OrderTableDAO = (OrderTableDAO) session.getAttribute("OrderTableDAO"); 
        session.setAttribute("orderTableDAO", OrderTableDAO);

        response.sendRedirect("cart.jsp"); 
        try {
            OrderTableDAO.incrementQuantity(product_id, user_id);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
