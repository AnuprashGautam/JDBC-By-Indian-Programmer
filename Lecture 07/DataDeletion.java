import java.sql.*;

public class DataDeletion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "haveaniceday";
        String query = "DELETE from employees WHERE id=3;";
        Connection con = null;
        Statement stmt = null;
        int rowsAffected = 0;

        // Loading Driver files.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver files loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Establishing connection and doing other works.
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully.");
            stmt = con.createStatement();
            rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Insert successful. " + rowsAffected + " row(s) affected.");
            } else {
                System.out.println("Insertion failed.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
