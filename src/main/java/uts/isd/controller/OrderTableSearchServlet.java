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
import java.time.LocalDate;


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

        String idParameter = request.getParameter("id");
        int Orderid;
        if (idParameter == null || idParameter.isEmpty()) {
            Orderid = 0;
        } else {
            Orderid = Integer.parseInt(idParameter);
        } 
        OrderTableDAO OrderTableDAO = (OrderTableDAO) session.getAttribute("OrderTableDAO"); 
        try {
            if (Orderid == 0){
                session.setAttribute("bothEmpty", "field cannot be empty");
                request.getRequestDispatcher("orderlog.jsp").forward(request, response);

            }  else {
                OrderTable searchedOrder = OrderTableDAO.getOrder(user_id, Orderid);
                session.setAttribute("searchedOrder", searchedOrder);
                request.getRequestDispatcher("orderlog.jsp").forward(request, response);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        response.sendRedirect("orderlog.jsp"); 
    }
}

