package Model.Class;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
	 public Connection connection;

	    public Task(Connection connection) {
	        this.connection = connection;
	    }

    private String taskName;
    private String taskType;
    private Date dueDate;
    private String subjectName;
    
    // Constructor
    public Task(String taskName, String taskType, Date dueDate, String subjectName) {
        this.taskName = taskName;
        this.taskType = taskType;
        this.dueDate = dueDate;
        this.subjectName = subjectName;
    }
    
    // Getters
    public String getTaskName() {
        return taskName;
    }
    
    public String getTaskType() {
        return taskType;
    }
    
    public Date getDueDate() {
        return dueDate;
    }
    
    public String getSubjectName() {
        return subjectName;
    }
    
    // Setters
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
    
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDueDate = dateFormat.format(dueDate);
        
        String tableFormat = String.format("| %-20s | %-20s | %-15s | %-20s |%n",
                taskName, taskType, formattedDueDate, subjectName);
        return tableFormat;
    }
    public static String getColumnHeaders() {
        return String.format("|----------------------|----------------------|-----------------|----------------------|\n" +
                             "|      TASK NAME       |      TASK TYPE       |    DUE DATE     |      SUBJECT NAME    |\n" +
                             "|----------------------|----------------------|-----------------|----------------------|");
    }
}
