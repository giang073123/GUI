package com.raven.model;

import java.sql.Date;

public class QuanLyThuongTetdata {
    private int msKThg;
    private String tenKhoanThuong;
    private int giaTriPhanQua;
    private Date ngayTao;
    private Date ngayKetThuc;
    private String trangThai;
    private int tongThuong;
    private String ghiChu;

    // Constructor không tham số
    public QuanLyThuongTetdata() {
    }

    // Constructor với tất cả các thuộc tính
    public QuanLyThuongTetdata(int msKThg, String tenKhoanThuong, int giaTriPhanQua, Date ngayTao, Date ngayKetThuc, String trangThai, int tongThuong, String ghiChu) {
        this.msKThg = msKThg;
        this.tenKhoanThuong = tenKhoanThuong;
        this.giaTriPhanQua = giaTriPhanQua;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.tongThuong = tongThuong;
        this.ghiChu = ghiChu;
    }

    // Getter cho msKThg
    public int getMsKThg() {
        return msKThg;
    }

    // Setter cho msKThg
    public void setMsKThg(int msKThg) {
        this.msKThg = msKThg;
    }

    // Getter cho tenKhoanThuong
    public String getTenKhoanThuong() {
        return tenKhoanThuong;
    }

    // Setter cho tenKhoanThuong
    public void setTenKhoanThuong(String tenKhoanThuong) {
        this.tenKhoanThuong = tenKhoanThuong;
    }

    // Getter cho giaTriPhanQua
    public int getGiaTriPhanQua() {
        return giaTriPhanQua;
    }

    // Setter cho giaTriPhanQua
    public void setGiaTriPhanQua(int giaTriPhanQua) {
        this.giaTriPhanQua = giaTriPhanQua;
    }

    // Getter cho ngayTao
    public Date getNgayTao() {
        return ngayTao;
    }

    // Setter cho ngayTao
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    // Getter cho ngayKetThuc
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    // Setter cho ngayKetThuc
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    // Getter cho trangThai
    public String getTrangThai() {
        return trangThai;
    }

    // Setter cho trangThai
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Getter cho tongThuong
    public int getTongThuong() {
        return tongThuong;
    }

    // Setter cho tongThuong
    public void setTongThuong(int tongThuong) {
        this.tongThuong = tongThuong;
    }

    // Getter cho ghiChu
    public String getGhiChu() {
        return ghiChu;
    }

    // Setter cho ghiChu
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    // Override phương thức toString() nếu bạn muốn in ra thông tin đối tượng
    @Override
    public String toString() {
        return "QuanLyThuongTet{" +
                "msKThg=" + msKThg +
                ", tenKhoanThuong='" + tenKhoanThuong + '\'' +
                ", giaTriPhanQua=" + giaTriPhanQua +
                ", ngayTao=" + ngayTao +
                ", ngayKetThuc=" + ngayKetThuc +
                ", trangThai='" + trangThai + '\'' +
                ", tongThuong=" + tongThuong +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
