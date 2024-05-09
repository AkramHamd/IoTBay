package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.ShipmentDAO;

public class DeleteShipmentServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
        if (shipmentDAO == null) {
            throw new ServletException("ShipmentDAO not found in session");
        }

        try {
            int shipmentId = Integer.parseInt(request.getParameter("shipmentId"));

            // Delete the shipment from the database
            shipmentDAO.deleteShipment(shipmentId);

            // Refresh the shipment list in the session
            session.setAttribute("shipments", shipmentDAO.getAllShipments());

            // Redirect to the shipment listing page
            response.sendRedirect(request.getContextPath() + "/ListShipmentServlet");
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Error deleting shipment", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST method required");
    }
}
