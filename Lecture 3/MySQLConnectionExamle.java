import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionExamle
{
    public static void main(String[] args)
    {
        // Database url
        String url="jdbc:mysql://localhost:3306/mydatabase";
        
        //Database Credentials
        String username="your_username";
        String password="your_password";
        
        // Establish the connection
        try (Connection connection = DriverManager.getConnection(url,username,password))
        {
            System.out.println("Connected to the database.");
            
            // Perform database operations here.
        }
        catch (SQLException e)
        {
            System.err.println("Connection failed: "+e.getMessage());
        }
    }
}