package Model.NhanKhau;

public class ho_gia_dinh {
    private int Ma_Ho; // Ma_Ho
    private String CCCD_Chuho; // CCCD_Chuho
    private int So_nha; // So_nha
    private double Dien_tich; // Dien_tich
    private String Duong_; // Duong_
    private String Phuong_; // Phuong_
    private String Quan_; // Quan_




    public ho_gia_dinh(int Ma_Ho, String CCCD_Chuho, int So_nha, double Dien_tich,
                       String Duong_, String Phuong_, String Quan_) {
        this.Ma_Ho = Ma_Ho;
        this.CCCD_Chuho = CCCD_Chuho;
        this.So_nha = So_nha;
        this.Dien_tich = Dien_tich;
        this.Duong_ = Duong_;
        this.Phuong_ = Phuong_;
        this.Quan_ = Quan_;
    }

    public ho_gia_dinh(){}

    public ho_gia_dinh clone_(){
        ho_gia_dinh f = new ho_gia_dinh();
        f.setMa_Ho(this.getMa_Ho());
        f.setCCCD_Chuho(this.getCCCD_Chuho());
        f.setSo_nha(this.getSo_nha());
        f.setDien_tich(this.getDien_tich());
        f.setDuong_(this.getDuong_());
        f.setPhuong_(this.getPhuong_());
        f.setQuan_(this.getQuan_());
        return f;
    }

    public int getMa_Ho() {
        return Ma_Ho;
    }

    public void setMa_Ho(int Ma_Ho) {
        this.Ma_Ho = Ma_Ho;
    }

    public String getCCCD_Chuho() {
        return CCCD_Chuho;
    }

    public void setCCCD_Chuho(String CCCD_Chuho) {
        this.CCCD_Chuho = CCCD_Chuho;
    }

    public int getSo_nha() {
        return So_nha;
    }

    public void setSo_nha(int So_nha) {
        this.So_nha = So_nha;
    }

    public double getDien_tich() {
        return Dien_tich;
    }

    public void setDien_tich(double Dien_tich) {
        this.Dien_tich = Dien_tich;
    }

    public String getDuong_() {
        return Duong_;
    }

    public void setDuong_(String Duong_) {
        this.Duong_ = Duong_;
    }

    public String getPhuong_() {
        return Phuong_;
    }

    public void setPhuong_(String Phuong_) {
        this.Phuong_ = Phuong_;
    }

    public String getQuan_() {
        return Quan_;
    }

    public void setQuan_(String Quan_) {
        this.Quan_ = Quan_;
    }


}


