/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi;

import com.raven.form.QuanLyThuPhi.Form_LichSuDanhSachDienNuoc;
import com.raven.form.QuanLyThuPhi.Form_ThemKhoanThuDienNuoc;
import com.raven.form.QuanLyThuPhi.Form_DanhSachDienNuocHienTai;
import java.awt.Container;

/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiDienNuoc extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThuPhiDienNuoc
     */
    public Form_ThuPhiDienNuoc() {
        initComponents();
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTietActionPerformed(evt);
            }
        }); 
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        }); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_KhoanThuDienNuoc = new com.raven.swing.Table();
        jButton_KetThuc = new javax.swing.JButton();
        jButton_XemChiTiet = new javax.swing.JButton();
        jButton_Xoa = new javax.swing.JButton();
        jButton_Them = new javax.swing.JButton();
        jLabel_ChonNgay = new javax.swing.JLabel();
        jDateChooser_ChonNgay = new com.toedter.calendar.JDateChooser();
        jLabel_Loai = new javax.swing.JLabel();
        jComboBox_LoaiTien = new javax.swing.JComboBox<>();
        jButton_XemChiTiet1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton_XemChiTiet2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_KhoanThuDienNuoc1 = new com.raven.swing.Table();
        jLabel_ChonNgay1 = new javax.swing.JLabel();
        jDateChooser_ChonNgay1 = new com.toedter.calendar.JDateChooser();
        jLabel_Loai1 = new javax.swing.JLabel();
        jComboBox_LoaiTien1 = new javax.swing.JComboBox<>();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel_TieuDe1 = new javax.swing.JLabel();

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Các khoản thu tiền điện, nước, Internet hiện tại");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_KhoanThuDienNuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số", "Tên ", "Loại", "Ngày tạo", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table_KhoanThuDienNuoc);

        jButton_KetThuc.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThuc.setText("Kết thúc khoản thu");
        jButton_KetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucActionPerformed(evt);
            }
        });

        jButton_XemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet.setText("Xem chi tiết");
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTietActionPerformed(evt);
            }
        });

        jButton_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Xoa.setText("Xóa khoản thu");
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jButton_Them.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Them.setText("Thêm khoản thu");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jLabel_ChonNgay.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_ChonNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ChonNgay.setText("Chọn ngày:");

        jLabel_Loai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Loai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Loai.setText("Loại:");

        jComboBox_LoaiTien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền điện", "Tiền nước", "Tiền Internet" }));

        jButton_XemChiTiet1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet1.setText("Tìm kiếm");
        jButton_XemChiTiet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTiet1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_XemChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_KetThuc))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel_ChonNgay)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jDateChooser_ChonNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Loai)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox_LoaiTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(jButton_XemChiTiet1))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_ChonNgay)
                    .addComponent(jDateChooser_ChonNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_LoaiTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_XemChiTiet1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Loai)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_KetThuc)
                    .addComponent(jButton_Xoa)
                    .addComponent(jButton_Them)
                    .addComponent(jButton_XemChiTiet))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Theo dõi các khoản thu phí điện, nước, Internet hiện tại", jPanel3);

        jButton_XemChiTiet2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet2.setText("Xem chi tiết");
        jButton_XemChiTiet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTiet2ActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_KhoanThuDienNuoc1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số", "Tên ", "Loại", "Ngày tạo", "Ngày kết thúc", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table_KhoanThuDienNuoc1);

        jLabel_ChonNgay1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_ChonNgay1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ChonNgay1.setText("Chọn ngày:");

        jLabel_Loai1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Loai1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Loai1.setText("Loại:");

        jComboBox_LoaiTien1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền điện", "Tiền nước", "Tiền Internet" }));

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jLabel_TieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe1.setText("Các khoản thu tiền điện, nước, Internet hiện tại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_XemChiTiet2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel_ChonNgay1)
                            .addGap(18, 18, 18)
                            .addComponent(jDateChooser_ChonNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel_Loai1)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox_LoaiTien1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_TimKiem))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_LoaiTien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Loai1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser_ChonNgay1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_ChonNgay1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_XemChiTiet2)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử các khoản thu phí điện, nước, Internet", jPanel1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void jButton_KetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KetThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_KetThucActionPerformed

    private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XemChiTietActionPerformed
         Form_DanhSachDienNuocHienTai formDanhSachDienNuocHienTai = new Form_DanhSachDienNuocHienTai();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDanhSachDienNuocHienTai);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_XemChiTietActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        Form_ThemKhoanThuDienNuoc formThemKhoanThuDienNuoc = new Form_ThemKhoanThuDienNuoc();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThemKhoanThuDienNuoc);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_XemChiTiet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XemChiTiet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XemChiTiet1ActionPerformed

    private void jButton_XemChiTiet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XemChiTiet2ActionPerformed
        Form_LichSuDanhSachDienNuoc formLichSuDanhSachDienNuoc = new Form_LichSuDanhSachDienNuoc();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formLichSuDanhSachDienNuoc);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_XemChiTiet2ActionPerformed

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_TimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_KetThuc;
    private javax.swing.JButton jButton_Them;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XemChiTiet1;
    private javax.swing.JButton jButton_XemChiTiet2;
    private javax.swing.JButton jButton_Xoa;
    private javax.swing.JComboBox<String> jComboBox_LoaiTien;
    private javax.swing.JComboBox<String> jComboBox_LoaiTien1;
    private com.toedter.calendar.JDateChooser jDateChooser_ChonNgay;
    private com.toedter.calendar.JDateChooser jDateChooser_ChonNgay1;
    private javax.swing.JLabel jLabel_ChonNgay;
    private javax.swing.JLabel jLabel_ChonNgay1;
    private javax.swing.JLabel jLabel_Loai;
    private javax.swing.JLabel jLabel_Loai1;
    private javax.swing.JLabel jLabel_TieuDe;
    private javax.swing.JLabel jLabel_TieuDe1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.Table table_KhoanThuDienNuoc;
    private com.raven.swing.Table table_KhoanThuDienNuoc1;
    // End of variables declaration//GEN-END:variables
}
