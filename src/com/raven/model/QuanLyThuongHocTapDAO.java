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
        String sql = "SELECT MS_KThg, Ten_KThg, Thuong_hsg_dacbiet, Thuong_hstt, Thuong_khac, Ngaytao_KThg, Ngaykthuc_KThg, Trang_thai_khoanthuong, Tong_thuong, Ghi_chu FROM khoan_thuong_hoctap";

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
}
