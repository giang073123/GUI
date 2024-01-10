package com.raven.model;
public class HoGiaDinh {
    private int maHo;
    private String cccdChuHo;
    private int soNha;
    private double dienTich;
    private String duong;
    private String phuong;
    private String quan;
    private String trangThaiHo;

    // Default constructor
    public HoGiaDinh() {
    }

    // Parameterized constructor
    public HoGiaDinh(int maHo, String cccdChuHo, int soNha, double dienTich, String duong, String phuong, String quan, String trangThaiHo) {
        this.maHo = maHo;
        this.cccdChuHo = cccdChuHo;
        this.soNha = soNha;
        this.dienTich = dienTich;
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.trangThaiHo = trangThaiHo;
    }

    // Getters and setters for maHo
    public int getMaHo() {
        return maHo;
    }

    public void setMaHo(int maHo) {
        this.maHo = maHo;
    }

    // Getters and setters for cccdChuHo
    public String getCccdChuHo() {
        return cccdChuHo;
    }

    public void setCccdChuHo(String cccdChuHo) {
        this.cccdChuHo = cccdChuHo;
    }

    // Getters and setters for soNha
    public int getSoNha() {
        return soNha;
    }

    public void setSoNha(int soNha) {
        this.soNha = soNha;
    }

    // Getters and setters for dienTich
    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    // Getters and setters for duong
    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    // Getters and setters for phuong
    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    // Getters and setters for quan
    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    // Getters and setters for trangThaiHo
    public String getTrangThaiHo() {
        return trangThaiHo;
    }

    public void setTrangThaiHo(String trangThaiHo) {
        this.trangThaiHo = trangThaiHo;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "HoGiaDinh{" +
                "maHo=" + maHo +
                ", cccdChuHo='" + cccdChuHo + '\'' +
                ", soNha=" + soNha +
                ", dienTich=" + dienTich +
                ", duong='" + duong + '\'' +
                ", phuong='" + phuong + '\'' +
                ", quan='" + quan + '\'' +
                ", trangThaiHo='" + trangThaiHo + '\'' +
                '}';
    }
}
