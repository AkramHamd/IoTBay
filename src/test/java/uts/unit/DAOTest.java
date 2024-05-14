package uts.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import uts.isd.model.Address;
import uts.isd.model.Log;
import uts.isd.model.User;
import uts.isd.model.dao.AddressDAO;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.LogDAO;
import uts.isd.model.dao.UserDAO;

@Disabled public class DAOTest {
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

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    // Tests from here (testCreateUser) to (testDeleteAddress) are written by Ahmad)

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

    // @Test
    // public void testUpdateAddress() throws SQLException {
    //     addressDAO.updateAddress(10, 1, 1, "Test St", "Test Suburb", "NSW", 2000, "Australia");
    // }

    // @Test
    // public void testDeleteAddress() throws SQLException {
    //     addressDAO.deleteAddress(25);
    // }

    // Tests to here (testCreateUser) to (testDeleteAddress) are written by Ahmad)
}
