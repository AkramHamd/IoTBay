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

    @BeforeEach
    public void setUp() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        shipmentDAO = new ShipmentDAO(conn);
    }

    @AfterEach
    public void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testGetAllShipments() throws SQLException {
        List<Shipment> shipments = shipmentDAO.getAllShipments();
        assertNotNull(shipments);
        assertTrue(shipments.size() > 0);
    }

    @Test
    public void testGetShipmentById() throws SQLException {
        Shipment shipment = shipmentDAO.getShipmentById(22); // adjust as necessary
        assertNotNull(shipment);
        assertEquals(22, shipment.getShipment_Id());
    }

    @Test
    public void testCreateShipment() throws SQLException {
        Date now = new Date(System.currentTimeMillis());
        System.out.println(now);
        Shipment newShipment = new Shipment(0, 1, 1, 1, 1, now, now, "789012");
        int shipmentId = shipmentDAO.createShipment(newShipment);
        Shipment createdShipment = shipmentDAO.getShipmentById(shipmentId);
        assertNotNull(createdShipment, "Created shipment should not be null");
        assertEquals(shipmentId, createdShipment.getShipment_Id());  
    }

    @Test
    public void testDeleteShipment() throws SQLException {
        Date now = new Date(System.currentTimeMillis());
        System.out.println(now);
        Shipment createdShipment = new Shipment(0, 1, 1, 1, 1, now, now, "789012");
        int shipmentId = shipmentDAO.createShipment(createdShipment);
        assertNotNull(createdShipment);
        shipmentDAO.deleteShipment(shipmentId);
        Shipment deletedShipment = shipmentDAO.getShipmentById(999);
        assertNull(deletedShipment);
    }


    @Test
    public void testGetShipmentsByUserId() throws SQLException {
        List<Shipment> shipments = shipmentDAO.getShipmentsByUserId(1); // adjust as necessary
        assertNotNull(shipments);
        assertTrue(shipments.size() > 0);
    }

    @Test
    public void testSearchShipments() throws SQLException {
        List<Shipment> shipments = shipmentDAO.searchShipments(1, null, null); // adjust as necessary
        assertNotNull(shipments);
        assertTrue(shipments.size() > 0);
    }

    @Test
    public void testSearchShipmentsByUserIdAndDate() throws SQLException {
        Date searchDate = new Date(System.currentTimeMillis()); // Use current date
        List<Shipment> shipments = shipmentDAO.searchShipmentsByUserIdAndDate(1, searchDate); // adjust as necessary
        assertNotNull(shipments);
        assertTrue(shipments.size() > 0);
    }

    @Test
    public void testUpdateShipment() throws SQLException {
        Date now = new Date(System.currentTimeMillis());
        Shipment newShipment = new Shipment(0, 1, 1, 1, 1, now, now, "789012");
        int shipmentId = shipmentDAO.createShipment(newShipment); // Save and get the generated ID
        Shipment shipment = shipmentDAO.getShipmentById(shipmentId);
        shipment.setTracking_Number("123");
        shipmentDAO.updateShipment(shipment);
        Shipment updatedShipment = shipmentDAO.getShipmentById(shipmentId); // Use the correct ID
        assertNotNull(updatedShipment);
        assertEquals("123", updatedShipment.getTracking_Number());
        shipmentDAO.deleteShipment(shipmentId); // clean up
    }
}
