package uts.isd.model;
import java.io.Serializable;

public class User implements Serializable{
    
    private String firstName;
    private String lastName;
    private String email;
    private String password1;
    private String passowrd2;
    
    public User(String firstName, String lastName, String email, String password1, String passowrd2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password1 = password1;
        this.passowrd2 = passowrd2;
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
}
