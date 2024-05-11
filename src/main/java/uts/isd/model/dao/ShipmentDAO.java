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

    public List<Shipment> getAllShipments() throws SQLException {
        List<Shipment> shipments = new ArrayList<>();
        String query = "SELECT * FROM shipment";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                shipments.add(extractShipmentFromResultSet(rs));
            }
        }
        return shipments;
    }

    public Shipment getShipmentById(int shipmentId) throws SQLException {
        String query = "SELECT * FROM shipment WHERE shipment_Id = ?";
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

    public void updateShipment(Shipment shipment) throws SQLException {
        String query = "UPDATE shipment SET order_Id = ?, user_id = ?, address_Id = ?, courier_Id = ?, date_Shipped = ?, date_Delivered = ?, tracking_number = ? WHERE shipment_Id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, shipment.getOrder_Id());
            stmt.setInt(2, shipment.getuser_id());
            stmt.setInt(3, shipment.getAddress_Id());
            stmt.setInt(4, shipment.getCourier_Id());
            stmt.setDate(5, shipment.getDate_Shipped());
            stmt.setDate(6, shipment.getDate_Delivered());
            stmt.setString(7, shipment.getTracking_Number());
            stmt.setInt(8, shipment.getShipment_Id());
            stmt.executeUpdate();
        }
    }

    public List<Shipment> getShipmentsByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM shipments WHERE user_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            List<Shipment> shipments = new ArrayList<>();
            while (rs.next()) {
                Shipment shipment = new Shipment();
                shipment.setShipment_Id(rs.getInt("shipment_id"));
                shipment.setOrder_Id(rs.getInt("order_id"));
                shipment.setuser_id(rs.getInt("user_id"));
                shipment.setAddress_Id(rs.getInt("address_id"));
                shipment.setCourier_Id(rs.getInt("courier_id"));
                shipment.setDate_Shipped(rs.getDate("date_shipped"));
                shipment.setDate_Delivered(rs.getDate("date_delivered"));
                shipment.setTracking_Number(rs.getString("tracking_number"));
                shipments.add(shipment);
            }
            return shipments;
        }
    }
    private Shipment extractShipmentFromResultSet(ResultSet rs) throws SQLException {
        int shipmentId = rs.getInt("shipment_Id");
        int orderId = rs.getInt("order_Id");
        int customerId = rs.getInt("user_id");
        int addressId = rs.getInt("address_Id");
        int courierId = rs.getInt("courier_Id");
        java.sql.Date dateShipped = rs.getDate("date_Shipped");
        java.sql.Date dateDelivered = rs.getDate("date_Delivered");
        String trackingNumber = rs.getString("tracking_Number");
        return new Shipment(shipmentId, orderId, customerId, addressId, courierId, dateShipped, dateDelivered, trackingNumber);
    }

    public void deleteShipment(int shipmentId) throws SQLException {
        String query = "DELETE FROM shipment WHERE shipment_Id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, shipmentId);
            stmt.executeUpdate();
        }
    }

    public void createShipment(Shipment shipment) throws SQLException {
        String query = "INSERT INTO shipment (order_Id, user_id, address_Id, courier_Id, date_Shipped, date_Delivered, tracking_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, shipment.getOrder_Id());
            stmt.setInt(2, shipment.getuser_id());
            stmt.setInt(3, shipment.getAddress_Id());
            stmt.setInt(4, shipment.getCourier_Id());
            stmt.setDate(5, shipment.getDate_Shipped());
            stmt.setDate(6, shipment.getDate_Delivered());
            stmt.setString(7, shipment.getTracking_Number());
            stmt.executeUpdate();
        }
    }

    public List<Shipment> searchShipments(Integer userId, Integer shipmentId, Date dateShipped) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM shipment WHERE 1=1");

        if (userId != null) {
            query.append(" AND user_id = ?");
        }
        if (shipmentId != null) {
            query.append(" AND shipment_Id = ?");
        }
        if (dateShipped != null) {
            query.append(" AND date_Shipped = ?");
        }

        try (PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (userId != null) {
                stmt.setInt(paramIndex++, userId);
            }
            if (shipmentId != null) {
                stmt.setInt(paramIndex++, shipmentId);
            }
            if (dateShipped != null) {
                stmt.setDate(paramIndex++, dateShipped);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                List<Shipment> shipments = new ArrayList<>();
                while (rs.next()) {
                    shipments.add(extractShipmentFromResultSet(rs));
                }
                return shipments;
            }
        }
    }

}
