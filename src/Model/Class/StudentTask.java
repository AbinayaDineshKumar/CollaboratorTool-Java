package Model.Class;
public class StudentTask {
    private int userId;
    private String userName;
    private String taskName;
    private String taskStatus;
    private String dateOfCompletion;

    public StudentTask(int userId, String userName, String taskName, String taskStatus, String dateOfCompletion) {
        this.userId = userId;
        this.userName = userName;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.dateOfCompletion = dateOfCompletion;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDateOfCompletion() {
        return dateOfCompletion;
    }
    public void setDateOfCompletion(String dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }
    public String toString() {
        String tableFormat = String.format("| %-20s | %-20s | %-20s | %-20s | %-23s |%n",
                userId, userName, taskName, taskStatus, dateOfCompletion);
        return tableFormat;
    }

    public static String getColumnHeaders() {
        return String.format("|----------------------|----------------------|----------------------|----------------------|-------------------------|%n" +
                             "|       User ID        |      User Name       |      Task Name       |     Task Status      |   Date of Completion    |%n" +
                             "|----------------------|----------------------|----------------------|----------------------|-------------------------|");
    }
}
