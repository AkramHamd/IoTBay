package uts.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uts.isd.model.Shipment;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.ShipmentDAO;

public class DAOTest {

    private DBConnector connector;
    private Connection conn;
    private ShipmentDAO shipmentDAO;

    
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import uts.isd.model.Address;
import uts.isd.model.Log;
import uts.isd.model.Shipment;
import uts.isd.model.User;
import uts.isd.model.dao.AddressDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.LogDAO;
import uts.isd.model.dao.UserDAO;

public class DAOTest {
    
    private DBConnector connector;
    private Connection conn;
    private UserDAO userDAO;
    private LogDAO logDAO;
    private AddressDAO addressDAO;

    public DAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        userDAO = new UserDAO(conn);
        logDAO = new LogDAO(conn);
        addressDAO = new AddressDAO(conn);
    }

//     @Test
//     public void testConnection() throws SQLException {
//         assertNotNull(conn);
//     }

    // @Test
    // public void testCreateUser() throws SQLException {
    //     int user_id = userDAO.createUser("John", "Doe", "johndoe@gmail.com", "123456", "0422 222 222", "1999-01-01", "1234", "false", "false");	
    //     assertNotNull(user_id);
    // }

    // @Test
    // public void testReadUser() throws SQLException {
    //     User user = userDAO.readUser(40);
    //     assertNotNull(user);
    // }

    // @Test
    // public void testReadAllUsers() throws SQLException {
    //     ArrayList<User> users = userDAO.readAllUsers();
    //     assertTrue(users.size() > 0);
    // }

    // @Test
    // public void testUpdateUser() throws SQLException {
    //     userDAO.updateUser(40, "John", "Doe", "johndoe@TEST.com", "testPassword" ,"0000 000 000", "1999-01-01");	
    
    //     User updatedUser = userDAO.readUser(40);
    //     assertEquals("John", updatedUser.getGiven_name());
    //     assertEquals("Doe", updatedUser.getFamily_name());
    //     assertEquals("johndoe@TEST.com", updatedUser.getEmail());
    //     assertEquals("testPassword", updatedUser.getPassword());
    //     assertEquals("0000 000 000", updatedUser.getPhone());
    //     assertEquals("1999-01-01", updatedUser.getDob());
    // }

    // @Test
    // public void testDeleteUser() throws SQLException {
    //     userDAO.deleteUser(80);
    // }

    // @Test
    // public void testAddLog() throws SQLException {
    //     logDAO.addLog(40, "test");
    // }

    // @Test
    // public void testGetLogs() throws SQLException {
    //     ArrayList<Log> logs = logDAO.getLogs(40);
    //     assertTrue(logs.size() > 0);
    // }

    // @Test
    // public void testGetAllLogs() throws SQLException {
    //     ArrayList<Log> allLogs = logDAO.getAllLogs();
    //     assertTrue(allLogs.size() > 0);
    // }

    // @Test
    // public void testCreateAddress() throws SQLException {
    //     int addressId = addressDAO.createAddress(40, 1, 1, "Test St", "Test Suburb", "NSW", 2000, "Australia");
    //     assertNotNull(addressId);
    // }

    // @Test
    // public void testReadAddress() throws SQLException {
    //     Address address = addressDAO.readAddress(10);
    //     assertNotNull(address);
    // }

    // @Test
    // public void testReadAddresses() throws SQLException {
    //     ArrayList<Address> addresses = addressDAO.readAddresses(40);
    //     assertTrue(addresses.size() > 0);
    // }



    //---------- product tests ----------//

    //select/fetch all products
    @Test
    public void testSelectProducts() throws SQLException {
        ArrayList<Product> products = productDAO.fetchProducts();
        assertTrue(products.size() > 0);
        // System.out.println("---------");
        // System.out.println(products.get(4).getProductId());
        // System.out.println(products.get(4).getProductName());
        // System.out.println("---------");
    }

    //test specific retrieval utilising select from previous test
    @Test
    public void testSpecificProduct() throws SQLException {   
        ArrayList<Product> products = productDAO.fetchProducts();
        Product tester = productDAO.selectSpecificProduct(products.get(0).getProductId());
        assertEquals(tester.getProductName(), products.get(0).getProductName());
    }

    //select using specific array
    @Test
    public void testArrayProduct() throws SQLException {
        ArrayList<Integer> products = new ArrayList<>();
        products.add(1);
        products.add(2);
        ArrayList<Product> tester = productDAO.selectArrayProduct(products);
        assertEquals(tester.get(1).getProductId(), 2);
    }

    //create product
    @Test
    public void testCreateProducts() throws SQLException {
        productDAO.createProduct("MVN Test product", "Testers", "This is a test description", null, 1.23d, 0.00d, false, 30, 10, "adsa");
    }

    //delete product
    @Test
    public void testDeleteProducts() throws SQLException {
        ArrayList<Product> products;
        products = productDAO.fetchProducts();
        Integer productOriginalSize = products.size();
        productDAO.deleteProduct(products.get(products.size()-1).getProductId());
        products = productDAO.fetchProducts();
        assertTrue(products.size() < productOriginalSize);
        for(Product product : productDAO.fetchProducts()) {
            if(product.getProductName() == "MVN Test product") {
                productDAO.deleteProduct(product.getProductId());
            }
        }
    } */
}
