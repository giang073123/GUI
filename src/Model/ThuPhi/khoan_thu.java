package Model.ThuPhi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class khoan_thu {

    protected int MS_KThu;
    protected String Ten_KThu;
    protected java.sql.Date Ngaytao_KThu;
    protected java.sql.Date Ngaykthuc_KThu;
    protected String Trang_thai_khoanthu;
    protected int Tong_thu;
    protected String Ghi_chu;

    protected String table_name;
    protected String ds_table_name;


    protected ArrayList<String> col_name = new ArrayList<>();


    public khoan_thu() {

    }


    // For overriding

    public void getDataFromRs(ResultSet rs) {

    }

    public void setDataForStm(PreparedStatement stm) {
    }

    public String insertQuery() {
        return null;
    }

    public khoan_thu Clone_() {
        return null;
    }


    //
/*
    @Override
    public Object clone()throws CloneNotSupportedException{
         return this.clone();
    }
 */

    public int getMS_KThu() {
        return MS_KThu;
    }

    public void setMS_KThu(int mS_KThu) {
        MS_KThu = mS_KThu;
    }

    public String getTen_KThu() {
        return Ten_KThu;
    }

    public void setTen_KThu(String ten_KThu) {
        Ten_KThu = ten_KThu;
    }

    public java.sql.Date getNgaytao_KThu() {
        return Ngaytao_KThu;
    }

    public void setNgaytao_KThu(java.sql.Date ngaytao_KThu) {
        Ngaytao_KThu = ngaytao_KThu;
    }

    public java.sql.Date getNgaykthuc_KThu() {
        return Ngaykthuc_KThu;
    }

    public void setNgaykthuc_KThu(java.sql.Date ngaykthuc_KThu) {
        Ngaykthuc_KThu = ngaykthuc_KThu;
    }

    public String getTrang_thai_khoanthu() {
        return Trang_thai_khoanthu;
    }

    public void setTrang_thai_khoanthu(String Trang_thai_khoanthu) {
        this.Trang_thai_khoanthu = Trang_thai_khoanthu;
    }

    public int getTong_thu() {
        return Tong_thu;
    }

    public void setTong_thu(int tong_thu) {
        Tong_thu = tong_thu;
    }

    public String getGhi_chu() {
        return Ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        Ghi_chu = ghi_chu;
    }

    public String getTable_name() {
        return table_name;
    }

    public ArrayList<String> getCol_name() {
        return col_name;
    }

    public String getDs_table_name() {
        return ds_table_name;
    }
}