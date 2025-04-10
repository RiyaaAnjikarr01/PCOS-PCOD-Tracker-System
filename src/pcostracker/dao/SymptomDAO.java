package pcostracker.dao;

import pcostracker.model.SymptomEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pcostracker.db.DBConnection;

public class SymptomDAO {

    // Get symptoms from database for a user
    public static List<SymptomEntry> getSymptomsForUser(String username) {
    List<SymptomEntry> list = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM symptoms WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            SymptomEntry entry = new SymptomEntry();
            entry.setUsername(rs.getString("username"));
            entry.setSymptom(rs.getString("symptom"));
            entry.setSeverity(rs.getInt("severity"));
            entry.setNotes(rs.getString("notes"));
            list.add(entry);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"DB Error:"+e.getMessage()); 
        e.printStackTrace();
    }
    return list;
}

    public static boolean saveSymptom(SymptomEntry s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
