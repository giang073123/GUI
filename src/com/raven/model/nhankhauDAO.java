package com.raven.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NhanKhauDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }
    public Map<String, Map<String, Integer>> getStatisticsByAgeAndGender() throws SQLException {
        // SQL query to get age groups and gender count
        String sql = "SELECT TIMESTAMPDIFF(YEAR, Ngay_sinh, CURDATE()) AS Age, Gioi_tinh, COUNT(*) AS Count " +
                "FROM nhan_khau " +
                "GROUP BY Age, Gioi_tinh";

        // A map to hold the statistics
        Map<String, Map<String, Integer>> stats = new HashMap<>();
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int age = rs.getInt("Age");
                String gender = rs.getString("Gioi_tinh").trim();
                int count = rs.getInt("Count");
                String ageGroup = getAgeGroup(age);

                // Initialize maps for each gender within the age group with zero count
                stats.putIfAbsent(ageGroup, new HashMap<>());
                Map<String, Integer> genderMap = stats.get(ageGroup);
                genderMap.putIfAbsent("Nam", 0);
                genderMap.putIfAbsent("Nữ", 0);

                // Update the count for the current gender
                genderMap.put(gender, genderMap.get(gender) + count);
            }
        }
        return stats;
    }



    private String getAgeGroup(int age) {
        if (age <= 12) return "0-12";
        else if (age <= 17) return "13-17";
        else if (age <= 24) return "18-24";
        else if (age <= 34) return "25-34";
        else if (age <= 44) return "35-44";
        else if (age <= 54) return "45-54";
        else if (age <= 64) return "55-64";
        else return "65+";
    }
    public void addTamTru(String cccd, String sdt, String diachiThuongtru, int soNha, String duong, Date ttTuNgay, Date ttDenNgay) throws SQLException {
        // Regular expression to match exactly 5 digits
        String cccdPattern = "^\\d{5}$";

        // Check if cccd matches the pattern
        if (!cccd.matches(cccdPattern)) {
            throw new IllegalArgumentException("CCCD must be exactly 5 digits.");
        }

        String sql = "INSERT INTO ds_tam_tru (CCCD, Ma_Ho, Ho_Ten, SDT, Diachi_thuongtru, So_nha, Duong_, Tt_tu_ngay, Tt_den_ngay) " +
                "SELECT ?, nk.Ma_Ho, nk.Ho_Ten, ?, ?, ?, ?, ?, ? FROM nhan_khau nk WHERE nk.CCCD = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cccd);
            statement.setString(2, sdt);
            statement.setString(3, diachiThuongtru);
            statement.setInt(4, soNha);
            statement.setString(5, duong);
            statement.setDate(6, new java.sql.Date(ttTuNgay.getTime()));
            statement.setDate(7, new java.sql.Date(ttDenNgay.getTime()));
            statement.setString(8, cccd); // Assuming CCCD is unique in nhan_khau

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new temporary residency was inserted successfully!");
            }
        } catch (SQLException e) {
            // Handle exceptions as needed
            throw e;
        }
    }

    public List<NhanKhau> getNhanKhauForThuongHocTap() throws SQLException {
        List<NhanKhau> listNhanKhau = new ArrayList<>();
        String sql = "SELECT * FROM nhankhau WHERE YEAR(CURDATE()) - YEAR(ngay_sinh) BETWEEN 6 AND 18";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setMaHo(rs.getInt("ma_ho"));
                nhanKhau.setHoTen(rs.getString("ho_ten"));
                nhanKhau.setNgaySinh(rs.getDate("ngay_sinh"));
                // Set các trường thông tin khác của nhân khẩu từ ResultSet
                listNhanKhau.add(nhanKhau);
            }
        }
        return listNhanKhau;
    }

    // Phương thức khác để thêm, cập nhật, xóa nhân khẩu...
}