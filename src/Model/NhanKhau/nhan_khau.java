package Model.NhanKhau;

import java.sql.Date;

public class nhan_khau {
    private String CCCD; // CCCD
    private int Ma_Ho; // Ma_Ho
    private String Ho_ten; // Ho_ten
    private String QH_chuho; // QH_chuho
    private String Bi_danh; // Bi_danh
    private String Gioi_tinh; // Gioi_tinh
    private Date Ngay_sinh; // Ngay_sinh
    private String Noi_sinh; // Noi_sinh
    private String Nguyen_quan; // Nguyen_quan
    private String Dan_toc; // Dan_toc
    private String Nghe_nghiep; // Nghe_nghiep
    private Date Ngay_DKTT; // Ngay_DKTT
    private String Noi_o_truoc; // Noi_o_truoc

    // Constructors, getters, and setters can be added here based on your requirements

    // Example constructor
    public nhan_khau(String CCCD, int Ma_Ho, String Ho_ten, String QH_chuho, String Bi_danh,
                     String Gioi_tinh, Date Ngay_sinh, String Noi_sinh, String Nguyen_quan,
                     String Dan_toc, String Nghe_nghiep, Date Ngay_DKTT, String Noi_o_truoc) {
        this.CCCD = CCCD;
        this.Ma_Ho = Ma_Ho;
        this.Ho_ten = Ho_ten;
        this.QH_chuho = QH_chuho;
        this.Bi_danh = Bi_danh;
        this.Gioi_tinh = Gioi_tinh;
        this.Ngay_sinh = Ngay_sinh;
        this.Noi_sinh = Noi_sinh;
        this.Nguyen_quan = Nguyen_quan;
        this.Dan_toc = Dan_toc;
        this.Nghe_nghiep = Nghe_nghiep;
        this.Ngay_DKTT = Ngay_DKTT;
        this.Noi_o_truoc = Noi_o_truoc;
    }

    public nhan_khau(){}

    // Example getters and setters
    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public int getMa_Ho() {
        return Ma_Ho;
    }

    public void setMa_Ho(int Ma_Ho) {
        this.Ma_Ho = Ma_Ho;
    }

    public String getHo_ten() {
        return Ho_ten;
    }

    public void setHo_ten(String Ho_ten) {
        this.Ho_ten = Ho_ten;
    }

    public String getQH_chuho() {
        return QH_chuho;
    }

    public void setQH_chuho(String QH_chuho) {
        this.QH_chuho = QH_chuho;
    }

    public String getBi_danh() {
        return Bi_danh;
    }

    public void setBi_danh(String Bi_danh) {
        this.Bi_danh = Bi_danh;
    }

    public String getGioi_tinh() {
        return Gioi_tinh;
    }

    public void setGioi_tinh(String Gioi_tinh) {
        this.Gioi_tinh = Gioi_tinh;
    }

    public Date getNgay_sinh() {
        return Ngay_sinh;
    }

    public void setNgay_sinh(Date Ngay_sinh) {
        this.Ngay_sinh = Ngay_sinh;
    }

    public String getNoi_sinh() {
        return Noi_sinh;
    }

    public void setNoi_sinh(String Noi_sinh) {
        this.Noi_sinh = Noi_sinh;
    }

    public String getNguyen_quan() {
        return Nguyen_quan;
    }

    public void setNguyen_quan(String Nguyen_quan) {
        this.Nguyen_quan = Nguyen_quan;
    }

    public String getDan_toc() {
        return Dan_toc;
    }

    public void setDan_toc(String Dan_toc) {
        this.Dan_toc = Dan_toc;
    }

    public String getNghe_nghiep() {
        return Nghe_nghiep;
    }

    public void setNghe_nghiep(String Nghe_nghiep) {
        this.Nghe_nghiep = Nghe_nghiep;
    }

    public Date getNgay_DKTT() {
        return Ngay_DKTT;
    }

    public void setNgay_DKTT(Date Ngay_DKTT) {
        this.Ngay_DKTT = Ngay_DKTT;
    }

    public String getNoi_o_truoc() {
        return Noi_o_truoc;
    }

    public void setNoi_o_truoc(String Noi_o_truoc) {
        this.Noi_o_truoc = Noi_o_truoc;
    }

    // Feel free to add more methods or customize this class based on your needs
}


