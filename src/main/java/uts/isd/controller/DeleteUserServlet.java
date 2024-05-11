package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.User;
import uts.isd.model.dao.UserDAO;

public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        User user = (User) session.getAttribute("user");
        
        try {
            if (user != null) {
                userDAO.deleteUser(user.getUser_id());
                response.sendRedirect("logout.jsp");
            }
        } catch (SQLException e) {
            throw new ServletException("Could not delete customer", e);
        }
    }
}
