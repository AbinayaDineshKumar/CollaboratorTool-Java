package Model;
import Model.Class.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl {
    private static Connection connection;

    public UserDAOImpl(Connection connection) {
        UserDAOImpl.connection = connection;
    }
    public static void insertUser(Connection connection, User user) throws SQLException {        
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO user (userId, username, userMail, userPassword, userRole) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserMail());
            statement.setString(4, user.getUserPassword());
            statement.setString(5, user.getUserRole());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    public User getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM user WHERE userId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("userId"),
                            resultSet.getString("userName"),
                            resultSet.getString("userMail"),
                            resultSet.getString("userPassword"),
                            resultSet.getString("userRole")
                    );
                } else {
                    return null;
                }
            }
        }
    }
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE user SET userName=?, userMail=?, userPassword=?, userRole=? WHERE userId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserMail());
            statement.setString(3, user.getUserPassword());
            statement.setString(4, user.getUserRole());
            statement.setInt(5, user.getUserId());
            statement.executeUpdate();
        }
    }
    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM user WHERE userId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userName = resultSet.getString("userName");
                String userMail = resultSet.getString("userMail");
                String userPassword = resultSet.getString("userPassword");
                String userRole = resultSet.getString("userRole");

                userList.add(new User(userId, userName, userMail, userPassword, userRole));
            }
        }
        return userList;
    }
}
