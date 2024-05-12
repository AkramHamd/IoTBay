package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Shipment;
import uts.isd.model.User;
import uts.isd.model.dao.ShipmentDAO;

public class UserListShipmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the session
            HttpSession session = request.getSession();
            
            // Retrieve the user from the session
            User user = (User) session.getAttribute("user");
            if (user == null) {
                // If user is not authenticated, redirect to login page
                response.sendRedirect("login.jsp"); 
                return; 
            }
            
            // Retrieve the shipment DAO object from the servlet context
            ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
            if (shipmentDAO == null) {
                // If shipmentDAO is not available, display an error message
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "ShipmentDAO is not available");
                return;
            }
    
            // Retrieve the user's shipments from the database
            List<Shipment> userShipments = shipmentDAO.getShipmentsByUserId(user.getUser_id());
            System.out.println(userShipments.size());
            // Set the user's shipments as request attribute
            request.setAttribute("userShipments", userShipments);
    
            // Forward to the JSP view to display the user's shipments
            request.getRequestDispatcher("/user_shipments.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving user shipments: " + e.getMessage());
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // POST method not implemented for this servlet
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST method not supported for this request");
    }
}
