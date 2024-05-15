package uts.isd.model;

import java.io.Serializable;

public class OrderLineItem implements Serializable {
    
    private int orderLineNumber;
    private int order_id; // Modified from orderId
    private int product_id; // Modified from productId
    private int quantity;
    private double orderLineNumberPrice;
    
    public OrderLineItem(int orderLineNumber, int order_id, int product_id, int quantity, double orderLineNumberPrice) {
        this.orderLineNumber = orderLineNumber;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.orderLineNumberPrice = orderLineNumberPrice;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }
    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getOrderLineNumberPrice() {
        return orderLineNumberPrice;
    }
    public void setOrderLineNumberPrice(double orderLineNumberPrice) {
        this.orderLineNumberPrice = orderLineNumberPrice;
    }    
}