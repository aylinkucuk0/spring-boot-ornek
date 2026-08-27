package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/runner_track";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {

        String selectSQL = "SELECT * FROM runs";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL);
             ResultSet rs = pstmt.executeQuery()) { // Sorguyu çalıştır ve sonucu rs'ye at

            System.out.println("--- KOŞU KAYITLARI ---");


            while (rs.next()) {
                Long id = rs.getLong("id");
                String date = rs.getString("date");
                double distance = rs.getDouble("distance");
                int duration = rs.getInt("duration");

                System.out.println("Kayıt No: " + id + " | Tarih: " + date + " | Mesafe: " + distance + " km | Süre: " + duration + " dk");
            }
            System.out.println("----------------------");

        } catch (SQLException e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }
}