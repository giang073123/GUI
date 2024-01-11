package com.raven.model;
import java.util.Date;

public class Dstamvang {
    private String cccd;
    private int maHo;
    private String hoTen;
    private String sdt;
    private String diachiTv;
    private Date tvTuNgay;
    private Date tvDenNgay;
    private String lyDo;

    // Constructor mặc định
    public Dstamvang() {
    }

    // Constructor đầy đủ các thuộc tính
    public Dstamvang(String cccd, int maHo, String hoTen, String diachiTv, Date tvTuNgay, Date tvDenNgay, String lyDo) {
        this.cccd = cccd;
        this.maHo = maHo;
        this.hoTen = hoTen;
        this.diachiTv = diachiTv;
        this.tvTuNgay = tvTuNgay;
        this.tvDenNgay = tvDenNgay;
        this.lyDo = lyDo;
        this.sdt = sdt;
    }

    // Getters và Setters
    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachiTv() {
        return diachiTv;
    }

    public void setDiachiTv(String diachiTv) {
        this.diachiTv = diachiTv;
    }

    public Date getTvTuNgay() {
        return tvTuNgay;
    }

    public void setTvTuNgay(Date tvTuNgay) {
        this.tvTuNgay = tvTuNgay;
    }

    public Date getTvDenNgay() {
        return tvDenNgay;
    }

    public void setTvDenNgay(Date tvDenNgay) {
        this.tvDenNgay = tvDenNgay;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Dstamvang{" +
                "cccd='" + cccd + '\'' +
                ", maHo=" + maHo +
                ", hoTen='" + hoTen + '\'' +
                ", diachiTv='" + diachiTv + '\'' +
                ", tvTuNgay=" + tvTuNgay +
                ", tvDenNgay=" + tvDenNgay +
                ", lyDo='" + lyDo + '\'' +
                ", sdt='" + sdt + '\'' + // Include SDT in the toString method
                '}';
    }
}
