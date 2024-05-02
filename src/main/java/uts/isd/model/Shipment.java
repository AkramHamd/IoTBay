package uts.isd.model;
import java.io.Serializable;
import java.sql.Date;

public class Shipment implements Serializable{
    
    private int shipmentId;
    private int orderId;
    private int customerId;
    private int addressId;
    private int courierId;
    private Date dateShipped;
    private Date dateDelivered;
    private String trackingNumber;
    
    public Shipment(int shipmentId, int orderId, int customerId, int addressId, int courierId, Date dateShipped,
            Date dateDelivered, String trackingNumber) {
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

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
