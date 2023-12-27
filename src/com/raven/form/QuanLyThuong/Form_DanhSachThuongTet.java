/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuong;

import com.raven.form.QuanLyThuPhi.Form_TaoKhoanThuTuNguyen;
import java.awt.Container;

/**
 *
 * @author dangk
 */
public class Form_DanhSachThuongTet extends javax.swing.JPanel {

    /**
     * Creates new form Form_DanhSachThuongTet
     */
    public Form_DanhSachThuongTet() {
        initComponents();
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_QuayLaiActionPerformed(evt);
        }
    });
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThemActionPerformed(evt);
        }
    });
        jButton_ThongKe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThongKeActionPerformed(evt);
        }
    });
    }
private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_QuanLyThuongTet formQuanLyThuongTet = new Form_QuanLyThuongTet();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formQuanLyThuongTet);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchText_CCCD = new com.raven.swing.SearchText();
        jTextField_MaSo = new javax.swing.JTextField();
        searchText_Ten = new com.raven.swing.SearchText();
        searchText_MaHo = new com.raven.swing.SearchText();
        jButton_TimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSachChiTiet = new com.raven.swing.Table();
        jButton_ChinhSua = new javax.swing.JButton();
        jLabel_Ten = new javax.swing.JLabel();
        jLabel_MaSo = new javax.swing.JLabel();
        jLabel_TenKhoanThuongTet = new javax.swing.JLabel();
        jLabel_CCCD = new javax.swing.JLabel();
        jTextField_TenKhoanThuongTet = new javax.swing.JTextField();
        jLabel_MaHo = new javax.swing.JLabel();
        jButton_QuayLai = new javax.swing.JButton();
        jButton_Them = new javax.swing.JButton();
        jButton_Xoa = new javax.swing.JButton();
        jButton_XuatFileExcel = new javax.swing.JButton();
        jButton_ThongKe = new javax.swing.JButton();

        searchText_CCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_CCCDActionPerformed(evt);
            }
        });

        jTextField_MaSo.setText("jTextField2");

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

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSachChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSachChiTiet);

        jButton_ChinhSua.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ChinhSua.setText("Chỉnh sửa");
        jButton_ChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChinhSuaActionPerformed(evt);
            }
        });

        jLabel_Ten.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Ten.setText("Họ và tên: ");

        jLabel_MaSo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSo.setText("Mã số:");

        jLabel_TenKhoanThuongTet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TenKhoanThuongTet.setText("Tên khoản thưởng:");

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_CCCD.setText("CCCD: ");

        jTextField_TenKhoanThuongTet.setText("jTextField1");
        jTextField_TenKhoanThuongTet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TenKhoanThuongTetActionPerformed(evt);
            }
        });

        jLabel_MaHo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaHo.setText("Mã hộ:");

        jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_QuayLai.setText("Quay lại");

        jButton_Them.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Them.setText("Thêm");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jButton_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Xoa.setText("Xóa");
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jButton_XuatFileExcel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFileExcel.setText("Xuất File");
        jButton_XuatFileExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XuatFileExcelActionPerformed(evt);
            }
        });

        jButton_ThongKe.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ThongKe.setText("Thống kê");
        jButton_ThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_MaSo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_MaSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_TenKhoanThuongTet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_TenKhoanThuongTet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Ten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_CCCD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_MaHo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_TimKiem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_XuatFileExcel)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_ThongKe)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_ChinhSua)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Xoa)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_QuayLai))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenKhoanThuongTet)
                    .addComponent(jTextField_TenKhoanThuongTet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSo)
                    .addComponent(jTextField_MaSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Ten)
                    .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MaHo)
                    .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_XuatFileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchText_CCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_CCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_CCCDActionPerformed

    private void searchText_TenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_TenActionPerformed

    private void searchText_MaHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MaHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_MaHoActionPerformed

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    private void jButton_ChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChinhSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ChinhSuaActionPerformed

    private void jTextField_TenKhoanThuongTetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TenKhoanThuongTetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TenKhoanThuongTetActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        Form_ThemDanhSachTet formThemDanhSachTet = new Form_ThemDanhSachTet();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThemDanhSachTet);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jButton_XuatFileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatFileExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XuatFileExcelActionPerformed

    private void jButton_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThongKeActionPerformed
        Form_ThongKeThuongTet formThongKeThuongTet= new Form_ThongKeThuongTet();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThongKeThuongTet);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ChinhSua;
    private javax.swing.JButton jButton_QuayLai;
    private javax.swing.JButton jButton_Them;
    private javax.swing.JButton jButton_ThongKe;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_Xoa;
    private javax.swing.JButton jButton_XuatFileExcel;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_MaHo;
    private javax.swing.JLabel jLabel_MaSo;
    private javax.swing.JLabel jLabel_Ten;
    private javax.swing.JLabel jLabel_TenKhoanThuongTet;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_MaSo;
    private javax.swing.JTextField jTextField_TenKhoanThuongTet;
    private com.raven.swing.SearchText searchText_CCCD;
    private com.raven.swing.SearchText searchText_MaHo;
    private com.raven.swing.SearchText searchText_Ten;
    private com.raven.swing.Table table_DanhSachChiTiet;
    // End of variables declaration//GEN-END:variables
}
