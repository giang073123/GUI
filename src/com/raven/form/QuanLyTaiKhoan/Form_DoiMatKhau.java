/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyTaiKhoan;

import java.awt.Container;

/**
 *
 * @author dangk
 */
public class Form_DoiMatKhau extends javax.swing.JPanel {
    int mycheck;
    /**
     * Creates new form Form_DoiMatKhau
     */
    public Form_DoiMatKhau(int check) {
        initComponents();
        mycheck = check;
        jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_HuyActionPerformed(evt);
        }
    });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchText_MkCu1 = new com.raven.swing.SearchText();
        jLabel_MkCu1 = new javax.swing.JLabel();
        searchText_MkCu2 = new com.raven.swing.SearchText();
        jLabel_MkCu2 = new javax.swing.JLabel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jButton_DoiMK = new javax.swing.JButton();
        searchText_MkCu = new com.raven.swing.SearchText();
        jButton_Huy = new javax.swing.JButton();
        jLabel_MkCu = new javax.swing.JLabel();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MkCu2)
                            .addComponent(jLabel_MkCu1)
                            .addComponent(jLabel_MkCu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchText_MkCu, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(searchText_MkCu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchText_MkCu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(228, 228, 228))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_DoiMK)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Huy)
                        .addGap(98, 98, 98))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText_MkCu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MkCu))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText_MkCu1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MkCu1))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText_MkCu2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MkCu2))
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Huy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_DoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DoiMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_DoiMKActionPerformed

    private void jButton_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyActionPerformed
        Form_QuanLyTaiKhoan formQuanLyTaiKhoan = new Form_QuanLyTaiKhoan(mycheck);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formQuanLyTaiKhoan);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_HuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DoiMK;
    private javax.swing.JButton jButton_Huy;
    private javax.swing.JLabel jLabel_MkCu;
    private javax.swing.JLabel jLabel_MkCu1;
    private javax.swing.JLabel jLabel_MkCu2;
    private javax.swing.JLabel jLabel_TieuDe;
    private com.raven.swing.SearchText searchText_MkCu;
    private com.raven.swing.SearchText searchText_MkCu1;
    private com.raven.swing.SearchText searchText_MkCu2;
    // End of variables declaration//GEN-END:variables
}
