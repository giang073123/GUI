/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuong;
import java.io.File;
import java.io.IOException;
import java.util.List;

import java.awt.Container;
import com.raven.model.DanhSachThuongHocTapDAO;
import com.raven.model.DanhSachThuongHocTap;
import com.raven.model.QuanLyThuongHocTapDAO;
import com.raven.model.QuanLyThuongHocTap;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author dangk
 */
public class Form_LichSuDanhSachThuongHocTap extends javax.swing.JPanel {

    private Integer ms_kthg;
    private String tenKthg;
    public Form_LichSuDanhSachThuongHocTap() {
        initComponents();
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_QuayLaiActionPerformed(evt);
        }
    });
    }

    public Form_LichSuDanhSachThuongHocTap(Integer ms_kthg, String tenKthg) {
        initComponents();
        this.ms_kthg = ms_kthg;
        this.tenKthg = tenKthg;
        jLabel_TenKT.setText(tenKthg);
        jLabel_MaSo1.setText(String.valueOf(ms_kthg));
        fillTableWithDanhSachThuongHocTap(ms_kthg);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSach = new com.raven.swing.Table();
        jLabel_Ten = new javax.swing.JLabel();
        jLabel_CCCD = new javax.swing.JLabel();
        jLabel_MaHo = new javax.swing.JLabel();
        searchText_CCCD = new com.raven.swing.SearchText();
        searchText_Ten = new com.raven.swing.SearchText();
        searchText_MaHo = new com.raven.swing.SearchText();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel1_TenKhoanThuong = new javax.swing.JLabel();
        jLabel_MaSo = new javax.swing.JLabel();
        jButton_QuayLai = new javax.swing.JButton();
        jLabel_TenKT = new javax.swing.JLabel();
        jLabel_MaSo1 = new javax.swing.JLabel();

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "CCCD", "Mã hộ", "Trường học", "Thành tích", "Minh chứng", "Giá trị phần quà", "Ngày thưởng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSach);

        jLabel_Ten.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Ten.setText("Họ và tên: ");

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_CCCD.setText("CCCD: ");

        jLabel_MaHo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaHo.setText("Mã hộ:");

        searchText_CCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_CCCDActionPerformed(evt);
            }
        });

        searchText_Ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_TenActionPerformed(evt);
            }
        });

        searchText_MaHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_MaHoActionPerformed(evt);
            }
        });

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jLabel1_TenKhoanThuong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1_TenKhoanThuong.setText("Tên khoản thưởng:");

        jLabel_MaSo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSo.setText("Mã số:");

        jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_QuayLai.setText("Quay lại");
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        });

        jLabel_TenKT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenKT.setText("jLabel_TenKT");

        jLabel_MaSo1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaSo1.setText("jLabel_MaSo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_QuayLai)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Ten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_CCCD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_MaHo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TimKiem))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1_TenKhoanThuong)
                            .addComponent(jLabel_MaSo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MaSo1)
                            .addComponent(jLabel_TenKT))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1_TenKhoanThuong)
                    .addComponent(jLabel_TenKT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSo)
                    .addComponent(jLabel_MaSo1))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Ten)
                    .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MaHo)
                    .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_QuayLai)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchText_CCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_CCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_CCCDActionPerformed

    private void searchText_TenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_TenActionPerformed

    private void searchText_MaHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MaHoActionPerformed
        String input = searchText_MaHo.getText();
        if (!input.matches("\\d*")) { // Chỉ cho phép nhập số
            JOptionPane.showMessageDialog(this, "Chỉ nhập số cho mã hộ.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
            searchText_MaHo.setText(input.replaceAll("[^\\d]", "")); // Xóa các ký tự không phải số
        }
    }

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        try {
            performSearch();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã hộ phải là một số nguyên.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        }    }
    private void performSearch() {
        String hoTen = searchText_Ten.getText();
        String cccd = searchText_CCCD.getText();
        String maHoStr = searchText_MaHo.getText();
        Integer maHo = maHoStr.isEmpty() ? null : Integer.parseInt(maHoStr);

        try {
            DanhSachThuongHocTapDAO dao = new DanhSachThuongHocTapDAO();
            List<DanhSachThuongHocTap> danhSach = dao.TimKiemThuongHocTap(this.ms_kthg, hoTen, cccd, maHo);

            DefaultTableModel model = (DefaultTableModel) this.table_DanhSach.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ

            for (DanhSachThuongHocTap item : danhSach) {
                model.addRow(new Object[]{
                        item.getHoTen(),
                        item.getCCCD(),
                        item.getMaHo(),
                        item.getTruongHoc(),
                        item.getThanhTich(),
                        item.getMinhChung(),
                        item.getGiaTriPhanQua(),
                        item.getNgayThuong()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

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
    }
    // Phần này đặt trong Form_LichSuDanhSachThuongHocTap.java


    // Phần này đặt trong DanhSachThuongHocTapDAO.java
    public void fillTableWithDanhSachThuongHocTap(int ms_kthg) {
        try {
            // Gọi DAO để lấy dữ liệu
            DanhSachThuongHocTapDAO dao = new DanhSachThuongHocTapDAO();
            List<DanhSachThuongHocTap> danhSach = dao.getDanhSachThuongHocTap(ms_kthg);

            // Lấy mô hình bảng từ JTable
            DefaultTableModel model = (DefaultTableModel) this.table_DanhSach.getModel();

            // Xóa dữ liệu cũ khỏi mô hình
            model.setRowCount(0);

            // Điền dữ liệu vào mô hình bảng
            for (DanhSachThuongHocTap item : danhSach) {
                model.addRow(new Object[]{
                        item.getHoTen(),
                        item.getCCCD(),
                        item.getMaHo(),
                        item.getTruongHoc(),
                        item.getThanhTich(),
                        item.getMinhChung(),
                        item.getTrangThaiPhatThuong(),
                        item.getGiaTriPhanQua(),
                        item.getNgayThuong()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi ở đây
        }
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_QuayLai;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JLabel jLabel1_TenKhoanThuong;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_MaHo;
    private javax.swing.JLabel jLabel_MaSo;
    private javax.swing.JLabel jLabel_MaSo1;
    private javax.swing.JLabel jLabel_Ten;
    private javax.swing.JLabel jLabel_TenKT;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.SearchText searchText_CCCD;
    private com.raven.swing.SearchText searchText_MaHo;
    private com.raven.swing.SearchText searchText_Ten;
    private com.raven.swing.Table table_DanhSach;
    // End of variables declaration//GEN-END:variables
}
