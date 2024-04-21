package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Class.*;

public class SubjectDAOimpl {
    private Connection connection;

    public SubjectDAOimpl(Connection connection) {
        this.connection = connection;
    }
    public void insertSubject(Subject subject) throws SQLException {
        String query = "INSERT INTO subject (subjectId, subjectName) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, subject.getSubjectId());
            statement.setString(2, subject.getSubjectName());
            statement.executeUpdate();
        }
    }
    public List<Subject> getAllSubjects() throws SQLException {
        List<Subject> subjectList = new ArrayList<>();
        String query = "SELECT * FROM subject";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int subjectId = resultSet.getInt("subjectId");
                String subjectName = resultSet.getString("subjectName");

                subjectList.add(new Subject(subjectId, subjectName));
            }
        }
        return subjectList;
    }
    public void updateSubject(Subject subject) throws SQLException {
        String query = "UPDATE subject SET subjectName=? WHERE subjectId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, subject.getSubjectName());
            statement.setInt(2, subject.getSubjectId());
            statement.executeUpdate();
        }
    }
    public void deleteSubject(int subjectId) throws SQLException {
        String query = "DELETE FROM subject WHERE subjectId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, subjectId);
            statement.executeUpdate();
        }
    }
}
