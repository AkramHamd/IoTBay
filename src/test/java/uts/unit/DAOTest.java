// // package uts.unit;

<<<<<<< Updated upstream
// // import static org.junit.jupiter.api.Assertions.assertNotNull;
// // import static org.junit.jupiter.api.Assertions.assertTrue;

// // import java.sql.Connection;
// // import java.sql.PreparedStatement;
// // import java.sql.SQLException;
// // import java.util.ArrayList;
// // import java.util.List;

// // import org.junit.jupiter.api.Test;

// import java.sql.Connection;
// import java.sql.SQLException;

// import uts.isd.model.Address;
// import uts.isd.model.Log;
// import uts.isd.model.Shipment;
// import uts.isd.model.User;
// import uts.isd.model.dao.AddressDAO;
// import uts.isd.model.dao.DBConnector;
// import uts.isd.model.dao.LogDAO;
// import uts.isd.model.dao.UserDAO;

// public class DAOTest {
//     private DBConnector connector;
//     private Connection conn;
//     private UserDAO userDAO;
//     private LogDAO logDAO;
//     private AddressDAO addressDAO;

//     public DAOTest() throws ClassNotFoundException, SQLException {
//         connector = new DBConnector();
//         conn = connector.openConnection();
//         userDAO = new UserDAO(conn);
//         logDAO = new LogDAO(conn);
//         addressDAO = new AddressDAO(conn);
//     }

// //     @Test
// //     public void testConnection() throws SQLException {
// //         assertNotNull(conn);
// //     }

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

//     // @Test
//     // public void testDeleteUser() throws SQLException {
//     //     userDAO.deleteUser(80);
//     // }

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

//     // @Test
//     // public void testDeleteAddress() throws SQLException {
//     //     addressDAO.deleteAddress(25);
//     // }

   
//     // @Test
//     // public void testSelectShipments() throws SQLException {
//     //     Object shipmentDAO;
//     //     List<Shipment> shipments = shipmentDAO.getAllShipments();
//     //     assertTrue(shipments.size() >= 0);
//     // }


// //     // @Test
// //     // public void testGetShipmentById() throws SQLException {
// //     //     // ID de envío a buscar
// //     //     int shipmentId = 1;
        
// //     //     // Llama al método para obtener el envío por su ID
// //     //     Shipment retrievedShipment = shipmentDAO.getShipmentById(shipmentId);
        
// //     //     // Verifica que el envío recuperado no sea nulo
// //     //     assertNotNull(retrievedShipment);
        
// //     //     // Verifica que el ID del envío recuperado sea igual al ID esperado
// //     //     assertEquals(shipmentId, retrievedShipment.getShipment_Id());
        
// //     //     // Imprime los detalles del envío recuperado para depuración
// //     //     System.out.println("Shipment details:");
// //     //     System.out.println("Shipment ID: " + retrievedShipment.getShipment_Id());
// //     //     System.out.println("Order ID: " + retrievedShipment.getOrder_Id());
// //     //     System.out.println("Customer ID: " + retrievedShipment.getCustomer_Id());
// //     //     System.out.println("Address ID: " + retrievedShipment.getAddress_Id());
// //     //     System.out.println("Courier ID: " + retrievedShipment.getCourier_Id());
// //     //     System.out.println("Date Shipped: " + retrievedShipment.getDate_Delivered());
// //     //     System.out.println("Date Delivered: " + retrievedShipment.getDate_Delivered());
// //     //     System.out.println("Tracking Number: " + retrievedShipment.getTracking_Number());
// //     // }


//     // public void createShipment(Shipment shipment) throws SQLException {
//     //     String query = "INSERT INTO Shipment (order_Id, customer_Id, address_Id, courier_Id, date_Shipped, date_Delivered, tracking_Number) VALUES (?, ?, ?, ?, ?, ?, ?)";
//     //     try (PreparedStatement stmt = conn.prepareStatement(query)) {
//     //         stmt.setInt(1, shipment.getOrder_Id());
//     //         stmt.setInt(2, shipment.getCustomer_Id());
//     //         stmt.setInt(3, shipment.getAddress_Id());
//     //         stmt.setInt(4, shipment.getCourier_Id());
//     //         stmt.setDate(5, shipment.getDate_Shipped());
//     //         stmt.setDate(6, shipment.getDate_Delivered());
//     //         stmt.setString(7, shipment.getTracking_Number());
//     //         stmt.executeUpdate();
//     //     }
//     // }
// }
=======
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
>>>>>>> Stashed changes
