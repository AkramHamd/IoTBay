package uts.isd.model.dao;

import uts.isd.model.PaymentMethod;

import java.sql.*;

public class PaymentMethodDAO {

    private Connection connection;

    

    public PaymentMethodDAO(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(true);
    }
    // retrieve the payment method by the customer id

    public PaymentMethod getByCustomer(int customer_id) {
        String query = "select * from paymentmethod where user_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, customer_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                // Create and return a new PaymentMethod object

                return new PaymentMethod(
                        rs.getInt("paymentMethod_id"),
                        rs.getInt("user_id"),
                        rs.getString("Number"),
                        rs.getString("Name"),
                        rs.getString("Expiry"),
                        rs.getString("CVV")
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // add a new payment method method

    public PaymentMethod add(PaymentMethod paymentMethod) {

        // SQL to insert a new payment method into the DB

        String query = "INSERT INTO paymentmethod (user_id, Number, Name, Expiry, CVV) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, paymentMethod.getCustomerId());
            st.setString(2, paymentMethod.getNumber());
            st.setString(3, paymentMethod.getName());
            st.setString(4, paymentMethod.getExpiry());
            st.setString(5, paymentMethod.getCvv());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int paymentMethodId = rs.getInt(1);
                String selectQuery = "SELECT * FROM paymentmethod WHERE paymentMethod_id = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setInt(1, paymentMethodId);
                ResultSet selectResultSet = selectStatement.executeQuery();
                if (selectResultSet.next()) {

                    // create a payment method object based on the data
                    
                    return new PaymentMethod(
                            selectResultSet.getInt("paymentMethod_id"),
                            selectResultSet.getInt("user_id"),
                            selectResultSet.getString("Number"),
                            selectResultSet.getString("Name"),
                            selectResultSet.getString("Expiry"),
                            selectResultSet.getString("CVV")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
