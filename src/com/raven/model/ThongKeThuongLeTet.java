package com.raven.model;

public class ThongKeThuongLeTet {
    private int maHo;
    private String tenChuHo;
    private int soLuongPhanQua;
    // Thêm các thuộc tính khác nếu cần

    // Constructor mặc định
    public ThongKeThuongLeTet() {
    }

    // Constructor với tất cả các thuộc tính
    public ThongKeThuongLeTet(int maHo, String tenChuHo, int soLuongPhanQua) {
        this.maHo = maHo;
        this.tenChuHo = tenChuHo;
        this.soLuongPhanQua = soLuongPhanQua;
    }

    // Getter và Setter cho maHo
    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    // Getter và Setter cho tenChuHo
    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    // Getter và Setter cho soLuongPhanQua
    public int getSoLuongPhanQua() {
        return soLuongPhanQua;
    }

    public void setSoLuongPhanQua(int soLuongPhanQua) {
        this.soLuongPhanQua = soLuongPhanQua;
    }

    // Thêm các getter và setter khác nếu bạn có thêm thuộc tính

    // Phương thức toString() để in thông tin đối tượng (nếu cần)
    @Override
    public String toString() {
        return "ThongKeThuongLeTet{" +
                "maHo=" + maHo +
                ", tenChuHo='" + tenChuHo + '\'' +
                ", soLuongPhanQua=" + soLuongPhanQua +
                // Thêm các thuộc tính khác vào đây
                '}';
    }
}
