package uts.isd.model;

import java.io.Serializable;

public class OrderTable implements Serializable {
    private int order_id; // Modified from orderId
    private int user_id; // Modified from customerId
    private String orderDate;
    private String status;
    private String shippingId;
    
    public OrderTable(int order_id, int user_id, String orderDate, String status, String shippingId) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.orderDate = orderDate;
        this.status = status;
        this.shippingId = shippingId;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }   
}