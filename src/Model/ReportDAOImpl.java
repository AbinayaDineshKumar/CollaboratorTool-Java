package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Class.*;

public class ReportDAOImpl {
    private Connection connection;

    public ReportDAOImpl(Connection connection) {
        this.connection = connection;
    }
    public void insertReport(Report report) throws SQLException {
        String query = "INSERT INTO report (reportId, userId, projectId, reportProgress, reportingDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, report.getReportId());
            statement.setInt(2, report.getUserId());
            statement.setInt(3, report.getProjectId());
            statement.setString(4, report.getReportProgress());
            statement.setDate(5, new java.sql.Date(report.getReportingDate().getTime())); // Assuming java.util.Date
            statement.executeUpdate();
        }
    }
    public List<Report> getReportsByUserId(int userId) throws SQLException {
        List<Report> reportList = new ArrayList<>();
        String query = "SELECT * FROM report WHERE userId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int reportId = resultSet.getInt("reportId");
                    int projectId = resultSet.getInt("projectId");
                    String reportProgress = resultSet.getString("reportProgress");
                    Date reportingDate = resultSet.getDate("reportingDate");

                    reportList.add(new Report(reportId, userId, projectId, reportProgress, reportingDate));
                }
            }
        }
        return reportList;
    }
    public void updateReport(Report report) throws SQLException {
        String query = "UPDATE report SET reportProgress=?, reportingDate=? WHERE reportId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, report.getReportProgress());
            statement.setDate(2, new java.sql.Date(report.getReportingDate().getTime()));
            statement.setInt(3, report.getReportId());
            statement.executeUpdate();
        }
    }
    public void deleteReport(int reportId) throws SQLException {
        String query = "DELETE FROM report WHERE reportId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reportId);
            statement.executeUpdate();
        }
    }
    public List<Report> getAllReports() throws SQLException {
        List<Report> reportList = new ArrayList<>();
        String query = "SELECT * FROM report";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int reportId = resultSet.getInt("reportId");
                int userId = resultSet.getInt("userId");
                int projectId = resultSet.getInt("projectId");
                String reportProgress = resultSet.getString("reportProgress");
                Date reportingDate = resultSet.getDate("reportingDate");

                reportList.add(new Report(reportId, userId, projectId, reportProgress, reportingDate));
            }
        }
        return reportList;
    }
}
