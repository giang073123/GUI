/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyTaiKhoan;

import com.raven.form.QuanLyNhanKhau.Form_NhanKhauMoi;
import java.awt.Container;

public class Form_QuanLyTaiKhoan extends javax.swing.JPanel {

    public Form_QuanLyTaiKhoan() {
        initComponents();
        jButton_DoiMK.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_DoiMKActionPerformed(evt);
        }
    });
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_DoiMKActionPerformed(evt);
        }
    });
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jLabel_MaCB = new javax.swing.JLabel();
        jLabel_TenCB = new javax.swing.JLabel();
        jLabel_ChucVu = new javax.swing.JLabel();
        jButton_DoiMK = new javax.swing.JButton();
        jLabel_MaCB1 = new javax.swing.JLabel();
        jLabel_TenCB1 = new javax.swing.JLabel();
        jLabel_ChucVu1 = new javax.swing.JLabel();
        jLabel_CCCD = new javax.swing.JLabel();
        jLabel_CCCD1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton_CapNhat2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSach = new com.raven.swing.Table();
        jButton_Them = new javax.swing.JButton();
        jButton_CapNhat = new javax.swing.JButton();
        jLabel_TieuDe1 = new javax.swing.JLabel();

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Thông tin tài khoản cá nhân");

        jLabel_MaCB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_MaCB.setText("Mã cán bộ:");

        jLabel_TenCB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenCB.setText("Tên cán bộ:");

        jLabel_ChucVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_ChucVu.setText("Chức vụ:");

        jButton_DoiMK.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_DoiMK.setText("Thay đổi mật khẩu");
        jButton_DoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DoiMKActionPerformed(evt);
            }
        });

        jLabel_MaCB1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaCB1.setText("jLabel_MaCB");

        jLabel_TenCB1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenCB1.setText("jLabel_TenCB");

        jLabel_ChucVu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_ChucVu1.setText("jLabel_ChucVu");

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_CCCD.setText("CCCD:");

        jLabel_CCCD1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_CCCD1.setText("jLabel_CCCD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_TenCB)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel_MaCB)
                                        .addGap(140, 140, 140))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel_ChucVu, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_CCCD, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_CCCD1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_TenCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_ChucVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_MaCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_DoiMK)
                        .addGap(100, 100, 100))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaCB)
                    .addComponent(jLabel_MaCB1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenCB)
                    .addComponent(jLabel_TenCB1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ChucVu)
                    .addComponent(jLabel_ChucVu1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(jLabel_CCCD1))
                .addGap(218, 218, 218)
                .addComponent(jButton_DoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        jTabbedPane1.addTab("Thông tin cá nhân", jPanel3);

        jButton_CapNhat2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat2.setText("Xóa");
        jButton_CapNhat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhat2ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã cán bộ", "CCCD", "Họ và tên", "Tên tài khoản", "Mật khẩu", "Chức vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSach);

        jButton_Them.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Them.setText("Thêm");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jButton_CapNhat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat.setText("Cập nhật");
        jButton_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatActionPerformed(evt);
            }
        });

        jLabel_TieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_TieuDe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe1.setText("Danh sách cán bộ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_CapNhat)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Them)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_CapNhat2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Them)
                    .addComponent(jButton_CapNhat)
                    .addComponent(jButton_CapNhat2))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách tài khoản cán bộ", jPanel1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jButton_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DoiMKActionPerformed
       Form_DoiMatKhau formDoiMatKhau = new Form_DoiMatKhau();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDoiMatKhau);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_DoiMKActionPerformed

    private void jButton_CapNhat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhat2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CapNhat2ActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        Form_ThemCanBo formThemCanBo= new Form_ThemCanBo();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThemCanBo);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CapNhatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JButton jButton_CapNhat2;
    private javax.swing.JButton jButton_DoiMK;
    private javax.swing.JButton jButton_Them;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_CCCD1;
    private javax.swing.JLabel jLabel_ChucVu;
    private javax.swing.JLabel jLabel_ChucVu1;
    private javax.swing.JLabel jLabel_MaCB;
    private javax.swing.JLabel jLabel_MaCB1;
    private javax.swing.JLabel jLabel_TenCB;
    private javax.swing.JLabel jLabel_TenCB1;
    private javax.swing.JLabel jLabel_TieuDe;
    private javax.swing.JLabel jLabel_TieuDe1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.Table table_DanhSach;
    // End of variables declaration//GEN-END:variables
}
