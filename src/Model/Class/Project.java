package Model.Class;

import java.sql.Connection;

public class Project {
	public Connection connection;

    public Project(Connection connection) {
        this.connection = connection;
    }
    private int userId;
    private int projectId;
    private String projectName;
    private String projectDomain;
    private String projectObjective;
    private String mentorName;
    
    // Constructor
    public Project(int userId, int projectId, String projectName, String projectDomain, String projectObjective, String mentorName) {
        this.userId = userId;
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDomain = projectDomain;
        this.projectObjective = projectObjective;
        this.mentorName = mentorName;
    }
    
  

	// Getters
    public int getUserId() {
        return userId;
    }
    
    public int getProjectId() {
        return projectId;
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public String getProjectDomain() {
        return projectDomain;
    }
    
    public String getProjectObjective() {
        return projectObjective;
    }
    
    public String getMentorName() {
        return mentorName;
    }
    
    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public void setProjectDomain(String projectDomain) {
        this.projectDomain = projectDomain;
    }
    
    public void setProjectObjective(String projectObjective) {
        this.projectObjective = projectObjective;
    }
    
    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }
    @Override
    public String toString() {
        String tableFormat = String.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",
                userId, projectId, projectName, projectDomain, projectObjective, mentorName);
        return tableFormat;
    }

    public static String getColumnHeaders() {
        return String.format("|----------------------|----------------------|----------------------|----------------------|----------------------|----------------------|%n" +
                             "|       User ID        |      Project ID      |    Project Name      |    Project Domain    |  Project Objective   |     Mentor Name      |%n" +
                             "|----------------------|----------------------|----------------------|----------------------|----------------------|----------------------|");
    }

}
