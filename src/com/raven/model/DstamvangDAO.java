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
    import java.util.List;
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

                stmt.setDate(1, new java.sql.Date(fromDate.getTime()));
                stmt.setDate(2, new java.sql.Date(toDate.getTime()));

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Dstamvang record = new Dstamvang();
                        record.setCccd(rs.getString("cccd"));
                        record.setMaHo(rs.getInt("ma_ho"));
                        record.setHoTen(rs.getString("ho_ten"));
                        record.setSdt(rs.getString("sdt")); // Assuming you have a column 'sdt' in your table
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
