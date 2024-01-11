package com.raven.model;

import com.raven.model.DatabaseUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelImporter {
    private Connection getConnection() throws SQLException {
        return DatabaseUtil.getConnection();
    }

    public void importToDatabase(File excelFile) {
        String sql = "INSERT INTO ds_thu_tien_khac (MS_KThu, Ma_Ho, Loai_KThu, So_tien, Trangthai_Thu, Ngay_thu) VALUES (?, ?, ?, ?, ?, ?)";

        try (FileInputStream fis = new FileInputStream(excelFile);
             Workbook workbook = new XSSFWorkbook(fis);
             Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) { // Chỉ số dòng bắt đầu từ 0
                    continue; // Bỏ qua tiêu đề nếu có
                }

                int msKThu = (int) row.getCell(0).getNumericCellValue();
                int maHo = (int) row.getCell(1).getNumericCellValue();
                String loaiKThu = row.getCell(2).getStringCellValue();
                int soTien = (int) row.getCell(3).getNumericCellValue();
                String trangThaiThu = row.getCell(4).getStringCellValue();
                Date ngayThu = row.getCell(5).getDateCellValue();

                stmt.setInt(1, msKThu);
                stmt.setInt(2, maHo);
                stmt.setString(3, loaiKThu);
                stmt.setInt(4, soTien);
                stmt.setString(5, trangThaiThu);
                stmt.setDate(6, new java.sql.Date(ngayThu.getTime()));

                stmt.addBatch();
            }
            stmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File excelFile = fileChooser.getSelectedFile();
            new ExcelImporter().importToDatabase(excelFile);
        }
    }
}
