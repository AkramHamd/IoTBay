package uts.isd.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Shipment;
import uts.isd.model.dao.ShipmentDAO;


public class CreateShipmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
        if (shipmentDAO == null) {
            throw new ServletException("ShipmentDAO not found in session");
        }

        try {
            // Retrieve shipment details from the form
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            int addressId = Integer.parseInt(request.getParameter("addressId"));
            int courierId = Integer.parseInt(request.getParameter("courierId"));
            Date dateShipped = Date.valueOf(request.getParameter("dateShipped"));
            Date dateDelivered = request.getParameter("dateDelivered").isEmpty() ? null : Date.valueOf(request.getParameter("dateDelivered"));
            String trackingNumber = request.getParameter("trackingNumber");

            // Create a new shipment object
            Shipment shipment = new Shipment(0, orderId, customerId, addressId, courierId, dateShipped, dateDelivered, trackingNumber);

            // Add the new shipment to the database
            shipmentDAO.createShipment(shipment);

            // Refresh the shipment list in the session
            session.setAttribute("shipments", shipmentDAO.getAllShipments());

            // Redirect to the shipment listing page
            response.sendRedirect(request.getContextPath() + "/ListShipmentServlet");
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Error creating shipment", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST method required");
    }
}
