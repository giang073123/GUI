package com.raven.model;

import java.util.Date;

public class NhanKhau {
    private String cccd;
    private int maHo;
    private String hoTen;
    private String qhChuHo;
    private String biDanh;
    private String gioiTinh;
    private Date ngaySinh;
    private String noiSinh;
    private String nguyenQuan;
    private String danToc;
    private String ngheNghiep;
    private Date ngayDKTT; // Đăng ký thường trú
    private String noiOTruoc;
    private String trangThaiNhanKhau;
    // Constructor mặc định
    public NhanKhau() {
        // Khởi tạo mặc định
    }

    // Constructor đầy đủ các tham số
    public NhanKhau(String cccd, int maHo, String hoTen, String qhChuHo, String biDanh, String gioiTinh, Date ngaySinh, String noiSinh, String nguyenQuan, String danToc, String ngheNghiep, Date ngayDKTT, String noiOTruoc, String trangThaiNhanKhau) {
        this.cccd = cccd;
        this.maHo = maHo;
        this.hoTen = hoTen;
        this.qhChuHo = qhChuHo;
        this.biDanh = biDanh;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.ngheNghiep = ngheNghiep;
        this.ngayDKTT = ngayDKTT;
        this.noiOTruoc = noiOTruoc;
        this.trangThaiNhanKhau = trangThaiNhanKhau;
    }

    public String getCCCD() {
        return cccd;
    }

    public void setCCCD(String cccd) {
        this.cccd = cccd;
    }

    // Phương thức getter và setter cho maHo
    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    // Phương thức getter và setter cho hoTen
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    // Phương thức getter và setter cho qhChuHo
    public String getQhChuHo() {
        return qhChuHo;
    }

    public void setQhChuHo(String qhChuHo) {
        this.qhChuHo = qhChuHo;
    }

    // Phương thức getter và setter cho biDanh
    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    // Phương thức getter và setter cho gioiTinh
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    // Phương thức getter và setter cho ngaySinh
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    // Phương thức getter và setter cho noiSinh
    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    // Phương thức getter và setter cho nguyenQuan
    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    // Phương thức getter và setter cho danToc
    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    // Phương thức getter và setter cho ngheNghiep
    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    // Phương thức getter và setter cho ngayDKTT
    public Date getNgayDKTT() {
        return ngayDKTT;
    }

    public void setNgayDKTT(Date ngayDKTT) {
        this.ngayDKTT = ngayDKTT;
    }

    // Phương thức getter và setter cho noiOTruoc
    public String getNoiOTruoc() {
        return noiOTruoc;
    }

    public void setNoiOTruoc(String noiOTruoc) {
        this.noiOTruoc = noiOTruoc;
    }

    // Phương thức getter và setter cho trangThaiNhanKhau
    public String getTrangThaiNhanKhau() {
        return trangThaiNhanKhau;
    }

    public void setTrangThaiNhanKhau(String trangThaiNhanKhau) {
        this.trangThaiNhanKhau = trangThaiNhanKhau;
    }
    @Override
    public String toString() {
        return "NhanKhau{" +
                "cccd='" + cccd + '\'' +
                ", maHo=" + maHo +
                ", hoTen='" + hoTen + '\'' +
                ", qhChuHo='" + qhChuHo + '\'' +
                ", biDanh='" + biDanh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", noiSinh='" + noiSinh + '\'' +
                ", nguyenQuan='" + nguyenQuan + '\'' +
                ", danToc='" + danToc + '\'' +
                ", ngheNghiep='" + ngheNghiep + '\'' +
                ", ngayDKTT=" + ngayDKTT +
                ", noiOTruoc='" + noiOTruoc + '\'' +
                ", trangThaiNhanKhau='" + trangThaiNhanKhau + '\'' +
                '}';
    }
}
