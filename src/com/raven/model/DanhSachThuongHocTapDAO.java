package com.raven.model;
import java.util.Date;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;

public class DanhSachThuongHocTapDAO {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }
    private Connection conn;
    DanhSachThuongHocTap danhSach;
    public List<DanhSachThuongHocTap> getDanhSachThuongHocTap(int ms_kthg) throws SQLException {
        List<DanhSachThuongHocTap> danhSachThuong = new ArrayList<>();
        String sql = "SELECT MS_KThg, Ho_ten, CCCD, Ma_Ho, Truong_hoc, Thanh_tich, Minh_chung, " +
                "Gia_tri_phan_qua, Trangthai_Phatthuong, Ngay_thuong " +
                "FROM ds_thuong_hoctap WHERE MS_KThg = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ms_kthg);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DanhSachThuongHocTap dst = new DanhSachThuongHocTap();
                    dst.setMsKThg(rs.getInt("MS_KThg"));
                    dst.setHoTen(rs.getString("Ho_ten"));
                    dst.setCCCD(rs.getString("CCCD"));
                    dst.setMaHo(rs.getInt("Ma_Ho"));
                    dst.setTruongHoc(rs.getString("Truong_hoc"));
                    dst.setThanhTich(rs.getString("Thanh_tich"));
                    dst.setMinhChung(rs.getString("Minh_chung"));
                    dst.setGiaTriPhanQua(rs.getInt("Gia_tri_phan_qua"));
                    dst.setTrangThaiPhatThuong(rs.getString("Trangthai_Phatthuong"));
                    dst.setNgayThuong(rs.getDate("Ngay_thuong"));
                    danhSachThuong.add(dst);
                }
            }
        }
        return danhSachThuong;
    }
    public void updateDanhSachThuongHocTap(DanhSachThuongHocTap dst, int msKThg) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection(); // Lấy connection đã được kết nối đến CSDL

            // Cập nhật thông tin vào bảng ds_thuong_hoctap
            String sqlUpdate = "UPDATE ds_thuong_hoctap " +
                    "SET Truong_hoc = ?, Thanh_tich = ?, Minh_chung = ?, Trangthai_Phatthuong = ?, Gia_tri_phan_qua = ?, Ngay_thuong = ? " +
                    "WHERE CCCD = ? AND MS_KThg = ?";
            stmt = conn.prepareStatement(sqlUpdate);

            stmt.setString(1, dst.getTruongHoc());
            stmt.setString(2, dst.getThanhTich());
            stmt.setString(3, dst.getMinhChung());
            stmt.setString(4, dst.getTrangThaiPhatThuong());

            // Xác định giá trị phần quà dựa trên thành tích và bảng khoan_thuong_hoctap
            int rewardValue = getRewardValueByAchievement(dst.getThanhTich(), msKThg, conn);
            stmt.setInt(5, rewardValue);

            // Cập nhật Ngay_thuong dựa trên Trangthai_Phatthuong
            Date ngayThuong = "Đã hoàn thành".equals(dst.getTrangThaiPhatThuong()) ? new Date(System.currentTimeMillis()) : null;
            if (ngayThuong != null) {
                stmt.setDate(6, new java.sql.Date(ngayThuong.getTime()));
            } else {
                stmt.setNull(6, java.sql.Types.DATE);
            }

            stmt.setString(7, dst.getCCCD());
            stmt.setInt(8, msKThg);

            // Thực thi câu lệnh SQL
            stmt.executeUpdate();

            // Cập nhật tổng thưởng trong bảng khoan_thuong_hoctap
            updateTotalReward(msKThg, conn);
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    private int getRewardValueByAchievement(String thanhTich, int msKThg, Connection conn) throws SQLException {
        String column = switch (thanhTich) {
            case "Học sinh giỏi" -> "Thuong_hsg_dacbiet";
            case "Học sinh tiên tiến" -> "Thuong_hstt";
            default -> "Thuong_khac";
        };

        String sqlSelect = "SELECT " + column + " FROM khoan_thuong_hoctap WHERE MS_KThg = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sqlSelect)) {
            stmt.setInt(1, msKThg);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(column);
                } else {
                    throw new SQLException("Không tìm thấy giá trị thưởng cho MS_KThg: " + msKThg);
                }
            }
        }
    }

    private void updateTotalReward(int msKThg, Connection conn) throws SQLException {
        String sqlSelect = "SELECT SUM(Gia_tri_phan_qua) as TotalReward FROM ds_thuong_hoctap WHERE MS_KThg = ? AND Trangthai_Phatthuong = 'Đã hoàn thành'";
        String sqlUpdate = "UPDATE khoan_thuong_hoctap SET Tong_thuong = ? WHERE MS_Kthg = ?";

        try (PreparedStatement selectStmt = conn.prepareStatement(sqlSelect);
             PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
            selectStmt.setInt(1, msKThg);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    int totalReward = rs.getInt("TotalReward");
                    updateStmt.setInt(1, totalReward);
                    updateStmt.setInt(2, msKThg);
                    updateStmt.executeUpdate();
                } else {
                    throw new SQLException("Không thể tính tổng thưởng cho MS_KThg: " + msKThg);
                }
            }
        }
    }



    public void fillTableWithDanhSachThuongHocTap(int msKThg, DefaultTableModel tableModel) {
        String query = "SELECT * FROM ds_thuong_hoctap WHERE MS_KThg = " + msKThg;
        try (Connection conn = getConnection(); // Sử dụng getConnection thay vì connect
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Xóa dữ liệu cũ trong bảng
            tableModel.setRowCount(0);

            // Điền dữ liệu mới vào bảng
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("Ho_ten"));
                row.add(rs.getString("CCCD"));
                row.add(rs.getInt("Ma_Ho"));
                row.add(rs.getString("Truong_hoc"));
                row.add(rs.getString("Thanh_tich"));
                row.add(rs.getString("Minh_chung"));
                row.add(rs.getInt("Gia_tri_phan_qua"));
                row.add(rs.getString("Trangthai_Phatthuong"));
                row.add(rs.getDate("Ngay_thuong"));
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xoaDanhSachThuongHocTap(String cccd) throws SQLException {
        String sqlGetXoa = "SELECT gia_tri_phan_qua, MS_KThg FROM ds_thuong_hoctap WHERE CCCD = ?";
        String sqlXoa = "DELETE FROM ds_thuong_hoctap WHERE CCCD = ?";
        String sqlCapNhat = "UPDATE khoan_thuong_hoctap SET Tong_thuong = Tong_thuong - ? WHERE MS_KThg = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmtGetXoa = conn.prepareStatement(sqlGetXoa);
             PreparedStatement pstmtXoa = conn.prepareStatement(sqlXoa);
             PreparedStatement pstmtCapNhat = conn.prepareStatement(sqlCapNhat)) {

            // Lấy giá trị phần quà và MS_KThg
            pstmtGetXoa.setString(1, cccd);
            int giaTriPhanQua = 0;
            int msKThg = 0;
            var rs = pstmtGetXoa.executeQuery();
            if (rs.next()) {
                giaTriPhanQua = rs.getInt("gia_tri_phan_qua");
                msKThg = rs.getInt("MS_KThg");
            }

            // Xóa dữ liệu
            pstmtXoa.setString(1, cccd);
            pstmtXoa.executeUpdate();

            // Cập nhật tổng thưởng
            pstmtCapNhat.setInt(1, giaTriPhanQua);
            pstmtCapNhat.setInt(2, msKThg);
            pstmtCapNhat.executeUpdate();
        }
    }







    public void themDanhSachThuongHocTap(DanhSachThuongHocTap dstht) throws SQLException {
        if (dstht.getCCCD().length() != 5 || !dstht.getCCCD().matches("\\d{5}")) {
            throw new IllegalArgumentException("CCCD Phai co 5 chu so.");
        }

        try (Connection conn = getConnection()) {
            // Begin transaction
            conn.setAutoCommit(false);

            String hoTen;
            int maHo;
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT Ho_ten, Ma_Ho FROM nhan_khau WHERE CCCD = ?")) {
                pstmt.setString(1, dstht.getCCCD());
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.next()) {
                        throw new SQLException("No data found for CCCD: " + dstht.getCCCD());
                    }
                    hoTen = rs.getString("Ho_ten");
                    maHo = rs.getInt("Ma_Ho");
                }
            }

            int giaTriPhanQua;
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM khoan_thuong_hoctap WHERE MS_KThg = ?")) {
                pstmt.setInt(1, dstht.getMsKThg());
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (!rs.next()) {
                            throw new SQLException("No data found for MS_KThg: " + dstht.getMsKThg());
                    }
                    switch (dstht.getThanhTich()) {
                        case "Học sinh giỏi":
                            giaTriPhanQua = rs.getInt("Thuong_hsg_dacbiet");
                            break;
                        case "Học sinh tiên tiến":
                            giaTriPhanQua = rs.getInt("Thuong_hstt");
                            break;
                        default:
                            giaTriPhanQua = rs.getInt("Thuong_khac");
                            break;
                    }
                }
            }
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ds_thuong_hoctap (MS_KThg, Ho_ten, CCCD, Ma_Ho, Truong_hoc, Thanh_tich, Minh_chung, Gia_tri_phan_qua, Trangthai_Phatthuong, Ngay_thuong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                pstmt.setInt(1, dstht.getMsKThg());
                pstmt.setString(2, hoTen);
                pstmt.setString(3, dstht.getCCCD());
                pstmt.setInt(4, maHo);
                pstmt.setString(5, dstht.getTruongHoc());
                pstmt.setString(6, dstht.getThanhTich());
                pstmt.setString(7, dstht.getMinhChung());
                pstmt.setInt(8, giaTriPhanQua);
                pstmt.setString(9, dstht.getTrangThaiPhatThuong());

                // Kiểm tra trạng thái để gán giá trị cho Ngay_thuong
                if ("Đã hoàn thành".equals(dstht.getTrangThaiPhatThuong())) {
                    pstmt.setDate(10, new java.sql.Date(new java.util.Date().getTime())); // Gán ngày hiện tại
                } else {
                    pstmt.setNull(10, java.sql.Types.DATE); // Gán NULL nếu không phải 'Đã hoàn thành'
                }

                pstmt.executeUpdate();
            }

            // Step 5: If Trang_thai is "Đã hoàn thành", update Tong_thuong in khoan_thuong_hoctap table
            if ("Đã hoàn thành".equals(dstht.getTrangThaiPhatThuong())) {
                try (PreparedStatement pstmt = conn.prepareStatement("UPDATE khoan_thuong_hoctap SET Tong_thuong = Tong_thuong + ? WHERE MS_KThg = ?")) {
                    pstmt.setInt(1, giaTriPhanQua);
                    pstmt.setInt(2, dstht.getMsKThg());
                    pstmt.executeUpdate();
                }
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public List<DanhSachThuongHocTap> TimKiemThuongHocTap(Integer ms_kthg, String hoTen, String cccd, Integer maHo) throws SQLException {
        List<DanhSachThuongHocTap> danhSachTimKiem = new ArrayList<>();
        String sql = "SELECT * FROM ds_thuong_hoctap WHERE MS_KThg = ? AND " +
                "((? IS NULL OR Ho_ten LIKE ?) AND " +
                "(? IS NULL OR CCCD LIKE ?) AND " +
                "(? IS NULL OR Ma_Ho = ?))";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ms_kthg);
            pstmt.setString(2, hoTen.isEmpty() ? null : "%" + hoTen + "%");
            pstmt.setString(3, hoTen.isEmpty() ? null : "%" + hoTen + "%");
            pstmt.setString(4, cccd.isEmpty() ? null : "%" + cccd + "%");
            pstmt.setString(5, cccd.isEmpty() ? null : "%" + cccd + "%");
            if (maHo != null) {
                pstmt.setInt(6, maHo);
                pstmt.setInt(7, maHo);
            } else {
                pstmt.setNull(6, Types.INTEGER);
                pstmt.setNull(7, Types.INTEGER);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DanhSachThuongHocTap dst = new DanhSachThuongHocTap();
                    dst.setHoTen(rs.getString("Ho_ten"));
                    dst.setCCCD(rs.getString("CCCD"));
                    dst.setMaHo(rs.getInt("Ma_Ho"));
                    dst.setTruongHoc(rs.getString("Truong_hoc"));
                    dst.setThanhTich(rs.getString("Thanh_tich"));
                    dst.setMinhChung(rs.getString("Minh_chung"));
                    dst.setGiaTriPhanQua(rs.getInt("Gia_tri_phan_qua"));
                    dst.setTrangThaiPhatThuong(rs.getString("Trangthai_Phatthuong"));
                    dst.setNgayThuong(rs.getDate("Ngay_thuong"));
                    danhSachTimKiem.add(dst);
                }
            }
        }
        return danhSachTimKiem;
    }
    public void exportTable(DefaultTableModel model, String path) throws IOException {
        // Tạo workbook mới
        Workbook workbook = new XSSFWorkbook();

        // Tạo sheet
        Sheet sheet = workbook.createSheet("Danh Sách Thưởng Học Tập");

        // Tạo hàng tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }

        // Viết dữ liệu từng hàng vào sheet
        for (int i = 0; i < model.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < model.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                Object value = model.getValueAt(i, j);
                if (value instanceof Integer) {
                    cell.setCellValue((Integer) value);
                } else if (value instanceof String) {
                    cell.setCellValue((String) value);
                } else if (value instanceof Date) {
                    cell.setCellValue(value.toString());
                    // Đặt format cho cell nếu cần
                    CellStyle cellStyle = workbook.createCellStyle();
                    CreationHelper createHelper = workbook.getCreationHelper();
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
                    cell.setCellStyle(cellStyle);
                }
                // Xử lý các kiểu dữ liệu khác nếu cần
            }
        }

        // Tự động điều chỉnh kích thước cột
        for (int i = 0; i < model.getColumnCount(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Ghi file
        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.write(fileOut);
        }

        // Đóng workbook
        workbook.close();
    }


}
