package Model.ThuPhi;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class thu_tien_khac extends thu_tien {

    private String Loai_KThu;


    public thu_tien_khac(){table_name="ds_thu_tien_khac";}

    @Override
    public void getDataFromRs(ResultSet resultSet){
        try {

            // Set values using setter methods
            this.setMS_KThu(resultSet.getInt("MS_KThu"));
            this.setMa_Ho(resultSet.getInt("Ma_Ho"));
            this.setLoai_KThu(resultSet.getString("Loai_KThu"));
            this.setSo_tien(resultSet.getInt("So_tien"));
            this.setTrangthai_Thu(resultSet.getString("Trangthai_Thu"));
            this.setNgay_thu(resultSet.getDate("Ngay_thu"));

        } catch (SQLException ex) {
            //Logger.getLogger(khoan_thu_phichungcu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void setDataForStm(PreparedStatement statement){    // CHÚ Ý: CHỈ Dùng cho thao tác UPDATE
        try {

            statement.setString(1, this.getLoai_KThu());
            statement.setInt(2, this.getSo_tien());
            statement.setString(3, this.getTrangthai_Thu());
            statement.setDate(4, new Date(this.getNgay_thu().getTime()));
            statement.setInt(5, this.getMS_KThu());
            statement.setInt(6, this.getMa_Ho());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    //@Override
    public String insertQuery(){ return "INSERT INTO ds_thu_tien_khac (MS_KThu, Ma_Ho,Loai_KThu, "
            + " So_tien, Trangthai_Thu, Ngay_thu) "
            + "VALUES (?, ?, ?, ?, ?,?)";}

    @Override
    public String updateQuery(){return "UPDATE ds_thu_tien_guixe SET"
            + "So_tien = ?, Trangthai_Thu = ?, Ngay_thu = ? WHERE MS_KThu = ? AND Ma_Ho = ? ";}

    @Override
    public thu_tien Clone_() {
        return new thu_tien_khac();
    }

    public String getLoai_KThu() {
        return Loai_KThu;
    }

    public void setLoai_KThu(String Loai_KThu) {
        this.Loai_KThu = Loai_KThu;
    }


}

