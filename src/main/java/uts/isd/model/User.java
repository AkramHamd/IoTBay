package uts.isd.model;

public class User {
    
    private int user_id;
    private String given_name;
    private String family_name;
    private String email;
    private String password;
    private String dob;
    private String phone;
    private String created_at;
    private String verification_code;
    private String is_verified;
    private String is_staff;

    public User(int user_id, String given_name, String family_name, String email, String password, String dob,
            String phone, String created_at, String verification_code, String is_verified, String is_staff) {
        this.user_id = user_id;
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.created_at = created_at;
        this.verification_code = verification_code;
        this.is_verified = is_verified;
        this.is_staff = is_staff;
    }

    public User(String given_name, String family_name, String email, String password, String dob, String phone,
            String verification_code, String is_verified, String is_staff) {
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.verification_code = verification_code;
        this.is_verified = is_verified;
        this.is_staff = is_staff;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public String getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(String is_verified) {
        this.is_verified = is_verified;
    }

    public String getIs_staff() {
        return is_staff;
    }

    public void setIs_staff(String is_staff) {
        this.is_staff = is_staff;
    }
}
