package uts.isd.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Log;
import uts.isd.model.OrderLineItem;
import uts.isd.model.OrderTable;
import uts.isd.model.Product;
import uts.isd.model.dao.OrderTableDAO;

public class OrderTableSearchServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int user_id = (int) session.getAttribute("user_id"); 
        String date = request.getParameter("date");

        String idParameter = request.getParameter("id"); //handle if id is empty
        int orderlineitemid;
        if (idParameter == null || idParameter.isEmpty()) {
            orderlineitemid = 0;
        } else {
            orderlineitemid = Integer.parseInt(idParameter);
        } 
        OrderTableDAO OrderTableDAO = (OrderTableDAO) session.getAttribute("OrderTableDAO"); 
        try {
            if (date.equals("") && orderlineitemid == 0){
                session.setAttribute("bothEmpty", "Both fields cannot be empty");
                request.getRequestDispatcher("orderlog.jsp").forward(request, response);

            } else if (date.equals("")) {
                ArrayList<OrderTable> searchedOrders = OrderTableDAO.searchItems(user_id, "", orderlineitemid);
                session.setAttribute("searchedOrders", searchedOrders);
                request.getRequestDispatcher("orderlog.jsp").forward(request, response);

            } else  if (orderlineitemid == 0){
                ArrayList<OrderTable> searchedOrders = OrderTableDAO.searchItems(user_id, date, 0);
                session.setAttribute("searchedOrders", searchedOrders);
                request.getRequestDispatcher("orderlog.jsp").forward(request, response);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        response.sendRedirect("orderlog.jsp"); 
    }
}

