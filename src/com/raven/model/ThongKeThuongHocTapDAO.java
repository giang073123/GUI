    package com.raven.model;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;

    public class ThongKeThuongHocTapDAO {
        private Connection getConnection() throws SQLException {
            return DatabaseUtil.getConnection();
        }
        public List<ThongKeThuongHocTap> thongKeThuongHocTap(int ms_kthg) throws SQLException {
            List<ThongKeThuongHocTap> thongKeList = new ArrayList<>();
            String sql = "SELECT dsth.Ma_Ho, nk.Ho_ten AS Ten_Chu_Ho, "
                    + "COUNT(CASE WHEN dsth.Trangthai_Phatthuong = 'Đã hoàn thành' THEN dsth.CCCD ELSE NULL END) AS SoLuongPhanQua, "
                    + "SUM(CASE WHEN dsth.Thanh_tich = 'Hoc sinh gioi' AND dsth.Trangthai_Phatthuong = 'Đã hoàn thành' THEN 1 ELSE 0 END) AS QuaHocSinhGioi, "
                    + "SUM(CASE WHEN dsth.Thanh_tich = 'Hoc sinh tien tien' AND dsth.Trangthai_Phatthuong = 'Đã hoàn thành' THEN 1 ELSE 0 END) AS QuaHocSinhTienTien, "
                    + "SUM(CASE WHEN dsth.Thanh_tich = 'Thanh tich khac' AND dsth.Trangthai_Phatthuong = 'Đã hoàn thành' THEN 1 ELSE 0 END) AS QuaThanhTichKhac "
                    + "FROM ds_thuong_hoctap dsth "
                    + "JOIN ho_gia_dinh hg ON dsth.Ma_Ho = hg.Ma_Ho "
                    + "JOIN nhan_khau nk ON hg.CCCD_Chuho = nk.CCCD "
                    + "WHERE dsth.MS_KThg = ? AND nk.QH_chuho = 'Chủ hộ' "
                    + "GROUP BY dsth.Ma_Ho, nk.Ho_ten";

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, ms_kthg);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        ThongKeThuongHocTap tk = new ThongKeThuongHocTap();
                        tk.setMaHo(rs.getInt("Ma_Ho"));
                        tk.setTenChuHo(rs.getString("Ten_Chu_Ho"));
                        tk.setSoLuongPhanQua(rs.getInt("SoLuongPhanQua"));
                        tk.setQuaHocSinhGioi(rs.getInt("QuaHocSinhGioi"));
                        tk.setQuaHocSinhTienTien(rs.getInt("QuaHocSinhTienTien"));
                        tk.setQuaThanhTichKhac(rs.getInt("QuaThanhTichKhac"));
                        thongKeList.add(tk);
                    }
                }
            }
            return thongKeList;
        }

    }
