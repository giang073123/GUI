// test git

package Model.NhanKhau;

import Model.TaiKhoan.can_bo;
import Service.Validater;
import Service.connectDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Model_NhanKhau {

    private Connection conn;
    private Validater val = new Validater();
    private can_bo cb;

    public Model_NhanKhau() {
//        try {        -> TẠI MỖI PHƯƠNG THỨC ĐỀU open và close rồi
//            open_conn();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void open_conn() throws SQLException {
        connectDB conndb = new connectDB();
        conn = conndb.connect();
    }

    public void close_conn() throws SQLException {
        conn.close();
    }

    public Validater getVal() {
        return val;
    }
    
    public void setCB(can_bo cb){
        this.cb=cb;
    }

    //    ------------------  CÁC METHOD VỀ HỘ KHẨU ---------------------------------------------------
    //   1.1 Lấy toàn bo danh sách hộ khẩu
    public ArrayList<ho_gia_dinh> ho_gia_dinh_getds() {

        // CHỈ LẤY DANH SÁCH CÁC HỘ ĐANG THƯỜNG TRÚ
        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<ho_gia_dinh> families = new ArrayList<>();

        try {
            PreparedStatement stm = conn.prepareStatement("select * from ho_gia_dinh where Trang_thai_ho = 'Thường trú' ");
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
                family.setTrang_thai_ho(resultSet.getString("Trang_thai_ho"));

                families.add(family);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return families;
    }

    // 1.2. Lấy thông tin cua mot ho
    public ho_gia_dinh ho_gia_dinh_getfamily(int Ma_Ho) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        ho_gia_dinh family = new ho_gia_dinh();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from ho_gia_dinh where Ma_Ho =? and Trang_thai_ho = 'Thường trú' ");
            stm.setInt(1, Ma_Ho);
            ResultSet resultSet = stm.executeQuery();

            // Iterate through the result set and populate the ArrayList
            if (resultSet.next()) {

                family.setMa_Ho(resultSet.getInt("Ma_Ho"));
                family.setCCCD_Chuho(resultSet.getString("CCCD_Chuho"));
                family.setSo_nha(resultSet.getInt("So_nha"));
                family.setDien_tich(resultSet.getFloat("Dien_tich"));
                family.setDuong_(resultSet.getString("Duong_"));
                family.setPhuong_(resultSet.getString("Phuong_"));
                family.setQuan_(resultSet.getString("Quan_"));

            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return family;
    }

    //1.2. Tạo hộ mới
    public void ho_gia_dinh_taomoi(ho_gia_dinh f) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO ho_gia_dinh (CCCD_Chuho, So_nha, Dien_tich, Duong_, Phuong_, Quan_) "
                + "VALUES (?, ?, truncate(?,2), ?, ?, ?)"; // update nhan_khau set Ma_Ho = ? where CCCD =? 

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setString(1, f.getCCCD_Chuho());
            statement.setInt(2, f.getSo_nha());
            statement.setDouble(3, f.getDien_tich());
            statement.setString(4, f.getDuong_());
            statement.setString(5, f.getPhuong_());
            statement.setString(6, f.getQuan_());
//            statement.setInt(8, f.getCCCD_Chuho());
//            statement.setString(8, f.getCCCD_Chuho());

            // Execute the query
            statement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // LẤY MÃ HỘ THEO CCCD CHỦ HỘ
     public ho_gia_dinh ho_gia_dinh_getfamily(String CCCD_Chuho) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        ho_gia_dinh family = new ho_gia_dinh();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from ho_gia_dinh where CCCD_Chuho=? and Trang_thai_ho = 'Thường trú' ");
            stm.setString(1, CCCD_Chuho);
            ResultSet resultSet = stm.executeQuery();

            // Iterate through the result set and populate the ArrayList
            if (resultSet.next()) {

                family.setMa_Ho(resultSet.getInt("Ma_Ho"));
                family.setCCCD_Chuho(resultSet.getString("CCCD_Chuho"));
                family.setSo_nha(resultSet.getInt("So_nha"));
                family.setDien_tich(resultSet.getFloat("Dien_tich"));
                family.setDuong_(resultSet.getString("Duong_"));
                family.setPhuong_(resultSet.getString("Phuong_"));
                family.setQuan_(resultSet.getString("Quan_"));

            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return family;
    }
    

    //1.3. Thêm nhân khẩu vào hộ
    public void ho_gia_dinh_themnk(String CCCD) { 

    } // -> DÙNG UPDATE NK

    public void ho_gia_dinh_xoank(nhan_khau nk) { // -> (DÙNG UPDATE NK) KHÔNG THỂ DÙNG UPDATE NK VÌ Phải để Mã hộ và QH chủ hộ là null
            try {                                // HIỆN TẠI KHÔNG CẦN NỮA
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String update = "UPDATE nhan_khau SET Ma_Ho = null, QH_Chuho = '' WHERE CCCD = ?";
    

        try (PreparedStatement stm = conn.prepareStatement(update)) {

            // Set the Ma_Ho parameter for updating "nhan_khau"
            stm.setString(1, nk.getCCCD());
            // Execute the update query for "nhan_khau"
            stm.executeUpdate();         

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  // -> DÙNG UPDATE NK

    //1.4. Xóa hộ
    public void ho_gia_dinh_delete(int Ma_Ho) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String update = "UPDATE nhan_khau SET Ma_Ho = null, QH_Chuho = '' WHERE Ma_Ho = ?";
        String delete = "Update ho_gia_dinh set Trang_thai_ho = 'Đã xóa', CCCD_Chuho = null WHERE Ma_Ho = ?";

        try (PreparedStatement updateNhanKhauStatement = conn.prepareStatement(update); PreparedStatement deleteHoGiaDinhStatement = conn.prepareStatement(delete)) {

            // Set the Ma_Ho parameter for updating "nhan_khau"
            updateNhanKhauStatement.setInt(1, Ma_Ho);
            // Execute the update query for "nhan_khau"
            updateNhanKhauStatement.executeUpdate();

            // Set the Ma_Ho parameter for deleting a row in "ho_gia_dinh"
            deleteHoGiaDinhStatement.setInt(1, Ma_Ho);
            // Execute the delete query for "ho_gia_dinh"
            deleteHoGiaDinhStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // CẬP NHẬT THÔNG TIN HỘ
    public void ho_gia_dinh_update(ho_gia_dinh f) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "update ho_gia_dinh set So_nha=?,Duong_=?,Phuong_=?, Quan_=?,Dien_tich =truncate(?,2), CCCD_Chuho=? where Ma_Ho=? "; //  

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement

            statement.setInt(1, f.getSo_nha());
            statement.setString(2, f.getDuong_());
            statement.setString(3, f.getPhuong_());
            statement.setString(4, f.getQuan_());
            statement.setDouble(5, f.getDien_tich());
            statement.setString(6, f.getCCCD_Chuho());
            statement.setInt(7, f.getMa_Ho());   //   BUG KHÔNG THAY ĐỔI ĐƯỢC CCCD CHỦ HỘ LÀ Ở ĐÂY, code gây bug: statement.setString(7, f.getCCCD_Chuho());
//            statement.setInt(8, f.getCCCD_Chuho());
//            statement.setString(8, f.getCCCD_Chuho());

            // Execute the query
            statement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    // BỎ THÔNG TIN CHỦ HỘ
    public void ho_gia_dinh_delChuho(ho_gia_dinh f){
          try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "update ho_gia_dinh set  CCCD_Chuho=null where Ma_Ho=? "; //  

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement

            statement.setInt(1, f.getMa_Ho());   


            // Execute the query
            statement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

    // CHECK TRÙNG ĐỊA CHỈ NHÀ
    public boolean check_addr(int sonha, String duong, String phuong, String quan) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "select* from ho_gia_dinh where So_nha =? and Duong_= ? and Phuong_= ? and Quan_ = ? and Trang_thai_ho ='Thường trú'  ";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement

            statement.setInt(1, sonha);
            statement.setString(2, duong);
            statement.setString(3, phuong);
            statement.setString(4, quan);
            ResultSet my_rs = statement.executeQuery();
            if (my_rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean check_samestring(String str1,String str2){
             
      try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        StringBuffer sb = new StringBuffer();
        sb.append("%"); sb.append(str2); sb.append("%");
       
        String sql = "SELECT IF(? like ? ,'yes','no');";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setString(1,str1);
            statement.setString(2,sb.toString());
            ResultSet my_rs = statement.executeQuery();
            if (my_rs.next()) {
                if(my_rs.getString(1).compareTo("yes")==0){ return true;}
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    
      return false;
    }
    
    public int count_ho(){
        int cnt =0;
         try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
       
        String sql = "SELECT COUNT(*) AS total FROM ho_gia_dinh WHERE Trang_thai_ho='Thường trú'";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            
            ResultSet my_rs = statement.executeQuery();
             if(my_rs.next())
            cnt=my_rs.getInt("total");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return cnt;
        
    }
    
    public int count_nk(){
        int cnt =0;
         try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
       
        String sql = "SELECT COUNT(*) AS total FROM nhan_khau WHERE Trang_thai_nhan_khau='Thường trú'";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            
            ResultSet my_rs = statement.executeQuery();
            if(my_rs.next())
            cnt=my_rs.getInt("total");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return cnt;
        
    }
    
    
    
//SELECT COUNT(*) FROM nhan_khau WHERE Trang_thai_nhan_khau='Thường trú';
//SELECT COUNT(*) FROM ho_gia_dinh WHERE Trang_thai_ho='Thường trú';
    

    //----------------------------------------------------------------------------------------------------------------------------------------
    //    ------------------  CÁC METHOD VỀ NHÂN KHẨU ---------------------------------------------------
    //   2.1.  Lấy danh sách toàn bộ nhân khẩu
    public ArrayList<nhan_khau> nhan_khau_getds() {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<nhan_khau> ds_nhankhau = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from nhan_khau where Trang_thai_nhan_khau='Thường trú' or Trang_thai_nhan_khau='Mới thêm' ");
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
                String Trang_thai_nhan_khau = my_rs.getString("Trang_thai_nhan_khau");
                //System.out.println(Gioi_tinh);
                nhan_khau nk = new nhan_khau(CCCD, Ma_Ho, Ho_ten, QH_chuho, Gioi_tinh, Bi_danh, Ngay_sinh, Noi_sinh,
                        Nguyen_quan, Dan_toc, Nghe_nghiep, Ngay_DKTT, Noi_o_truoc, Trang_thai_nhan_khau);
                ds_nhankhau.add(nk);
                //System.out.println(nk.getGioi_tinh());

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()); // Handle potential exceptions
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ds_nhankhau;
    }

    //   2.2.  Lấy danh sách nhân khẩu của một hộ
    public ArrayList<nhan_khau> ho_gia_dinh_getmembers(int Ma_Ho) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<nhan_khau> members = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from nhan_khau where Ma_Ho=? ");
            stm.setInt(1, Ma_Ho);
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
                String Trang_thai_nhan_khau = my_rs.getString("Trang_thai_nhan_khau");
                //System.out.println(Gioi_tinh);
                nhan_khau nk = new nhan_khau(CCCD, Ma_Ho, Ho_ten, QH_chuho, Gioi_tinh, Bi_danh, Ngay_sinh, Noi_sinh,
                        Nguyen_quan, Dan_toc, Nghe_nghiep, Ngay_DKTT, Noi_o_truoc, Trang_thai_nhan_khau);
                members.add(nk);
                //System.out.println(nk.getGioi_tinh());

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()); // Handle potential exceptions
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return members;
    }

    // 2.2. Lấy thông tin nhân khẩu theo CCCD
    public nhan_khau nhan_khau_get(String CCCD) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        nhan_khau nk = new nhan_khau();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from nhan_khau where CCCD = ? and Trang_thai_nhan_khau='Thường trú' ");
            stm.setString(1, CCCD);
            ResultSet my_rs = stm.executeQuery();

            if (my_rs.next()) {
                nk.setCCCD(my_rs.getString("CCCD"));
                nk.setMa_Ho(my_rs.getInt("Ma_Ho"));
                nk.setHo_ten(my_rs.getString("Ho_ten"));
                nk.setQH_chuho(my_rs.getString("QH_chuho"));
                nk.setGioi_tinh(my_rs.getString("Gioi_tinh"));
                nk.setBi_danh(my_rs.getString("Bi_danh"));
                nk.setNgay_sinh(my_rs.getDate("Ngay_sinh"));
                nk.setNoi_sinh(my_rs.getString("Noi_sinh"));
                nk.setNguyen_quan(my_rs.getString("Nguyen_quan"));
                nk.setDan_toc(my_rs.getString("Dan_toc"));
                nk.setNghe_nghiep(my_rs.getString("Nghe_nghiep"));
                nk.setNgay_DKTT(my_rs.getDate("Ngay_DKTT"));
                nk.setNoi_o_truoc(my_rs.getString("Noi_o_truoc"));
                nk.setTrang_thai_nhan_khau(my_rs.getString("Trang_thai_nhan_khau"));

            } else {
                return null;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()); // Handle potential exceptions
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nk;
    }
    
    
    // DÙNG ĐỂ KIỂM TRA NHÂN KHẨU ĐANG HOẶC ĐÃ TỪNG THƯỜNG TRÚ
     public nhan_khau nhan_khau_getALL(String CCCD) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        nhan_khau nk = new nhan_khau();
        try {
            PreparedStatement stm = conn.prepareStatement("select * from nhan_khau where CCCD = ?");
            stm.setString(1, CCCD);
            ResultSet my_rs = stm.executeQuery();

            if (my_rs.next()) {
                nk.setCCCD(my_rs.getString("CCCD"));
                nk.setMa_Ho(my_rs.getInt("Ma_Ho"));
                nk.setHo_ten(my_rs.getString("Ho_ten"));
                nk.setQH_chuho(my_rs.getString("QH_chuho"));
                nk.setGioi_tinh(my_rs.getString("Gioi_tinh"));
                nk.setBi_danh(my_rs.getString("Bi_danh"));
                nk.setNgay_sinh(my_rs.getDate("Ngay_sinh"));
                nk.setNoi_sinh(my_rs.getString("Noi_sinh"));
                nk.setNguyen_quan(my_rs.getString("Nguyen_quan"));
                nk.setDan_toc(my_rs.getString("Dan_toc"));
                nk.setNghe_nghiep(my_rs.getString("Nghe_nghiep"));
                nk.setNgay_DKTT(my_rs.getDate("Ngay_DKTT"));
                nk.setNoi_o_truoc(my_rs.getString("Noi_o_truoc"));
                nk.setTrang_thai_nhan_khau(my_rs.getString("Trang_thai_nhan_khau"));

            } else {
                return null;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()); // Handle potential exceptions
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nk;
    }

    // 2.3. Thêm nhân khẩu vào dữ liệu nhân khẩu
    public void nhan_khau_insert(nhan_khau nk) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO nhan_khau (CCCD, Ho_ten, Bi_danh, Gioi_tinh, "
                + "Ngay_sinh, Noi_sinh, Nguyen_quan, Dan_toc, Nghe_nghiep, "
                + "Ngay_DKTT, Noi_o_truoc,Ma_Ho,QH_Chuho,Trang_thai_nhan_khau) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,'Thường trú')";

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
            statement.setInt(12, nk.getMa_Ho());
            statement.setString(13, nk.getQH_chuho());
            // Trạng thái nhân khẩu là Thường trú khi thêm vào, được thực hiện trong DB
            int affectedRows = statement.executeUpdate();

            // Iterate through the result set and populate the ArrayList
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
            //JOptionPane.showMessageDialog(null,"CCCD đã tồn tại trong CSDL");
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // 2.4  . THÊM NHÂN KHẨU LÀ CHỦ HỘ KHI MỚI TẠO HỘ
    public void nhan_khau_insertchuho(nhan_khau nk) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO nhan_khau (CCCD, Ho_ten, Bi_danh, Gioi_tinh, "
                + "Ngay_sinh, Noi_sinh, Nguyen_quan, Dan_toc, Nghe_nghiep, "
                + "Ngay_DKTT, Noi_o_truoc, Trang_thai_nhan_khau) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'Thường trú')";

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
          //  statement.setInt(12, nk.getMa_Ho());
          //  statement.setString(13, nk.getQH_chuho());
            // Trạng thái nhân khẩu là Thường trú khi thêm vào, được thực hiện trong DB
            int affectedRows = statement.executeUpdate();

            // Iterate through the result set and populate the ArrayList
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
            //JOptionPane.showMessageDialog(null,"CCCD đã tồn tại trong CSDL");
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    

    // METHOD NÀY QUAN TRỌNG, CÓ THỂ ĐƯỢC SỬ DỤNG TRONG NHIỀU TRƯỜNG HỢP
    // 2.5. Update dữ liệu nhân khẩu
    public void nhan_khau_update(nhan_khau nk) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

//        if (nk.getMa_Ho() > 0) {
//            nk.setTrang_thai_nhan_khau("Thường trú");
//        } else {
//            nk.setTrang_thai_nhan_khau("Mới thêm");
//            nk.setQH_chuho("");
//        }

        String sql1 = "UPDATE nhan_khau SET Ho_ten = ?, QH_chuho = ?, Bi_danh = ?, "
                + "Gioi_tinh = ?, Ngay_sinh = ?, Noi_sinh = ?, "
                + "Nguyen_quan = ?, Dan_toc = ?, Nghe_nghiep = ?, "
                + "Ngay_DKTT = ?, Noi_o_truoc = ?, Ma_Ho = ?, CCCD=?,Trang_thai_nhan_khau=? WHERE CCCD = ?";

       

        if (nk.getMa_Ho() > 0) {
            try (PreparedStatement statement = conn.prepareStatement(sql1)) {
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
                statement.setString(14, nk.getTrang_thai_nhan_khau());
                statement.setString(15, nk.getCCCD());

                statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
            }
        } else if (nk.getMa_Ho() == 0) {   // DÀNH CHO THÊM CHỦ HỘ KHI CHỦ HỘ LÀ NGƯỜI TRƯỚC ĐÂY TỪNG RỜI ĐI, GIỜ QUAY LẠI
             String sql2 = "UPDATE nhan_khau SET Ho_ten = ?, QH_chuho = ?, Bi_danh = ?, "
                + "Gioi_tinh = ?, Ngay_sinh = ?, Noi_sinh = ?, "
                + "Nguyen_quan = ?, Dan_toc = ?, Nghe_nghiep = ?, "
                + "Ngay_DKTT = ?, Noi_o_truoc = ?, Ma_Ho = null, CCCD=?,Trang_thai_nhan_khau=? WHERE CCCD = ?";
             
            try (PreparedStatement statement = conn.prepareStatement(sql2)) {
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
 

                // Set CCCD for the WHERE clause
                statement.setString(12, nk.getCCCD());
                statement.setString(13, nk.getTrang_thai_nhan_khau());
                statement.setString(14, nk.getCCCD());

                statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
            }

        }
        
        
//        if(this.check_samestring(nk.getQH_chuho(), "Chủ hộ")) {
//        
//             ho_gia_dinh f = this.ho_gia_dinh_getfamily(nk.getMa_Ho());
//             if(f)
//        
//        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //2.6. Xóa nhân khẩu khỏi dữ liệu nhân khẩu
    public void nhan_khau_delete(nhan_khau nk) {    // METHOD NÀY THỰC RA KHÔNG CẦN, DÙNG UPDATE VÀ SET Ở FORM CÁC THÔNG TIN CẦN THIẾT LÀ ĐƯỢC
                                                   // NHƯNG VIẾT RỒI THÌ CỨ ĐỂ ĐÓ
        try {                                      // -> SAI, sau khi viết lại logic chương trình thì đã khác
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         if (this.check_samestring(nk.getQH_chuho(), "Chủ hộ")) {
            String sql2 = "Update ho_gia_dinh set CCCD_Chuho = null where Ma_Ho=? ";

            try (PreparedStatement statement = conn.prepareStatement(sql2)) {
                // Set CCCD for the prepared statement
                statement.setInt(1, nk.getMa_Ho());

                // Execute the query
                statement.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
            }
        }
        

        String sql = "Update nhan_khau set Trang_thai_nhan_khau = 'Đã xóa', Ma_Ho= null,QH_chuho = ' '  WHERE CCCD = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set CCCD for the prepared statement
            statement.setString(1, nk.getCCCD());

            // Execute the query
            statement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

       

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

    } // METHOD NÀY THỰC RA KHÔNG CẦN, DÙNG UPDATE VÀ SET Ở FORM CÁC THÔNG TIN CẦN THIẾT LÀ ĐƯỢC
    // NHƯNG VIẾT RỒI THÌ CỨ ĐỂ ĐÓ

    //----------------------------------------------------------------------------------------------------------------------------------------
// 3. CÁC METHOD VỀ TẠM TRÚ TẠM VẮNG
    //3.1. KHAI BÁO TẠM  VẮNG
    public void tam_vang_insert(tam_vang tv) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        String insertSql = "INSERT INTO ds_tam_vang (CCCD, Ma_Ho, Ho_Ten, Diachi_tv, Tv_tu_ngay, Tv_den_ngay, Ly_do) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

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

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //3.2. KIỂM TRA KHAI BÁO TẠM VẮNG HỢP LỆ
    public boolean tam_vang_check(String CCCD, Date tv_tu_ngay) {

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean check = false;
        String sql = "Select * from ds_tam_vang where CCCD=? and Tv_den_ngay >?";
        ResultSet my_rs;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setString(1, CCCD);
            statement.setDate(2, tv_tu_ngay);
            my_rs = statement.executeQuery();
            if (my_rs.next()) {
                check = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            close_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_NhanKhau.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }

    public static void main(String args[]) {
        Model_NhanKhau m = new Model_NhanKhau();
          System.out.println(m.count_nk());
//        System.out.println(nk.getQH_chuho());
//        System.out.println(m.check_samestring(nk.getQH_chuho(),"Chủ hộ"));
     
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
