package com.raven.model;
import com.raven.model.Dstamtru;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.event.ActionListener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
public class DstamtruDAO {

    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }
    public List<Dstamtru> searchByDateRange(Date fromDate, Date toDate) throws SQLException {
        List<Dstamtru> results = new ArrayList<>();
        String sql = "SELECT * FROM ds_tam_tru WHERE tt_tu_ngay <= ? AND tt_den_ngay >= ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, new java.sql.Date(toDate.getTime()));
            stmt.setDate(2, new java.sql.Date(fromDate.getTime()));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Dstamtru record = new Dstamtru();
                    record.setCccd(rs.getString("cccd"));
                    record.setMaHo(rs.getInt("ma_ho"));
                    record.setHoTen(rs.getString("ho_ten"));
                    record.setSdt(rs.getString("sdt"));
                    record.setDiachiThuongtru(rs.getString("diachi_thuongtru"));
                    record.setSoNha(rs.getInt("so_nha"));
                    record.setDuong(rs.getString("duong_"));
                    record.setTtTuNgay(rs.getDate("tt_tu_ngay"));
                    record.setTtDenNgay(rs.getDate("tt_den_ngay"));
                    results.add(record);
                }
            }
        }
        return results;
    }


    public List<Dstamtru> listAllTamTru() throws SQLException {
        List<Dstamtru> listTamTru = new ArrayList<>();
        String sql = "SELECT * FROM ds_tam_tru";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Dstamtru tamTru = new Dstamtru();
                tamTru.setCccd(resultSet.getString("CCCD"));
                tamTru.setMaHo(resultSet.getInt("Ma_Ho"));
                tamTru.setHoTen(resultSet.getString("Ho_Ten"));
                tamTru.setSdt(resultSet.getString("SDT"));
                tamTru.setDiachiThuongtru(resultSet.getString("Diachi_thuongtru"));
                tamTru.setSoNha(resultSet.getInt("So_nha"));
                tamTru.setDuong(resultSet.getString("Duong_"));
                tamTru.setTtTuNgay(resultSet.getDate("Tt_tu_ngay"));
                tamTru.setTtDenNgay(resultSet.getDate("Tt_den_ngay"));
                listTamTru.add(tamTru);
            }
        }
        return listTamTru;
    }
    private String getMonthName(int month) {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        // Check if the month number is valid
        if (month >= 1 && month <= 12) {
            return monthNames[month - 1]; // subtract 1 to get correct index
        } else {
            throw new IllegalArgumentException("Invalid month number: " + month);
        }
    }
    public void addTamTru(String cccd, String sdt, String diachiThuongtru, int soNha, String duong, Date ttTuNgay, Date ttDenNgay) throws SQLException {
        // Regular expression to match exactly 5 digits
        String cccdPattern = "^\\d{5}$";

        // Check if cccd matches the pattern
        if (!cccd.matches(cccdPattern)) {
            throw new IllegalArgumentException("CCCD must be exactly 5 digits.");
        }

        String sql = "INSERT INTO ds_tam_tru (CCCD, Ma_Ho, Ho_Ten, SDT, Diachi_thuongtru, So_nha, Duong_, Tt_tu_ngay, Tt_den_ngay) " +
                "SELECT ?, nk.Ma_Ho, nk.Ho_Ten, ?, ?, ?, ?, ?, ? FROM nhan_khau nk WHERE nk.CCCD = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cccd);
            statement.setString(2, sdt);
            statement.setString(3, diachiThuongtru);
            statement.setInt(4, soNha);
            statement.setString(5, duong);
            statement.setDate(6, new java.sql.Date(ttTuNgay.getTime()));
            statement.setDate(7, new java.sql.Date(ttDenNgay.getTime()));
            statement.setString(8, cccd); // Assuming CCCD is unique in nhan_khau

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new temporary residency was inserted successfully!");
            }
        } catch (SQLException e) {
            // Handle exceptions as needed
            throw e;
        }
    }
    public void exportToExcel(List<Dstamtru> list, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Temporary Residency");

        // Create a Row for Header
        Row headerRow = sheet.createRow(0);

        // These headers are just an example, match them with your actual headers
        String[] columnHeaders = {
                "CCCD", "Mã hộ", "Họ tên", "SDT", "Địa chỉ thường trú", "Số nhà", "Đường", "Tạm trú từ ngày", "Tạm trú đến ngày"
        };

        // Create cells for header
        for (int i = 0; i < columnHeaders.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnHeaders[i]);
        }

        // Create Other rows and cells with contacts data
        int rowNum = 1;
        for (Dstamtru item : list) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(item.getCccd());
            row.createCell(1).setCellValue(item.getMaHo());
            row.createCell(2).setCellValue(item.getHoTen());
            row.createCell(3).setCellValue(item.getSdt());
            row.createCell(4).setCellValue(item.getDiachiThuongtru());
            row.createCell(5).setCellValue(item.getSoNha());
            row.createCell(6).setCellValue(item.getDuong());
            row.createCell(7).setCellValue(item.getTtTuNgay().toString());
            row.createCell(8).setCellValue(item.getTtDenNgay().toString());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columnHeaders.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Dstamtru> getAllTamTru() throws SQLException {
        List<Dstamtru> listTamTru = new ArrayList<>();
        String sql = "SELECT * FROM ds_tam_tru";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Dstamtru tamTru = new Dstamtru();
                tamTru.setCccd(resultSet.getString("CCCD"));
                tamTru.setMaHo(resultSet.getInt("Ma_Ho"));
                tamTru.setHoTen(resultSet.getString("Ho_Ten"));
                tamTru.setSdt(resultSet.getString("SDT"));
                tamTru.setDiachiThuongtru(resultSet.getString("Diachi_thuongtru"));
                tamTru.setSoNha(resultSet.getInt("So_nha"));
                tamTru.setDuong(resultSet.getString("Duong_"));
                tamTru.setTtTuNgay(resultSet.getDate("Tt_tu_ngay"));
                tamTru.setTtDenNgay(resultSet.getDate("Tt_den_ngay"));
                listTamTru.add(tamTru);
            }
        }

        return listTamTru;
    }
}
