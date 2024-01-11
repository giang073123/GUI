    package com.raven.model;

    import java.sql.*;
    import java.util.Vector;
    import com.raven.model.QuanLyThuongTetdata;
    import com.raven.model.QuanLyThuongTetDAO;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.util.List;
    import java.util.ArrayList;
    import java.util.Date;

    public class QuanLyThuongTetDAO {
        private Connection getConnection() throws SQLException {
            return DatabaseUtil.getConnection();
        }

        public Vector<Vector<Object>> layTatCaKhoanThuong() throws SQLException {
            Vector<Vector<Object>> khoanThuongs = new Vector<>();
            // Adjust the SQL query to check for NULL in Trang_thai_khoanthuong
            String sql = "SELECT * FROM khoan_thuong_letet WHERE Trang_thai_khoanthuong = 'Hoạt động'";
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
            String sqlInsertKhoanThuong = "INSERT INTO khoan_thuong_letet " +
                    "(Ten_KThg, Gia_tri_phan_qua, Ngaytao_KThg, Trang_thai_khoanthuong, Tong_thuong, Ghi_chu) " +
                    "VALUES (?, ?, CURRENT_DATE, 'Hoạt động', 0, ?)";

            String sqlSelectEligibleNhanKhau = "SELECT cccd, Ma_Ho, Ho_ten, Ngay_sinh " +
                    "FROM nhan_khau " +
                    "WHERE YEAR(CURRENT_DATE) - YEAR(Ngay_sinh) BETWEEN 0 AND 6";

            String sqlInsertDsThuongLetet = "INSERT INTO ds_thuong_letet " +
                    "(MS_KThg, Ho_ten, CCCD, Ma_Ho, Ngay_sinh, Gia_tri_phan_qua, Trangthai_Phatthuong, Ngay_thuong) " +
                    "VALUES (?, ?, ?, ?, ?, ?, NULL, NULL)";

            try (Connection conn = getConnection();
                 PreparedStatement pstmtInsertKhoanThuong = conn.prepareStatement(sqlInsertKhoanThuong, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement pstmtSelectNhanKhau = conn.prepareStatement(sqlSelectEligibleNhanKhau);
                 PreparedStatement pstmtInsertDsThuongLetet = conn.prepareStatement(sqlInsertDsThuongLetet)) {

                // Insert new khoan_thuong_letet
                pstmtInsertKhoanThuong.setString(1, khoanThuong.getTenKhoanThuong());
                pstmtInsertKhoanThuong.setInt(2, khoanThuong.getGiaTriPhanQua());
                pstmtInsertKhoanThuong.setString(3, khoanThuong.getGhiChu());
                pstmtInsertKhoanThuong.executeUpdate();

                // Retrieve generated ms_kthg
                int generatedMsKThg;
                try (ResultSet generatedKeys = pstmtInsertKhoanThuong.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedMsKThg = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Creating khoan_thuong_letet failed, no ID obtained.");
                    }
                }

                // Select eligible nhan_khau based on age criteria
                ResultSet rsNhanKhau = pstmtSelectNhanKhau.executeQuery();
                while (rsNhanKhau.next()) {
                    // Insert into ds_thuong_letet
                    pstmtInsertDsThuongLetet.setInt(1, generatedMsKThg);
                    pstmtInsertDsThuongLetet.setString(2, rsNhanKhau.getString("Ho_ten"));
                    pstmtInsertDsThuongLetet.setString(3, rsNhanKhau.getString("cccd"));
                    pstmtInsertDsThuongLetet.setInt(4, rsNhanKhau.getInt("Ma_Ho"));
                    pstmtInsertDsThuongLetet.setDate(5, rsNhanKhau.getDate("Ngay_sinh"));
                    pstmtInsertDsThuongLetet.setInt(6, khoanThuong.getGiaTriPhanQua());
                    pstmtInsertDsThuongLetet.executeUpdate();
                }
            }
        }
        public List<QuanLyThuongTetdata> searchLetetAwardsByDate(java.sql.Date startDate, java.sql.Date endDate) throws SQLException  {
            List<QuanLyThuongTetdata> awards = new ArrayList<>();
            String sql = "SELECT * FROM khoan_thuong_letet WHERE " +
                    "Ngaytao_KThg <= ? AND Ngaykthuc_KThg >= ? AND " +
                    "Trang_thai_khoanthuong = 'Kết thúc'";

            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, new java.sql.Date(endDate.getTime()));
                preparedStatement.setDate(2, new java.sql.Date(startDate.getTime()));

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        QuanLyThuongTetdata award = new QuanLyThuongTetdata();
                        award.setMsKThg(resultSet.getInt("MS_KThg"));
                        award.setTenKhoanThuong(resultSet.getString("Ten_KThg"));
                        award.setMsKThg(resultSet.getInt("Gia_tri_phan_qua"));
                        award.setNgayTao(resultSet.getDate("Ngaytao_KThg"));
                        award.setNgayKetThuc(resultSet.getDate("Ngaykthuc_KThg"));
                        award.setTrangThai(resultSet.getString("Trang_thai_khoanthuong"));
                        award.setTongThuong(resultSet.getInt("Tong_thuong"));
                        award.setGhiChu(resultSet.getString("Ghi_chu"));
                        awards.add(award);
                    }
                }
            }
            return awards;
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
            String sql = "UPDATE khoan_thuong_letet SET Trang_thai_khoanthuong='Kết Thúc', Ngaykthuc_KThg=? WHERE MS_KThg=?";

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Đặt Ngaykthuc_KThg là ngày hiện tại
                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                pstmt.setDate(1, currentDate);

                // Đặt MS_KThg cho khoản thưởng cần kết thúc
                pstmt.setInt(2, msKThg);

                // Thực hiện cập nhật
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
            String sql = "SELECT * FROM khoan_thuong_letet WHERE Trang_thai_khoanthuong='Kết thúc'";
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


