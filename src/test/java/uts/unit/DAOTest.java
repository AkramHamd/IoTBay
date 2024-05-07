package uts.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import uts.isd.model.Customer;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.CustomerDAO;

public class DAOTest {
    private DBConnector connector;
    private Connection conn;
    private CustomerDAO customerDAO;

    public DAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        customerDAO = new CustomerDAO(conn);
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testSelectUsers() throws SQLException {
        ArrayList<Customer> users = customerDAO.fetchAllCustomers();
        assertTrue(users.size() > 0);
    }
    @Test
    public void testCreateUsers() throws SQLException {
        customerDAO.addCustomer("test_given", "test_last", "test_give@email.comer", "123456", "0422 222 222", "1999-01-01");	
    }
}
