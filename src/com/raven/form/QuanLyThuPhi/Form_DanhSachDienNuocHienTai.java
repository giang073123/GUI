/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi;

import java.awt.Container;

/**
 *
 * @author dangk
 */
public class Form_DanhSachDienNuocHienTai extends javax.swing.JPanel {

    /**
     * Creates new form Form_DanhSachDienNuocHienTai
     */
    public Form_DanhSachDienNuocHienTai() {
        initComponents();
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        }); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_MaSoKT = new javax.swing.JLabel();
        jLabel_TenKT1 = new javax.swing.JLabel();
        jLabel_MaSoKT1 = new javax.swing.JLabel();
        jLabel_NhapMa = new javax.swing.JLabel();
        miniSearch_NhapMa = new com.raven.component.MiniSearch();
        jButton_TimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSach = new com.raven.swing.Table();
        jButton_Them = new javax.swing.JButton();
        jButton_CapNhat = new javax.swing.JButton();
        jButton_XuatFile = new javax.swing.JButton();
        jLabel_LoaiKT = new javax.swing.JLabel();
        jLabel_LoaiKT1 = new javax.swing.JLabel();
        jButton_Thoat = new javax.swing.JButton();

        jLabel_MaSoKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSoKT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MaSoKT.setText("Mã số khoản thu:");

        jLabel_TenKT1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT1.setText("jLabel_TenKT");

        jLabel_MaSoKT1.setText("jLabel_MaKT");

        jLabel_NhapMa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_NhapMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_NhapMa.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số", "Mã hộ", "Số tiền", "Loại", "Ngày thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSach);

        jButton_Them.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Them.setText("Thêm danh sách");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jButton_CapNhat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat.setText("Cập nhật danh sách");
        jButton_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatActionPerformed(evt);
            }
        });

        jButton_XuatFile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFile.setText("Xuất File");
        jButton_XuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XuatFileActionPerformed(evt);
            }
        });

        jLabel_LoaiKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_LoaiKT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_LoaiKT.setText("Loại:");

        jLabel_LoaiKT1.setText("jLabel_LoaiKT");

        jButton_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Thoat.setText("Thoát");
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_NhapMa)
                        .addGap(18, 18, 18)
                        .addComponent(miniSearch_NhapMa, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton_TimKiem))
                    .addComponent(jLabel_TenKT1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_LoaiKT)
                            .addComponent(jLabel_MaSoKT))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MaSoKT1)
                            .addComponent(jLabel_LoaiKT1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton_XuatFile)
                            .addGap(10, 10, 10)
                            .addComponent(jButton_CapNhat)
                            .addGap(10, 10, 10)
                            .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jButton_Thoat))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel_TenKT1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSoKT)
                    .addComponent(jLabel_MaSoKT1))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_LoaiKT)
                    .addComponent(jLabel_LoaiKT1))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(miniSearch_NhapMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_NhapMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Them)
                    .addComponent(jButton_CapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_XuatFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Thoat))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CapNhatActionPerformed

    private void jButton_XuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XuatFileActionPerformed

    private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThoatActionPerformed
         Form_ThuPhiDienNuoc formThuPhiDienNuoc= new Form_ThuPhiDienNuoc();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThuPhiDienNuoc);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JButton jButton_Them;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_XuatFile;
    private javax.swing.JLabel jLabel_LoaiKT;
    private javax.swing.JLabel jLabel_LoaiKT1;
    private javax.swing.JLabel jLabel_MaSoKT;
    private javax.swing.JLabel jLabel_MaSoKT1;
    private javax.swing.JLabel jLabel_NhapMa;
    private javax.swing.JLabel jLabel_TenKT1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.component.MiniSearch miniSearch_NhapMa;
    private com.raven.swing.Table table_DanhSach;
    // End of variables declaration//GEN-END:variables
}
