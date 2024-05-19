package uts.isd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.User;
import uts.isd.model.dao.LogDAO;

public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // get user and logDAO from the session
        User user = (User) session.getAttribute("user");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");

        // checking if validated user is logged in and logDAO is available
        if (user != null && logDAO != null) {
            try {

                // add log to the database
                logDAO.addLog(user.getUser_id(), "logout");

                // invalidate the session and redirect to logout page
                session.invalidate();
                response.sendRedirect("logout.jsp");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
