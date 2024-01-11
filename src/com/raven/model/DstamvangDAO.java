    package com.raven.model;
    import java.util.Date;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import org.apache.poi.ss.usermodel.*;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import javax.swing.*;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.Calendar;
    import java.util.LinkedHashMap;
    import java.util.Map;
    public class DstamvangDAO {
        private Connection getConnection() throws SQLException {
            return DatabaseUtil.getConnection();
        }

        public List<Dstamvang> getAllTamVang() throws SQLException {
            List<Dstamvang> listTamVang = new ArrayList<>();
            String sql = "SELECT * FROM ds_tam_vang";

            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Dstamvang tamVang = new Dstamvang();
                    tamVang.setCccd(resultSet.getString("CCCD"));
                    tamVang.setMaHo(resultSet.getInt("Ma_Ho"));
                    tamVang.setHoTen(resultSet.getString("Ho_Ten"));
                    // Assume you have added SDT to your Dstamvang class as a String
                    tamVang.setSdt(resultSet.getString("SDT"));
                    tamVang.setDiachiTv(resultSet.getString("DiaChi_tv"));
                    tamVang.setTvTuNgay(resultSet.getDate("Tv_tu_ngay"));
                    tamVang.setTvDenNgay(resultSet.getDate("Tv_den_ngay"));
                    tamVang.setLyDo(resultSet.getString("Ly_do"));
                    listTamVang.add(tamVang);
                }
            }
            return listTamVang;
        }
        public List<Dstamvang> searchByDateRange(Date fromDate, Date toDate) throws SQLException {
            List<Dstamvang> results = new ArrayList<>();
            String sql = "SELECT * FROM ds_tam_vang WHERE tv_tu_ngay <= ? AND tv_den_ngay >= ?";

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setDate(1, new java.sql.Date(toDate.getTime()));
                stmt.setDate(2, new java.sql.Date(fromDate.getTime()));

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Dstamvang record = new Dstamvang();
                        record.setCccd(rs.getString("cccd"));
                        record.setMaHo(rs.getInt("ma_ho"));
                        record.setHoTen(rs.getString("ho_ten"));
                        record.setSdt(rs.getString("sdt")); // Assuming there is an 'sdt' column in ds_tam_vang
                        record.setDiachiTv(rs.getString("diachi_tv"));
                        record.setTvTuNgay(rs.getDate("tv_tu_ngay"));
                        record.setTvDenNgay(rs.getDate("tv_den_ngay"));
                        record.setLyDo(rs.getString("ly_do"));
                        results.add(record);
                    }
                }
            }
            return results;
        }
        public Map<String, Integer> getNewTemporaryAbsenceStatisticsByMonthAndYear(int year) throws SQLException {
            Map<String, Integer> stats = new LinkedHashMap<>();
            // Initialize the stats map with all months set to zero
            for (String monthName : getMonthNames()) {
                stats.put(monthName, 0);
            }

            String sql = "SELECT tv_tu_ngay, tv_den_ngay " +
                    "FROM ds_tam_vang " +
                    "WHERE YEAR(tv_tu_ngay) <= ? AND YEAR(tv_den_ngay) >= ?";

            try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, year);
                pstmt.setInt(2, year);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Date startDate = rs.getDate("tv_tu_ngay");
                        Date endDate = rs.getDate("tv_den_ngay");
                        Calendar startCal = Calendar.getInstance();
                        startCal.setTime(startDate);
                        Calendar endCal = Calendar.getInstance();
                        endCal.setTime(endDate);

                        while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
                            if (startCal.get(Calendar.YEAR) == year) {
                                String monthName = getMonthNames()[startCal.get(Calendar.MONTH)];
                                stats.put(monthName, stats.get(monthName) + 1);
                            }
                            startCal.add(Calendar.MONTH, 1);
                            startCal.set(Calendar.DAY_OF_MONTH, 1);
                        }
                    }
                }
            }
            return stats;
        }

        private String[] getMonthNames() {
            return new String[]{"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"};
        }
        public static void exportListToExcel(List<Dstamvang> listTamVang, String path) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Danh Sách Tạm Vắng");

            // Create header row
            String[] headers = {"CCCD", "Mã hộ", "Họ tên", "SDT", "Địa chỉ tạm vắng", "Tạm trú từ", "Tạm trú đến", "Lý do"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(headers[i]);
            }

            // Writing data
            int rowNum = 1;
            for (Dstamvang tamVang : listTamVang) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(tamVang.getCccd());
                row.createCell(1).setCellValue(tamVang.getMaHo());
                row.createCell(2).setCellValue(tamVang.getHoTen());
                row.createCell(3).setCellValue(tamVang.getSdt());
                row.createCell(4).setCellValue(tamVang.getDiachiTv());
                row.createCell(5).setCellValue(tamVang.getTvTuNgay().toString());
                row.createCell(6).setCellValue(tamVang.getTvDenNgay().toString());
                row.createCell(7).setCellValue(tamVang.getLyDo());
            }

            // Autosize columns
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the workbook to a file
            try (FileOutputStream outputStream = new FileOutputStream(path)) {
                workbook.write(outputStream);
                workbook.close();
                JOptionPane.showMessageDialog(null, "Truyền file excel thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Lỗi truyền file");
                e.printStackTrace();
            }
        }
    }
