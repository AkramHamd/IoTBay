package uts.isd.model;
import java.io.Serializable;

public class Log implements Serializable{
    
    private int log_id;
    private int customer_id;
    private String type;
    private String timestamp;

    public Log(int log_id, int customer_id, String type, String timestamp) {
        this.log_id = log_id;
        this.customer_id = customer_id;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Log(int customer_id, String type, String timestamp) {
        this.customer_id = customer_id;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Log(int customer_id, String type) {
        this.customer_id = customer_id;
        this.type = type;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}