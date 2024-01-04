package com.raven.model;

import java.sql.*;
import java.util.Vector;
import com.raven.model.QuanLyThuongTetdata;
import com.raven.model.QuanLyThuongTetDAO;

public class QuanLyThuongTetDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public Vector<Vector<Object>> layTatCaKhoanThuong() throws SQLException {
        Vector<Vector<Object>> khoanThuongs = new Vector<>();
        // Adjust the SQL query to check for NULL in Trang_thai_khoanthuong
        String sql = "SELECT * FROM khoan_thuong_letet WHERE Trang_thai_khoanthuong = 'Đang Diễn Ra'";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("MS_KThg"));
                row.add(rs.getString("Ten_KThg"));
                row.add(rs.getInt("Gia_tri_phan_qua"));
                row.add(rs.getDate("Ngaytao_KThg"));
                row.add(rs.getDate("Ngaykthuc_KThg"));
                row.add(rs.getInt("Tong_thuong"));
                row.add(rs.getString("Ghi_chu"));
                khoanThuongs.add(row);
            }
        }
        return khoanThuongs;
    }

    public Vector<Vector<Object>> layLichSuKhoanThuong() throws SQLException {
        return getBonusesByStatusNotNull();
    }
    public Vector<Vector<Object>> getBonusesWithStatusNotNull() throws SQLException {
        return getBonusesByStatusNotNull();
    }
    public Vector<Vector<Object>> layDanhSachThuongTet(int msKThg) throws SQLException {
        Vector<Vector<Object>> danhSachThuongTet = new Vector<>();
        String sql = "SELECT * FROM khoan_thuong_letet WHERE MS_KThg = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("MS_KThg"));
                    row.add(rs.getString("Ten_KThg"));
                    row.add(rs.getInt("Gia_tri_phan_qua"));
                    row.add(rs.getDate("Ngaytao_KThg"));
                    row.add(rs.getDate("Ngaykthuc_KThg"));
                    row.add(rs.getInt("Tong_thuong"));
                    row.add(rs.getString("Ghi_chu"));
                    danhSachThuongTet.add(row);
                }
            }
        }
        return danhSachThuongTet;
    }

    public Vector<Vector<Object>> timKiemDanhSachThuongTetTheoMaHo(int maHo) throws SQLException {
        Vector<Vector<Object>> results = new Vector<>();
        String sql = "SELECT * FROM khoan_thuong_letet WHERE Ma_Ho = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maHo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("MS_KThg"));
                    row.add(rs.getString("Ten_KThg"));
                    row.add(rs.getInt("Gia_tri_phan_qua"));
                    row.add(rs.getDate("Ngaytao_KThg"));
                    row.add(rs.getDate("Ngaykthuc_KThg"));
                    row.add(rs.getInt("Tong_thuong"));
                    row.add(rs.getString("Ghi_chu"));
                    results.add(row);
                }
            }
        }
        return results;
    }
    public Vector<Vector<Object>> searchDanhSachThuongTet(String hoTen, String cccd, String maHo) throws SQLException {
        Vector<Vector<Object>> searchResults = new Vector<>();
        String sql = "SELECT * FROM ds_thuong_letet WHERE HoTen LIKE ? AND CCCD LIKE ? AND MaHo LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + hoTen + "%");
            pstmt.setString(2, "%" + cccd + "%");
            pstmt.setString(3, "%" + maHo + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getString("HoTen"));
                    row.add(rs.getString("CCCD"));
                    row.add(rs.getInt("MaHo"));
                    row.add(rs.getDate("NgaySinh"));
                    row.add(rs.getInt("GiaTriPhanQua"));
                    row.add(rs.getString("TrangThaiPhatThuong"));
                    row.add(rs.getDate("NgayThuong"));
                    searchResults.add(row);
                }
            }
        }
        return searchResults;
    }


    public Vector<Vector<Object>> timKiemDanhSachThuongTet(String tuKhoa) throws SQLException {
        Vector<Vector<Object>> results = new Vector<>();
        String sql = "SELECT * FROM khoan_thuong_letet WHERE Ten_KThg LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + tuKhoa + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("MS_KThg"));
                    row.add(rs.getString("Ten_KThg"));
                    row.add(rs.getInt("Gia_tri_phan_qua"));
                    row.add(rs.getDate("Ngaytao_KThg"));
                    row.add(rs.getDate("Ngaykthuc_KThg"));
                    row.add(rs.getInt("Tong_thuong"));
                    row.add(rs.getString("Ghi_chu"));
                    results.add(row);
                }
            }
        }
        return results;
    }


    public void themKhoanThuong(QuanLyThuongTetdata khoanThuong) throws SQLException {
            String sql = "INSERT INTO khoan_thuong_letet (Ten_KThg, Gia_tri_phan_qua, Ngaytao_KThg, Ngaykthuc_KThg, Trang_thai_khoanthuong, Tong_thuong, Ghi_chu) VALUES (?, ?, ?, ?, 'Đang Diễn Ra', ?, ?)";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, khoanThuong.getTenKhoanThuong());
                pstmt.setInt(2, khoanThuong.getGiaTriPhanQua());
                pstmt.setDate(3, khoanThuong.getNgayTao());
                pstmt.setDate(4, khoanThuong.getNgayKetThuc());
                pstmt.setInt(5, khoanThuong.getTongThuong());
                pstmt.setString(6, khoanThuong.getGhiChu());
                pstmt.executeUpdate();
            }
        }

    public void capNhatKhoanThuong(QuanLyThuongTetdata khoanThuong) throws SQLException {
            String sql = "UPDATE khoan_thuong_letet SET Ten_KThg=?, Gia_tri_phan_qua=?, Ngaytao_KThg=?, Ngaykthuc_KThg=?, Trang_thai_khoanthuong=?, Tong_thuong=?, Ghi_chu=? WHERE MS_KThg=?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, khoanThuong.getTenKhoanThuong());
                pstmt.setInt(2, khoanThuong.getGiaTriPhanQua());
                pstmt.setDate(3, khoanThuong.getNgayTao());
                pstmt.setDate(4, khoanThuong.getNgayKetThuc());
                pstmt.setString(5, khoanThuong.getTrangThai());
                pstmt.setInt(6, khoanThuong.getTongThuong());
                pstmt.setString(7, khoanThuong.getGhiChu());
                pstmt.setInt(8, khoanThuong.getMsKThg());
                pstmt.executeUpdate();
            }
        }
    public void ketThucKhoanThuong(int msKThg) throws SQLException {
        String sql = "UPDATE khoan_thuong_letet SET Trang_thai_khoanthuong='Đã Kết Thúc' WHERE MS_KThg=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Kết thúc khoản thưởng thành công!");
            } else {
                System.out.println("Không tìm thấy khoản thưởng có mã số " + msKThg);
            }
        }
    }

        public void xoaKhoanThuong(int msKThg) throws SQLException {
            String sql = "DELETE FROM khoan_thuong_letet WHERE MS_KThg=?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, msKThg);
                pstmt.executeUpdate();
            }
        }

    public Vector<Vector<Object>> layKhoanThuongDaKetThuc() throws SQLException {
        Vector<Vector<Object>> danhSach = new Vector<>();
        String sql = "SELECT * FROM khoan_thuong_letet WHERE Trang_thai_khoanthuong='Đã Kết Thúc'";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("MS_KThg"));
                row.add(rs.getString("Ten_KThg"));
                row.add(rs.getInt("Gia_tri_phan_qua"));
                row.add(rs.getDate("Ngaytao_KThg"));
                row.add(rs.getDate("Ngaykthuc_KThg"));
                row.add(rs.getInt("Tong_thuong"));
                row.add(rs.getString("Ghi_chu"));
                danhSach.add(row);
            }
        }
        return danhSach;
    }


    private Vector<Vector<Object>> getBonusesByStatus(String status) throws SQLException {
            Vector<Vector<Object>> bonuses = new Vector<>();
            String sql = "SELECT * FROM khoan_thuong_letet WHERE Trang_thai_khoanthuong = ?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, status);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Vector<Object> row = new Vector<>();
                        row.add(rs.getInt("MS_KThg"));
                        row.add(rs.getString("Ten_KThg"));
                        row.add(rs.getInt("Gia_tri_phan_qua"));
                        row.add(rs.getDate("Ngaytao_KThg"));
                        row.add(rs.getDate("Ngaykthuc_KThg"));
                        row.add(rs.getInt("Tong_thuong"));
                        row.add(rs.getString("Ghi_chu"));
                        bonuses.add(row);
                    }
                }
            }
            return bonuses;
        }
    private Vector<Vector<Object>> getBonusesByStatusNotNull() throws SQLException  {
        Vector<Vector<Object>> bonuses = new Vector<>();
        String sql = "SELECT * FROM khoan_thuong_letet WHERE Trang_thai_khoanthuong IS NOT NULL";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("MS_KThg"));
                row.add(rs.getString("Ten_KThg"));
                row.add(rs.getInt("Gia_tri_phan_qua"));
                row.add(rs.getDate("Ngaytao_KThg"));
                row.add(rs.getDate("Ngaykthuc_KThg"));
                row.add(rs.getInt("Tong_thuong"));
                row.add(rs.getString("Ghi_chu"));
                bonuses.add(row);
            }
        }
        return bonuses;
    }
    }


