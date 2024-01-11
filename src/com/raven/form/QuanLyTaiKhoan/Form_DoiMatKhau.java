/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyTaiKhoan;

import java.awt.Container;
import Model.TaiKhoan.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dangk
 */
public class Form_DoiMatKhau extends javax.swing.JPanel {

    Model_TaiKhoan myModel;

    /**
     * Creates new form Form_DoiMatKhau
     */
    public Form_DoiMatKhau(Model_TaiKhoan model) {
        initComponents();
       // searchText_MkCu.setEchoChar('*'); 
       myModel = model;
        jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyActionPerformed(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_MkCu1 = new javax.swing.JLabel();
        jLabel_MkCu2 = new javax.swing.JLabel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jButton_DoiMK = new javax.swing.JButton();
        jButton_Huy = new javax.swing.JButton();
        jLabel_MkCu = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();

        jLabel_MkCu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_MkCu1.setText("Nhập mật khẩu mới:");

        jLabel_MkCu2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_MkCu2.setText("Nhập lại mật khẩu mới:");

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Đổi mật khẩu");

        jButton_DoiMK.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_DoiMK.setText("Xác nhận");
        jButton_DoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DoiMKActionPerformed(evt);
            }
        });

        jButton_Huy.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Huy.setText("Hủy");
        jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyActionPerformed(evt);
            }
        });

        jLabel_MkCu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_MkCu.setText("Nhập mật khẩu cũ:");

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPasswordField1.setText("jPasswordField1iiiiiii");

        jPasswordField2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPasswordField2.setText("jPasswordField2ooooooo");

        jPasswordField3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPasswordField3.setText("jPasswordField3yyyyyyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_DoiMK)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Huy)
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_MkCu2)
                                .addGap(48, 48, 48)
                                .addComponent(jPasswordField3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_MkCu)
                                .addGap(85, 85, 85)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_MkCu1)
                                .addGap(73, 73, 73)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(382, 382, 382))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MkCu)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MkCu1)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MkCu2)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Huy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_DoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DoiMKActionPerformed
        // TODO add your handling code here:

       
        
//        if(searchText_Mkmoi.getText().length()<8){
//             JOptionPane.showMessageDialog(null, "Mật khẩu cần có độ dài trên 8 ký tự");
//            return;
//        }

        Object[] options = {"Xác nhận", "Hủy"};
        int choosen = JOptionPane.showOptionDialog(null,
                "Bạn có chắc chắn muốn đổi mật khẩu?",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choosen == JOptionPane.YES_OPTION) {
            
             if (jPasswordField1.getText().isEmpty() || jPasswordField2.getText().isEmpty() || jPasswordField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập đủ các thông tin yêu cầu");
            return;
        }
        if (jPasswordField1.getText().compareTo(myModel.getCb().getPassword()) != 0) {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ không chính xác");
            return;
        }

        if (jPasswordField2.getText().compareTo(jPasswordField3.getText()) != 0) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới nhập lại không chính xác");
            return;
        }
            
            myModel.getCb().setPassword(jPasswordField2.getText());
            myModel.update_cb(myModel.getCb());
            
            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
            exit();
            return;
        } else if (choosen == JOptionPane.NO_OPTION) {
            return;
        } else if (choosen == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            return;
        }

    }//GEN-LAST:event_jButton_DoiMKActionPerformed

    private void jButton_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyActionPerformed
       exit();
    }//GEN-LAST:event_jButton_HuyActionPerformed

    private void exit(){
        Form_QuanLyTaiKhoan formQuanLyTaiKhoan = new Form_QuanLyTaiKhoan(myModel);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formQuanLyTaiKhoan);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DoiMK;
    private javax.swing.JButton jButton_Huy;
    private javax.swing.JLabel jLabel_MkCu;
    private javax.swing.JLabel jLabel_MkCu1;
    private javax.swing.JLabel jLabel_MkCu2;
    private javax.swing.JLabel jLabel_TieuDe;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables
}
