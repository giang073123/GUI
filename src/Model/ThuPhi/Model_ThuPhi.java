package Model.ThuPhi;

import Service.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Model_ThuPhi{

    private final Connection conn;

    public Model_ThuPhi() {
        connectDB conndb = new connectDB();
        conn = conndb.connect();
    }

    //     1. CÁC METHOD VỚI KHOẢN THU
//         1.1. Lấy thông tin khoản thu hiện tại hoặc quá khứ
    public ArrayList<khoan_thu> khoan_thu_Danhsach(khoan_thu kt, String trang_thai) {   // truyền vào kt để clone

        ArrayList<khoan_thu> list = new ArrayList<>();// tạo instance
        //cl kt = new Class<>;

        try (PreparedStatement stm = conn.prepareStatement("select * from " + kt.getTable_name() + " where Trang_thai_khoanthu = ? ")) {
            stm.setString(1, trang_thai);
            ResultSet resultSet = stm.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                list.add(i, kt.Clone_());
                list.get(i).getDataFromRs(resultSet);
                i++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        return list;
    }

    //  1.2. Tạo khoản thu mới
    public void khoan_thu_Taomoi(khoan_thu kt) {   //-> Method này sẽ viết code riêng cho các class khoản thu
        String sql = kt.insertQuery();

        System.out.println(sql);
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            kt.setDataForStm(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // 1.3. Kết thúc khoản thu
    public void khoan_thu_Ketthuc(String table_name, int MS_KThu) {   // -> Method chỉ tác động đến các cột dữ liệu chung

        Date today = Date.valueOf(LocalDate.now());

        String sql = "Update " + table_name + " set Ngaykthuc_KThu = ?, Trang_thai_khoanthu = 'Đã kết thúc' where MS_KThu=?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setDate(1, today);
            statement.setInt(2, MS_KThu);
            // Execute the query
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // 1.4. Xóa khoản thu
    public void khoan_thu_Xoa(String table_name, int MS_KThu) {        // -> Method chỉ tác động đến các cột dữ liệu chung

        String sql = "Delete from " + table_name + " where MS_KThu=?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set values for the prepared statement
            statement.setInt(1, MS_KThu);
            // Execute the query
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // 1.5. Tìm kiếm khoản thu theo thời gian
    // -> Phần này thực hiện luôn trên code UI
//   2. CÁC METHOD VỚI DANH SÁCH THU TIỀN
// 2.1. Lấy danh sách thu tiền



    public ArrayList<thu_tien> thu_tien_Danhsach(thu_tien tt, int MS_KThu){

        ArrayList<thu_tien> list = new ArrayList<>();// tạo instance

        try (PreparedStatement stm = conn.prepareStatement("select * from " + tt.getTable_name() + " where MS_KThu = ? ")) {
            stm.setInt(1, MS_KThu);
            ResultSet resultSet = stm.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                list.add(i, tt.Clone_());
                list.get(i).getDataFromRs(resultSet);
                i++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
        }

        return list;

    }

    //   2.2. Thêm hàng vào danh sách    // Chỉ dùng cho Quản lý thu tự nguyện
    public void thu_tien_ThemHang(thu_tien_khac tt) {
        String sql = tt.insertQuery();

        System.out.println(sql);
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, tt.getMS_KThu());
            statement.setInt(2, tt.getMa_Ho());
            statement.setString(3, tt.getLoai_KThu());
            statement.setInt(4, tt.getSo_tien());
            statement.setString(5, tt.getTrangthai_Thu());
            statement.setDate(6, new Date(tt.getNgay_thu().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    //    2.3. Cập nhật danh sách
    public void thu_tien_CapNhat(thu_tien tt) {   //-> Method này sẽ viết code riêng cho các class khoản thu
        String sql = tt.updateQuery();
        JOptionPane.showMessageDialog(null,tt.getTrangthai_Thu());
        System.out.println(sql);
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            tt.setDataForStm(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }


    //3. Method cho Đăng ký xe


    void dang_ky_xe_update(dang_ky_xe dk){
        String sql = "Update dang_ky_xe set So_luong_xedap =?, So_luong_xemay = ?, So_luong_oto=? where Ma_Ho=? ";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set the parameters for the prepared statement

            statement.setInt(1, dk.getSo_luong_xedap());
            statement.setInt(2, dk.getSo_luong_xemay());
            statement.setInt(3, dk.getSo_luong_oto());
            statement.setInt(4, dk.getMa_Ho());
            // Execute the query
            statement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    //---------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String args[]) {
        Model_ThuPhi m = new Model_ThuPhi();
        /*

         khoan_thu_phichungcu kt = new khoan_thu_phichungcu();
                kt.setTen_KThu("khoản thu chung cư mới"); kt.setPhi_dichvu(5000); kt.setPhi_quanly(5000); kt.setGhi_chu("");
                m.khoan_thu_Taomoi(kt);

        khoan_thu_guixe kt = new khoan_thu_guixe();
             kt.setTen_KThu("Thu tiền gửi xe tháng 11"); kt.setPhi_xe_dap(30000); kt.setPhi_xe_may(100000); kt.setPhi_xe_oto(500000);
             kt.setGhi_chu("");
             m.khoan_thu_Taomoi(kt);
        */
//        khoan_thu_phichungcu kt = new khoan_thu_phichungcu();
//        kt.setTen_KThu("khoản thu chung cư mới 2"); kt.setPhi_dichvu(5000); kt.setPhi_quanly(5000); kt.setGhi_chu("");
//                m.khoan_thu_Taomoi(kt);
//
        thu_tien_guixe tt= new thu_tien_guixe();

        ArrayList<thu_tien> list = m.thu_tien_Danhsach(tt, 6);

        ArrayList<thu_tien_guixe> mylist = new ArrayList<>();

        for(thu_tien t:list){
            mylist.add((thu_tien_guixe) t);

        }

        // mylist.get(0).setTrangthai_Thu("Đã thu"); mylist.get(0).setNgay_thu(Date.valueOf(LocalDate.now()));

        //  m.thu_tien_CapNhat(mylist.get(0));
        System.out.println(mylist.get(0).getMS_KThu());


    }

}

/*
    public void khoan_thu_Hientai(khoan_thu kt) {

        String sql = "select * from " + kt.getTable_name() + " where Trang_thai_khoanthu = 'Chưa kết thúc' ";

        try (PreparedStatement stm = conn.prepareStatement(sql)) {


            ResultSet resultSet = stm.executeQuery();
          while (resultSet.next()) {
            kt.getDataFromRs(resultSet);
          }
            //else{ JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu phù hợp"); return null;}
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // Handle potential exceptions
            // e.printStackTrace();
        }

    }
 */

