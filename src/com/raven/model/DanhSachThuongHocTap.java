    package com.raven.model;

    import java.util.Date;

    public class DanhSachThuongHocTap {
        private int msKThg;
        private String hoTen;
        private String cccd;
        private int maHo;
        private String truongHoc;
        private String thanhTich;
        private String minhChung;
        private int giaTriPhanQua;
        private String TrangThaiPhatThuong;
        private Date ngayThuong;
        private int stt;
        // Getters
        public int getMsKThg() {
            return msKThg;
        }
        public int getStt() {
            return stt; // Getter cho trường mới
        }
        public String getHoTen() {
            return hoTen;
        }

        public String getCCCD() {
            return cccd;
        }

        public int getMaHo() {
            return maHo;
        }

        public String getTruongHoc() {
            return truongHoc;
        }

        public String getThanhTich() {
            return thanhTich;
        }

        public String getMinhChung() {
            return minhChung;
        }

        public int getGiaTriPhanQua() {
            return giaTriPhanQua;
        }

        public String getTrangThaiPhatThuong() {
            return TrangThaiPhatThuong;
        }

        public Date getNgayThuong() {
            return ngayThuong;
        }

        // Setters
        public void setMsKThg(int msKThg) {
            this.msKThg = msKThg;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }
        public void setStt(int stt) {
            this.stt = stt; // Setter cho trường mới
        }
        public void setCCCD(String cccd) {
            this.cccd = cccd;
        }
        public void setMaHo(int maHo) {
            this.maHo = maHo;
        }
        public void setTruongHoc(String truongHoc) {
            this.truongHoc = truongHoc;
        }

        public void setThanhTich(String thanhTich) {
            this.thanhTich = thanhTich;
        }

        public void setMinhChung(String minhChung) {
            this.minhChung = minhChung;
        }

        public void setGiaTriPhanQua(int giaTriPhanQua) {
            this.giaTriPhanQua = giaTriPhanQua;
        }

        public void setTrangThaiPhatThuong(String TrangThaiPhatThuong) {
            this.TrangThaiPhatThuong = TrangThaiPhatThuong;
        }


        public void setNgayThuong(Date ngayThuong) {
            this.ngayThuong = ngayThuong;
        }

        // toString Method
        @Override
        public String toString() {
            return "DanhSachThuongHocTap{" +
                    "msKThg=" + msKThg +
                    ", hoTen='" + hoTen + '\'' +
                    ", cccd='" + cccd + '\'' +
                    ", maHo=" + maHo +
                    ", truongHoc='" + truongHoc + '\'' +
                    ", thanhTich='" + thanhTich + '\'' +
                    ", minhChung='" + minhChung + '\'' +
                    ", giaTriPhanQua=" + giaTriPhanQua +
                    ", TrangThaiPhatThuong='" + TrangThaiPhatThuong + '\'' +
                    ", ngayThuong=" + ngayThuong +
                    '}';
        }
    }
