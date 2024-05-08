//ShipmentServlet.java
package uts.isd.controller;

import java.io.IOException;
import java.sql.Date;
//import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Shipment;
import uts.isd.model.dao.ShipmentDAO;

@WebServlet("/shipment")
public class ListShipmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the session
            HttpSession session = request.getSession();
            
            // Retrieve the shipment DAO object from the session
            ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
            
            // Get all shipments from the database
            List<Shipment> shipments = shipmentDAO.getAllShipments();
            
            // Add shipments to request attributes to display in a JSP view
            session.setAttribute("shipments", shipments);
            
            // Forward to the JSP view to display shipments
            request.getRequestDispatcher("/list_shipments.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error getting shipments", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the session
            HttpSession session = request.getSession(false);
            
            // Check if the user is authenticated
            if (session == null || session.getAttribute("user") == null) {
                // Redirect the user to the login page if not authenticated
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
            
            // Retrieve the shipment DAO object from the session
            ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
            if (shipmentDAO == null) {
                throw new ServletException("ShipmentDAO not found in session");
            }

            // Retrieve the user's shipments using the user ID from the session
            int userId = (int) session.getAttribute("userId");
            List<Shipment> shipments = shipmentDAO.getShipmentsByUserId(userId);

            // Add shipments to session attributes to display in a JSP view
            session.setAttribute("shipments", shipments);

            // Forward to the JSP view to display shipments
            request.getRequestDispatcher("/list_shipments.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving shipments", e);
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid user ID", e);
        }
    }
}