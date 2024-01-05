package com.raven.model;

import java.sql.*;
import java.util.ArrayList; // Add this import
import java.util.List;

public class QuanLyThuongHocTapDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public List<QuanLyThuongHocTap> getActiveAwards() throws SQLException {
        List<QuanLyThuongHocTap> allAwards = new ArrayList<>();
        String sql = "SELECT MS_KThg, Ten_KThg, Thuong_hsg_dacbiet, Thuong_hstt, Thuong_khac, Ngaytao_KThg, Ngaykthuc_KThg, Trang_thai_khoanthuong, Tong_thuong, Ghi_chu FROM khoan_thuong_hoctap where Trang_thai_khoanthuong='Đang xử lý'";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                QuanLyThuongHocTap award = new QuanLyThuongHocTap();
                award.setMsKThg(rs.getInt("MS_KThg"));
                award.setTenKThg(rs.getString("Ten_KThg"));
                award.setThuongHsgDacBiet(rs.getInt("Thuong_hsg_dacbiet"));
                award.setThuongHstt(rs.getInt("Thuong_hstt"));
                award.setThuongKhac(rs.getInt("Thuong_khac"));
                award.setNgayTaoKThg(rs.getDate("Ngaytao_KThg"));
                award.setNgayKetThucKThg(rs.getDate("Ngaykthuc_KThg"));
                award.setTrangThai(rs.getString("Trang_thai_khoanthuong")); // Make sure the column name matches the one in the database
                award.setTongThuong(rs.getInt("Tong_thuong"));
                award.setGhiChu(rs.getString("Ghi_chu"));

                allAwards.add(award);
            }
        }
        return allAwards;
    }
    public QuanLyThuongHocTap getKhoanThuongById(int msKThg) throws SQLException {
        QuanLyThuongHocTap award = null;
        String sql = "SELECT * FROM khoan_thuong_hoctap WHERE MS_KThg = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    award = new QuanLyThuongHocTap();
                    award.setMsKThg(rs.getInt("MS_KThg"));
                    award.setTenKThg(rs.getString("Ten_KThg"));
                    // Set các trường khác cho đối tượng award từ ResultSet
                    // ...
                }
            }
        }
        return award;
    }
    public void deleteKhoanThuong(int msKThg) throws SQLException {
        String sql = "DELETE FROM khoan_thuong_hoctap WHERE MS_KThg = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);

            pstmt.executeUpdate();
        }
    }
    public void addKhoanThuong(String tenKThg, int thuongHsgDacBiet, int thuongHstt, int thuongKhac, String ghiChu) throws SQLException {
        String sql = "INSERT INTO khoan_thuong_hoctap (Ten_KThg, Thuong_hsg_dacbiet, Thuong_hstt, Thuong_khac, Ghi_chu) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tenKThg);
            pstmt.setInt(2, thuongHsgDacBiet);
            pstmt.setInt(3, thuongHstt);
            pstmt.setInt(4, thuongKhac);
            pstmt.setString(5, ghiChu);

            pstmt.executeUpdate();
        }
    }
}
