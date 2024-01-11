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
import com.raven.model.ThongKeThuongHocTapDAO;
import com.raven.model.ThongKeThuongHocTap;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import java.util.List;



public class Form_ThongKeThuongHocTap extends javax.swing.JPanel {

    private Integer ms_kthg;
    private String tenKthg;
    public Form_ThongKeThuongHocTap() {
        initComponents();
        jButton_QuayLai1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_QuayLai1ActionPerformed(evt);
        }
    });
    }
    public Form_ThongKeThuongHocTap(Integer ms_kthg, String tenKthg) {
        this.ms_kthg = ms_kthg;
        this.tenKthg = tenKthg;
        initComponents();
        displayThongKeThuongHocTap();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel_TieuDe1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_ThongKe1 = new com.raven.swing.Table();
        jButton_XuatFile1 = new javax.swing.JButton();
        jButton_QuayLai1 = new javax.swing.JButton();
        searchText_MaHo1 = new com.raven.swing.SearchText();
        jButton_TimKiem1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel_TieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe1.setText("Thống kê số lượng thưởng học tập");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_ThongKe1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Tên chủ hộ", "Số lượng phần quà đã nhận", "Quà học sinh giỏi", "Quà học sinh tiên tiến", "Quà thành tích khác"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane3.setViewportView(table_ThongKe1);

        jButton_XuatFile1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFile1.setText("Xuất File");
        jButton_XuatFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XuatFile1ActionPerformed(evt);
            }
        });

        jButton_QuayLai1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_QuayLai1.setText("Quay lại");
        jButton_QuayLai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLai1ActionPerformed(evt);
            }
        });

        searchText_MaHo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_MaHo1ActionPerformed(evt);
            }
        });

        jButton_TimKiem1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem1.setText("Tìm kiếm");
        jButton_TimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiem1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Nhập mã hộ:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_XuatFile1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_QuayLai1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(20, 20, 20)
                            .addComponent(searchText_MaHo1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(jButton_TimKiem1))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_TimKiem1)
                    .addComponent(searchText_MaHo1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_QuayLai1)
                    .addComponent(jButton_XuatFile1))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_XuatFile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatFile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XuatFile1ActionPerformed


    private void displayThongKeThuongHocTap() {
        try {
            ThongKeThuongHocTapDAO dao = new ThongKeThuongHocTapDAO();
            List<ThongKeThuongHocTap> thongKeList = dao.thongKeThuongHocTap(this.ms_kthg);

            // Lấy mô hình bảng từ JTable và xóa dữ liệu hiện tại
            DefaultTableModel model = (DefaultTableModel) this.table_ThongKe1.getModel();
            model.setRowCount(0);

            // Điền dữ liệu vào bảng
            for (ThongKeThuongHocTap item : thongKeList) {
                model.addRow(new Object[]{
                        item.getMaHo(),
                        item.getTenChuHo(),
                        item.getSoLuongPhanQua(),
                        item.getQuaHocSinhGioi(),
                        item.getQuaHocSinhTienTien(),
                        item.getQuaThanhTichKhac()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi truy vấn cơ sở dữ liệu.", "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton_QuayLai1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Tạo một đối tượng mới của Form_DanhSachThuongHocTap với các tham số truyền vào
        Form_DanhSachThuongHocTap formDanhSachThuongHocTap = new Form_DanhSachThuongHocTap(ms_kthg, tenKthg);

        // Các bước tiếp theo như bạn đã thực hiện
        Container parentContainer = this.getParent();
        parentContainer.remove(this);
        parentContainer.add(formDanhSachThuongHocTap);
        parentContainer.revalidate();
        parentContainer.repaint();
    }

    private void searchText_MaHo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MaHo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_MaHo1ActionPerformed

    private void jButton_TimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_TimKiem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_QuayLai1;
    private javax.swing.JButton jButton_TimKiem1;
    private javax.swing.JButton jButton_XuatFile1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_TieuDe1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.raven.swing.SearchText searchText_MaHo1;
    private com.raven.swing.Table table_ThongKe1;
    // End of variables declaration//GEN-END:variables
}
