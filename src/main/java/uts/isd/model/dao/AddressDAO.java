package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uts.isd.model.Address;

public class AddressDAO {
    private Connection connection;

    public AddressDAO(Connection connection) throws SQLException{
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    public Address addAddress(int customer_id, int unit_number, int street_number, String street_name, String suburb, String state, int postcode, String country) throws SQLException {
        String query = "INSERT INTO addresses (customer_id, unit_number, street_number, street_name, suburb, state, postcode, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, customer_id);
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
            String selectQuery = "SELECT * FROM addresses WHERE address_id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, address_id);
            ResultSet selectResultSet = selectStatement.executeQuery();
            if (selectResultSet.next()) {
                return new Address(
                    selectResultSet.getInt("address_id"),
                    selectResultSet.getInt("customer_id"),
                    selectResultSet.getInt("unit_number"),
                    selectResultSet.getInt("street_number"),
                    selectResultSet.getString("street_name"),
                    selectResultSet.getString("suburb"),
                    selectResultSet.getString("state"),
                    selectResultSet.getInt("postcode"),
                    selectResultSet.getString("country")
                );
            }
        }
        return null;
    }

    public void updateAddress(Address address) throws SQLException {
        String query = "UPDATE addresses SET unit_number = ?, street_number = ?, street_name = ?, suburb = ?, state = ?, postcode = ?, country = ? WHERE address_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, address.getUnit_number());
        statement.setInt(2, address.getStreet_number());
        statement.setString(3, address.getStreet_name());
        statement.setString(4, address.getSuburb());
        statement.setString(5, address.getState());
        statement.setInt(6, address.getPostcode());
        statement.setString(7, address.getCountry());
        statement.setInt(8, address.getAddress_id());
        statement.executeUpdate();
    }
}
