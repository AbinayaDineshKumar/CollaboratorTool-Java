package Model.Class;
import java.sql.Connection;
import java.util.Date;

public class Report {
	public Connection connection;

    public Report(Connection connection) {
        this.connection = connection;
    }
    private int reportId;
    private int userId;
    private int projectId;
    private String reportProgress;
    private Date reportingDate;
    
    // Constructor
    public Report(int reportId, int userId, int projectId, String reportProgress, Date reportingDate) {
        this.reportId = reportId;
        this.userId = userId;
        this.projectId = projectId;
        this.reportProgress = reportProgress;
        this.reportingDate = reportingDate;
    }
    
   

	// Getters
    public int getReportId() {
        return reportId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public int getProjectId() {
        return projectId;
    }
    
    public String getReportProgress() {
        return reportProgress;
    }
    
    public Date getReportingDate() {
        return reportingDate;
    }
    
    // Setters
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    
    public void setReportProgress(String reportProgress) {
        this.reportProgress = reportProgress;
    }
    
    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }
    @Override
    public String toString() {
        String tableFormat = String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |%n",
                reportId, userId, projectId, reportProgress, reportingDate);
        return tableFormat;
    }

    public static String getColumnHeaders() {
        return String.format("|----------------------|----------------------|----------------------|----------------------|----------------------|%n" +
                             "|     Report ID        |       User ID        |     Project ID       |    Report Progress   |   Reporting Date     |%n" +
                             "|----------------------|----------------------|----------------------|----------------------|----------------------|");
    }

}

