package com.raven.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeThuongLeTetDAO {

    private Connection getConnection() throws SQLException {
        // Assuming DatabaseUtil.getConnection() creates a connection to your database
        return DatabaseUtil.getConnection();
    }

    public List<ThongKeThuongLeTet> thongKeThuongLeTet(int ms_kthg) throws SQLException {
        List<ThongKeThuongLeTet> thongKeList = new ArrayList<>();

        String sql = "SELECT ds.Ma_Ho, nk.Ho_ten AS Ten_Chu_Ho, COUNT(ds.Ma_Ho) AS So_Luong_Phan_Qua "
                + "FROM ds_thuong_letet ds "
                + "JOIN ho_gia_dinh hg ON ds.Ma_Ho = hg.Ma_Ho "
                + "JOIN nhan_khau nk ON hg.CCCD_Chuho = nk.CCCD "
                + "WHERE ds.MS_KThg = ? AND ds.Trangthai_Phatthuong = 'Đã hoàn thành' "
                + "GROUP BY ds.Ma_Ho, nk.Ho_ten";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ms_kthg);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ThongKeThuongLeTet thongKe = new ThongKeThuongLeTet();
                    thongKe.setMaHo(rs.getInt("Ma_Ho"));
                    thongKe.setTenChuHo(rs.getString("Ten_Chu_Ho"));
                    thongKe.setSoLuongPhanQua(rs.getInt("So_Luong_Phan_Qua"));
                    thongKeList.add(thongKe);
                }
            }
        }
        return thongKeList;
    }
}

