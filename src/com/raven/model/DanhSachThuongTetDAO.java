package com.raven.model;

import java.sql.*;
import java.util.Vector;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

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
    public void exportTable(DefaultTableModel model, String path) throws IOException {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a cell style for the date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create a sheet
        Sheet sheet = workbook.createSheet("Data");

        // Create the header row
        Row headerRow = sheet.createRow(0);

        // Set the header row values
        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }

        // Write the data rows
        for (int i = 0; i < model.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1);

            for (int j = 0; j < model.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                Object value = model.getValueAt(i, j);

                if (value != null) { // Kiểm tra xem giá trị có phải là null không
                    if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    } else if (value instanceof Date) {
                        cell.setCellValue((Date) value);
                        cell.setCellStyle(dateCellStyle); // Apply date format
                    } else {
                        cell.setCellValue(value.toString());
                    }
                }
            }
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < model.getColumnCount(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.write(fileOut);
        }

        // Close the workbook
        workbook.close();
    }
    public Vector<Vector<Object>> searchDanhSachThuongTet(String hoTen, String CCCD, String maHo, int msKThg) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Vector<Vector<Object>> data = new Vector<>();

        try {
            connection = getConnection();

            String query = "SELECT * FROM ds_thuong_letet WHERE MS_KThg = ?";
            if (!hoTen.isEmpty() || !CCCD.isEmpty() || !maHo.isEmpty()) {
                query += " AND (";
                List<String> conditions = new ArrayList<>();

                if (!hoTen.isEmpty()) {
                    conditions.add("Ho_ten LIKE ?");
                }
                if (!CCCD.isEmpty()) {
                    conditions.add("CCCD LIKE ?");
                }
                if (!maHo.isEmpty()) {
                    conditions.add("Ma_ho LIKE ?");
                }
                query += String.join(" OR ", conditions);
                query += ")";
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, msKThg);

            int index = 2;
            if (!hoTen.isEmpty()) {
                preparedStatement.setString(index++, "%" + hoTen + "%");
            }
            if (!CCCD.isEmpty()) {
                preparedStatement.setString(index++, "%" + CCCD + "%");
            }
            if (!maHo.isEmpty()) {
                preparedStatement.setString(index, "%" + maHo + "%");
            }

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getString("Ho_ten")); // Ho và tên
                row.add(resultSet.getString("CCCD")); // CCCD
                row.add(resultSet.getInt("Ma_ho")); // Mã hộ
                row.add(resultSet.getDate("Ngay_sinh")); // Ngày sinh
                row.add(resultSet.getInt("Gia_tri_phan_qua")); // Giá trị phần quà
                row.add(resultSet.getString("Trangthai_Phatthuong")); // Trạng thái phát thưởng
                row.add(resultSet.getDate("Ngay_thuong")); // Ngày thưởng
                data.add(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

        return data;
    }
    public void themDanhSachThuongTet(String CCCD, int msKThg, String trangThaiPhatThuong) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isEligibleForReward = false;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            // Declare maHo at the method level to avoid redeclaration
            Integer maHo = null;
            String hoTen;
            Date ngaySinh;

            // Check if the CCCD exists and meets the conditions in nhan_khau
            String checkQuery = "SELECT Ma_ho, Trang_thai_nhan_khau FROM nhan_khau WHERE CCCD = ?";
            preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, CCCD);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new SQLException("Nhân khẩu không tồn tại.");
            }

            // Get Ma_ho and Trang_thai_nhan_khau without redeclaring maHo
            maHo = (Integer) resultSet.getObject("Ma_ho");  // Use getObject to handle possible nulls
            String trangThaiNhanKhau = resultSet.getString("Trang_thai_nhan_khau");

            if (maHo == null || !"Thường trú".equals(trangThaiNhanKhau)) {
                throw new SQLException("Nhân khẩu không đáp ứng điều kiện Thường trú và Ma_Ho khác NULL.");
            }

            // Close the previous statement and result set before reusing them
            resultSet.close();
            preparedStatement.close();

            // Get hoTen, maHo, ngaySinh from nhan_khau using CCCD
            String queryNhanKhau = "SELECT Ho_ten, Ma_ho, Ngay_sinh FROM nhan_khau WHERE CCCD = ?";
            preparedStatement = connection.prepareStatement(queryNhanKhau);
            preparedStatement.setString(1, CCCD);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                hoTen = resultSet.getString("Ho_ten");
                // maHo is already declared, so we just assign the value here
                maHo = resultSet.getInt("Ma_ho");
                ngaySinh = resultSet.getDate("Ngay_sinh");

                // Get giaTriPhanQua from khoan_thuong_letet using msKThg
                String queryKhoanThuong = "SELECT Gia_tri_phan_qua FROM khoan_thuong_letet WHERE MS_KThg = ?";
                preparedStatement = connection.prepareStatement(queryKhoanThuong);
                preparedStatement.setInt(1, msKThg);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int giaTriPhanQua = resultSet.getInt("Gia_tri_phan_qua");

                    // Insert into ds_thuong_letet
                    String insertQuery = "INSERT INTO ds_thuong_letet (CCCD, Ho_ten, Ma_ho, Ngay_sinh, Gia_tri_phan_qua, Trangthai_Phatthuong, MS_KThg, Ngay_thuong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, CCCD);
                    preparedStatement.setString(2, hoTen);
                    preparedStatement.setInt(3, maHo);
                    preparedStatement.setDate(4, ngaySinh);
                    preparedStatement.setInt(5, giaTriPhanQua);
                    preparedStatement.setString(6, trangThaiPhatThuong);
                    preparedStatement.setInt(7, msKThg);

                    if ("Đã hoàn thành".equals(trangThaiPhatThuong)) {
                        preparedStatement.setDate(8, new java.sql.Date(System.currentTimeMillis())); // Ngày hiện tại
                    } else {
                        preparedStatement.setNull(8, java.sql.Types.DATE); // NULL nếu không phải "Đã hoàn thành"
                    }

                    preparedStatement.executeUpdate();

                    // Update total award
                    capNhatTongThuong(msKThg);
                }
            }
            connection.commit();

        }  catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback changes if exception occurred
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle potential SQL exceptions on rollback
                }
            }
            throw ex; // Rethrow the original exception
        } finally {
            // Close resources in the finally block to ensure they are always closed
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Reset auto-commit to true
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle potential SQL exceptions on setting auto-commit
                }
                connection.close();
            }
        }
    }
    public void xoaDanhSachThuongTet(int msKThg, String CCCD) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            // Xóa bản ghi từ bảng ds_thuong_letet
            String deleteQuery = "DELETE FROM ds_thuong_letet WHERE MS_KThg = ? AND CCCD = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, msKThg);
            preparedStatement.setString(2, CCCD);
            preparedStatement.executeUpdate();

            // Cập nhật tổng thưởng sau khi xóa
            capNhatTongThuong(msKThg);
        } catch (SQLException ex) {
            // Xử lý các ngoại lệ SQL
            ex.printStackTrace();
            throw ex; // Ném lại ngoại lệ để xử lý ở tầng cao hơn
        } finally {
            // Đóng các tài nguyên
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
    public void updateBonusStatus(String cccd, int msKThg, String status, java.sql.Date date) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String updateStatusQuery = "UPDATE ds_thuong_letet SET Trangthai_Phatthuong = ?, Ngay_thuong = ? WHERE CCCD = ? AND MS_KThg = ?";
            preparedStatement = connection.prepareStatement(updateStatusQuery);
            preparedStatement.setString(1, status);
            if (date != null) {
                preparedStatement.setDate(2, date);
            } else {
                preparedStatement.setNull(2, java.sql.Types.DATE);
            }
            preparedStatement.setString(3, cccd);
            preparedStatement.setInt(4, msKThg);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                // Update the total bonus after the status update
                capNhatTongThuong(msKThg);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
    public void capNhatTongThuong(int msKThg) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sumQuery = "SELECT SUM(Gia_tri_phan_qua) AS TongThuong FROM ds_thuong_letet WHERE MS_KThg = ? AND Trangthai_Phatthuong = 'Đã hoàn thành'";
            preparedStatement = connection.prepareStatement(sumQuery);
            preparedStatement.setInt(1, msKThg);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int tongThuong = resultSet.getInt("TongThuong");

                // Update total award in khoan_thuong_letet
                String updateQuery = "UPDATE khoan_thuong_letet SET Tong_thuong = ? WHERE MS_KThg = ?";
                preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setInt(1, tongThuong);
                preparedStatement.setInt(2, msKThg);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            ex.printStackTrace();
        } finally {
            // Close resources
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }


}
