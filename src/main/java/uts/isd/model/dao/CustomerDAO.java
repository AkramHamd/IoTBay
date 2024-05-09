package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import uts.isd.model.Customer;

public class CustomerDAO {

    private Connection connection;

    public CustomerDAO(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    public Integer addCustomer(String given_name, String family_name, String email, String password, String phone, String dob, String verification_code, String is_verified) throws SQLException {
        String query = "INSERT INTO customers (given_name, family_name, email, password, phone, dob, verification_code, is_verified) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, given_name);
        st.setString(2, family_name);
        st.setString(3, email);
        st.setString(4, password);
        st.setString(5, phone);
        st.setString(6, dob);
        st.setString(7, verification_code);
        st.setString(8, is_verified);
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            int customer_id = rs.getInt(1);
            return customer_id;
        } else {
            return null;
        }
    }

    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM customers WHERE email = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        } else {
            return false;
        }
    }

    public void updateCustomer(Customer customer) throws SQLException {
        String query = "UPDATE customers SET given_name = ?, family_name = ?, email = ?, password = ?, phone = ?, dob = ? WHERE customer_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getGiven_name());
        statement.setString(2, customer.getFamily_name());
        statement.setString(3, customer.getEmail());
        statement.setString(4, customer.getPassword());
        statement.setString(5, customer.getPhone());
        statement.setString(6, customer.getDob());
        statement.setInt(7, customer.getCustomer_id());
        statement.executeUpdate();
    }

    public ArrayList<Customer> fetchAllCustomers() throws SQLException {
        // Connection conn = connection; // Initialize conn with the existing connection object
        String query = "SELECT customer_id, given_name, family_name, email, password, phone FROM customers";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Customer> allCustomers = new ArrayList<>();
    
        while (rs.next()) {
            int customer_id = rs.getInt(1);
            String given_name = rs.getString(2);
            String family_name = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String phone = rs.getString(6);
    
            Customer customer = new Customer(customer_id, given_name, family_name, email, password, phone);
            allCustomers.add(customer);
        }
    
        return allCustomers;
    }

    public Customer fetchCustomer(int customer_id) throws SQLException {
        String query = "SELECT * FROM customers WHERE customer_id = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, customer_id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            String given_name = rs.getString(2);
            String family_name = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String dob = rs.getString(6);
            String phone = rs.getString(7);
            String created_at = rs.getString(8);
            String verification_code = rs.getString(9);
            String is_verified = rs.getString(10);


            Customer customer = new Customer(customer_id, given_name, family_name, email, password, dob, phone, created_at, verification_code, is_verified);
            return customer;
        } else {
            return null;
        }
    }

    public Integer validateCustomer(String email, String password) throws SQLException {
        String query = "SELECT * FROM customers WHERE email = ? AND password = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1, email);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            int customer_id = rs.getInt(1);
            return customer_id;
        } else {
            return null;
        }
    }
}
