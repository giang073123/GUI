    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
     */
    package com.raven.form.QuanLyThuong;
    import java.io.File;
    import java.io.IOException;
    import java.awt.Container;
    import com.raven.model.DanhSachThuongHocTapDAO;
    import com.raven.model.DanhSachThuongHocTap;
    import com.raven.model.QuanLyThuongHocTapDAO;
    import com.raven.model.QuanLyThuongHocTap;
    import javax.swing.table.DefaultTableModel;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
    import javax.swing.JFileChooser;

    import java.util.List;

    /**
     *
     * @author dangk
     */
    public class Form_ThemKhoanThuongHocTap extends javax.swing.JPanel {

        /**
         * Creates new form Form_ThemKhoanThuongHocTap
         */
        public Form_ThemKhoanThuongHocTap() {
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

            jLabel_HocSinhTT = new javax.swing.JLabel();
            searchText_HocSinhTT = new com.raven.swing.SearchText();
            jLabel_TienKhac = new javax.swing.JLabel();
            searchText_TienKhac = new com.raven.swing.SearchText();
            jLabel_GhiChu = new javax.swing.JLabel();
            jLabel_TieuDe = new javax.swing.JLabel();
            jLabel_TenKhoanThuong = new javax.swing.JLabel();
            jLabel_HocSinhGioi = new javax.swing.JLabel();
            searchText_TenKhoanThuong = new com.raven.swing.SearchText();
            searchText_GhiChu = new com.raven.swing.SearchText();
            jButton_XacNhan = new javax.swing.JButton();
            searchText_HocSinhGioi = new com.raven.swing.SearchText();
            jButton_QuayLai = new javax.swing.JButton();

            jLabel_HocSinhTT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jLabel_HocSinhTT.setText("Tiền thưởng học sinh tiên tiến:");

            searchText_HocSinhTT.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    searchText_HocSinhTTActionPerformed(evt);
                }
            });

            jLabel_TienKhac.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jLabel_TienKhac.setText("Tiền thưởng khác:");

            searchText_TienKhac.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    searchText_TienKhacActionPerformed(evt);
                }
            });

            jLabel_GhiChu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jLabel_GhiChu.setText("Ghi chú:");

            jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel_TieuDe.setText("Điền thông tin khoản thưởng học tập mới");

            jLabel_TenKhoanThuong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jLabel_TenKhoanThuong.setText("Tên khoản thưởng:");

            jLabel_HocSinhGioi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jLabel_HocSinhGioi.setText("Tiền thưởng học sinh giỏi:");

            searchText_TenKhoanThuong.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    searchText_TenKhoanThuongActionPerformed(evt);
                }
            });

            searchText_GhiChu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    searchText_GhiChuActionPerformed(evt);
                }
            });


            jButton_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jButton_XacNhan.setText("Xác nhận");

            jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jButton_QuayLai.setText("Quay lại");
            jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_QuayLaiActionPerformed(evt);
                }
            });
            jButton_XacNhan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    xacNhanButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_TenKhoanThuong)
                                    .addComponent(jLabel_HocSinhTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_TienKhac)
                                    .addComponent(jLabel_HocSinhGioi, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel_GhiChu))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(searchText_GhiChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchText_HocSinhTT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchText_TenKhoanThuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchText_TienKhac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchText_HocSinhGioi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton_XacNhan)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(84, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(76, 76, 76)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(searchText_TenKhoanThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_TenKhoanThuong))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_HocSinhGioi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchText_HocSinhGioi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_HocSinhTT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchText_HocSinhTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_TienKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchText_TienKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(searchText_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(66, 66, 66)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_QuayLai)
                        .addComponent(jButton_XacNhan))
                    .addContainerGap(78, Short.MAX_VALUE))
            );
        }// </editor-fold>//GEN-END:initComponents

        private void searchText_TienKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TienKhacActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_searchText_TienKhacActionPerformed

        private void searchText_TenKhoanThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TenKhoanThuongActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_searchText_TenKhoanThuongActionPerformed

        private void searchText_HocSinhTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_HocSinhTTActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_searchText_HocSinhTTActionPerformed

        private void searchText_GhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_GhiChuActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_searchText_GhiChuActionPerformed

        private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuayLaiActionPerformed
            Form_QuanLyThuongHocTap formQuanLyThuongHocTap = new Form_QuanLyThuongHocTap();

            // Get the parent container (JFrame or another container)
            Container parentContainer = this.getParent();

            // Remove the current panel (Form_ThongTinHo) from the parent container
            parentContainer.remove(this);

            // Add the new panel (Form_ThongTinChiTiet) to the parent container
            parentContainer.add(formQuanLyThuongHocTap);

            // Repaint the container to reflect the changes
            parentContainer.revalidate();
            parentContainer.repaint();
        }//GEN-LAST:event_jButton_QuayLaiActionPerformed
        private void xacNhanButtonActionPerformed(java.awt.event.ActionEvent evt) {
            // Retrieve values from text fields
            String tenKhoanThuong = searchText_TenKhoanThuong.getText();
            int thuongHsgDacBiet = Integer.parseInt(searchText_HocSinhGioi.getText());
            int thuongHstt = Integer.parseInt(searchText_HocSinhTT.getText());
            int thuongKhac = Integer.parseInt(searchText_TienKhac.getText());
            String ghiChu = searchText_GhiChu.getText();

            // Create a new QuanLyThuongHocTap object
            QuanLyThuongHocTap newKhoanThuong = new QuanLyThuongHocTap();
            newKhoanThuong.setTenKThg(tenKhoanThuong);
            newKhoanThuong.setThuongHsgDacBiet(thuongHsgDacBiet);
            newKhoanThuong.setThuongHstt(thuongHstt);
            newKhoanThuong.setThuongKhac(thuongKhac);
            newKhoanThuong.setGhiChu(ghiChu);

            // Save the new award using KhoanThuongHocTapDAO
            QuanLyThuongHocTapDAO dao = new QuanLyThuongHocTapDAO();
            try {
                dao.addKhoanThuongHocTap(newKhoanThuong);
                JOptionPane.showMessageDialog(this, "Khoản thưởng mới đã được thêm thành công.");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton_QuayLai;
        private javax.swing.JButton jButton_XacNhan;
        private javax.swing.JLabel jLabel_GhiChu;
        private javax.swing.JLabel jLabel_HocSinhGioi;
        private javax.swing.JLabel jLabel_HocSinhTT;
        private javax.swing.JLabel jLabel_TenKhoanThuong;
        private javax.swing.JLabel jLabel_TienKhac;
        private javax.swing.JLabel jLabel_TieuDe;
        private com.raven.swing.SearchText searchText_GhiChu;
        private com.raven.swing.SearchText searchText_HocSinhGioi;
        private com.raven.swing.SearchText searchText_HocSinhTT;
        private com.raven.swing.SearchText searchText_TenKhoanThuong;
        private com.raven.swing.SearchText searchText_TienKhac;
        // End of variables declaration//GEN-END:variables
    }
