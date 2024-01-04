package Model.ThuPhi;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class khoan_thu_khac extends khoan_thu {

    private String Loai_KThu;

    public khoan_thu_khac() {
        // TODO Auto-generated constructor stub
        table_name = "khoan_thu_khac";
        ds_table_name= "ds_thu_tien_khac";
        col_name.add(0, "MS_KThu");
        col_name.add(1, "Ten_KThu");
        col_name.add(2, "Loai_KThu");
        col_name.add(3, "Ngaytao_KThu");
        col_name.add(4, "Ngaykthuc_KThu");
        col_name.add(5, "Trang_thai_khoanthu");
        col_name.add(6, "Tong_thu");
        col_name.add(7, "Ghi_chu");
    }

    @Override
    public void getDataFromRs(ResultSet resultSet) {
        try {

            this.setMS_KThu(resultSet.getInt("MS_KThu"));
            this.setTen_KThu(resultSet.getString("Ten_KThu"));
            this.setLoai_KThu(resultSet.getString("Loai_KThu"));
            this.setNgaytao_KThu(resultSet.getDate("Ngaytao_KThu"));
            this.setNgaykthuc_KThu(resultSet.getDate("Ngaykthuc_KThu"));
            this.setTrang_thai_khoanthu(resultSet.getString("Trang_thai_khoanthu"));
            this.setTong_thu(resultSet.getInt("Tong_thu"));
            this.setGhi_chu(resultSet.getString("Ghi_chu"));

        } catch (SQLException ex) {
            //Logger.getLogger(khoan_thu_phichungcu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void setDataForStm(PreparedStatement stm) {
        try {

            this.setTong_thu(0);
            this.setTrang_thai_khoanthu("Chưa kết thúc");

            stm.setString(1, this.getTen_KThu());
            stm.setString(2, this.getLoai_KThu());
            stm.setDate(3, Date.valueOf(LocalDate.now()));
            stm.setString(4, this.getTrang_thai_khoanthu());
            stm.setInt(5, this.getTong_thu());
            stm.setString(6, this.getGhi_chu());
        } catch (SQLException ex) {
            Logger.getLogger(khoan_thu_phichungcu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String insertQuery() {
        return " Insert into khoan_thu_khac(Ten_KThu, Loai_KThu, Ngaytao_KThu, Trang_thai_khoanthu, Tong_thu, Ghi_chu)"
                + " Values (?,?,?,?,?,?) ";
    }

    @Override
    public khoan_thu Clone_() {
        khoan_thu_khac kt = new khoan_thu_khac();
        return kt;
    }

    public String getLoai_KThu() {
        return Loai_KThu;
    }

    public void setLoai_KThu(String loai_KThu) {
        Loai_KThu = loai_KThu;
    }

}

