/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyTaiKhoan;

/**
 *
 * @author dangk
 */
public class Form_ThemCanBo extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThemCanBo
     */
    public Form_ThemCanBo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchText_MkCu = new com.raven.swing.SearchText();
        searchText_MkCu1 = new com.raven.swing.SearchText();
        jLabel1 = new javax.swing.JLabel();
        jLabel_CCCD1 = new javax.swing.JLabel();
        jLabel_CCCD2 = new javax.swing.JLabel();
        jLabel_TenCB = new javax.swing.JLabel();
        jLabel_ChucVu = new javax.swing.JLabel();
        searchText_MkCu2 = new com.raven.swing.SearchText();
        jButton_DoiMK = new javax.swing.JButton();
        searchText_MkCu3 = new com.raven.swing.SearchText();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton_DoiMK1 = new javax.swing.JButton();
        jLabel_CCCD = new javax.swing.JLabel();

        searchText_MkCu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        searchText_MkCu1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        searchText_MkCu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_MkCu1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kê khai thông tin cán bộ mới");

        jLabel_CCCD1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_CCCD1.setText("Tài khoản:");

        jLabel_CCCD2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_CCCD2.setText("Mật khẩu");

        jLabel_TenCB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenCB.setText("Tên cán bộ:");

        jLabel_ChucVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_ChucVu.setText("Chức vụ:");

        searchText_MkCu2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        searchText_MkCu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_MkCu2ActionPerformed(evt);
            }
        });

        jButton_DoiMK.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_DoiMK.setText("Quay lại");
        jButton_DoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DoiMKActionPerformed(evt);
            }
        });

        searchText_MkCu3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        searchText_MkCu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_MkCu3ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổ trưởng", "Tổ phó", "Cán bộ quản lý nhân khẩu", "Cán bộ quản lý thưởng", "Cán bộ quản lý thu chi" }));

        jButton_DoiMK1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_DoiMK1.setText("Xác nhận");
        jButton_DoiMK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DoiMK1ActionPerformed(evt);
            }
        });

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_CCCD.setText("CCCD:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_CCCD)
                    .addComponent(jLabel_ChucVu)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton_DoiMK1)
                            .addGap(27, 27, 27)
                            .addComponent(jButton_DoiMK))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_TenCB)
                                .addComponent(jLabel_CCCD2)
                                .addComponent(jLabel_CCCD1))
                            .addGap(92, 92, 92)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(searchText_MkCu3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchText_MkCu2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchText_MkCu1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchText_MkCu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(273, 273, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenCB)
                    .addComponent(searchText_MkCu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(searchText_MkCu1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ChucVu)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CCCD1)
                    .addComponent(searchText_MkCu2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CCCD2)
                    .addComponent(searchText_MkCu3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton_DoiMK1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(174, 174, 174))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchText_MkCu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MkCu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_MkCu1ActionPerformed

    private void searchText_MkCu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MkCu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_MkCu2ActionPerformed

    private void jButton_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DoiMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_DoiMKActionPerformed

    private void searchText_MkCu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MkCu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_MkCu3ActionPerformed

    private void jButton_DoiMK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DoiMK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_DoiMK1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DoiMK;
    private javax.swing.JButton jButton_DoiMK1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_CCCD1;
    private javax.swing.JLabel jLabel_CCCD2;
    private javax.swing.JLabel jLabel_ChucVu;
    private javax.swing.JLabel jLabel_TenCB;
    private com.raven.swing.SearchText searchText_MkCu;
    private com.raven.swing.SearchText searchText_MkCu1;
    private com.raven.swing.SearchText searchText_MkCu2;
    private com.raven.swing.SearchText searchText_MkCu3;
    // End of variables declaration//GEN-END:variables
}
