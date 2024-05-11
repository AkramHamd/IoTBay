package uts.isd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.User;
import uts.isd.model.dao.UserDAO;

public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        User user = (User) session.getAttribute("user");

        String given_name = request.getParameter("given_name");
        String family_name = request.getParameter("family_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");

        try {
            userDAO.updateUser(user.getUser_id(), given_name, family_name, email, password, phone, dob);

            response.sendRedirect("DashboardServlet");
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
