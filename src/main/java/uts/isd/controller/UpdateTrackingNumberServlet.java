package uts.isd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Shipment;
import uts.isd.model.dao.ShipmentDAO;

@WebServlet("/UpdateTrackingNumberServlet")
public class UpdateTrackingNumberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
        if (shipmentDAO == null) {
            throw new ServletException("ShipmentDAO not found in session");
        }

        int shipmentId = Integer.parseInt(request.getParameter("shipmentId"));
        String trackingNumber = request.getParameter("trackingNumber");

        try {
            // Retrieve the existing shipment from the database
            Shipment shipment = shipmentDAO.getShipmentById(shipmentId);
            if (shipment == null) {
                throw new ServletException("Shipment not found with ID: " + shipmentId);
            }

            // Update the tracking number of the shipment
            shipment.setTracking_Number(trackingNumber);

            // Update the shipment in the database
            shipmentDAO.updateShipment(shipment);

            // Update the session attribute
            session.setAttribute("shipments", shipmentDAO.getAllShipments());

            // Redirect or forward to the shipment listing page
            response.sendRedirect(request.getContextPath() + "/ListShipmentServlet");
        } catch (Exception e) {
            System.out.println(e);
            throw new ServletException("Error updating shipment tracking number", e);
        }
    }
}
