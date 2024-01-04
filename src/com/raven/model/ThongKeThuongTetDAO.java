package com.raven.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ThongKeThuongTetDAO {

    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public Vector<Vector<Object>> thongKeThuongTet(String maHo) throws SQLException {
        Vector<Vector<Object>> thongKe = new Vector<>();
        String sql = "SELECT Ma_Ho, Ho_ten, SUM(Gia_tri_phan_qua) AS TongPhanQua FROM ds_thuong_letet WHERE Ma_Ho = ? GROUP BY Ma_Ho";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maHo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("Ma_Ho"));
                    row.add(rs.getString("Ho_ten"));
                    row.add(rs.getInt("TongPhanQua"));
                    thongKe.add(row);
                }
            }
        }
        return thongKe;
    }
}
