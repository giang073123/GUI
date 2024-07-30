/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyNhanKhau;

import Model.NhanKhau.Model_NhanKhau;
import Model.NhanKhau.ho_gia_dinh;
import Model.NhanKhau.nhan_khau;
import com.raven.swing.*;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author PC Giang
 */
public class Form_NhanKhauMoi extends javax.swing.JPanel {

    Model_NhanKhau myModel;
    ArrayList<SearchText> stList = new ArrayList<>();

    /**
     * Creates new form Form_NhanKhauMoi
     */
    public Form_NhanKhauMoi(Model_NhanKhau model) {
        initComponents();

        stList.add(searchText1);
        stList.add(searchText2);
        stList.add(searchText3);
        stList.add(searchText4);
        stList.add(searchText5);
        stList.add(searchText6);
        stList.add(searchText7);
        stList.add(searchText8);
        stList.add(searchText9);
        stList.add(searchText10);

        myModel = model;

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
    }

    // LUU THONG TIN
    private void jButton2ActionPerformed(ActionEvent evt) {

        Object[] options = {"Xác nhận", "Hủy"};
        int choosen = JOptionPane.showOptionDialog(null,
                "Bạn có chắc chắn muốn thêm nhân khẩu này",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choosen == JOptionPane.YES_OPTION) {
            //THỰC HIỆN THÊM NHÂN KHẨU
            
             // Check nhập đủ thông tin
            if (jDateChooser1.getDate() == null || jDateChooser2.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin yêu cầu");
                return;
            }

            for (int i = 0; i < 10; i++) {
//                if (i == 1 || i == 7 || i == 9) {
//                    continue;
//                }

                if (stList.get(i).getText().length() < 1) {
                    JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin yêu cầu");
                    return;
                }
            }
            
            
            // CHECK MÃ HỘ
                if (!myModel.getVal().validate_Ma_Ho(searchText8.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã hộ không hợp lệ");  // Nhập không đúng định dạng
                    return;
                } else {

                    ho_gia_dinh family = myModel.ho_gia_dinh_getfamily(Integer.parseInt(searchText8.getText()));
                    if (family == null) {
                        JOptionPane.showMessageDialog(null, "Mã hộ này không tồn tại");
                        return;
                    }

                    if (myModel.check_samestring(searchText10.getText(),"Chủ hộ") && family.getCCCD_Chuho().length() > 0) {
                        JOptionPane.showMessageDialog(null, "Hộ này đã có chủ hộ");
                        return;
                    }
                }
            

            // CHECK CCCD:
            // Check CCCD hợp lệ:
            if (!myModel.getVal().validate_CCCD(searchText6.getText())) {
                JOptionPane.showMessageDialog(null, "CCCD không hợp lệ");
                return;
            }

            nhan_khau newnk = myModel.nhan_khau_getALL(searchText6.getText());

            if (newnk == null) {
                newnk = new nhan_khau();
                newnk.setCCCD(searchText6.getText());
                newnk.setHo_ten(searchText1.getText());
                newnk.setMa_Ho(Integer.parseInt(searchText8.getText()));
                newnk.setQH_chuho(searchText10.getText());
                newnk.setBi_danh(searchText2.getText());
                newnk.setGioi_tinh(jComboBox1.getSelectedItem().toString());
                newnk.setNgay_sinh(new java.sql.Date(jDateChooser1.getDate().getTime()));
                newnk.setNoi_sinh(searchText4.getText());
                newnk.setNguyen_quan(searchText5.getText());
                newnk.setDan_toc(searchText3.getText());
                newnk.setNghe_nghiep(searchText7.getText());
                newnk.setNgay_DKTT(new java.sql.Date(jDateChooser2.getDate().getTime()));
                newnk.setNoi_o_truoc(searchText9.getText());

                myModel.nhan_khau_insert(newnk);
                JOptionPane.showMessageDialog(null, "Thêm nhân khẩu thành công.");
                exit();
                return;

            } else if (newnk.getTrang_thai_nhan_khau().compareTo("Thường trú") == 0) {
                JOptionPane.showMessageDialog(null, "Số CCCD đã tồn tại trong dữ liệu dân cư");
                return;
            } else if (newnk.getTrang_thai_nhan_khau().compareTo("Đã xóa") == 0) {  // ĐÃ XÓA TRƯỚC ĐÂY GIỜ QUAY LẠI
                newnk = new nhan_khau();
                newnk.setCCCD(searchText6.getText());
                newnk.setHo_ten(searchText1.getText());
                newnk.setMa_Ho(Integer.parseInt(searchText8.getText()));
                newnk.setQH_chuho(searchText10.getText());
                newnk.setBi_danh(searchText2.getText());
                newnk.setGioi_tinh(jComboBox1.getSelectedItem().toString());
                newnk.setNgay_sinh(new java.sql.Date(jDateChooser1.getDate().getTime()));
                newnk.setNoi_sinh(searchText4.getText());
                newnk.setNguyen_quan(searchText5.getText());
                newnk.setDan_toc(searchText3.getText());
                newnk.setNghe_nghiep(searchText7.getText());
                newnk.setNgay_DKTT(new java.sql.Date(jDateChooser2.getDate().getTime()));
                newnk.setNoi_o_truoc(searchText9.getText());
                newnk.setTrang_thai_nhan_khau("Thường trú");
                
                JOptionPane.showMessageDialog(null, "Thêm nhân khẩu thành công.");
                myModel.nhan_khau_update(newnk);
            } else if (newnk.getTrang_thai_nhan_khau().compareTo("Đã khai tử") == 0) {
                JOptionPane.showMessageDialog(null, "Số CCCD là của nhân khẩu đã khai tử");
                return;
            }

            //JOptionPane.showMessageDialog(null, "--");
            exit();
            return;
        } else if (choosen == JOptionPane.NO_OPTION) {
            return;
        } else if (choosen == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            return;
        }

    }

// THOAT
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        searchText1 = new com.raven.swing.SearchText();
        searchText2 = new com.raven.swing.SearchText();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        searchText3 = new com.raven.swing.SearchText();
        jLabel7 = new javax.swing.JLabel();
        searchText4 = new com.raven.swing.SearchText();
        jLabel8 = new javax.swing.JLabel();
        searchText5 = new com.raven.swing.SearchText();
        jLabel9 = new javax.swing.JLabel();
        searchText6 = new com.raven.swing.SearchText();
        jLabel10 = new javax.swing.JLabel();
        searchText7 = new com.raven.swing.SearchText();
        jLabel11 = new javax.swing.JLabel();
        searchText8 = new com.raven.swing.SearchText();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        searchText9 = new com.raven.swing.SearchText();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        searchText10 = new com.raven.swing.SearchText();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Điền thông tin nhân khẩu mới");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Họ và tên gọi khác (nếu có):");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Ngày tháng năm sinh:");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        searchText2.setText("'Không'");
        searchText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Giới tính:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Dân tộc:");

        searchText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Nơi sinh:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Nguyên quán:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setText("Số CMT/CCCD:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setText("Nghề nghiệp:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setText("Mã hộ:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("Quan hệ với chủ hộ:");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("Ngày đăng ký thường trú:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setText("Thoát");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton2.setText("Lưu thông tin");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setText("Nơi ở trước đây:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel14))
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)))
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchText9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(searchText7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                                    .addComponent(searchText5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchText1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchText4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(25, 25, 25)
                        .addComponent(jButton1)
                        .addGap(33, 33, 33))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(searchText3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                            .addComponent(searchText8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchText6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchText10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchText2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(95, Short.MAX_VALUE))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(searchText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(searchText7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
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

    private void searchText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void searchText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.SearchText searchText10;
    private com.raven.swing.SearchText searchText2;
    private com.raven.swing.SearchText searchText3;
    private com.raven.swing.SearchText searchText4;
    private com.raven.swing.SearchText searchText5;
    private com.raven.swing.SearchText searchText6;
    private com.raven.swing.SearchText searchText7;
    private com.raven.swing.SearchText searchText8;
    private com.raven.swing.SearchText searchText9;
    // End of variables declaration//GEN-END:variables
}
