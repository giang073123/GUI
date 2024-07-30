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
public class khoan_thu_phichungcu extends khoan_thu {

    private int Phi_dichvu;
    private int Phi_quanly;

    public khoan_thu_phichungcu() {
        // TODO Auto-generated constructor stub
        table_name = "khoan_thu_phichungcu";
        ds_table_name = "ds_thu_tien_phichungcu";
        col_name.add(0, "MS_KThu");
        col_name.add(1, "Ten_KThu");
        col_name.add(2, "Phi_dichvu");
        col_name.add(3, "Phi_quanly");
        col_name.add(4, "Ngaytao_KThu");
        col_name.add(5, "Ngaykthuc_KThu");
        col_name.add(6, "Trang_thai_khoanthu");
        col_name.add(7, "Tong_thu");
        col_name.add(8, "Ghi_chu");
    }

    @Override
    public void getDataFromRs(ResultSet resultSet) {
        try {

            this.setMS_KThu(resultSet.getInt("MS_KThu"));
            this.setTen_KThu(resultSet.getString("Ten_KThu"));
            this.setPhi_dichvu(resultSet.getInt("Phi_dichvu"));
            this.setPhi_quanly(resultSet.getInt("Phi_quanly"));
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
    public void setDataForStm(PreparedStatement stm) {    // CHÚ Ý : Method này chỉ dùng cho thêm mới, dùng cho cập nhật cần phải sửa lại
        try {

            this.setTong_thu(0);
            this.setTrang_thai_khoanthu("Chưa kết thúc");
            stm.setString(1, this.getTen_KThu());
            stm.setInt(2, this.getPhi_dichvu());
            stm.setInt(3, this.getPhi_quanly());
            stm.setDate(4, Date.valueOf(LocalDate.now()));
            stm.setString(5, this.getTrang_thai_khoanthu());
            stm.setInt(6, this.getTong_thu());
            stm.setString(7, this.getGhi_chu());
        } catch (SQLException ex) {
            Logger.getLogger(khoan_thu_phichungcu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String insertQuery() {
        return " Insert into khoan_thu_phichungcu(Ten_KThu, Phi_dichvu, Phi_quanly, Ngaytao_KThu, Trang_thai_khoanthu, Tong_thu, Ghi_chu)"
                + " Values (?,?,?,?,?,?,?) ";
    }

    @Override
    public khoan_thu Clone_() {
        khoan_thu_phichungcu kt = new khoan_thu_phichungcu();
        return kt;
    }

    public int getPhi_dichvu() {
        return Phi_dichvu;
    }

    public void setPhi_dichvu(int phi_dichvu) {
        Phi_dichvu = phi_dichvu;
    }

    public int getPhi_quanly() {
        return Phi_quanly;
    }

    public void setPhi_quanly(int phi_quanly) {
        Phi_quanly = phi_quanly;
    }

}

