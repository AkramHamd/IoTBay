package uts.isd.controller;

import java.io.IOException;
import java.sql.Date;
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

public class UserSearchShipmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/user_search_shipments.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        ShipmentDAO shipmentDAO = (ShipmentDAO) session.getAttribute("shipmentDAO");
        if (shipmentDAO == null) {
            throw new ServletException("ShipmentDAO not found in session");
        }

        try {
            // Retrieve the user from the session
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            // Retrieve search criteria
            String shipmentIdStr = request.getParameter("shipmentId");
            String dateShippedStr = request.getParameter("dateShipped");

            // Parse search criteria into appropriate types
            Integer shipmentId = shipmentIdStr != null && !shipmentIdStr.isEmpty() ? Integer.parseInt(shipmentIdStr) : null;
            Date dateShipped = dateShippedStr != null && !dateShippedStr.isEmpty() ? Date.valueOf(dateShippedStr) : null;

            // Fetch shipments based on the search criteria and user id
            List<Shipment> shipments = shipmentDAO.searchShipments(user.getUser_id(), shipmentId, dateShipped);

            // Set search results in the session
            session.setAttribute("searchResults", shipments);

            // Forward to the search results JSP page
            request.getRequestDispatcher("/user_search_shipments.jsp").forward(request, response);
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Error searching shipments", e);
        }
    }
}
