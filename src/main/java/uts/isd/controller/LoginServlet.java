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
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");
    
        try {
            Integer user_id = userDAO.validateUser(email, password);

            if (user_id != null) {
                logDAO.addLog(user_id, "login");
                session.setAttribute("user_id", user_id);

                response.sendRedirect("DashboardServlet");

            } else {
                session.setAttribute("login_emailPasswordErr", "Invalid email or password");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
        
    }
}
