package Model.ThuPhi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class thu_tien {

    protected int MS_KThu;
    protected int Ma_Ho;
    protected int So_tien;
    protected String Trangthai_Thu;
    protected java.sql.Date Ngay_thu;

    protected String table_name;
    protected ArrayList<String> col_name;

    public thu_tien() {}




    // For overriding

    public void getDataFromRs(ResultSet rs){

    }

    public void setDataForStm(PreparedStatement stm, String trang_thai){}


    // public String insertQuery(){ return null;}

    public String updateQuery(String trang_thai){ return null;}

    public thu_tien Clone_() {
        return null;
    }


    public int getMS_KThu() {
        return MS_KThu;
    }
    public void setMS_KThu(int mS_KThu) {
        MS_KThu = mS_KThu;
    }
    public int getMa_Ho() {
        return Ma_Ho;
    }
    public void setMa_Ho(int ma_Ho) {
        Ma_Ho = ma_Ho;
    }
    public int getSo_tien() {
        return So_tien;
    }
    public void setSo_tien(int so_tien) {
        So_tien = so_tien;
    }
    public String getTrangthai_Thu() {
        return Trangthai_Thu;
    }
    public void setTrangthai_Thu(String trang_thai) {
        Trangthai_Thu = trang_thai;
    }
    public java.sql.Date getNgay_thu() {
        return Ngay_thu;
    }
    public void setNgay_thu(java.sql.Date ngay_thu) {
        Ngay_thu = ngay_thu;
    }

    public String getTable_name() {
        return table_name;
    }

    public ArrayList<String> getCol_name() {
        return col_name;
    }
}
