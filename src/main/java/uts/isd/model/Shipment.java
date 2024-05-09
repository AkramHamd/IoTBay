package uts.isd.model;

import java.sql.Date;

public class Shipment {
    private int shipment_Id;
    private int order_Id;
    private int customer_Id;
    private int address_Id;
    private int courier_Id;
    private Date date_Shipped;
    private Date date_Delivered;
    private String tracking_Number;

    // Constructor
    public Shipment(int shipment_Id, int order_Id, int customer_Id, int address_Id, int courier_Id, Date date_Shipped, Date date_Delivered, String tracking_Number) {
        this.shipment_Id = shipment_Id;
        this.order_Id = order_Id;
        this.customer_Id = customer_Id;
        this.address_Id = address_Id;
        this.courier_Id = courier_Id;
        this.date_Shipped = date_Shipped;
        this.date_Delivered = date_Delivered;
        this.tracking_Number = tracking_Number;
    }

    public Shipment() {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public int getShipment_Id() {
        return shipment_Id;
    }

    public void setShipment_Id(int shipment_Id) {
        this.shipment_Id = shipment_Id;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(int address_Id) {
        this.address_Id = address_Id;
    }

    public int getCourier_Id() {
        return courier_Id;
    }

    public void setCourier_Id(int courier_Id) {
        this.courier_Id = courier_Id;
    }

    public Date getDate_Shipped() {
        return date_Shipped;
    }

    public void setDate_Shipped(Date date_Shipped) {
        this.date_Shipped = date_Shipped;
    }

    public Date getDate_Delivered() {
        return date_Delivered;
    }

    public void setDate_Delivered(Date date_Delivered) {
        this.date_Delivered = date_Delivered;
    }

    public String getTracking_Number() {
        return tracking_Number;
    }

    public void setTracking_Number(String tracking_Number) {
        this.tracking_Number = tracking_Number;
    }
}
