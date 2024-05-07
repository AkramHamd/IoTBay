package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Customer;
import uts.isd.model.dao.CustomerDAO;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String given_name = request.getParameter("given_name");
        String family_name = request.getParameter("family_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");

        // int indexOfSpace = dob.indexOf(' ');
        // dob = dob.substring(0, indexOfSpace);

        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");

        if (given_name.length() <= 0) {
            session.setAttribute("firstNameErr", "First name can't be empty");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else if (password.length() <= 5) {
            session.setAttribute("passwordErr", "Password needs to be greater than 5 letters");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else {
            try {
                Customer customer = customerDAO.addCustomer(given_name, family_name, email, password, phone, dob);
                session.setAttribute("customer", customer);
                response.sendRedirect("dashboard.jsp");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
