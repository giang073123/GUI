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
public class thu_tien_phichungcu extends thu_tien {
    private float Dien_tich;

    public thu_tien_phichungcu(){table_name="ds_thu_tien_phichungcu";}

    @Override
    public void getDataFromRs(ResultSet resultSet){
        try {

            // Set values using setter methods
            this.setMS_KThu(resultSet.getInt("MS_KThu"));
            this.setMa_Ho(resultSet.getInt("Ma_Ho"));
            this.setDien_tich(resultSet.getFloat("Dien_tich"));
            this.setSo_tien(resultSet.getInt("So_tien"));
            this.setTrangthai_Thu(resultSet.getString("Trangthai_Thu"));
            this.setNgay_thu(resultSet.getDate("Ngay_thu"));

        } catch (SQLException ex) {
            //Logger.getLogger(khoan_thu_phichungcu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void setDataForStm(PreparedStatement statement){     // CHÚ Ý: CHỈ Dùng cho thao tác UPDATE  (không cần thao tác INSERT)
        try {
            this.setNgay_thu(java.sql.Date.valueOf(LocalDate.now()));
            statement.setFloat(1, this.getDien_tich());
            statement.setInt(2, this.getSo_tien());
            statement.setString(3, this.getTrangthai_Thu());
            statement.setDate(4, new Date(this.getNgay_thu().getTime()));
            statement.setInt(5, this.getMS_KThu());
            statement.setInt(6, this.getMa_Ho());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }


    @Override
    public String updateQuery(){return "UPDATE ds_thu_tien_phichungcu "
            + "SET Dien_tich = ? ,"
            + "So_tien = ?, Trangthai_Thu = ?, Ngay_thu = ? WHERE MS_KThu = ? AND Ma_Ho = ? ";}



    @Override
    public thu_tien Clone_() {
        return new thu_tien_phichungcu();
    }




    public float getDien_tich() {
        return Dien_tich;
    }

    public void setDien_tich(float Dien_tich) {
        this.Dien_tich = Dien_tich;
    }
}

