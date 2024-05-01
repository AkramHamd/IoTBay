package uts.isd.model;
import java.io.Serializable;

public class PaymentLog implements Serializable{
    private int paymentLogId;
    private int paymentId;
    private int customerId;
    private String logDate;
    private String logTime;
    
    public PaymentLog(int paymentLogId, int paymentId, int customerId, String logDate, String logTime) {
        this.paymentLogId = paymentLogId;
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.logDate = logDate;
        this.logTime = logTime;
    }

    public int getPaymentLogId() {
        return paymentLogId;
    }

    public void setPaymentLogId(int paymentLogId) {
        this.paymentLogId = paymentLogId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
}
