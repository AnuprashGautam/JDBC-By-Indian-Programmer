import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class ImageRetrievalFromDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "haveaniceday";
        String query = "SELECT image_data FROM image_table WHERE image_id=?;";
        String folder_path="C:\\Users\\anupr\\Downloads\\Images\\";
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

            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1,1);

            ResultSet rs=pstmt.executeQuery();

            if(rs.next()){
                byte[] imagedata=rs.getBytes("image_data");
                String image_path=folder_path+"extractedImage.jpg";
                OutputStream outputStream=new FileOutputStream(image_path);
                outputStream.write(imagedata);
                System.out.println("Image retrieval successfull.");
            }else{
                System.out.println("Image retrieval failed.");
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
