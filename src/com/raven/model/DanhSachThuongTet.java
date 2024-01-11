package com.raven.model;
import com.raven.model.QuanLyThuongTetdata;

import java.sql.Date;

public class DanhSachThuongTet {
    private int maHo;
    private String hoTen;
    private String CCCD;
    private Date ngaySinh;
    private int giaTriPhanQua;
    private String trangThaiPhatThuong;
    private Date ngayThuong;
    private int maSo;
    private int msKThg;

    // Constructor không tham số
    public DanhSachThuongTet() {
    }

    // Constructor với tham số
    public DanhSachThuongTet(int maHo, String hoTen, String CCCD, Date ngaySinh, int giaTriPhanQua, String trangThaiPhatThuong, Date ngayThuong, int maSo) {
        this.maHo = maHo;
        this.hoTen = hoTen;
        this.CCCD = CCCD;
        this.ngaySinh = ngaySinh;
        this.giaTriPhanQua = giaTriPhanQua;
        this.trangThaiPhatThuong = trangThaiPhatThuong;
        this.ngayThuong = ngayThuong;
        this.maSo = maSo;
    }
    public int getMsKThg() {
        return msKThg;
    }

    public void setMsKThg(int msKThg) {
        this.msKThg = msKThg;
    }
    // Getter và Setter cho các thuộc tính
    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }
    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }
    public int getMaSo() {
        return maSo;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGiaTriPhanQua() {
        return giaTriPhanQua;
    }

    public void setGiaTriPhanQua(int giaTriPhanQua) {
        this.giaTriPhanQua = giaTriPhanQua;
    }

    public String getTrangThaiPhatThuong() {
        return trangThaiPhatThuong;
    }

    public void setTrangThaiPhatThuong(String trangThaiPhatThuong) {
        this.trangThaiPhatThuong = trangThaiPhatThuong;
    }

    public Date getNgayThuong() {
        return ngayThuong;
    }

    public void setNgayThuong(Date ngayThuong) {
        this.ngayThuong = ngayThuong;
    }

    // Phương thức toString() có thể được ghi đè để in ra thông tin đối tượng
    @Override
    public String toString() {
        return "DanhSachThuongTet{" +
                "maHo=" + maHo +
                ", hoTen='" + hoTen + '\'' +
                ", CCCD='" + CCCD + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", giaTriPhanQua=" + giaTriPhanQua +
                ", trangThaiPhatThuong='" + trangThaiPhatThuong + '\'' +
                ", ngayThuong=" + ngayThuong +
                '}';
    }
}
