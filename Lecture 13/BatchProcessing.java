import java.sql.*;
import java.util.Scanner;

public class BatchProcessing  {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "haveaniceday";
        String query = "Insert into employees(id, name, job_title, salary) values (?,?,?,?);";
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner scanner=new Scanner(System.in);

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
            con.setAutoCommit(false);
            pstmt= con.prepareStatement(query);

            while(true){
                System.out.print("Enter the id:");
                int id=scanner.nextInt();
                System.out.print("Enter the name:");
                String name=scanner.next();
                System.out.print("Enter the job title:");
                String jobTitle=scanner.next();
                System.out.print("Enter the Salary:");
                int salary=scanner.nextInt();

                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.setString(3,jobTitle);
                pstmt.setInt(4,salary);

                pstmt.addBatch();

                System.out.println("Do you want to enter more data (Y/N):");
                String decision= scanner.next();

                if(decision.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] batchResult=pstmt.executeBatch();
            con.commit();
            System.out.println("Batch executed successfully.");

            con.close();
            pstmt.close();
            scanner.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
