package Model.ThuPhi;

public class dang_ky_xe {
    private int Ma_Ho;
    private int So_luong_xedap;
    private int So_luong_xemay;
    private int So_luong_oto;

    public dang_ky_xe() {
        // Default constructor
    }

    public dang_ky_xe(int Ma_Ho, int So_luong_xedap, int So_luong_xemay, int So_luong_oto) {
        this.Ma_Ho = Ma_Ho;
        this.So_luong_xedap = So_luong_xedap;
        this.So_luong_xemay = So_luong_xemay;
        this.So_luong_oto = So_luong_oto;
    }

    public int getMa_Ho() {
        return Ma_Ho;
    }

    public void setMa_Ho(int Ma_Ho) {
        this.Ma_Ho = Ma_Ho;
    }

    public int getSo_luong_xedap() {
        return So_luong_xedap;
    }

    public void setSo_luong_xedap(int So_luong_xedap) {
        this.So_luong_xedap = So_luong_xedap;
    }

    public int getSo_luong_xemay() {
        return So_luong_xemay;
    }

    public void setSo_luong_xemay(int So_luong_xemay) {
        this.So_luong_xemay = So_luong_xemay;
    }

    public int getSo_luong_oto() {
        return So_luong_oto;
    }

    public void setSo_luong_oto(int So_luong_oto) {
        this.So_luong_oto = So_luong_oto;
    }
}
