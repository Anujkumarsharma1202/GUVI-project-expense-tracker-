package dao;

import db.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDAO {
    public static boolean validateUser(String username, String password) {
        try (Connection con = dbconnection.getConnection()) {
            if (con == null) return false;

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getUserId(String username) {
        try (Connection con = dbconnection.getConnection()) {
            if (con == null) return -1;

            String sql = "SELECT id FROM users WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
