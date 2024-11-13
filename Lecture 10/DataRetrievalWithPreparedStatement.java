import java.sql.*;

public class DataRetrievalWithPreparedStatement {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "haveaniceday";
        String query = "SELECT * FROM employees WHERE name=? AND job_title=?;";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully.");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully.");
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1,"Hemant");
            pstmt.setString(2,"Full Stack Developer");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String jobtitle=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("ID: "+jobtitle);
                System.out.println("ID: "+salary);
            }
            pstmt.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
