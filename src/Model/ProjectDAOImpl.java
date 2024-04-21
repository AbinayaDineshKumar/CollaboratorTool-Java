package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Class.*;

public class ProjectDAOImpl {
    private Connection connection;

    public ProjectDAOImpl(Connection connection) {
       this.connection = connection;
    }
    public static void insertProject(Connection connection,Project project) throws SQLException {
    	
        PreparedStatement statement = null ;
        try {
            String sql = "INSERT INTO project(userId,projectId, projectName, projectDomain, projectObjective, mentorName) VALUES (?,?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, project.getUserId());
            statement.setInt(2, project.getProjectId());
            statement.setString(3, project.getProjectName());
            statement.setString(4, project.getProjectDomain());
            statement.setString(5, project.getProjectObjective());
            statement.setString(6, project.getMentorName());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public Project getProjectById(int projectId) throws SQLException {
        String query = "SELECT * FROM project WHERE projectId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Project(
                            resultSet.getInt("userId"),
                            resultSet.getInt("projectId"),
                            resultSet.getString("projectName"),
                            resultSet.getString("projectDomain"),
                            resultSet.getString("projectObjective"),
                            resultSet.getString("mentorName")
                    );
                } else {
                    return null;
                }
            }
        }
    }
    public void updateProject(Project project) throws SQLException {
        String query = "UPDATE project SET userId=?, projectName=?, projectDomain=?, projectObjective=?, mentorName=? WHERE projectId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, project.getUserId());
            statement.setString(2, project.getProjectName());
            statement.setString(3, project.getProjectDomain());
            statement.setString(4, project.getProjectObjective());
            statement.setString(5, project.getMentorName());
            statement.setInt(6, project.getProjectId());
            statement.executeUpdate();
        }
    }
    public void deleteProject(int projectId) throws SQLException {
        String query = "DELETE FROM project WHERE projectId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectId);
            statement.executeUpdate();
        }
    }
    public List<Project> getAllProjects() throws SQLException {
        List<Project> projectList = new ArrayList<>();
        String query = "SELECT * FROM project";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                int projectId = resultSet.getInt("projectId");
                String projectName = resultSet.getString("projectName");
                String projectDomain = resultSet.getString("projectDomain");
                String projectObjective = resultSet.getString("projectObjective");
                String mentorName = resultSet.getString("mentorName");

                projectList.add(new Project(userId, projectId, projectName, projectDomain, projectObjective, mentorName));
            }
        }
        return projectList;
    }
}
