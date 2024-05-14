package uts.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import uts.isd.model.Address;
import uts.isd.model.Log;
import uts.isd.model.User;
import uts.isd.model.Product;
import uts.isd.model.dao.AddressDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.LogDAO;
import uts.isd.model.dao.UserDAO;
import uts.isd.model.dao.ProductDAO;

public class DAOTest {
    private DBConnector connector;
    private Connection conn;
    private UserDAO userDAO;
    private LogDAO logDAO;
    private AddressDAO addressDAO;
    private ProductDAO productDAO;

    public DAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        userDAO = new UserDAO(conn);
        logDAO = new LogDAO(conn);
        addressDAO = new AddressDAO(conn);
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    // Tests from here (testCreateUser) to (testDeleteAddress) are written by Ahmad)

    @Test
    public void testCreateUser() throws SQLException {
        int user_id = userDAO.createUser("John", "Doe", "johndoe@gmail.com", "123456", "0422 222 222", "1999-01-01", "1234", "false", "false");	
        assertNotNull(user_id);
    }

    @Test
    public void testReadUser() throws SQLException {
        User user = userDAO.readUser(81);
        assertNotNull(user);
    }

    @Test
    public void testReadAllUsers() throws SQLException {
        ArrayList<User> users = userDAO.readAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void testUpdateUser() throws SQLException {
        userDAO.updateUser(81, "John", "Doe", "johndoe@TEST.com", "testPassword" ,"0000 000 000", "1999-01-01");	
    
        User updatedUser = userDAO.readUser(81);
        assertEquals("John", updatedUser.getGiven_name());
        assertEquals("Doe", updatedUser.getFamily_name());
        assertEquals("johndoe@TEST.com", updatedUser.getEmail());
        assertEquals("testPassword", updatedUser.getPassword());
        assertEquals("0000 000 000", updatedUser.getPhone());
        assertEquals("1999-01-01", updatedUser.getDob());
    }

    // @Test
    // public void testDeleteUser() throws SQLException {
    //     userDAO.deleteUser(80);
    // }

    @Test
    public void testAddLog() throws SQLException {
        logDAO.addLog(81, "test");
    }

    @Test
    public void testGetLogs() throws SQLException {
        ArrayList<Log> logs = logDAO.getLogs(81);
        assertTrue(logs.size() > 0);
    }

    @Test
    public void testGetAllLogs() throws SQLException {
        ArrayList<Log> allLogs = logDAO.getAllLogs();
        assertTrue(allLogs.size() > 0);
    }

    @Test
    public void testCreateAddress() throws SQLException {
        int addressId = addressDAO.createAddress(81, 1, 1, "Test St", "Test Suburb", "NSW", 2000, "Australia");
        assertNotNull(addressId);
    }

    @Test
    public void testReadAddress() throws SQLException {
        Address address = addressDAO.readAddress(26);
        assertNotNull(address);
    }

    @Test
    public void testReadAddresses() throws SQLException {
        ArrayList<Address> addresses = addressDAO.readAddresses(81);
        assertTrue(addresses.size() > 0);
    }

    @Test
    public void testUpdateAddress() throws SQLException {
        addressDAO.updateAddress(26, 1, 1, "Test St", "Test Suburb", "NSW", 2000, "Australia");
    }

    @Test
    public void testSelectProducts() throws SQLException {
        ArrayList<Product> products = productDAO.fetchProducts();
        assertTrue(products.size() > 0);
        // System.out.println("---------");
        // System.out.println(products.get(4).getProductId());
        // System.out.println(products.get(4).getProductName());
        // System.out.println("---------");
    }

    @Test
    public void testSpecificProduct() throws SQLException {
        Product gnest = productDAO.selectSpecificProduct(2);
        // System.out.println("Expecting 'Nest' but got: " + gnest.getProductName());
        assertEquals(gnest.getProductName(), "Nest");
    }


    //delete product
    @Test
    public void testDeleteProducts() throws SQLException {
        ArrayList<Product> products;
        products = productDAO.fetchProducts();
        Integer productOriginalSize = products.size();
        // System.out.println("Old list size: " + products.size());
        productDAO.deleteProduct(products.get(products.size()-1).getProductId());
        products = productDAO.fetchProducts();
        // System.out.println("New list size: " + products.size());
        assertTrue(products.size() < productOriginalSize);
        for(Product product : productDAO.fetchProducts()) {
            if(product.getProductName() == "MVN Test product") {
                productDAO.deleteProduct(product.getProductId());
            }
            System.out.println(product.getProductId());
        }
    }

    // @Test
    // public void testDeleteAddress() throws SQLException {
    //     addressDAO.deleteAddress(25);
    // }

    // Tests to here (testCreateUser) to (testDeleteAddress) are written by Ahmad)
}
