import java.sql.*;
import java.util.Scanner;

public class DataInsertionWithPreparedStatement {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "haveaniceday";
        String query = "INSERT INTO employees(id,name,job_title,salary) VALUES (?,?,?,?);";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully.");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Scanner scanner=new Scanner(System.in);

            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established successfully.");

            System.out.println("Enter the id:");
            int id=scanner.nextInt();
            System.out.println("Enter the name:");
            String name=scanner.next();
            System.out.println("Enter the job title:");
            String jobtitle=scanner.next();
            System.out.println("Enter the salary:");
            double salary=scanner.nextDouble();

            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,jobtitle);
            pstmt.setDouble(4,salary);

            int rowsAffected=pstmt.executeUpdate();

            if(rowsAffected>0) System.out.println("Data Insertion successfull.");
            else System.out.println("Data Insertion failed.");

            scanner.close();
            pstmt.close();
            con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
