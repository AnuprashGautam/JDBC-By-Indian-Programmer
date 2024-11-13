import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class ImageInsertionInDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "haveaniceday";
        String query = "INSERT INTO image_table(image_data) VALUES(?);";
        String image_path="C:\\Users\\anupr\\Downloads\\Photo.avif";
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

            FileInputStream fis=new FileInputStream(image_path);
            byte[] imagedata=new byte[fis.available()];
            fis.read(imagedata);

            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setBytes(1,imagedata);

            rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Image inserted successfully.");
            } else {
                System.out.println("Image insertion failed.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
