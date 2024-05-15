package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uts.isd.model.User;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    // creating a user method
    public Integer createUser(String given_name, String family_name, String email, String password, String phone, String dob, String verification_code, String is_verified, String is_staff) throws SQLException {
        String query = "INSERT INTO users (given_name, family_name, email, password, phone, dob, verification_code, is_verified, is_staff) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, given_name);
        st.setString(2, family_name);
        st.setString(3, email);
        st.setString(4, password);
        st.setString(5, phone);
        st.setString(6, dob);
        st.setString(7, verification_code);
        st.setString(8, is_verified);
        st.setString(9, is_staff);
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            int user_id = rs.getInt(1);
            return user_id;
        } else {
            return null;
        }
    }

    // reading a user by id method
    public User readUser(int user_id) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, user_id);
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
            String is_staff = rs.getString(11);


            User user = new User(user_id, given_name, family_name, email, password, dob, phone, created_at, verification_code, is_verified, is_staff);
            return user;
        } else {
            return null;
        }
    }

    // reading all users method
    public ArrayList<User> readAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        
        ArrayList<User> allUsers = new ArrayList<>();
    
        while (rs.next()) {
            int user_id = rs.getInt(1);
            String given_name = rs.getString(2);
            String family_name = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String dob = rs.getString(6);
            String phone = rs.getString(7);
            String created_at = rs.getString(8);
            String verification_code = rs.getString(9);
            String is_verified = rs.getString(10);
            String is_staff = rs.getString(11);

            User user = new User(user_id, given_name, family_name, email, password, dob, phone, created_at, verification_code, is_verified, is_staff);
            allUsers.add(user);
        }
    
        return allUsers;
    }

    //updating a user by id method
    public void updateUser(int user_id, String given_name, String family_name, String email, String password, String phone, String dob) throws SQLException {
        String query = "UPDATE users SET given_name = ?, family_name = ?, email = ?, password = ?, phone = ?, dob = ? WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, given_name);
        statement.setString(2, family_name);
        statement.setString(3, email);
        statement.setString(4, password);
        statement.setString(5, phone);
        statement.setString(6, dob);
        statement.setInt(7, user_id);
        
        statement.executeUpdate();
    }

    //deleting a user by id method
    public void deleteUser(int user_id) throws SQLException {
        String query = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, user_id);
        statement.executeUpdate();
    }

    // checking if email exists method for register jsp to not allow a user to create an account with an existing email
    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
       
        if (rs.next()) {
            return rs.getInt(1) > 0; // returns true if an email exists
        } else {
            return false; // returns false if an email does not exist
        }
    }

    // checking if email exists method for login jsp to validate a user with entered email and password
    public Integer validateUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            int user_id = rs.getInt(1);
            return user_id;
        } else {
            return null;
        }
    }
}
