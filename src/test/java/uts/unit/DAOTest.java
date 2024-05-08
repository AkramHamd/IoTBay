package uts.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


    // @Test
    // public void testGetShipmentById() throws SQLException {
    //     // ID de envío a buscar
    //     int shipmentId = 1;
        
    //     // Llama al método para obtener el envío por su ID
    //     Shipment retrievedShipment = shipmentDAO.getShipmentById(shipmentId);
        
    //     // Verifica que el envío recuperado no sea nulo
    //     assertNotNull(retrievedShipment);
        
    //     // Verifica que el ID del envío recuperado sea igual al ID esperado
    //     assertEquals(shipmentId, retrievedShipment.getShipment_Id());
        
    //     // Imprime los detalles del envío recuperado para depuración
    //     System.out.println("Shipment details:");
    //     System.out.println("Shipment ID: " + retrievedShipment.getShipment_Id());
    //     System.out.println("Order ID: " + retrievedShipment.getOrder_Id());
    //     System.out.println("Customer ID: " + retrievedShipment.getCustomer_Id());
    //     System.out.println("Address ID: " + retrievedShipment.getAddress_Id());
    //     System.out.println("Courier ID: " + retrievedShipment.getCourier_Id());
    //     System.out.println("Date Shipped: " + retrievedShipment.getDate_Delivered());
    //     System.out.println("Date Delivered: " + retrievedShipment.getDate_Delivered());
    //     System.out.println("Tracking Number: " + retrievedShipment.getTracking_Number());
    // }


    public void createShipment(Shipment shipment) throws SQLException {
        String query = "INSERT INTO Shipment (order_Id, customer_Id, address_Id, courier_Id, date_Shipped, date_Delivered, tracking_Number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, shipment.getOrder_Id());
            stmt.setInt(2, shipment.getCustomer_Id());
            stmt.setInt(3, shipment.getAddress_Id());
            stmt.setInt(4, shipment.getCourier_Id());
            stmt.setDate(5, shipment.getDate_Shipped());
            stmt.setDate(6, shipment.getDate_Delivered());
            stmt.setString(7, shipment.getTracking_Number());
            stmt.executeUpdate();
        }
    }
}    