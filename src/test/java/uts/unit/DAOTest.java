package uts.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import uts.isd.model.User;
import uts.isd.model.Product;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.UserDAO;

public class DAOTest {
    private DBConnector connector;
    private Connection conn;
    private UserDAO userDAO;

    public DAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        userDAO = new UserDAO(conn);
    }



    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testSelectUsers() throws SQLException {
        ArrayList<User> users = userDAO.fetchUsers();
        assertTrue(users.size() > 0);
    }
    @Test
    public void testCreateUsers() throws SQLException {
        userDAO.createUser("22@22", "hello", "lname", "password", "10/09/02", "0411111111");
    }
    //Feature 2 Tests

    //select products
    @Test
    public void testSelectProducts() throws SQLException {
        ArrayList<Product> products = userDAO.fetchProducts();
        assertTrue(products.size() > 0);
    }

    //create product
    @Test
    public void testCreateProducts() throws SQLException {
        userDAO.createProduct("MVN Test product", "Testers", "This is a test description", null, 1.23d, 0.00d, false, 30, 10);
    }
}
