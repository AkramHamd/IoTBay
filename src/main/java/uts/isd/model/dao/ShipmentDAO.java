package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uts.isd.model.Shipment;

public class ShipmentDAO {
    
    private Connection conn;

    public ShipmentDAO(Connection conn) {
        this.conn = conn;
    }

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

    public Shipment getShipmentById(int shipmentId) throws SQLException {
        String query = "SELECT * FROM Shipment WHERE shipment_Id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, shipmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractShipmentFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<Shipment> getAllShipments() throws SQLException {
        List<Shipment> shipments = new ArrayList<>();
        String query = "SELECT * FROM Shipment";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                shipments.add(extractShipmentFromResultSet(rs));
            }
        }
        return shipments;
    }

    public void updateShipment(Shipment shipment) throws SQLException {
        String query = "UPDATE Shipment SET order_Id = ?, customer_Id = ?, address_Id = ?, courier_Id = ?, date_Shipped = ?, date_Delivered = ?, tracking_Number = ? WHERE shipment_Id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, shipment.getOrder_Id());
            stmt.setInt(2, shipment.getCustomer_Id());
            stmt.setInt(3, shipment.getAddress_Id());
            stmt.setInt(4, shipment.getCourier_Id());
            stmt.setDate(5, shipment.getDate_Shipped());
            stmt.setDate(6, shipment.getDate_Delivered());
            stmt.setString(7, shipment.getTracking_Number());
            stmt.setInt(8, shipment.getShipment_Id());
            stmt.executeUpdate();
        }
    }

    public void deleteShipment(int shipmentId) throws SQLException {
        String query = "DELETE FROM Shipment WHERE shipment_Id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, shipmentId);
            stmt.executeUpdate();
        }
    }

    private Shipment extractShipmentFromResultSet(ResultSet rs) throws SQLException {
        int shipmentId = rs.getInt("shipment_Id");
        int orderId = rs.getInt("order_Id");
        int customerId = rs.getInt("customer_Id");
        int addressId = rs.getInt("address_Id");
        int courierId = rs.getInt("courier_Id");
        Date dateShipped = rs.getDate("date_Shipped");
        Date dateDelivered = rs.getDate("date_Delivered");
        String trackingNumber = rs.getString("tracking_Number");
        return new Shipment(shipmentId, orderId, customerId, addressId, courierId, dateShipped, dateDelivered, trackingNumber);
    }
}
