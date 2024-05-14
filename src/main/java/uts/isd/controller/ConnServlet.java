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
import uts.isd.model.dao.UserDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.LogDAO;
import uts.isd.model.dao.ProductDAO;

public class ConnServlet extends HttpServlet{
    private DBConnector db;
    private UserDAO userDAO;
    private LogDAO logDAO;
    private AddressDAO addressDAO;
    private ProductDAO productDAO;
    private Connection connection;
    
    @Override
    public void init() {
        try {
            db = new DBConnector();
            System.out.println("Database connection established.");
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
            userDAO = new UserDAO(connection);
            logDAO = new LogDAO(connection);
            addressDAO = new AddressDAO(connection);
            productDAO = new ProductDAO(connection);
        } catch (SQLException e) {
            System.out.print(e);
        }

        session.setAttribute("userDAO", userDAO);
        session.setAttribute("logDAO", logDAO);
        session.setAttribute("addressDAO", addressDAO);
        session.setAttribute("productDAO", productDAO);
        System.out.println("All DAOs have been set in session.");
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
