package uts.isd.model;
import java.io.Serializable;

public class Log implements Serializable{
    
    private int log_id;
    private int user_id;
    private String type;
    private String timestamp;

    public Log(int log_id, int user_id, String type, String timestamp) {
        this.log_id = log_id;
        this.user_id = user_id;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Log(int user_id, String type, String timestamp) {
        this.user_id = user_id;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Log(int user_id, String type) {
        this.user_id = user_id;
        this.type = type;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}