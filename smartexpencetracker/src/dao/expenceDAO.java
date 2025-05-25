package dao;

import db.dbconnection;
import model.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class expenceDAO {
    public static boolean addExpense(Expense expense) {
    try (Connection con = dbconnection.getConnection()) {
        if (con == null) {
            System.err.println("❌ Cannot add expense: DB connection failed.");
            return false;
        }

        String sql = "INSERT INTO expenses (user_id, category, amount, date) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, expense.getUserId());
        ps.setString(2, expense.getCategory());
        ps.setDouble(3, expense.getAmount());
        ps.setString(4, expense.getDate());

        int rowsAffected = ps.executeUpdate();
        System.out.println("✅ Expense added. Rows affected: " + rowsAffected);
        return true;
    } catch (Exception e) {
        System.err.println("❌ Failed to add expense: " + e.getMessage());
        return false;
    }
}

}
