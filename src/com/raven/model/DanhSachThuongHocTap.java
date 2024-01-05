package com.raven.model;

import java.util.Date;

public class DanhSachThuongHocTap {
    private int msKThg;
    private String hoTen;
    private String cccd;
    private int maHo;
    private String truongHoc;
    private String thanhTich;
    private String minhChung;
    private int giaTriPhanQua;
    private String trangThaiKhoanThuong;
    private Date ngayThuong;
    private Date ngaySinh;
    // Getters
    public int getMsKThg() {
        return msKThg;
    }

    public String getHoTen() {
        return hoTen;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public String getCccd() {
        return cccd;
    }

    public int getMaHo() {
        return maHo;
    }

    public String getTruongHoc() {
        return truongHoc;
    }

    public String getThanhTich() {
        return thanhTich;
    }

    public String getMinhChung() {
        return minhChung;
    }

    public int getGiaTriPhanQua() {
        return giaTriPhanQua;
    }

    public String getTrangThaiKhoanThuong() {
        return trangThaiKhoanThuong;
    }

    public Date getNgayThuong() {
        return ngayThuong;
    }

    // Setters
    public void setMsKThg(int msKThg) {
        this.msKThg = msKThg;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    public void setTruongHoc(String truongHoc) {
        this.truongHoc = truongHoc;
    }

    public void setThanhTich(String thanhTich) {
        this.thanhTich = thanhTich;
    }

    public void setMinhChung(String minhChung) {
        this.minhChung = minhChung;
    }

    public void setGiaTriPhanQua(int giaTriPhanQua) {
        this.giaTriPhanQua = giaTriPhanQua;
    }

    public void setTrangThaiKhoanThuong(String trangThaiKhoanThuong) {
        this.trangThaiKhoanThuong = trangThaiKhoanThuong;
    }

    public void setNgayThuong(Date ngayThuong) {
        this.ngayThuong = ngayThuong;
    }

    // toString Method
    @Override
    public String toString() {
        return "DanhSachThuongHocTap{" +
                "msKThg=" + msKThg +
                ", hoTen='" + hoTen + '\'' +
                ", cccd='" + cccd + '\'' +
                ", maHo=" + maHo +
                ", truongHoc='" + truongHoc + '\'' +
                ", thanhTich='" + thanhTich + '\'' +
                ", minhChung='" + minhChung + '\'' +
                ", giaTriPhanQua=" + giaTriPhanQua +
                ", trangThaiKhoanThuong='" + trangThaiKhoanThuong + '\'' +
                ", ngayThuong=" + ngayThuong +
                '}';
    }
}
