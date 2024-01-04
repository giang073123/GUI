package Model.NhanKhau;

import Service.connectDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Model_HoKhau {
    private  Connection conn;

    public Model_HoKhau() {
        try {
            open_conn();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
      public void open_conn() throws SQLException{
          connectDB conndb = new connectDB();
          conn = conndb.connect();}
      public void close_conn() throws SQLException{ conn.close();}


    //    ------------------  CÁC METHOD VỀ HỘ KHẨU ---------------------------------------------------


    //   1.1 Lấy toàn bo danh sách hộ khẩu
    public ArrayList<ho_gia_dinh> ho_gia_dinh_getds() {
        ArrayList<ho_gia_dinh> families = new ArrayList<>();

        try {
            PreparedStatement stm = conn.prepareStatement("select * from ho_gia_dinh ");
            ResultSet resultSet = stm.executeQuery();

            // Iterate through the result set and populate the ArrayList
            while (resultSet.next()) {
                ho_gia_dinh family = new ho_gia_dinh();
                family.setMa_Ho(resultSet.getInt("Ma_Ho"));
                family.setCCCD_Chuho(resultSet.getString("CCCD_Chuho"));
                family.setSo_nha(resultSet.getInt("So_nha"));
                family.setDien_tich(resultSet.getFloat("Dien_tich"));
                family.setDuong_(resultSet.getString("Duong_"));
                family.setPhuong_(resultSet.getString("Phuong_"));
                family.setQuan_(resultSet.getString("Quan_"));

                families.add(family);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle potential exceptions
        }

        return families;
    }

    // 1.2. Lấy thông tin cua mot ho
    public ho_gia_dinh ho_gia_dinh_getfamily(int Ma_Ho){
        ho_gia_dinh family =new ho_gia_dinh();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from ho_gia_dinh where Ma_Ho =? ");
            stm.setInt(1,Ma_Ho);
            ResultSet resultSet = stm.executeQuery();

            // Iterate through the result set and populate the ArrayList
            if(resultSet.next()) {

                family.setMa_Ho(resultSet.getInt("Ma_Ho"));
                family.setCCCD_Chuho(resultSet.getString("CCCD_Chuho"));
                family.setSo_nha(resultSet.getInt("So_nha"));
                family.setDien_tich(resultSet.getFloat("Dien_tich"));
                family.setDuong_(resultSet.getString("Duong_"));
                family.setPhuong_(resultSet.getString("Phuong_"));
                family.setQuan_(resultSet.getString("Quan_"));

            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle potential exceptions
        }

        return family;
    }

    //1.2. Tạo hộ mới
    public void ho_gia_dinh_taomoi(ho_gia_dinh f){
        String sql = "INSERT INTO ho_gia_dinh (CCCD_Chuho, So_nha, Dien_tich, Duong_, Phuong_, Quan_) " +
                "VALUES (?, ?, truncate(?,2), ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setString(1, f.getCCCD_Chuho());
            statement.setInt(2, f.getSo_nha());
            statement.setDouble(3, f.getDien_tich());
            statement.setString(4, f.getDuong_());
            statement.setString(5, f.getPhuong_());
            statement.setString(6, f.getQuan_());

            // Execute the query
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //1.3. Thêm nhân khẩu vào hộ
    public void ho_gia_dinh_themnk(String CCCD){

    }

    //1.4. Xóa hộ
    public void ho_gia_dinh_delete(int Ma_Ho){
        String update = "UPDATE nhan_khau SET Ma_Ho = 0, QH_Chuho = '' WHERE Ma_Ho = ?";
        String delete = "DELETE FROM ho_gia_dinh WHERE Ma_Ho = ?";

        try (PreparedStatement updateNhanKhauStatement = conn.prepareStatement(update);
             PreparedStatement deleteHoGiaDinhStatement = conn.prepareStatement(delete)) {

            // Set the Ma_Ho parameter for updating "nhan_khau"
            updateNhanKhauStatement.setInt(1, Ma_Ho);
            // Execute the update query for "nhan_khau"
            updateNhanKhauStatement.executeUpdate();

            // Set the Ma_Ho parameter for deleting a row in "ho_gia_dinh"
            deleteHoGiaDinhStatement.setInt(1, Ma_Ho);
            // Execute the delete query for "ho_gia_dinh"
            deleteHoGiaDinhStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //----------------------------------------------------------------------------------------------------------------------------------------
    //    ------------------  CÁC METHOD VỀ NHÂN KHẨU ---------------------------------------------------

    //   2.1.  Lấy danh sách toàn bộ nhân khẩu
    public ArrayList<nhan_khau> nhan_khau_getds() {
        ArrayList<nhan_khau> ds_nhankhau = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from nhan_khau ");
            ResultSet my_rs = stm.executeQuery();

            while (my_rs.next()) {
                String CCCD = my_rs.getString("CCCD");

                int Ma_Ho = my_rs.getInt("Ma_Ho");
                String Ho_ten = my_rs.getString("Ho_ten");
                String QH_chuho = my_rs.getString("QH_chuho");
                String Gioi_tinh = my_rs.getString("Gioi_tinh");
                String Bi_danh = my_rs.getString("Bi_danh");
                Date Ngay_sinh = my_rs.getDate("Ngay_sinh");
                String Noi_sinh = my_rs.getString("Noi_sinh");
                String Nguyen_quan = my_rs.getString("Nguyen_quan");
                String Dan_toc = my_rs.getString("Dan_toc");
                String Nghe_nghiep = my_rs.getString("Nghe_nghiep");
                Date Ngay_DKTT = my_rs.getDate("Ngay_DKTT");
                String Noi_o_truoc = my_rs.getString("Noi_o_truoc");
                //System.out.println(Gioi_tinh);
                nhan_khau nk = new nhan_khau(CCCD, Ma_Ho, Ho_ten, QH_chuho, Gioi_tinh, Bi_danh, Ngay_sinh, Noi_sinh,
                        Nguyen_quan, Dan_toc, Nghe_nghiep, Ngay_DKTT, Noi_o_truoc);
                ds_nhankhau.add(nk);
                //System.out.println(nk.getGioi_tinh());

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return ds_nhankhau;
    }

    //   2.2.  Lấy danh sách nhân khẩu của một hộ
    public ArrayList<nhan_khau> ho_gia_dinh_getmembers(int Ma_Ho){
        ArrayList<nhan_khau> members = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from nhan_khau where Ma_Ho=? ");
            stm.setInt(1,Ma_Ho);
            ResultSet my_rs = stm.executeQuery();

            while (my_rs.next()) {
                String CCCD = my_rs.getString("CCCD");


                String Ho_ten = my_rs.getString("Ho_ten");
                String QH_chuho = my_rs.getString("QH_chuho");
                String Gioi_tinh = my_rs.getString("Gioi_tinh");
                String Bi_danh = my_rs.getString("Bi_danh");
                Date Ngay_sinh = my_rs.getDate("Ngay_sinh");
                String Noi_sinh = my_rs.getString("Noi_sinh");
                String Nguyen_quan = my_rs.getString("Nguyen_quan");
                String Dan_toc = my_rs.getString("Dan_toc");
                String Nghe_nghiep = my_rs.getString("Nghe_nghiep");
                Date Ngay_DKTT = my_rs.getDate("Ngay_DKTT");
                String Noi_o_truoc = my_rs.getString("Noi_o_truoc");
                //System.out.println(Gioi_tinh);
                nhan_khau nk = new nhan_khau(CCCD, Ma_Ho, Ho_ten, QH_chuho, Gioi_tinh, Bi_danh, Ngay_sinh, Noi_sinh,
                        Nguyen_quan, Dan_toc, Nghe_nghiep, Ngay_DKTT, Noi_o_truoc);
                members.add(nk);
                //System.out.println(nk.getGioi_tinh());

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return members;
    }


    // 2.2. Lấy thông tin nhân khẩu theo CCCD
    public nhan_khau nhan_khau_get(String CCCD) {
        nhan_khau nk = new nhan_khau();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from nhan_khau where CCCD = ? ");
            stm.setString(1, CCCD);
            ResultSet my_rs = stm.executeQuery();

            if (my_rs.next()) {

                nk.setMa_Ho(my_rs.getInt("Ma_Ho"));
                nk.setHo_ten(my_rs.getString("Ho_ten"));
                nk.setQH_chuho(my_rs.getString("QH_chuho"));
                nk.setGioi_tinh( my_rs.getString("Gioi_tinh"));
                nk.setBi_danh(my_rs.getString("Bi_danh"));
                nk.setNgay_sinh(my_rs.getDate("Ngay_sinh")) ;
                nk.setNoi_sinh(my_rs.getString("Noi_sinh")) ;
                nk.setNguyen_quan(my_rs.getString("Nguyen_quan"));
                nk.setDan_toc(my_rs.getString("Dan_toc"));
                nk.setNghe_nghiep(my_rs.getString("Nghe_nghiep"));
                nk.setNgay_DKTT(my_rs.getDate("Ngay_DKTT"));
                nk.setNoi_o_truoc(my_rs.getString("Noi_o_truoc"));

            }
            else return null;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return nk;
    }

    // 2.3. Thêm nhân khẩu vào dữ liệu nhân khẩu
    public void nhan_khau_insert(nhan_khau nk) {
        String sql = "INSERT INTO nhan_khau (CCCD, Ho_ten, Bi_danh, Gioi_tinh, " +
                "Ngay_sinh, Noi_sinh, Nguyen_quan, Dan_toc, Nghe_nghiep, " +
                "Ngay_DKTT, Noi_o_truoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nk.getCCCD());
            statement.setString(2, nk.getHo_ten());
            statement.setString(3, nk.getBi_danh());
            statement.setString(4, nk.getGioi_tinh());
            statement.setDate(5, new Date(nk.getNgay_sinh().getTime()));
            statement.setString(6, nk.getNoi_sinh());
            statement.setString(7, nk.getNguyen_quan());
            statement.setString(8, nk.getDan_toc());
            statement.setString(9, nk.getNghe_nghiep());
            statement.setDate(10, new Date(nk.getNgay_DKTT().getTime()));
            statement.setString(11, nk.getNoi_o_truoc());


            int affectedRows = statement.executeUpdate();

            // Iterate through the result set and populate the ArrayList

        } catch (SQLException e) {
             e.printStackTrace(); // Handle potential exceptions
            //JOptionPane.showMessageDialog(null,"CCCD đã tồn tại trong CSDL");
        }

    }

    // 2.4. Update dữ liệu nhân khẩu
    public void nhan_khau_update(nhan_khau nk){
        String sql = "UPDATE nhan_khau SET Ho_ten = ?, QH_chuho = ?, Bi_danh = ?, " +
                "Gioi_tinh = ?, Ngay_sinh = ?, Noi_sinh = ?, " +
                "Nguyen_quan = ?, Dan_toc = ?, Nghe_nghiep = ?, " +
                "Ngay_DKTT = ?, Noi_o_truoc = ?, Ma_Ho = ? WHERE CCCD = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setString(1, nk.getHo_ten());
            statement.setString(2, nk.getQH_chuho());
            statement.setString(3, nk.getBi_danh());
            statement.setString(4, nk.getGioi_tinh());
            statement.setDate(5, new java.sql.Date(nk.getNgay_sinh().getTime()));
            statement.setString(6, nk.getNoi_sinh());
            statement.setString(7, nk.getNguyen_quan());
            statement.setString(8, nk.getDan_toc());
            statement.setString(9, nk.getNghe_nghiep());
            statement.setDate(10, new java.sql.Date(nk.getNgay_DKTT().getTime()));
            statement.setString(11, nk.getNoi_o_truoc());
            statement.setInt(12, nk.getMa_Ho());

            // Set CCCD for the WHERE clause
            statement.setString(13, nk.getCCCD());
             statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //2.6. Xóa nhân khẩu khỏi dữ liệu nhân khẩu
    public void nhan_khau_delete(String CCCD){
        String sql = "DELETE FROM nhan_khau WHERE CCCD = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set CCCD for the prepared statement
            statement.setString(1, CCCD);

            // Execute the query
             statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

 //----------------------------------------------------------------------------------------------------------------------------------------

// 3. CÁC METHOD VỀ TẠM TRÚ TẠM VẮNG

    //3.1. KHAI BÁO TẠM  VẮNG

    public void tam_vang_insert(tam_vang tv){
        String insertSql = "INSERT INTO ds_tam_vang (CCCD, Ma_Ho, Ho_Ten, Diachi_tv, Tv_tu_ngay, Tv_den_ngay, Ly_do) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(insertSql)) {
            // Set values for the parameters
            statement.setString(1, tv.getCCCD());
            statement.setInt(2, tv.getMa_Ho());
            statement.setString(3, tv.getHo_Ten());
            statement.setString(4, tv.getDiachi_tv());
            statement.setDate(5, new java.sql.Date(tv.getTv_tu_ngay().getTime()));
            statement.setDate(6, new java.sql.Date(tv.getTv_den_ngay().getTime()));
            statement.setString(7, tv.getLy_do());

            // Execute the insert query
            int rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.2. KIỂM TRA KHAI BÁO TẠM VẮNG HỢP LỆ

    public boolean tam_vang_check(String CCCD, Date tv_tu_ngay){
        boolean check=false;
        String sql = "Select * from ds_tam_vang where CCCD=? and Tv_den_ngay >?";
        ResultSet my_rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setString(1,CCCD);
            statement.setDate(2,tv_tu_ngay);
             my_rs = statement.executeQuery();
             if (my_rs.next()) check = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }










    public static void main(String args[]) {
        Model_HoKhau m = new Model_HoKhau();


        // Use getter methods to assign values
//        nhan_khau nnk = new nhan_khau();
//        nnk.setCCCD("5551");
//        nnk.setHo_ten("Nguễn Trọng Dương");
//        nnk.setBi_danh(" ");
//        nnk.setGioi_tinh("Nam");
//        nnk.setNgay_sinh(Date.valueOf("1992-01-13"));
//        nnk.setNoi_sinh("Bắc Giang");
//        nnk.setNguyen_quan("Bắc Giang");
//        nnk.setDan_toc("Kinh");
//        nnk.setNghe_nghiep("Công an");
//        nnk.setNgay_DKTT(Date.valueOf("2023-12-28"));
//        nnk.setNoi_o_truoc("Bắc Giang");
//        nnk.setMa_Ho(5); nnk.setQH_chuho("Chủ hộ");
//        m.nhan_khau_update(nnk);
//
//        m.insert_nhankhau(nnk);

//         ho_gia_dinh f = new ho_gia_dinh();
//        f.setCCCD_Chuho();
//        f.setSo_nha();
//        f.setDien_tich();
//        f.setDuong_();
//        f.setPhuong_();
//        f.setQuan_();



    }

}