package uts.isd.model;
import java.io.Serializable;

public class Address implements Serializable{
    
    private int address_id;
    private int customer_id;
    private int unit_number;
    private int street_number;
    private String street_name;
    private String suburb;
    private String state;
    private int postcode;
    private String country;
    
    public Address(int address_id, int customer_id, int unit_number, int street_number, String street_name,
            String suburb, String state, int postcode, String country) {
        this.address_id = address_id;
        this.customer_id = customer_id;
        this.unit_number = unit_number;
        this.street_number = street_number;
        this.street_name = street_name;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }

    public Address(int customer_id, int unit_number, int street_number, String street_name, String suburb, String state,
            int postcode, String country) {
        this.customer_id = customer_id;
        this.unit_number = unit_number;
        this.street_number = street_number;
        this.street_name = street_name;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getUnit_number() {
        return unit_number;
    }

    public void setUnit_number(int unit_number) {
        this.unit_number = unit_number;
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}