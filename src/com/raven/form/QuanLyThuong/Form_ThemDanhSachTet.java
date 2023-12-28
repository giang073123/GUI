/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuong;

import java.awt.Container;

/**
 *
 * @author dangk
 */
public class Form_ThemDanhSachTet extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThemDanhSachTet
     */
    public Form_ThemDanhSachTet() {
        initComponents();
         jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_HuyActionPerformed(evt);
        }
    });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_CCCD = new javax.swing.JLabel();
        jLabel_MaHo = new javax.swing.JLabel();
        jLabel_NgaySinh = new javax.swing.JLabel();
        jLabel_MaSo = new javax.swing.JLabel();
        searchText_CCCD = new com.raven.swing.SearchText();
        searchText_MaHo = new com.raven.swing.SearchText();
        jLabel_TenKhoanThuong = new javax.swing.JLabel();
        jButton_XacNhan = new javax.swing.JButton();
        jButton_Huy = new javax.swing.JButton();
        jLabel_HoVaTen = new javax.swing.JLabel();
        searchText_HoVaTen = new com.raven.swing.SearchText();
        jLabel_TrangThai = new javax.swing.JLabel();
        jComboBox_TrangThai = new javax.swing.JComboBox<>();
        jDateChooser_NgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel_TenKT1 = new javax.swing.JLabel();
        jLabel_MaSo2 = new javax.swing.JLabel();

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_CCCD.setText("CCCD:");

        jLabel_MaHo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaHo.setText("Mã hộ:");

        jLabel_NgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_NgaySinh.setText("Ngày sinh");

        jLabel_MaSo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSo.setText("Mã số:");

        jLabel_TenKhoanThuong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TenKhoanThuong.setText("Tên khoản thưởng:");

        jButton_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XacNhan.setText("Xác nhận");
        jButton_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XacNhanActionPerformed(evt);
            }
        });

        jButton_Huy.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Huy.setText("Hủy");
        jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyActionPerformed(evt);
            }
        });

        jLabel_HoVaTen.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_HoVaTen.setText("Họ và tên:");

        jLabel_TrangThai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TrangThai.setText("Trạng thái:");

        jComboBox_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã hoàn thành", "Chưa hoàn thành" }));
        jComboBox_TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TrangThaiActionPerformed(evt);
            }
        });

        jDateChooser_NgaySinh.setDateFormatString("yyyy-MM-dd");

        jLabel_TenKT1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenKT1.setText("jLabel_TenKT");

        jLabel_MaSo2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaSo2.setText("jLabel_MaSo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_MaSo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_TenKhoanThuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_TenKT1)))
                .addContainerGap(527, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jButton_XacNhan)
                        .addGap(20, 20, 20)
                        .addComponent(jButton_Huy))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_MaHo)
                                    .addComponent(jLabel_NgaySinh)
                                    .addComponent(jLabel_TrangThai))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchText_MaHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox_TrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_CCCD)
                                    .addComponent(jLabel_HoVaTen))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel_MaSo2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(searchText_HoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenKhoanThuong)
                    .addComponent(jLabel_TenKT1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSo)
                    .addComponent(jLabel_MaSo2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_HoVaTen)
                    .addComponent(searchText_HoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaHo)
                    .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_NgaySinh)
                    .addComponent(jDateChooser_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_TrangThai)
                    .addComponent(jComboBox_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XacNhan)
                    .addComponent(jButton_Huy))
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XacNhanActionPerformed

    private void jButton_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyActionPerformed
        Form_DanhSachThuongTet formDanhSachThuongTet = new Form_DanhSachThuongTet();

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formDanhSachThuongTet);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }//GEN-LAST:event_jButton_HuyActionPerformed

    private void jComboBox_TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Huy;
    private javax.swing.JButton jButton_XacNhan;
    private javax.swing.JComboBox<String> jComboBox_TrangThai;
    private com.toedter.calendar.JDateChooser jDateChooser_NgaySinh;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_HoVaTen;
    private javax.swing.JLabel jLabel_MaHo;
    private javax.swing.JLabel jLabel_MaSo;
    private javax.swing.JLabel jLabel_MaSo2;
    private javax.swing.JLabel jLabel_NgaySinh;
    private javax.swing.JLabel jLabel_TenKT1;
    private javax.swing.JLabel jLabel_TenKhoanThuong;
    private javax.swing.JLabel jLabel_TrangThai;
    private com.raven.swing.SearchText searchText_CCCD;
    private com.raven.swing.SearchText searchText_HoVaTen;
    private com.raven.swing.SearchText searchText_MaHo;
    // End of variables declaration//GEN-END:variables
}
