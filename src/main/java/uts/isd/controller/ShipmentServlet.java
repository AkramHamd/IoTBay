package uts.isd.controller;

import java.io.IOException;
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
public class ShipmentServlet extends HttpServlet {
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
            request.setAttribute("shipments", shipments);
            
            // Forward to the JSP view to display shipments
            request.getRequestDispatcher("/shipments.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error getting shipments", e);
        }
    }

    @Override
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the session
            HttpSession session = request.getSession();
            
            // Retrieve the shipment DAO object from the session
            ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
            
            // Extract shipment details from request parameters
            String method = request.getParameter("method");
            String date = request.getParameter("date");
            String address = request.getParameter("address");
            
            // Assuming orderId is retrieved from session or request
            int orderId = 123; // Replace with actual orderId
            
            // Save shipment details to the database
            shipmentDAO.createShipment(orderId, method, date, address);
            
            // Redirect to the shipment page to display the updated list of shipments
            response.sendRedirect(request.getContextPath() + "/shipment");
        } catch (SQLException e) {
            throw new ServletException("Error creating shipment", e);
        }
    }
}
