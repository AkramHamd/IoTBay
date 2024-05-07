package uts.isd.model;

public class Customer {
    
    private int customer_id;
    private String given_name;
    private String family_name;
    private String email;
    private String password;
    private String dob;
    private String phone;
    private String created_at;
    private int address_id;
    private int payment_id;
    private int log_id;
    private int order_id;

    

    public Customer(String given_name, String family_name, String email, String password, String phone, String dob) {
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dob = dob;
    }

    public Customer(String given_name, String family_name, String email, String password, String phone) {
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Customer(int customer_id, String given_name, String family_name, String email, String password,
            String phone) {
        this.customer_id = customer_id;
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Customer(int customer_id, String given_name, String family_name, String email, String password, String dob,
            String phone) {
        this.customer_id = customer_id;
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
    }

    public Customer(String given_name, String family_name, String email, String password, String dob, String phone,
            int address_id, int payment_id, int log_id, int order_id) {
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.address_id = address_id;
        this.payment_id = payment_id;
        this.log_id = log_id;
        this.order_id = order_id;
    }

    public Customer(int customer_id, String given_name, String family_name, String email, String password, String dob,
            String phone, String created_at, int address_id, int payment_id, int log_id, int order_id) {
        this.customer_id = customer_id;
        this.given_name = given_name;
        this.family_name = family_name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.created_at = created_at;
        this.address_id = address_id;
        this.payment_id = payment_id;
        this.log_id = log_id;
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
