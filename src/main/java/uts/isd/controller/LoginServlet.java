package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.UserDAO;
import uts.isd.model.dao.LogDAO;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // getting the email and password from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // getting the userDAO and logDAO from the session
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");
    
        try {
            // retrieving the user_id from the database
            Integer user_id = userDAO.validateUser(email, password);

            // checking if user id is truthy or falsey
            if (user_id != null) {

                // if true add log for that user with log type to database
                logDAO.addLog(user_id, "login");
                session.setAttribute("user_id", user_id);

                // redirect user to dashboard servlet
                response.sendRedirect("DashboardServlet");

            } else {
                // if false set error message and redirect user to login page
                session.setAttribute("login_emailPasswordErr", "Invalid email or password");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
        
    }
}
