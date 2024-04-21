package Model.Class;

import java.sql.Connection;

public class StudentRemarks {
	 public Connection connection;

	    public StudentRemarks(Connection connection) {
	        this.connection = connection;
	    }
    private int userId;
    private String feedbackOnProject;
    private String remark;
    
    // Constructor
    public StudentRemarks(int userId, String feedbackOnProject, String remark) {
        this.userId = userId;
        this.feedbackOnProject = feedbackOnProject;
        this.remark = remark;
    }
    
    // Getters
    public int getUserId() {
        return userId;
    }
    
    public String getFeedbackOnProject() {
        return feedbackOnProject;
    }
    
    public String getRemark() {
        return remark;
    }
    
    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setFeedbackOnProject(String feedbackOnProject) {
        this.feedbackOnProject = feedbackOnProject;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString() {
        String tableFormat = String.format("| %-20s | %-20s | %-20s |%n",
                userId, feedbackOnProject, remark);
        return tableFormat;
    }

    public static String getColumnHeaders() {
        return String.format("|----------------------|----------------------|----------------------|%n" +
                             "|       User ID        |  Feedback on Project |        Remark        |%n" +
                             "|----------------------|----------------------|----------------------|");
    }

}
