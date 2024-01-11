/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import com.mysql.cj.result.Row;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Model.ThuPhi.*;

/**
 *
 * @author Admin
 */
public class ExcelImporter {
    private khoan_thu_khac myKT;
            
    private connectDB conndb = new connectDB();
    
    

    public ExcelImporter(khoan_thu_khac kt) {
       // MS_KThu = MS;
       myKT = kt;
    }

    public void importToDatabase() {

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filename = file.getName();
            String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

            String excel = "xlsx";
            if (!extension.equals(excel)) {
                JOptionPane.showMessageDialog(null, "Choose an excel file!");

            } else {

                Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc chắn muốn tải lên file này",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (choosen == JOptionPane.YES_OPTION) {

                    Connection conn = conndb.connect();
                      String sql = "INSERT INTO ds_thu_tien_khac (MS_KThu, Ma_Ho, Loai_KThu, So_tien, Trangthai_Thu, Ngay_thu) VALUES (?, ?, ?, ?, 'Chưa thu', null)";
                    try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis);
                             PreparedStatement stmt = conn.prepareStatement(sql);) {

                        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
                         
                        
                        for (org.apache.poi.ss.usermodel.Row row : sheet) {
                            if (row.getRowNum() == 0) { // Chỉ số dòng bắt đầu từ 0
                                continue; // Bỏ qua tiêu đề nếu có
                            }
                           
                            
                            try {

                                int maHo = (int) row.getCell(1).getNumericCellValue();                          
                                int soTien = (int) row.getCell(2).getNumericCellValue();
                                
                                
                                stmt.setInt(1, myKT.getMS_KThu());
                                stmt.setInt(2, maHo);
                                stmt.setString(3, myKT.getLoai_KThu());
                                stmt.setInt(4, soTien);
                                
                                

                                 stmt.addBatch();
                            } catch (NumberFormatException nfe) {
                                JOptionPane.showMessageDialog(null, "Kiểm tra lại định dạng dữ liệu file");
                            }

                        }
                         stmt.executeBatch();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ExcelImporter.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    JOptionPane.showMessageDialog(null, "Đã tải lên");
                    return;
                } else if (choosen == JOptionPane.NO_OPTION) {
                    return;
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                    return;
                } else {
                    return;
                }

            }
        }

    }

    public static void main(String[] args) {
         Model_ThuPhi m = new Model_ThuPhi();
         khoan_thu_khac kt = (khoan_thu_khac) m.khoan_thu_Get(new khoan_thu_khac(), 17);
         ExcelImporter n = new ExcelImporter(kt);
         n.importToDatabase();
    }

}
