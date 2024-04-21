package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Class.*;


public class StudentTaskDAO {
    private Connection connection;

    public StudentTaskDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertTask(StudentTask task) throws SQLException {
        String query = "INSERT INTO sTask (userId, userName, taskName, taskStatus, dateOfCompletion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, task.getUserId());
            statement.setString(2, task.getUserName());
            statement.setString(3, task.getTaskName());
            statement.setString(4, task.getTaskStatus());
            statement.setString(5, task.getDateOfCompletion());
            statement.executeUpdate();
        }
    }

    public List<StudentTask> getAllTasks() throws SQLException {
        List<StudentTask> tasks = new ArrayList<>();
        String query = "SELECT userId, userName, taskName, taskStatus, dateOfCompletion FROM sTask";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userName = resultSet.getString("userName");
                String taskName = resultSet.getString("taskName");
                String taskStatus = resultSet.getString("taskStatus");
                String dateOfCompletion = resultSet.getString("dateOfCompletion");
                StudentTask task = new StudentTask(userId, userName, taskName, taskStatus, dateOfCompletion);
                tasks.add(task);
            }
        }
        return tasks;
    }
}

