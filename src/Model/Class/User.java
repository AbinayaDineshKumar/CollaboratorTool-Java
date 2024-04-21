package Model.Class;

public class User {
    private int userId;
    private String userName;
    private String userMail;
    private String userPassword;
    private String userRole;
    
    // Constructor
    public User(int userId, String userName, String userMail, String userPassword, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }
    
    // Getters
    public int getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getUserMail() {
        return userMail;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public String getUserRole() {
        return userRole;
    }
    
    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
