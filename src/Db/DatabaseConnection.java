package Db;
import java.sql.*;

public class DatabaseConnection {
    public static Connection con=null;
    public Connection getConnectivity() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/console","root","adAD@2364");
        return con;
    }
    
}
