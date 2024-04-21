package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Class.StudentRemarks;
public class StudentRemarksDAOImpl implements StudentRemarksDAO {
    private Connection connection;

    public StudentRemarksDAOImpl(Connection connection) {
        this.connection = connection;
    }
    public void insertStudentRemark(StudentRemarks studentRemark) throws SQLException {
        String query = "INSERT INTO student_remarks (userId, feedbackOnProject, remark) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentRemark.getUserId());
            statement.setString(2, studentRemark.getFeedbackOnProject());
            statement.setString(3, studentRemark.getRemark());
            statement.executeUpdate();
        }
    }
    public List<StudentRemarks> getStudentRemarksByUserId(int userId) throws SQLException {
        List<StudentRemarks> studentRemarksList = new ArrayList<>();
        String query = "SELECT * FROM student_remarks WHERE userId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String feedbackOnProject = resultSet.getString("feedbackOnProject");
                    String remark = resultSet.getString("remark");

                    studentRemarksList.add(new StudentRemarks(userId, feedbackOnProject, remark));
                }
            }
        }
        return studentRemarksList;
    }

    public void updateStudentRemark(StudentRemarks studentRemark) throws SQLException {
        String query = "UPDATE student_remarks SET feedbackOnProject=?, remark=? WHERE userId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, studentRemark.getFeedbackOnProject());
            statement.setString(2, studentRemark.getRemark());
            statement.setInt(3, studentRemark.getUserId());
            statement.executeUpdate();
        }
    }
    public void deleteStudentRemark(int userId) throws SQLException {
        String query = "DELETE FROM student_remarks WHERE userId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }
    public List<StudentRemarks> getAllRemarks() throws SQLException {
        List<StudentRemarks> remarkList = new ArrayList<>();
        String query = "SELECT * FROM student_remarks";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String feedbackOnProject = resultSet.getString("feedbackOnProject");
                String remark = resultSet.getString("remark");

                remarkList.add(new StudentRemarks(userId, feedbackOnProject, remark));
            }
        }
        return remarkList;
    }
}
