package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.OrderTableDAO;

public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();  

        int product_id = Integer.parseInt(request.getParameter("product_id")); 
        Double productPrice = Double.valueOf(request.getParameter("productPrice")); 
        int user_id = (int) session.getAttribute("user_id"); 

        OrderTableDAO orderTableDAO = (OrderTableDAO) session.getAttribute("orderTableDAO"); 

        session.setAttribute("orderTableDAO", orderTableDAO);
                
        try {
            if (!orderTableDAO.hasActiveOrder(user_id)) { 
                orderTableDAO.generateOrderTable(user_id);
            } 
            //orderTableDAO.generateOrderLineItem(productId, userID, productPrice); uncomment last
        } catch (SQLException e) {
            e.printStackTrace(); 
        }  
    }
}

