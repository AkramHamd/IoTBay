package uts.isd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.AddressDAO;
import uts.isd.model.dao.CustomerDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.LogDAO;

public class ConnServlet extends HttpServlet{
    private DBConnector db;
    private CustomerDAO customerDAO;
    private LogDAO logDAO;
    private AddressDAO addressDAO;
    private Connection connection;
    
    @Override
    public void init() {
        try {
            db = new DBConnector();
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        connection = db.openConnection();

        try {
            customerDAO = new CustomerDAO(connection);
            logDAO = new LogDAO(connection);
            addressDAO = new AddressDAO(connection);
        } catch (SQLException e) {
            System.out.print(e);
        }

        session.setAttribute("logDAO", logDAO);
        session.setAttribute("customerDAO", customerDAO);
        session.setAttribute("addressDAO", addressDAO);
        System.out.println("Conn Servlet");
        request.getRequestDispatcher("index.jsp").include(request, response);
    }

    @Override
    public void destroy(){
        try{
            db.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
