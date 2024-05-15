package uts.isd.controller;

import uts.isd.model.dao.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.ShipmentDAO;
import uts.isd.model.dao.AddressDAO;
import uts.isd.model.dao.UserDAO;
import uts.isd.model.dao.LogDAO;
import uts.isd.model.dao.ProductDAO;
import uts.isd.model.dao.OrderTableDAO;

public class ConnServlet extends HttpServlet{
    private DBConnector db;
    private ShipmentDAO shipmentDAO;
    private Connection conn;
    private UserDAO userDAO;
    private LogDAO logDAO;
    private AddressDAO addressDAO;
    // added DAO
    private PaymentMethodDAO paymentMethodDAO;
    private PaymentDAO paymentdDAO;
    private ProductDAO productDAO;
    private OrderTableDAO OrderTableDAO;
    private Connection connection;
    
    @Override
    public void init() {
        try {
            db = new DBConnector();
            conn = db.openConnection();
            shipmentDAO = new ShipmentDAO(conn);
            userDAO = new UserDAO(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Failed to establish database connection.");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("shipmentDAO", shipmentDAO);
        session.setAttribute("userDAO", userDAO); 
        
        connection = db.openConnection();

        try {
            userDAO = new UserDAO(connection);
            logDAO = new LogDAO(connection);
            addressDAO = new AddressDAO(connection);
            paymentMethodDAO = new PaymentMethodDAO(connection);
            paymentdDAO = new PaymentDAO(connection);
            OrderTableDAO = new OrderTableDAO(connection);
            productDAO = new ProductDAO(connection);
        } catch (SQLException e) {
            System.out.print(e);
        }

        session.setAttribute("userDAO", userDAO);
        session.setAttribute("logDAO", logDAO);
        session.setAttribute("addressDAO", addressDAO);
        session.setAttribute("paymentMethodDAO", paymentMethodDAO);
        session.setAttribute("paymentDAO", paymentdDAO);
        session.setAttribute("OrderTableDAO", OrderTableDAO);
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
