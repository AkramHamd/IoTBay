package uts.isd.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment implements Serializable {

    private int paymentId;

    private int customer_id;
    private int orderId;
    private int paymentMethodId;
    private String paymentDate;
    private String amount;
    private String currency;

    public Payment(int orderId, int customer_id, int paymentMethod, String amount, String paymentDate) {
        this.orderId = orderId;
        this.customer_id = customer_id;
        this.paymentMethodId = paymentMethod;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment(int paymentId, int orderId, int customer_id, int paymentMethod, String amount, String paymentDate) {
        this(orderId, customer_id, paymentMethod, amount, paymentDate);
        this.paymentId = paymentId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}