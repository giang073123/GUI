/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TaiKhoan;

/**
 *
 * @author Admin
 */public class can_bo {
    private int Ma_CB;
    private String CCCD;
    private String username;
    private String password;
    private String Ten_CB;
    private String Chuc_vu;
    

    // Constructors, getters, and setters

    public can_bo() {
        // Default constructor
    }

    public can_bo(int ma_CB, String cccd, String username, String password, String ten_CB, String chuc_vu) {
        this.Ma_CB = ma_CB;
        this.CCCD = cccd;
        this.username = username;
        this.password = password;
        this.Ten_CB = ten_CB;
        this.Chuc_vu = chuc_vu;
    }

    // Getters and setters for each attribute

    public int getMa_CB() {
        return Ma_CB;
    }

    public void setMa_CB(int ma_CB) {
        this.Ma_CB = ma_CB;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String cccd) {
        this.CCCD = cccd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen_CB() {
        return Ten_CB;
    }

    public void setTen_CB(String ten_CB) {
        this.Ten_CB = ten_CB;
    }

    public String getChuc_vu() {
        return Chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.Chuc_vu = chuc_vu;
    }
}

