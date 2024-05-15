package uts.isd.model;

public class PaymentMethod {

    private Integer id;
    private Integer customer_id;

    private String number;

    private String name;

    private String expiry;

    private String cvv;

    public PaymentMethod(Integer id, Integer customer_id, String number, String name, String expiry, String cvv) {
        this.id = id;
        this.customer_id = customer_id;
        this.number = number;
        this.name = name;
        this.expiry = expiry;
        this.cvv = cvv;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customer_id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getCvv() {
        return cvv;
    }
}
