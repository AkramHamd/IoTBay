package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDAO {
    
    private Connection connection;

    public LogDAO(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    public void addLog(int customer_id, String type) throws SQLException {
        String query = "INSERT INTO logs (customer_id, type) VALUES (?, ?)";
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, customer_id);
        st.setString(2, type);
        st.executeUpdate();
    }
}
