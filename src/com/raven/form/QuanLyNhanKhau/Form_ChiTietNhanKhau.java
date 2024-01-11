/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyNhanKhau;

import Model.NhanKhau.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PC Giang
 */
public class Form_ChiTietNhanKhau extends javax.swing.JPanel {

    Model_NhanKhau myModel;
    nhan_khau my_nk;

    /**
     * Creates new form Form_ChiTietNhanKhau
     */
    public Form_ChiTietNhanKhau(Model_NhanKhau model, nhan_khau nk) {
        myModel = model;
        my_nk = nk;
        initComponents();
        setinfo();
        //  jTextField_QHChuHo.setVisible(false);jTextField_QHChuHo.setVisible(false);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });
    }

    // HIỂN THỊ THÔNG TIN
    private void setinfo() {
        jLabel18.setText(String.valueOf(my_nk.getMa_Ho()));
        jLabel16.setText(my_nk.getCCCD());
        // jTextField.setText(Integer.toString(my_nk.getMa_Ho()));
        jLabel17.setText(my_nk.getHo_ten());
        jLabel19.setText(my_nk.getQH_chuho());
        jLabel20.setText(my_nk.getBi_danh());
        jLabel21.setText(my_nk.getGioi_tinh());;
        jLabel28.setText(my_nk.getNgay_sinh().toString()); // Convert date to string or format accordingly
        jLabel22.setText(my_nk.getNoi_sinh());
        jLabel23.setText(my_nk.getNguyen_quan());
        jLabel24.setText(my_nk.getDan_toc());
        jLabel25.setText(my_nk.getNghe_nghiep());
        jLabel26.setText(my_nk.getNgay_DKTT().toString()); 
        jLabel27.setText(my_nk.getNoi_o_truoc());

    }

// LUU THONG TIN
//    private void jButton2ActionPerformed(ActionEvent evt) {
//
//        Object[] options = {"Xác nhận", "Hủy"};
//        int choosen = JOptionPane.showOptionDialog(null,
//                "Bạn có chắc chắn muốn lưu thông tin này",
//                "Xác nhận",
//                JOptionPane.YES_NO_CANCEL_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[0]);
//        if (choosen == JOptionPane.YES_OPTION) {
//
//         
//            // CHECK NHẬP THIẾU THÔNG TIN
//            if (jTextField_CCCD.getText().length() < 1 || jTextField_DanToc.getText().length() < 1 || jTextField_HoTen2.getText().length() < 1
//                    || jTextField_NgheNghiep.getText().length() < 1 || jTextField_NguyenQuan.getText().length() < 1 || jTextField_NoiOTruoc.getText().length() < 1
//                    || jTextField_NoiSinh.getText().length() < 1 || jTextField_QHChuHo.getText().length() < 1 || jDateChooser_Ngay.getDate() == null || jDateChooser_Ngay1.getDate() == null) {
//                JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin yêu cầu");
//                return;
//            }
//
//            // CHECK CCCD HỢP LỆ, CCCD TRÙNG VỚI NGƯỜI KHÁC
//            if (!myModel.getVal().validate_CCCD(jTextField_CCCD.getText())) {
//                JOptionPane.showMessageDialog(null, "CCCD không hợp lệ");
//                return;
//            }
//            if (my_nk.getCCCD().compareTo(jTextField_CCCD.getText()) != 0) {
//                nhan_khau test = myModel.nhan_khau_get(jTextField_CCCD.getText());
//                if (test!=null) {
//                    JOptionPane.showMessageDialog(null, "Số CCCD này trùng với nhân khẩu khác");
//                    return;
//                }
//            }
//
//            // CHECK MÃ HỘ HỢP LỆ, QUAN HỆ CHỦ HỘ HỢP LỆ
//            
//             if(Integer.parseInt(jLabel15.getText())==0 && jTextField_QHChuHo.getText().length()>0){
//                JOptionPane.showMessageDialog(null, "Nhân khẩu chưa được thêm vào hộ nào, không thể nhập quan hệ chủ hộ");
//                    return;
//            }
//            
//            ho_gia_dinh family = myModel.ho_gia_dinh_getfamily(Integer.parseInt(jLabel15.getText()));
////            if (my_nk.getQH_chuho().compareTo(jTextField_QHChuHo.getText()) != 0 || my_nk.getQH_chuho()==null ) {
////                if (jTextField_QHChuHo.getText().compareTo("Chủ hộ") == 0 && family.getCCCD_Chuho().length() > 0) {
////                    JOptionPane.showMessageDialog(null, "Hộ này đã có chủ hộ");
////                    return;
////                }
////            }
//              // TRƯỜNG HỢP HỘ CHƯA CÓ CHỦ HỘ, VÀ THÔNG TIN MỚI LÀ CHỦ HỘ
//             if(family.getCCCD_Chuho()==null){
//                  // JOptionPane.showMessageDialog(null,myModel.check_samestring(jTextField_QHChuHo.getText(), "Chủ hộ"));
//                 if (myModel.check_samestring(jTextField_QHChuHo.getText(), "Chủ hộ")) {
//                     family.setCCCD_Chuho(jTextField_CCCD.getText());
//                     //JOptionPane.showMessageDialog(null,family.getCCCD_Chuho());
//                     myModel.ho_gia_dinh_update(family);
//                 }
//             }
//             else {
//                 // TRƯỜNG HỢP HỘ ĐANG CÓ CHỦ HỘ
//                 if (myModel.check_samestring(jTextField_QHChuHo.getText(),"Chủ hộ") && family.getCCCD_Chuho().compareTo(my_nk.getCCCD())!=0) {
//                    JOptionPane.showMessageDialog(null, "Hộ này đã có chủ hộ");
//                    return;
//                }
//                 // TRƯỜNG HỢP ĐANG LÀ CHỦ HỘ, GIỜ XÓA ĐI
//                 else if(myModel.check_samestring(my_nk.getQH_chuho(),"Chủ hộ") || !myModel.check_samestring(jTextField_QHChuHo.getText(),"Chủ hộ") ){
//                     myModel.ho_gia_dinh_delChuho(family);
//                 }
//                 
//             }
//           
//            
//
//            my_nk.setCCCD(jTextField_CCCD.getText());
//            //my_nk.setMa_Ho(Integer.parseInt(jTextField_Ma_Ho.getText())); // Assuming Ma_Ho is an int
//            my_nk.setHo_ten(jTextField_HoTen2.getText());
//            my_nk.setQH_chuho(jTextField_QHChuHo.getText());
//            my_nk.setBi_danh(jTextField_HoTenKhac.getText());
//            my_nk.setGioi_tinh(jComboBox_GioiTinh.getSelectedItem().toString());
//            my_nk.setNgay_sinh(new Date(jDateChooser_Ngay.getDate().getTime()));
//            my_nk.setNoi_sinh(jTextField_NoiSinh.getText());
//            my_nk.setNguyen_quan(jTextField_NguyenQuan.getText());
//            my_nk.setDan_toc(jTextField_DanToc.getText());
//            my_nk.setNghe_nghiep(jTextField_NgheNghiep.getText());
//            my_nk.setNoi_o_truoc(jTextField_NoiOTruoc.getText());
//            my_nk.setNgay_DKTT(new Date(jDateChooser_Ngay1.getDate().getTime()));
//
//            myModel.nhan_khau_update(my_nk);
//            JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin nhân khẩu");
//
//            exit();
//
//            return;
//        } else if (choosen == JOptionPane.NO_OPTION) {
//            return;
//        } else if (choosen == JOptionPane.CANCEL_OPTION) {
//            return;
//        } else {
//            return;
//        }
//
//    }

// THOÁT
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        exit();
    }

    private void exit() {
        // Create an instance of Form_ThongTinChiTiet
        Form_ThongTinNhanKhau formThongTinNhanKhau = new Form_ThongTinNhanKhau(myModel);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formThongTinNhanKhau);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin nhân khẩu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Quan hệ với chủ hộ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Họ và tên gọi khác (nếu có):");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Giới tính:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Ngày tháng năm sinh:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Nơi sinh:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Nguyên quán:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Dân tộc:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setText("Số CMT/CCCD:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setText("Nghề nghiệp:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setText("Họ và tên:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("Ngày đăng ký thường trú:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("Nơi ở trước đây:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setText("Thoát");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setText("Mã hộ:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel16.setText("jLabel16");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel17.setText("jLabel17");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel18.setText("jLabel18");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel19.setText("jLabel19");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel20.setText("jLabel20");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel21.setText("jLabel21");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel22.setText("jLabel22");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel23.setText("jLabel23");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel24.setText("jLabel24");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel25.setText("jLabel25");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel26.setText("jLabel26");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel27.setText("jLabel27");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel28.setText("jLabel28");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(33, 33, 33))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(120, 120, 120)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addContainerGap(149, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(9, 9, 9)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18))
                .addGap(19, 19, 19)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel19))
                .addGap(19, 19, 19)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(11, 11, 11)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.raven.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
