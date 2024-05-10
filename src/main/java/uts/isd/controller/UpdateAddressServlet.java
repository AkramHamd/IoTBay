package uts.isd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.AddressDAO;

public class UpdateAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AddressDAO addressDAO = (AddressDAO) session.getAttribute("addressDAO");

        int address_id = Integer.parseInt(request.getParameter("address_id"));
        int unit_number = Integer.parseInt(request.getParameter("unit_number"));
        int street_number = Integer.parseInt(request.getParameter("street_number"));
        String street_name = request.getParameter("street_name");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        int postcode = Integer.parseInt(request.getParameter("postcode"));
        String country = request.getParameter("country");

        try {
            addressDAO.updateAddress(address_id, unit_number, street_number, street_name, suburb, state, postcode, country);
            response.sendRedirect("DashboardServlet");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
