package Model.ThuPhi;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class thu_tien_guixe extends thu_tien {
    private int So_luong_xedap;
    private int So_luong_xemay;
    private int So_luong_oto;

    public thu_tien_guixe() {
        table_name="ds_thu_tien_guixe";
    }


    @Override
    public void getDataFromRs(ResultSet resultSet){
        try {

            // Set values using setter methods
            this.setMS_KThu(resultSet.getInt("MS_KThu"));
            this.setMa_Ho(resultSet.getInt("Ma_Ho"));
            this.setSo_luong_xedap(resultSet.getInt("So_luong_xedap"));
            this.setSo_luong_xemay(resultSet.getInt("So_luong_xemay"));
            this.setSo_luong_oto(resultSet.getInt("So_luong_oto"));
            this.setSo_tien(resultSet.getInt("So_tien"));
            this.setTrangthai_Thu(resultSet.getString("Trangthai_Thu"));
            this.setNgay_thu(resultSet.getDate("Ngay_thu"));

        } catch (SQLException ex) {
            //Logger.getLogger(khoan_thu_phichungcu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void setDataForStm(PreparedStatement statement){    // CHÚ Ý: CHỈ Dùng cho thao tác UPDATE  (không cần thao tác INSERT)
        try {
            this.setTrangthai_Thu("Đã thu");
            statement.setInt(1, this.getSo_luong_xedap());
            statement.setInt(2, this.getSo_luong_xemay());
            statement.setInt(3, this.getSo_luong_oto());
            statement.setInt(4, this.getSo_tien());
            statement.setString(5, this.getTrangthai_Thu());
            statement.setDate(6, new Date(this.getNgay_thu().getTime()));
            statement.setInt(7, this.getMS_KThu());
            statement.setInt(8, this.getMa_Ho());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }


    @Override
    public String updateQuery(){return "UPDATE ds_thu_tien_guixe "
            + "SET So_luong_xedap = ?, So_luong_xemay = ?,  So_luong_oto = ?, "
            + "So_tien = ?, Trangthai_Thu = ?, Ngay_thu = ? WHERE MS_KThu = ? AND Ma_Ho = ? ";}

    @Override
    public thu_tien Clone_() {
        return new thu_tien_guixe();
    }

    public int getSo_luong_xedap() {
        return So_luong_xedap;
    }

    public void setSo_luong_xedap(int So_luong_xedap) {
        this.So_luong_xedap = So_luong_xedap;
    }

    public int getSo_luong_xemay() {
        return So_luong_xemay;
    }

    public void setSo_luong_xemay(int So_luong_xemay) {
        this.So_luong_xemay = So_luong_xemay;
    }

    public int getSo_luong_oto() {
        return So_luong_oto;
    }

    public void setSo_luong_oto(int So_luong_oto) {
        this.So_luong_oto = So_luong_oto;
    }
}
