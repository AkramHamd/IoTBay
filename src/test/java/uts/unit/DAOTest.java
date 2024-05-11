// // package uts.unit;

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
    //     User user = userDAO.readUser(81);
    //     assertNotNull(user);
    // }

    // @Test
    // public void testReadAllUsers() throws SQLException {
    //     ArrayList<User> users = userDAO.readAllUsers();
    //     assertTrue(users.size() > 0);
    // }

    // @Test
    // public void testUpdateUser() throws SQLException {
    //     userDAO.updateUser(81, "John", "Doe", "johndoe@TEST.com", "testPassword" ,"0000 000 000", "1999-01-01");	
    
    //     User updatedUser = userDAO.readUser(81);
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
    //     logDAO.addLog(81, "test");
    // }

    // @Test
    // public void testGetLogs() throws SQLException {
    //     ArrayList<Log> logs = logDAO.getLogs(81);
    //     assertTrue(logs.size() > 0);
    // }

    // @Test
    // public void testGetAllLogs() throws SQLException {
    //     ArrayList<Log> allLogs = logDAO.getAllLogs();
    //     assertTrue(allLogs.size() > 0);
    // }

    // @Test
    // public void testCreateAddress() throws SQLException {
    //     int addressId = addressDAO.createAddress(81, 1, 1, "Test St", "Test Suburb", "NSW", 2000, "Australia");
    //     assertNotNull(addressId);
    // }

    // @Test
    // public void testReadAddress() throws SQLException {
    //     Address address = addressDAO.readAddress(26);
    //     assertNotNull(address);
    // }

    // @Test
    // public void testReadAddresses() throws SQLException {
    //     ArrayList<Address> addresses = addressDAO.readAddresses(81);
    //     assertTrue(addresses.size() > 0);
    // }

    // @Test
    // public void testUpdateAddress() throws SQLException {
    //     addressDAO.updateAddress(26, 1, 1, "Test St", "Test Suburb", "NSW", 2000, "Australia");
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
