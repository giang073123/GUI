package com.raven.model;
import com.raven.model.Dstamtru;
import java.util.concurrent.TimeUnit;
import java.util.Map;

import java.util.LinkedHashMap;
import java.util.Calendar;

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
    public Map<String, Integer> getNewTemporaryResidencyStatisticsByMonthAndYear(int year) throws SQLException {
        Map<String, Integer> stats = new LinkedHashMap<>();
        // Initialize the stats map with all months set to zero
        for (String monthName : getMonthNames()) {
            stats.put(monthName, 0);
        }

        String sql = "SELECT tt_tu_ngay, tt_den_ngay " +
                "FROM ds_tam_tru " +
                "WHERE YEAR(tt_tu_ngay) <= ? AND YEAR(tt_den_ngay) >= ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, year);
            pstmt.setInt(2, year);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Date startDate = rs.getDate("tt_tu_ngay");
                    Date endDate = rs.getDate("tt_den_ngay");
                    Calendar startCal = Calendar.getInstance();
                    startCal.setTime(startDate);
                    Calendar endCal = Calendar.getInstance();
                    endCal.setTime(endDate);

                    while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
                        if (startCal.get(Calendar.YEAR) == year) {
                            // Get the month name from the array using the month number
                            String monthName = getMonthNames()[startCal.get(Calendar.MONTH)];
                            stats.put(monthName, stats.get(monthName) + 1);
                        }
                        // Move to the next month
                        startCal.add(Calendar.MONTH, 1);
                        // Set the date to the first day of the next month
                        startCal.set(Calendar.DAY_OF_MONTH, 1);
                    }
                }
            }
        }
        return stats;
    }

    // The existing getMonthName method can be used here
// Alternatively, you can have a getMonthNames method that returns all month names
    private String[] getMonthNames() {
        return new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
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

    public void addTamTru(String cccd, String sdt, String diachiThuongtru, int soNha, String duong, Date ttTuNgay, Date ttDenNgay) throws SQLException {
        // Regular expression to match exactly 5 digits - Needs to be updated to match the correct CCCD pattern
        String cccdPattern = "^\\d{5}$";

        // Check if cccd matches the pattern
        if (!cccd.matches(cccdPattern)) {
            throw new IllegalArgumentException("CCCD must be exactly 5 digits.");
        }

        Connection connection = null;
        PreparedStatement checkExistStmt = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();

            // Check if CCCD already exists in ds_tam_tru
            String checkExistSql = "SELECT COUNT(*) FROM ds_tam_tru WHERE CCCD = ?";
            checkExistStmt = connection.prepareStatement(checkExistSql);

            checkExistStmt.setString(1, cccd);
            ResultSet resultSet = checkExistStmt.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // CCCD exists in ds_tam_tru, throw an exception or handle accordingly
                throw new IllegalArgumentException("Người này đã tạm trú rồi không thể khai báo được nữa ");
            }
            long diff = ttDenNgay.getTime() - ttTuNgay.getTime();
            long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            long maxDaysFor2Years = 365 * 2; // Gần đúng cho 2 năm, không tính năm nhuận

            // Kiểm tra xem số ngày có vượt quá 2 năm không
            if (diffDays > maxDaysFor2Years) {
                throw new IllegalArgumentException("Không được phép tạm trú trên 2 năm.");
            }
            // If CCCD does not exist, proceed with the insert
            String sql = "INSERT INTO ds_tam_tru (CCCD, Ma_Ho, Ho_Ten, SDT, Diachi_thuongtru, So_nha, Duong_, Tt_tu_ngay, Tt_den_ngay) " +
                    "SELECT ?, nk.Ma_Ho, nk.Ho_Ten, ?, ?, ?, ?, ?, ? FROM nhan_khau nk WHERE nk.CCCD = ?";
            statement = connection.prepareStatement(sql);

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
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (checkExistStmt != null) {
                checkExistStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
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
