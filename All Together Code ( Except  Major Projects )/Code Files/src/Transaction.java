import java.sql.*;

public class Transaction {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "haveaniceday";
        String debitQuery = "UPDATE accounts SET balance=balance-? WHERE account_number=?;";
        String creditQuery = "UPDATE accounts SET balance=balance+? WHERE account_number=?;";
        Connection con = null;

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

            PreparedStatement debitStatement=con.prepareStatement(debitQuery);
            PreparedStatement creditStatement=con.prepareStatement(creditQuery);
            debitStatement.setDouble(1,500.00);
            debitStatement.setString(2,"account123");
            creditStatement.setDouble(1,500.00);
            creditStatement.setString(2,"account4569");

            int rowsAffectedDebit= debitStatement.executeUpdate();
            int rowsAffectedCredit= creditStatement.executeUpdate();

            if(rowsAffectedDebit>0 & rowsAffectedCredit>0){
                con.commit();
                System.out.println("Transaction successful.");
            }else{
                con.rollback();
                System.out.println("Transaction failed.");
            }
            con.close();
            debitStatement.close();
            creditStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

