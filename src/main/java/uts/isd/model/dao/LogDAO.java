package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uts.isd.model.Log;

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

    //get logs by customer_id and return the Log object
    public ArrayList<Log> getLogs(int customer_id) throws SQLException {
    String query = "SELECT * FROM logs WHERE customer_id = ?";
    PreparedStatement st = connection.prepareStatement(query);
    st.setInt(1, customer_id);
    ResultSet rs = st.executeQuery();

    ArrayList<Log> logs = new ArrayList<>();
        while (rs.next()) {
            int log_id = rs.getInt("log_id");
            int log_customer_id = rs.getInt("customer_id");
            String type = rs.getString("type");
            String timestamp = rs.getString("timestamp");
            logs.add(new Log(log_id, log_customer_id, type, timestamp));
        }
        return logs;
    }
}
