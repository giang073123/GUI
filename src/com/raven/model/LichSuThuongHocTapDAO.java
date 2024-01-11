package com.raven.model;

import java.sql.*;
import java.util.Vector;
import com.raven.model.LichSuThuongHocTap;
import java.util.List;
import java.util.ArrayList;
public class LichSuThuongHocTapDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public List<LichSuThuongHocTap> getAllEndedAwards() throws SQLException {
        List<LichSuThuongHocTap> endedAwards = new ArrayList<>();
        String sql = "SELECT * FROM khoan_thuong_hoctap WHERE Trang_thai_khoanthuong='Đã Kết Thúc'";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                LichSuThuongHocTap award = new LichSuThuongHocTap();
                award.setMsKThg(rs.getInt("MS_KThg"));
                award.setTenKThg(rs.getString("Ten_KThg"));
                award.setThuongHsgDacBiet(rs.getInt("Thuong_hsg_dacbiet"));
                award.setThuongHstt(rs.getInt("Thuong_hstt"));
                award.setThuongKhac(rs.getInt("Thuong_khac"));
                award.setNgayTaoKThg(rs.getDate("Ngaytao_KThg"));
                award.setNgayKetThucKThg(rs.getDate("Ngaykthuc_KThg"));
                award.setTrangThai(rs.getString("Trang_thai_khoanthuong"));
                award.setTongThuong(rs.getInt("Tong_thuong"));
                award.setGhiChu(rs.getString("Ghi_chu"));
                endedAwards.add(award);
            }
        }
        return endedAwards;
    }

}
