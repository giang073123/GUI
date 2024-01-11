package com.raven.model;

import java.sql.*;
import java.util.ArrayList; // Add this import
import java.util.List;
import java.sql.Connection;

public class QuanLyThuongHocTapDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }
    public List<QuanLyThuongHocTap> getActiveAwards() throws SQLException {
        List<QuanLyThuongHocTap> allAwards = new ArrayList<>();
        String sql = "SELECT MS_KThg, Ten_KThg, Thuong_hsg_dacbiet, Thuong_hstt, Thuong_khac, Ngaytao_KThg, Ngaykthuc_KThg, Trang_thai_khoanthuong, Tong_thuong, Ghi_chu FROM khoan_thuong_hoctap where Trang_thai_khoanthuong='Hoạt động'";

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

    public void addKhoanThuongHocTap(QuanLyThuongHocTap newKhoanThuong) throws SQLException {
        Connection conn = null; // Declare connection object outside of the try block
        try {
            conn = getConnection(); // Get the connection
            conn.setAutoCommit(false); // Start transaction

            // Insert a new entry into khoan_thuong_hoctap with the status 'Hoạt động'
            String insertKhoanThuongSql = "INSERT INTO khoan_thuong_hoctap (Ten_KThg, Thuong_hsg_dacbiet, Thuong_hstt, Thuong_khac, Trang_thai_khoanthuong, Ghi_chu, Ngaytao_KThg) VALUES (?, ?, ?, ?, 'Hoạt động', ?, CURDATE())";
            int msKThg = 0;
            try (PreparedStatement pstmt = conn.prepareStatement(insertKhoanThuongSql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, newKhoanThuong.getTenKThg());
                pstmt.setInt(2, newKhoanThuong.getThuongHsgDacBiet());
                pstmt.setInt(3, newKhoanThuong.getThuongHstt());
                pstmt.setInt(4, newKhoanThuong.getThuongKhac());
                pstmt.setString(5, newKhoanThuong.getGhiChu());
                pstmt.executeUpdate();

                // Retrieve the auto-generated MS_KThg
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        msKThg = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Creating award failed, no ID obtained.");
                    }
                }
            }

            // Select eligible students with 'Thường trú' status from nhan_khau
            String selectEligibleStudentsSql = "SELECT CCCD, Ma_Ho, Ho_ten FROM nhan_khau WHERE YEAR(CURDATE()) - YEAR(Ngay_sinh) BETWEEN 6 AND 18 AND Trang_thai_nhan_khau = 'Thường trú'";
            try (PreparedStatement pstmt = conn.prepareStatement(selectEligibleStudentsSql);
                 ResultSet rs = pstmt.executeQuery()) {
                // Insert corresponding entries into ds_thuong_hoctap for each eligible student
                String insertDsThuongSql = "INSERT INTO ds_thuong_hoctap (MS_KThg, Ho_ten, CCCD, Ma_Ho, Trangthai_Phatthuong) VALUES (?, ?, ?, ?, 'Chưa hoàn thành')";
                try (PreparedStatement pstmtDsThuong = conn.prepareStatement(insertDsThuongSql)) {
                    while (rs.next()) {
                        pstmtDsThuong.setInt(1, msKThg);
                        pstmtDsThuong.setString(2, rs.getString("Ho_ten"));
                        pstmtDsThuong.setString(3, rs.getString("CCCD"));
                        pstmtDsThuong.setInt(4, rs.getInt("Ma_Ho"));
                        pstmtDsThuong.executeUpdate();
                    }
                }
            }

            // Commit the transaction
            conn.commit();
        } catch (SQLException ex) {
            // In case of an exception, roll back the transaction
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            ex.printStackTrace();
            throw ex;
        } finally {
            // Finally, close the connection if it was opened
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
    public List<QuanLyThuongHocTap> searchAwardsByDate(java.sql.Date startDate, java.sql.Date endDate) throws SQLException  {
        List<QuanLyThuongHocTap> awards = new ArrayList<>();
        String sql = "SELECT * FROM khoan_thuong_hoctap WHERE " +
                "Ngaytao_KThg <= ? AND Ngaykthuc_KThg >= ? AND " +
                "Trang_thai_khoanthuong = 'Kết thúc'";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, new java.sql.Date(endDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(startDate.getTime()));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    QuanLyThuongHocTap award = new QuanLyThuongHocTap();
                    award.setMsKThg(resultSet.getInt("MS_KThg"));
                    award.setTenKThg(resultSet.getString("Ten_KThg"));
                    award.setThuongHsgDacBiet(resultSet.getInt("Thuong_hsg_dacbiet"));
                    award.setThuongHstt(resultSet.getInt("Thuong_hstt"));
                    award.setThuongKhac(resultSet.getInt("Thuong_khac"));
                    award.setNgayTaoKThg(resultSet.getDate("Ngaytao_KThg"));
                    award.setNgayKetThucKThg(resultSet.getDate("Ngaykthuc_KThg"));
                    award.setTrangThai(resultSet.getString("Trang_thai_khoanthuong"));
                    award.setTongThuong(resultSet.getInt("Tong_thuong"));
                    award.setGhiChu(resultSet.getString("Ghi_chu"));
                    awards.add(award);
                }
            }
        }
        return awards;
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
                    award.setThuongHsgDacBiet(rs.getInt("Thuong_hsg_dacbiet"));
                    award.setThuongHstt(rs.getInt("Thuong_hstt"));
                    award.setThuongKhac(rs.getInt("Thuong_khac"));
                    award.setNgayTaoKThg(rs.getDate("Ngaytao_KThg"));
                    award.setNgayKetThucKThg(rs.getDate("Ngaykthuc_KThg"));
                    award.setTrangThai(rs.getString("Trang_thai_khoanthuong")); // Make sure the column name matches the one in the database
                    award.setTongThuong(rs.getInt("Tong_thuong"));
                    award.setGhiChu(rs.getString("Ghi_chu"));

                }
            }
        }
        return award;
    }
    public QuanLyThuongHocTap getQuanLyThuongHocTap(int msKThg) throws SQLException {
        QuanLyThuongHocTap qltht = null;
        String sql = "SELECT * FROM khoan_thuong_hoctap WHERE MS_KThg = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    qltht = new QuanLyThuongHocTap();
                    qltht.setMsKThg(rs.getInt("MS_KThg"));
                    qltht.setTenKThg(rs.getString("Ten_KThg"));
                    qltht.setThuongHsgDacBiet(rs.getInt("Thuong_hsg_dacbiet"));
                    qltht.setThuongHstt(rs.getInt("Thuong_hstt"));
                    qltht.setThuongKhac(rs.getInt("Thuong_khac"));
                    qltht.setNgayTaoKThg(rs.getDate("Ngaytao_KThg"));
                    qltht.setNgayKetThucKThg(rs.getDate("Ngaykthuc_KThg"));
                    qltht.setTrangThai(rs.getString("Trang_thai_khoanthuong"));
                    qltht.setTongThuong(rs.getInt("Tong_thuong"));
                    qltht.setGhiChu(rs.getString("Ghi_chu"));
                    // Thêm các trường khác nếu có
                }
            }
        }
        return qltht;
    }
    public List<QuanLyThuongHocTap> getEndedAwards() throws SQLException {
        List<QuanLyThuongHocTap> endedAwards = new ArrayList<>();
        String sql = "SELECT MS_KThg, Ten_KThg, Thuong_hsg_dacbiet, Thuong_hstt, Thuong_khac, Ngaytao_KThg, Ngaykthuc_KThg, Trang_thai_khoanthuong, Tong_thuong, Ghi_chu FROM khoan_thuong_hoctap WHERE Trang_thai_khoanthuong='Kết thúc'";

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
                endedAwards.add(award);
            }
        }
        return endedAwards;
    }
    public void ketThucKhoanThuong(int ms_kthg) throws SQLException {
        String sql = "UPDATE khoan_thuong_hoctap SET Trang_thai_khoanthuong = 'Kết thúc', Ngaykthuc_KThg = CURDATE() WHERE MS_KThg = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ms_kthg);
            pstmt.executeUpdate();
        }
    }


    public void deleteKhoanThuong(int msKThg) throws SQLException {
        String sql = "DELETE FROM khoan_thuong_hoctap WHERE MS_KThg = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, msKThg);

            pstmt.executeUpdate();
        }
    }

}
