package com.raven.model;

import java.sql.*;
import java.util.Vector;

public class DanhSachThuongTetDAO {

    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public Vector<Vector<Object>> layTatCaDanhSachThuongTet() throws SQLException {
        Vector<Vector<Object>> danhSachThuongTet = new Vector<>();
        String sql = "SELECT Ho_ten, CCCD, Ma_Ho, Ngay_sinh, Gia_tri_phan_qua, Trangthai_Phatthuong, Ngay_thuong FROM ds_thuong_letet";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("Ho_ten"));
                row.add(rs.getString("CCCD"));
                row.add(rs.getInt("Ma_Ho"));
                row.add(rs.getDate("Ngay_sinh"));
                row.add(rs.getInt("Gia_tri_phan_qua"));
                row.add(rs.getString("Trangthai_Phatthuong"));
                row.add(rs.getDate("Ngay_thuong"));
                danhSachThuongTet.add(row);
            }
        }
        return danhSachThuongTet;
    }

    public Vector<Vector<Object>> layDanhSachThuongTetTheoMaKhoanThuong(int msKThg) throws SQLException {
        Vector<Vector<Object>> danhSachThuongTet = new Vector<>();
        String sql = "SELECT * FROM ds_thuong_letet WHERE MS_KThg = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getString("Ho_ten"));
                    row.add(rs.getString("CCCD"));
                    row.add(rs.getInt("Ma_Ho"));
                    row.add(rs.getDate("Ngay_sinh"));
                    row.add(rs.getInt("Gia_tri_phan_qua"));
                    row.add(rs.getString("Trangthai_Phatthuong"));
                    row.add(rs.getDate("Ngay_thuong"));
                    danhSachThuongTet.add(row);
                }
            }
        }
        return danhSachThuongTet;
    }

    // Assuming msKThg is a class member variable that holds the value from quanlytet
    public Vector<Vector<Object>> searchDanhSachThuongTet(String hoTen, String cccd, String maHo, int msKThg) throws SQLException {
        Vector<Vector<Object>> searchResults = new Vector<>();
        String sql = "SELECT * FROM ds_thuong_letet WHERE MS_KThg = ? AND Ho_ten LIKE ? AND CCCD LIKE ? AND Ma_Ho LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, msKThg);
            pstmt.setString(2, "%" + hoTen + "%");
            pstmt.setString(3, "%" + cccd + "%");
            pstmt.setString(4, "%" + maHo + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getString("Ho_ten"));
                    row.add(rs.getString("CCCD"));
                    row.add(rs.getInt("Ma_Ho"));
                    row.add(rs.getDate("Ngay_sinh"));
                    row.add(rs.getInt("Gia_tri_phan_qua"));
                    row.add(rs.getString("Trangthai_Phatthuong"));
                    row.add(rs.getDate("Ngay_thuong"));
                    searchResults.add(row);
                }
            }
        }
        return searchResults;
    }




    public void themDanhSachThuongTet(DanhSachThuongTet danhSach) throws SQLException {
        String sql = "INSERT INTO ds_thuong_letet (MS_KThg, Ho_ten, CCCD, Ma_Ho, Ngay_sinh, Gia_tri_phan_qua, Trangthai_Phatthuong, Ngay_thuong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, danhSach.getMsKThg());
            pstmt.setString(2, danhSach.getHoTen());
            pstmt.setString(3, danhSach.getCCCD());
            pstmt.setInt(4, danhSach.getMaHo());
            pstmt.setDate(5, new java.sql.Date(danhSach.getNgaySinh().getTime()));
            pstmt.setInt(6, danhSach.getGiaTriPhanQua());
            pstmt.setString(7, danhSach.getTrangThaiPhatThuong());
            pstmt.setDate(8, new java.sql.Date(danhSach.getNgayThuong().getTime()));

            pstmt.executeUpdate();
        }
    }

    public void capNhatDanhSachThuongTet(DanhSachThuongTet danhSach) throws SQLException {
        String sql = "UPDATE ds_thuong_letet SET Ho_ten=?, CCCD=?, Ma_Ho=?, Ngay_sinh=?, Gia_tri_phan_qua=?, Trangthai_Phatthuong=?, Ngay_thuong=? WHERE CCCD=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, danhSach.getHoTen());
            pstmt.setString(2, danhSach.getCCCD());
            pstmt.setInt(3, danhSach.getMaHo());
            pstmt.setDate(4, new java.sql.Date(danhSach.getNgaySinh().getTime()));
            pstmt.setInt(5, danhSach.getGiaTriPhanQua());
            pstmt.setString(6, danhSach.getTrangThaiPhatThuong());
            pstmt.setDate(7, new java.sql.Date(danhSach.getNgayThuong().getTime()));
            pstmt.setString(8, danhSach.getCCCD());

            pstmt.executeUpdate();
        }
    }

    public void xoaDanhSachThuongTet(String cccd) throws SQLException {
        String sql = "DELETE FROM ds_thuong_letet WHERE CCCD=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cccd);
            pstmt.executeUpdate();
        }
    }
}
