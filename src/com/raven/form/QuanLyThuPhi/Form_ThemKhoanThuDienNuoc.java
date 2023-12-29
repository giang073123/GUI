/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi;

import Model.ThuPhi.Model_ThuPhi;
import com.raven.form.QuanLyThuPhi.Form_ThuPhiDienNuoc;
import java.awt.Container;

/**
 *
 * @author dangk
 */
public class Form_ThemKhoanThuDienNuoc extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    /**
     * Creates new form Form_ThemKhoanThuDienNuoc
     */
    public Form_ThemKhoanThuDienNuoc(Model_ThuPhi model) {
        myModel=model;
        initComponents();
         jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        }); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchText_GhiChu = new com.raven.swing.SearchText();
        jButton_XacNhan = new javax.swing.JButton();
        jLabel_GhiChu = new javax.swing.JLabel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jLabel_TenKhoanThu = new javax.swing.JLabel();
        jLabel_Loai = new javax.swing.JLabel();
        searchText_TenKhoanThu = new com.raven.swing.SearchText();
        jButton_QuayLai = new javax.swing.JButton();
        jComboBox_Loai = new javax.swing.JComboBox<>();

        searchText_GhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_GhiChuActionPerformed(evt);
            }
        });

        jButton_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XacNhan.setText("Xác nhận");
        jButton_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XacNhanActionPerformed(evt);
            }
        });

        jLabel_GhiChu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_GhiChu.setText("Ghi chú:");

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Điền thông tin khoản thu điện, nước, Internet mới");

        jLabel_TenKhoanThu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TenKhoanThu.setText("Tên khoản thu:");

        jLabel_Loai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Loai.setText("Loại:");

        searchText_TenKhoanThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_TenKhoanThuActionPerformed(evt);
            }
        });

        jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_QuayLai.setText("Quay lại");
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        });

        jComboBox_Loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền điện", "Tiền nước", "Tiền Internet" }));
        jComboBox_Loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_LoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_TenKhoanThu)
                            .addComponent(jLabel_GhiChu))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchText_GhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                            .addComponent(searchText_TenKhoanThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_XacNhan)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText_TenKhoanThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TenKhoanThu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_QuayLai)
                    .addComponent(jButton_XacNhan))
                .addGap(82, 82, 82))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchText_GhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_GhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_GhiChuActionPerformed

    private void jButton_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XacNhanActionPerformed

    private void searchText_TenKhoanThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TenKhoanThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_TenKhoanThuActionPerformed

    private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuayLaiActionPerformed
        Form_ThuPhiDienNuoc formThuPhiDienNuoc = new Form_ThuPhiDienNuoc(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThuPhiDienNuoc);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_QuayLaiActionPerformed

    private void jComboBox_LoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_LoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_LoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_QuayLai;
    private javax.swing.JButton jButton_XacNhan;
    private javax.swing.JComboBox<String> jComboBox_Loai;
    private javax.swing.JLabel jLabel_GhiChu;
    private javax.swing.JLabel jLabel_Loai;
    private javax.swing.JLabel jLabel_TenKhoanThu;
    private javax.swing.JLabel jLabel_TieuDe;
    private com.raven.swing.SearchText searchText_GhiChu;
    private com.raven.swing.SearchText searchText_TenKhoanThu;
    // End of variables declaration//GEN-END:variables
}
