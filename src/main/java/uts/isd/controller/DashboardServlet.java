package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Log;
import uts.isd.model.Address;
import uts.isd.model.User;
import uts.isd.model.dao.AddressDAO;
import uts.isd.model.dao.UserDAO;
import uts.isd.model.dao.LogDAO;

public class DashboardServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int user_id = (int) session.getAttribute("user_id");
        
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");
        AddressDAO addressDAO = (AddressDAO) session.getAttribute("addressDAO");
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        System.out.println("Inside DashboardServlet");

        try {
            User user = userDAO.readUser(user_id);
            ArrayList<User> allUsers = userDAO.readAllUsers();
            ArrayList<Log> logs = logDAO.getLogs(user_id);
            ArrayList<Log> allLogs = logDAO.getAllLogs();
            ArrayList<Address> addresses = addressDAO.readAddresses(user_id);
            
            session.setAttribute("user", user);
            session.setAttribute("allUsers", allUsers);
            session.setAttribute("logs", logs);
            session.setAttribute("allLogs", allLogs);
            session.setAttribute("addresses", addresses);

            response.sendRedirect("dashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
