package uts.isd.model;
import java.io.Serializable;

public class Log implements Serializable{
    
    private int LogId;
    private int customerId;
    private String accessDate;
    private String accessTime;
    private boolean accessSuccess;

    public Log(int logId, int customerId, String accessDate, String accessTime, boolean accessSuccess) {
        LogId = logId;
        this.customerId = customerId;
        this.accessDate = accessDate;
        this.accessTime = accessTime;
        this.accessSuccess = accessSuccess;
    }
    public int getLogId() {
        return LogId;
    }
    public void setLogId(int logId) {
        LogId = logId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getAccessDate() {
        return accessDate;
    }
    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }
    public String getAccessTime() {
        return accessTime;
    }
    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }
    public boolean isAccessSuccess() {
        return accessSuccess;
    }
    public void setAccessSuccess(boolean accessSuccess) {
        this.accessSuccess = accessSuccess;
    }

    
}