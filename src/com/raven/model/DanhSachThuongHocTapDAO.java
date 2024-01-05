package com.raven.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachThuongHocTapDAO {

    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    // Hàm này trả về danh sách các đối tượng DanhSachThuongHocTap với MS_KThg cụ thể
    public List<DanhSachThuongHocTap> getAwardDetails(int msKThg) throws SQLException {
        List<DanhSachThuongHocTap> awardDetails = new ArrayList<>();
        String sql = "SELECT * FROM ds_thuong_hoctap WHERE MS_KThg = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DanhSachThuongHocTap detail = new DanhSachThuongHocTap();
                    detail.setMsKThg(rs.getInt("MS_KThg"));
                    detail.setHoTen(rs.getString("Ho_ten"));
                    detail.setCccd(rs.getString("CCCD"));
                    detail.setMaHo(rs.getInt("Ma_Ho"));
                    detail.setGiaTriPhanQua(rs.getInt("Gia_tri_phan_qua"));
                    detail.setTrangThaiKhoanThuong(rs.getString("TrangThaiKhoanThuong"));
                    detail.setNgayThuong(rs.getDate("Ngay_thuong"));
                    awardDetails.add(detail);
                }
            }
        }
        return awardDetails;
    }
    public List<DanhSachThuongHocTap> getAllAwards() throws SQLException {
        List<DanhSachThuongHocTap> awards = new ArrayList<>();
        String sql = "SELECT * FROM ds_thuong_hoctap";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DanhSachThuongHocTap award = new DanhSachThuongHocTap();
                award.setMsKThg(rs.getInt("MS_KThg"));
                award.setHoTen(rs.getString("Ho_ten"));
                award.setCccd(rs.getString("CCCD"));
                award.setMaHo(rs.getInt("Ma_Ho"));
                award.setTruongHoc(rs.getString("Truong_hoc"));
                award.setThanhTich(rs.getString("Thanh_tich"));
                award.setMinhChung(rs.getString("Minh_chung"));
                award.setGiaTriPhanQua(rs.getInt("Gia_tri_phan_qua"));
                award.setTrangThaiKhoanThuong(rs.getString("Trang_thai_khoanthuong"));
                award.setNgayThuong(rs.getDate("Ngay_thuong"));
                awards.add(award);
            }
        }
        return awards;
    }

    // Phương thức chuyển đổi java.sql.Date sang java.util.Date
    private java.util.Date convertToJavaDate(ResultSet rs, String columnName) throws SQLException {
        java.sql.Date sqlDate = rs.getDate(columnName);
        return sqlDate != null ? new java.util.Date(sqlDate.getTime()) : null;
    }
}
