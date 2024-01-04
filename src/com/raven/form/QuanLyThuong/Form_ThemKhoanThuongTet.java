/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuong;
import com.raven.model.QuanLyThuongTetDAO;

import com.raven.form.QuanLyThuong.Form_DanhSachThuongTet;
import com.raven.form.QuanLyThuong.Form_QuanLyThuongTet;
import java.awt.Container;
import javax.swing.JPanel;
import java.sql.Date;
import com.raven.model.QuanLyThuongTetdata;
import java.sql.SQLException;

/**
 *
 * @author dangk
 */
public class Form_ThemKhoanThuongTet extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThemKhoanThuongTet
     */
    public Form_ThemKhoanThuongTet() {
        initComponents();
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        });
        
    }
    private void initComponents() {
        searchText_GhiChu = new com.raven.swing.SearchText();
        jButton_XacNhan = new javax.swing.JButton();
        searchText_GiaTriQua = new com.raven.swing.SearchText();
        jLabel_GhiChu = new javax.swing.JLabel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jLabel_TenKhoanThuong = new javax.swing.JLabel();
        jLabel_GiaTriQua = new javax.swing.JLabel();
        searchText_TenKhoanThuong = new com.raven.swing.SearchText();
        jButton_QuayLai = new javax.swing.JButton();
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
        searchText_GiaTriQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_GiaTriQuaActionPerformed(evt);
            }
        });
        jLabel_GhiChu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_GhiChu.setText("Ghi chú:");
        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Điền thông tin khoản thưởng tết mới");
        jLabel_TenKhoanThuong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TenKhoanThuong.setText("Tên khoản thưởng:");
        jLabel_GiaTriQua.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_GiaTriQua.setText("Giá trị phần quà:");
        searchText_TenKhoanThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_TenKhoanThuongActionPerformed(evt);
            }
        });
        jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_QuayLai.setText("Quay lại");
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
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
                            .addComponent(jLabel_GiaTriQua, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_TenKhoanThuong)
                            .addComponent(jLabel_GhiChu))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchText_TenKhoanThuong, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                            .addComponent(searchText_GiaTriQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchText_GhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_XacNhan)
                        .addGap(20, 20, 20)
                        .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText_TenKhoanThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TenKhoanThuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_GiaTriQua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText_GiaTriQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_QuayLai)
                    .addComponent(jButton_XacNhan))
                .addGap(76, 76, 76))
        );
    }
    private void searchText_GhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_GhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_GhiChuActionPerformed

    private void searchText_TenKhoanThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TenKhoanThuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_TenKhoanThuongActionPerformed

        private void jButton_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {
            // Lấy thông tin từ giao diện
            String tenKhoanThuong = searchText_TenKhoanThuong.getText();
            int giaTriPhanQua = Integer.parseInt(searchText_GiaTriQua.getText());
            // Ngày tạo và ngày kết thúc có thể được tạo tự động hoặc nhập từ giao diện
            Date ngayTao = new Date(System.currentTimeMillis());
            Date ngayKetThuc = new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000); // Ngày hiện tại + 30 ngày
            int tongThuong = 0; // Tùy thuộc vào yêu cầu của bạn
            String ghiChu = searchText_GhiChu.getText();
            QuanLyThuongTetdata khoanThuong = new QuanLyThuongTetdata(0, tenKhoanThuong, giaTriPhanQua, ngayTao, ngayKetThuc, null, tongThuong, ghiChu);
            QuanLyThuongTetDAO dao = new QuanLyThuongTetDAO();
            try {
                dao.themKhoanThuong(khoanThuong);
                System.out.println("Thêm khoản thưởng thành công!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Lỗi khi thêm khoản thưởng: " + ex.getMessage());
            }
        }
    private void searchText_GiaTriQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_GiaTriQuaActionPerformed
        // TODO add your handling code here:
    }
    private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {
        // Tạo một thể hiện mới của Form_QuanLyThuongTet
        Form_QuanLyThuongTet formQuanLyThuongTet = new Form_QuanLyThuongTet();

        // Lấy container chứa panel hiện tại
        Container parentContainer = this.getParent();

        // Kiểm tra xem container chứa panel có phải là null không
        if (parentContainer != null) {
            // Nếu không phải là null, loại bỏ panel hiện tại khỏi container
            parentContainer.remove(this);

            // Thêm panel mới vào container
            parentContainer.add(formQuanLyThuongTet);

            // Làm mới và vẽ lại container để phản ánh thay đổi
            parentContainer.revalidate();
            parentContainer.repaint();
        } else {
            // Nếu container là null, in ra thông báo
            System.out.println("parentContainer là null. Không thể chuyển đổi panel.");
        }
    }

    private void switchPanel(JPanel panel) {
        Container parentContainer = this.getParent();
        parentContainer.remove(this);
        parentContainer.add(panel);
        parentContainer.revalidate();
        parentContainer.repaint();
    }
    private javax.swing.JButton jButton_QuayLai;
    private javax.swing.JButton jButton_XacNhan;
    private javax.swing.JLabel jLabel_GhiChu;
    private javax.swing.JLabel jLabel_GiaTriQua;
    private javax.swing.JLabel jLabel_TenKhoanThuong;
    private javax.swing.JLabel jLabel_TieuDe;
    private com.raven.swing.SearchText searchText_GhiChu;
    private com.raven.swing.SearchText searchText_GiaTriQua;
    private com.raven.swing.SearchText searchText_TenKhoanThuong;
    // End of variables declaration//GEN-END:variables
}
