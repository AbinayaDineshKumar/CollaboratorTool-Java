package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Model.*;
import Model.Class.*;
import View.UserView;

public class UserController {
    public static void registerUser(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("User registration");
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter User E-mail: ");
        String userMail = scanner.nextLine();
        System.out.print("Enter Password: ");
        String userPassword = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String userRole = scanner.nextLine();

        User newUser = new User(userId, userName, userMail, userPassword, userRole);

        UserDAOImpl.insertUser(connection,newUser);

        System.out.println("User registered successfully!");
    }

    public static void loginUser(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("User login");
        System.out.print("Enter User Name: ");
        String username = scanner.nextLine();
        System.out.print("Enter Your Password: ");
        String userPassword = scanner.nextLine();
        String query = "SELECT userRole FROM user WHERE username = ? AND userPassword = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, userPassword);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String userRole = resultSet.getString("userRole");
            System.out.println("Login successful!");
            if (userRole.equalsIgnoreCase("student")) {
                UserView.studentMenu(connection);
            } else if (userRole.equalsIgnoreCase("teacher")) {
                UserView.teacherMenu(connection);
            } else {
                System.out.println("Invalid user. Please try again.");
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}