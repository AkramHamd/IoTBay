package uts.isd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.AddressDAO;

public class DeleteAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AddressDAO addressDAO = (AddressDAO) session.getAttribute("addressDAO");
        int address_id = Integer.parseInt(request.getParameter("address_id"));

        try {
            addressDAO.deleteAddress(address_id);
            response.sendRedirect("DashboardServlet");
        } catch (Exception e) {
            throw new ServletException("Could not delete address", e);
        }
    }
}
