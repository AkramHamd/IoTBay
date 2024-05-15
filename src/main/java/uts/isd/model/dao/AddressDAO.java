package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uts.isd.model.Address;

public class AddressDAO {
    private Connection connection;

    public AddressDAO(Connection connection) throws SQLException{
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    public Integer createAddress(int user_id, int unit_number, int street_number, String street_name, String suburb, String state, int postcode, String country) throws SQLException {
        String query = "INSERT INTO addresses (user_id, unit_number, street_number, street_name, suburb, state, postcode, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, user_id);
        st.setInt(2, unit_number);
        st.setInt(3, street_number);
        st.setString(4, street_name);
        st.setString(5, suburb);
        st.setString(6, state);
        st.setInt(7, postcode);
        st.setString(8, country);
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            int address_id = rs.getInt(1);
            return address_id;
        }
        return null;
    }

    public Address readAddress(int addressId) throws SQLException {
        String query = "SELECT * FROM addresses WHERE address_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, addressId);
        ResultSet rs = statement.executeQuery();
    
        if (rs.next()) {
            int user_id = rs.getInt("user_id");
            int unitNumber = rs.getInt("unit_number");
            int streetNumber = rs.getInt("street_number");
            String streetName = rs.getString("street_name");
            String suburb = rs.getString("suburb");
            String state = rs.getString("state");
            int postcode = rs.getInt("postcode");
            String country = rs.getString("country");
    
            return new Address(addressId, user_id, unitNumber, streetNumber, streetName, suburb, state, postcode, country);
        }
    
        return null;
    }

    public ArrayList<Address> readAddresses(int user_id) throws SQLException {
    String query = "SELECT * FROM addresses WHERE user_id = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setInt(1, user_id);
    ResultSet rs = statement.executeQuery();

    ArrayList<Address> addresses = new ArrayList<>();

    while (rs.next()) {
        int addressId = rs.getInt("address_id");
        int unitNumber = rs.getInt("unit_number");
        int streetNumber = rs.getInt("street_number");
        String streetName = rs.getString("street_name");
        String suburb = rs.getString("suburb");
        String state = rs.getString("state");
        int postcode = rs.getInt("postcode");
        String country = rs.getString("country");

        addresses.add(new Address(addressId, user_id, unitNumber, streetNumber, streetName, suburb, state, postcode, country));
    }
        return addresses;
    }

    public void updateAddress(int addressId, int unitNumber, int streetNumber, String streetName, String suburb, String state, int postcode, String country) throws SQLException {
        String query = "UPDATE addresses SET unit_number = ?, street_number = ?, street_name = ?, suburb = ?, state = ?, postcode = ?, country = ? WHERE address_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, unitNumber);
        statement.setInt(2, streetNumber);
        statement.setString(3, streetName);
        statement.setString(4, suburb);
        statement.setString(5, state);
        statement.setInt(6, postcode);
        statement.setString(7, country);
        statement.setInt(8, addressId);
        statement.executeUpdate();
    }

    public void deleteAddress(int addressId) throws SQLException {
        String query = "DELETE FROM addresses WHERE address_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, addressId);
        statement.executeUpdate();
    }

    public Address getAddressByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM addresses WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);
        ResultSet rs = statement.executeQuery();
    
        if (rs.next()) {
            int addressId = rs.getInt("address_id");
            int unitNumber = rs.getInt("unit_number");
            int streetNumber = rs.getInt("street_number");
            String streetName = rs.getString("street_name");
            String suburb = rs.getString("suburb");
            String state = rs.getString("state");
            int postcode = rs.getInt("postcode");
            String country = rs.getString("country");
    
            return new Address(addressId, userId, unitNumber, streetNumber, streetName, suburb, state, postcode, country);
        }
    
        return null;
    }
}
