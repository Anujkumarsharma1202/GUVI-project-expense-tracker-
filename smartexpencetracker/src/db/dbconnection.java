package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    private static final String USER = "root";
    private static final String PASSWORD = "Anuj@5649";

   public static Connection getConnection() {
    try {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("✅ Connected to database.");
        return con;
    } catch (Exception e) {
        System.err.println("❌ Database not connected: " + e.getMessage());
        return null;
    }
}

}
