package uts.isd.model;
import java.io.Serializable;

public class Shipment implements Serializable{
    
    private int shipmentId;
    private int orderId;
    private int customerId;
    private int addressId;
    private int courierId;
    private String dateShipped;
    private String dateDelivered;
    private String trackingNumber;
    
    public Shipment(int shipmentId, int orderId, int customerId, int addressId, int courierId, String dateShipped,
            String dateDelivered, String trackingNumber) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.addressId = addressId;
        this.courierId = courierId;
        this.dateShipped = dateShipped;
        this.dateDelivered = dateDelivered;
        this.trackingNumber = trackingNumber;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(String dateShipped) {
        this.dateShipped = dateShipped;
    }

    public String getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(String dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}