package uts.isd.model.dao;

import uts.isd.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    private Connection connection;

    public PaymentDAO(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    public List<Payment> getAll(int customer_id) {
        String query = "select * from Payment where user_id=? order by Created_On desc";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, customer_id);

            ResultSet rs = st.executeQuery();
            List<Payment> payments = new ArrayList<>();
            while (rs.next()) {
                payments.add(new Payment(
                                rs.getInt("payment_id"),
                                rs.getInt("order_id"),
                                rs.getInt("user_id"),
                                rs.getInt("paymentMethod_id"),
                                rs.getString("Amount"),
                                rs.getString("Created_On")
                        )
                );
            }
            return payments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int add(Payment payment) {
        String query = "INSERT INTO Payment (order_id,user_id, paymentMethod_id, Created_On, Amount) VALUES (?,?, ?, ?, ?)";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, payment.getOrderId());
            st.setInt(2, payment.getCustomerId());
            st.setInt(3, payment.getPaymentMethodId());
            st.setString(4, payment.getPaymentDate());
            st.setString(5, payment.getAmount());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new RuntimeException("Unexpected error");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
