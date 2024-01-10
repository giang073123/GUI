package com.raven.model;
import java.util.Date;

public class Dstamtru {
    private String cccd;
    private int maHo;
    private String hoTen;
    private String sdt;
    private String diachiThuongtru;
    private int soNha;
    private String duong;
    private Date ttTuNgay;
    private Date ttDenNgay;

    // Getters
    public String getCccd() {
        return cccd;
    }

    public int getMaHo() {
        return maHo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachiThuongtru() {
        return diachiThuongtru;
    }

    public int getSoNha() {
        return soNha;
    }

    public String getDuong() {
        return duong;
    }

    public Date getTtTuNgay() {
        return ttTuNgay;
    }

    public Date getTtDenNgay() {
        return ttDenNgay;
    }

    // Setters
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachiThuongtru(String diachiThuongtru) {
        this.diachiThuongtru = diachiThuongtru;
    }

    public void setSoNha(int soNha) {
        this.soNha = soNha;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public void setTtTuNgay(Date ttTuNgay) {
        this.ttTuNgay = ttTuNgay;
    }

    public void setTtDenNgay(Date ttDenNgay) {
        this.ttDenNgay = ttDenNgay;
    }
    public String toString() {
        return "Dstamtru{" +
                "cccd='" + cccd + '\'' +
                ", maHo=" + maHo +
                ", hoTen='" + hoTen + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diachiThuongtru='" + diachiThuongtru + '\'' +
                ", soNha=" + soNha +
                ", duong='" + duong + '\'' +
                ", ttTuNgay=" + ttTuNgay +
                ", ttDenNgay=" + ttDenNgay +
                '}';
    }
}
