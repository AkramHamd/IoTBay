package uts.isd.model;
import java.io.Serializable;

public class Courier implements Serializable{
    
    private int courierId;
    private String courierName;
    private Double courierFee;

    public Courier(int courierId, String courierName, Double courierFee) {
        this.courierId = courierId;
        this.courierName = courierName;
        this.courierFee = courierFee;
    }
    public int getCourierId() {
        return courierId;
    }
    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }
    public String getCourierName() {
        return courierName;
    }
    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }
    public Double getCourierFee() {
        return courierFee;
    }
    public void setCourierFee(Double courierFee) {
        this.courierFee = courierFee;
    }
}
