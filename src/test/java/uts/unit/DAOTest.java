package uts.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import uts.isd.model.Shipment;
import uts.isd.model.User;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.ShipmentDAO;
import uts.isd.model.dao.UserDAO;

public class DAOTest {
    private DBConnector connector;
    private Connection conn;
    private UserDAO userDAO;
    private ShipmentDAO shipmentDAO;

    public DAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        userDAO = new UserDAO(conn);
        shipmentDAO = new ShipmentDAO(conn);
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
        userDAO.createUser("22@22", "hello", "password");
    }

     @Test
    public void testSelectShipments() throws SQLException {
        List<Shipment> shipments = shipmentDAO.getAllShipments();
        assertTrue(shipments.size() >= 0);
    }

    @Test
    public void testAddAndGetShipment() throws SQLException {
        
        Date dateShipped = Date.valueOf("2024-05-05");
        Date dateDelivered = Date.valueOf("2024-05-10");
        Shipment shipment = new Shipment(1, 1, 1, 1, 1, dateShipped, dateDelivered, "123456789");
    
        shipmentDAO.createShipment(shipment);
        
        Shipment retrievedShipment = shipmentDAO.getShipmentById(1);
        assertNotNull(retrievedShipment);
        assertEquals(shipment.getOrder_Id(), retrievedShipment.getOrder_Id());
        assertEquals(shipment.getCustomer_Id(), retrievedShipment.getCustomer_Id());
        assertEquals(shipment.getAddress_Id(), retrievedShipment.getAddress_Id());
        assertEquals(shipment.getCourier_Id(), retrievedShipment.getCourier_Id());
        assertEquals(shipment.getDate_Shipped(), retrievedShipment.getDate_Shipped());
        assertEquals(shipment.getDate_Delivered(), retrievedShipment.getDate_Delivered());
        assertEquals(shipment.getTracking_Number(), retrievedShipment.getTracking_Number());
    }
}    