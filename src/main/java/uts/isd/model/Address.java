package uts.isd.model;
import java.io.Serializable;

public class Address implements Serializable{
    
    private int addressId;
    private int customerId;
    private String unitNumber;
    private String streetNumber;
    private String streetName;
    private String stateName;
    private String postCode;
    private String countryName;
    public Address(int addressId, int customerId, String unitNumber, String streetNumber, String streetName,
            String stateName, String postCode, String countryName) {
        this.addressId = addressId;
        this.customerId = customerId;
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.stateName = stateName;
        this.postCode = postCode;
        this.countryName = countryName;
    }
    public int getAddressId() {
        return addressId;
    }
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getUnitNumber() {
        return unitNumber;
    }
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
    public String getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    

}