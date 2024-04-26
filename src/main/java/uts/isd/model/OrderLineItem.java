package uts.isd.model;
import java.io.Serializable;

public class OrderLineItem implements Serializable {
    
    private int orderLineNumber;
    private int orderId;
    private int productId;
    private int quantity;
    private double orderLineNumberPrice;
    
    public OrderLineItem(int orderLineNumber, int orderId, int productId, int quantity, double orderLineNumberPrice) {
        this.orderLineNumber = orderLineNumber;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderLineNumberPrice = orderLineNumberPrice;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }
    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
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