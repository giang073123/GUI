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
public class khoan_thu_guixe extends khoan_thu {

    private int phi_xe_dap;
    private int phi_xe_may;
    private int phi_xe_oto;

    public khoan_thu_guixe() {
        // TODO Auto-generated constructor stub
        table_name = "khoan_thu_guixe";
        ds_table_name = "ds_thu_tien_guixe";
        col_name.add(0, "MS_KThu");
        col_name.add(1, "Ten_KThu");
        col_name.add(2, "phi_xe_dap");
        col_name.add(3, "phi_xe_may");
        col_name.add(4, "phi_xe_oto");
        col_name.add(5, "Ngaytao_KThu");
        col_name.add(6, "Ngaykthuc_KThu");
        col_name.add(7, "Trang_thai_khoanthu");
        col_name.add(8, "Tong_thu");
        col_name.add(9, "Ghi_chu");
    }


    @Override
    public void getDataFromRs(ResultSet resultSet) {
        try {

            this.setMS_KThu(resultSet.getInt("MS_KThu"));
            this.setTen_KThu(resultSet.getString("Ten_KThu"));
            this.setPhi_xe_dap(resultSet.getInt("phi_xe_dap"));
            this.setPhi_xe_may(resultSet.getInt("phi_xe_may"));
            this.setPhi_xe_oto(resultSet.getInt("phi_xe_oto"));
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
            stm.setInt(2, this.getPhi_xe_dap());
            stm.setInt(3, this.getPhi_xe_may());
            stm.setInt(4, this.getPhi_xe_oto());
            stm.setDate(5, Date.valueOf(LocalDate.now()));
            stm.setString(6, this.getTrang_thai_khoanthu());
            stm.setInt(7, this.getTong_thu());
            stm.setString(8, this.getGhi_chu());
        } catch (SQLException ex) {
            Logger.getLogger(khoan_thu_phichungcu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String insertQuery(){ return " Insert into khoan_thu_guixe(Ten_KThu, phi_xe_dap, phi_xe_may,phi_xe_oto, Ngaytao_KThu, Trang_thai_khoanthu, Tong_thu, Ghi_chu)"
            + " Values (?,?,?,?,?,?,?,?) ";}


    @Override
    public khoan_thu Clone_() {
        khoan_thu_guixe kt = new khoan_thu_guixe();
        return kt;
    }


    public int getPhi_xe_dap() {
        return phi_xe_dap;
    }

    public void setPhi_xe_dap(int phi_xe_dap) {
        this.phi_xe_dap = phi_xe_dap;
    }

    public int getPhi_xe_may() {
        return phi_xe_may;
    }

    public void setPhi_xe_may(int phi_xe_may) {
        this.phi_xe_may = phi_xe_may;
    }

    public int getPhi_xe_oto() {
        return phi_xe_oto;
    }

    public void setPhi_xe_oto(int phi_xe_oto) {
        this.phi_xe_oto = phi_xe_oto;
    }

}

