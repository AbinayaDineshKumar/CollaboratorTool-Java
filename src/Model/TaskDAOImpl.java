package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Class.Task;

public class TaskDAOImpl implements TaskDAO {
    private Connection connection;

    public TaskDAOImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insertTask(Task task) throws SQLException {
        String query = "INSERT INTO task (taskName, taskType, dueDate, subjectName) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, task.getTaskName());
            statement.setString(2, task.getTaskType());
            statement.setDate(3, new java.sql.Date(task.getDueDate().getTime())); // Assuming java.util.Date
            statement.setString(4, task.getSubjectName());
            statement.executeUpdate();
        }
    }
    @Override
    public List<Task> getAllTasks() throws SQLException {
        List<Task> taskList = new ArrayList<>();
        String query = "SELECT * FROM task";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String taskName = resultSet.getString("taskName");
                String taskType = resultSet.getString("taskType");
                Date dueDate = resultSet.getDate("dueDate");
                String subjectName = resultSet.getString("subjectName");

                taskList.add(new Task(taskName, taskType, dueDate, subjectName));
            }
        }
        return taskList;
    }
    @Override
    public void updateTask(Task task) throws SQLException {
        String query = "UPDATE task SET taskType=?, dueDate=? WHERE taskName=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, task.getTaskType());
            statement.setDate(2, new java.sql.Date(task.getDueDate().getTime())); // Assuming java.util.Date
            statement.setString(3, task.getTaskName());
            statement.executeUpdate();
        }
    }
    @Override
    public void deleteTask(String taskName) throws SQLException {
        String query = "DELETE FROM task WHERE taskName=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, taskName);
            statement.executeUpdate();
        }
    }
}
