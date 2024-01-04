package com.raven.model;

import com.raven.model.QuanLyThuongHocTap;
import com.raven.model.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class QuanLyThuongHocTapDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public List<QuanLyThuongHocTap> getActiveAwards() throws SQLException {
        List<QuanLyThuongHocTap> activeAwards = new ArrayList<>();
        String sql = "SELECT MS_KThg, Ten_KThg, Thuong_hsg_dacbiet, Thuong_hstt, Thuong_khac, Ngaytao_KThg, Ngaykthuc_KThg, Tong_thuong, Ghi_chu FROM khoan_thuong_hoctap WHERE Trang_thai_khoanthuong='Đang xử lý'";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                QuanLyThuongHocTap award = new QuanLyThuongHocTap();
                award.setMsKThg(rs.getInt("MS_KThg"));
                award.setTenKThg(rs.getString("Ten_KThg"));
                int thuongHsgDacBiet = rs.getInt("Thuong_hsg_dacbiet");
                int thuongHstt = rs.getInt("Thuong_hstt");
                int thuongKhac = rs.getInt("Thuong_khac");
                java.sql.Date ngayTaoKThgSql = rs.getDate("Ngaytao_KThg");
                java.sql.Date ngayKetThucKThgSql = rs.getDate("Ngaykthuc_KThg");
                int tongThuong = rs.getInt("Tong_thuong");
                String ghiChu = rs.getString("Ghi_chu");

                // Convert java.sql.Date to java.util.Date
                Date ngayTaoKThg = new Date(ngayTaoKThgSql.getTime());
                Date ngayKetThucKThg = new Date(ngayKetThucKThgSql.getTime());
                activeAwards.add(award);
            }
        }
        return activeAwards;
    }
}