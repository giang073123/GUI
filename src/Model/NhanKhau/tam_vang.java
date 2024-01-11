package Model.NhanKhau;

import java.sql.Date;

public class tam_vang {
    private String CCCD;
    private int Ma_Ho;
    private String Ho_Ten;

    private String Diachi_tv;
    private Date Tv_tu_ngay;
    private Date Tv_den_ngay;
    private String Ly_do;

   public tam_vang(){}

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public int getMa_Ho() {
        return Ma_Ho;
    }

    public void setMa_Ho(int Ma_Ho) {
        this.Ma_Ho = Ma_Ho;
    }

    public String getHo_Ten() {
        return Ho_Ten;
    }

    public void setHo_Ten(String Ho_Ten) {
        this.Ho_Ten = Ho_Ten;
    }



    public String getDiachi_tv() {
        return Diachi_tv;
    }

    public void setDiachi_tv(String Diachi_tv) {
        this.Diachi_tv = Diachi_tv;
    }

    public Date getTv_tu_ngay() {
        return Tv_tu_ngay;
    }

    public void setTv_tu_ngay(Date Tv_tu_ngay) {
        this.Tv_tu_ngay = Tv_tu_ngay;
    }

    public Date getTv_den_ngay() {
        return Tv_den_ngay;
    }

    public void setTv_den_ngay(Date Tv_den_ngay) {
        this.Tv_den_ngay = Tv_den_ngay;
    }

    public String getLy_do() {
        return Ly_do;
    }

    public void setLy_do(String Ly_do) {
        this.Ly_do = Ly_do;
    }
}

