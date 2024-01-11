package com.raven.model;

import java.util.Date;

public class LichSuThuongHocTap {
    private int msKThg;
    private String tenKThg;
    private int thuongHsgDacBiet;
    private int thuongHstt;
    private int thuongKhac;
    private Date ngayTaoKThg;
    private Date ngayKetThucKThg;
    private String trangThai; // This should match the column name in your database.
    private int tongThuong;
    private String ghiChu;


    // Constructor không tham số
    public LichSuThuongHocTap() {
    }

    // Constructor với tất cả các thuộc tính
    public LichSuThuongHocTap(int msKThg, String tenKThg, int thuongHsgDacBiet,
                              int thuongHstt, int thuongKhac, Date ngayTaoKThg,
                              Date ngayKetThucKThg, String trangThai, // Thêm tham số này
                              int tongThuong, String ghiChu) {
        this.msKThg = msKThg;
        this.tenKThg = tenKThg;
        this.thuongHsgDacBiet = thuongHsgDacBiet;
        this.thuongHstt = thuongHstt;
        this.thuongKhac = thuongKhac;
        this.ngayTaoKThg = ngayTaoKThg;
        this.ngayKetThucKThg = ngayKetThucKThg;
        this.trangThai = trangThai; // Gán giá trị cho thuộc tính mới
        this.tongThuong = tongThuong;
        this.ghiChu = ghiChu;
    }

    // Getter và Setter cho msKThg
    public int getMsKThg() {
        return msKThg;
    }

    public void setMsKThg(int msKThg) {
        this.msKThg = msKThg;
    }

    // Getter và Setter cho tenKThg
    public String getTenKThg() {
        return tenKThg;
    }
    public String getTrangThai() {

        return trangThai;
    }
    public void setTenKThg(String tenKThg) {
        this.tenKThg = tenKThg;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    // Getter và Setter cho thuongHsgDacBiet
    public int getThuongHsgDacBiet() {
        return thuongHsgDacBiet;
    }

    public void setThuongHsgDacBiet(int thuongHsgDacBiet) {
        this.thuongHsgDacBiet = thuongHsgDacBiet;
    }

    // Getter và Setter cho thuongHstt
    public int getThuongHstt() {
        return thuongHstt;
    }

    public void setThuongHstt(int thuongHstt) {
        this.thuongHstt = thuongHstt;
    }

    // Getter và Setter cho thuongKhac
    public int getThuongKhac() {
        return thuongKhac;
    }

    public void setThuongKhac(int thuongKhac) {
        this.thuongKhac = thuongKhac;
    }

    // Getter và Setter cho ngayTaoKThg
    public Date getNgayTaoKThg() {
        return ngayTaoKThg;
    }

    public void setNgayTaoKThg(Date ngayTaoKThg) {
        this.ngayTaoKThg = ngayTaoKThg;
    }

    // Getter và Setter cho ngayKetThucKThg
    public Date getNgayKetThucKThg() {
        return ngayKetThucKThg;
    }

    public void setNgayKetThucKThg(Date ngayKetThucKThg) {
        this.ngayKetThucKThg = ngayKetThucKThg;
    }


    public int getTongThuong() {
        return tongThuong;
    }

    public void setTongThuong(int tongThuong) {
        this.tongThuong = tongThuong;
    }

    // Getter và Setter cho ghiChu
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    // Override phương thức toString()
    @Override
    public String toString() {
        return "LichSuThuongHocTap{" +
                "msKThg=" + msKThg +
                ", tenKThg='" + tenKThg + '\'' +
                ", thuongHsgDacBiet=" + thuongHsgDacBiet +
                ", thuongHstt=" + thuongHstt +
                ", thuongKhac=" + thuongKhac +
                ", ngayTaoKThg=" + ngayTaoKThg +
                ", ngayKetThucKThg=" + ngayKetThucKThg +
                ", trangThai='" + trangThai + '\'' + // In ra trạng thái khoản thưởng
                ", tongThuong=" + tongThuong +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
