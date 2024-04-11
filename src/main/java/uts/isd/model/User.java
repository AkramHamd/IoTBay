package uts.isd.model;
import java.io.Serializable;

public class User implements Serializable{
    
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password1;
    private String passowrd2;
    private String dob;
    private String phoneNumber;
    private int addressId;
    
    public User(String firstName, String lastName, String email, String password1, String passowrd2, String dob, String phoneNumber, int addressId, int userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password1 = password1;
        this.passowrd2 = passowrd2;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassowrd2() {
        return passowrd2;
    }

    public void setPassowrd2(String passowrd2) {
        this.passowrd2 = passowrd2;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }    
}
