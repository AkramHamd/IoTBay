package uts.unit;

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
        // System.out.println("---------");
        // System.out.println(products.get(4).getProductId());
        // System.out.println(products.get(4).getProductName());
        // System.out.println("---------");
    }

    //create product
    @Test
    public void testCreateProducts() throws SQLException {
        userDAO.createProduct("MVN Test product", "Testers", "This is a test description", null, 1.23d, 0.00d, false, 30, 10);
    }

    //delete product
    @Test
    public void testDeleteProducts() throws SQLException {
        ArrayList<Product> products;
        products = userDAO.fetchProducts();
        Integer productOriginalSize = products.size();
        // System.out.println("Old list size: " + products.size());
        userDAO.deleteProduct(products.get(products.size()-1).getProductId());
        products = userDAO.fetchProducts();
        // System.out.println("New list size: " + products.size());
        assertTrue(products.size() < productOriginalSize);
    }

    //complex create/select/delete/truncate product test
    @Test
    public void testAllFunctionsProducts() throws SQLException {
        userDAO.truncateTable(1212, "product");
        ArrayList<Product> products;
        userDAO.createProduct("TesterProduct", "Testers", "This is a description", "null", 1.25d, 0.00d, false, 10, 10);
        products = userDAO.fetchProducts();
        if(products.size()>0) {
            userDAO.deleteProduct(1);
        } else {
            System.out.println("error");
        }
        products = userDAO.fetchProducts();
        assertTrue(products.size() == 0);
    }

    //Setting up base products through test
    @Test
    public void productSetUp() throws SQLException {
        ArrayList<Product> products;
        userDAO.createProduct(
            "Nest Mini Smart Speaker",
            "Google",
            "The Google Nest Mini Smart Speaker comes with powerful, rich bass for great sounding music. And with the Google Assistant it’s also helpful around the house, easily set timers, alarms or ask Google a question. Plus, control hundreds of compatible smart devices, like lights, smart plugs and TVs**. Google Nest Mini has also been designed with the environment in mind, with its fabric covering made from recycled plastic bottles.",
            "googlenest",
            69.99d,
            0.00d,
            false,
            5,
            1);
        products = userDAO.fetchProducts();
        assertTrue(products.size() == 1);
    }


}