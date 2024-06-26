package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uts.isd.model.Log;

public class LogDAO {
    
    private Connection connection;

    // log constructor to initialise the connection
    public LogDAO(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    // add log method that accepts user id and type such as login, logout and register
    public void addLog(int user_id, String type) throws SQLException {
        String query = "INSERT INTO logs (user_id, type) VALUES (?, ?)";
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, user_id);
        st.setString(2, type);
        st.executeUpdate();
    }

    //get logs by user id and return the Log object
    public ArrayList<Log> getLogs(int user_id) throws SQLException {
    String query = "SELECT * FROM logs WHERE user_id = ?";
    PreparedStatement st = connection.prepareStatement(query);
    st.setInt(1, user_id);
    ResultSet rs = st.executeQuery();

    ArrayList<Log> logs = new ArrayList<>();
        while (rs.next()) {
            int log_id = rs.getInt("log_id");
            int log_user_id = rs.getInt("user_id");
            String type = rs.getString("type");
            String timestamp = rs.getString("timestamp");
            logs.add(new Log(log_id, log_user_id, type, timestamp));
        }
        return logs;
    }

    //get all logs and return the an array of Log object
    public ArrayList<Log> getAllLogs() throws SQLException {
        String query = "SELECT * FROM logs";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
    
        ArrayList<Log> logs = new ArrayList<>();
        while (rs.next()) {
            int log_id = rs.getInt("log_id");
            int log_user_id = rs.getInt("user_id");
            String type = rs.getString("type");
            String timestamp = rs.getString("timestamp");
            logs.add(new Log(log_id, log_user_id, type, timestamp));
        }
        return logs;
    }

    //search logs by user id and date and return the an array of Log object
    public ArrayList<Log> searchLogs(int user_id, String date) throws SQLException {
        //search logs by user id and date
        String query = "SELECT * FROM logs WHERE user_id = ? AND DATE(timestamp) = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, user_id);
        statement.setString(2, date);
        ResultSet rs = statement.executeQuery();

        ArrayList<Log> logs = new ArrayList<>();
        while (rs.next()) {
            int log_id = rs.getInt("log_id");
            int log_user_id = rs.getInt("user_id");
            String type = rs.getString("type");
            String timestamp = rs.getString("timestamp");
            logs.add(new Log(log_id, log_user_id, type, timestamp));
        }
        return logs;
    }

    //search all logs by date and return the an array of Log object
    public ArrayList<Log> searchAllLogs(String date) throws SQLException {
        //search logs by user id and date
        String query = "SELECT * FROM logs WHERE DATE(timestamp) = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, date);
        ResultSet rs = statement.executeQuery();

        ArrayList<Log> allLogs = new ArrayList<>();
        while (rs.next()) {
            int log_id = rs.getInt("log_id");
            int log_user_id = rs.getInt("user_id");
            String type = rs.getString("type");
            String timestamp = rs.getString("timestamp");
            allLogs.add(new Log(log_id, log_user_id, type, timestamp));
        }
        return allLogs;
    }
}
