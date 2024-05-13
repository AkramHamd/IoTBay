package uts.isd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Log;
import uts.isd.model.dao.LogDAO;

public class SearchLogsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String date = request.getParameter("date");

        try {

            if (date.equals("")) {
                session.setAttribute("view_logsDateEmpty", "Please select a date to search logs.");
                request.getRequestDispatcher("view_logs.jsp").forward(request, response);
            } else {
                ArrayList<Log> searchedLogs = logDAO.searchLogs(user_id, date);
                session.setAttribute("searchedLogs", searchedLogs);
                request.getRequestDispatcher("view_logs.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
