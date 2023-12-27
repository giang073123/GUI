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
public class Form_DanhSachThuongHocTap extends javax.swing.JPanel {

    /**
     * Creates new form DanhSachThuongHocTap
     */
    public Form_DanhSachThuongHocTap() {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Ten = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField_TenKhoanThuong = new javax.swing.JTextField();
        jLabel_MaHo = new javax.swing.JLabel();
        searchText_CCCD = new com.raven.swing.SearchText();
        jTextField_MaSoKhoanThuong = new javax.swing.JTextField();
        searchText_Ten = new com.raven.swing.SearchText();
        searchText_MaHo = new com.raven.swing.SearchText();
        jButton_TimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSachChiTiet = new com.raven.swing.Table();
        jLabel15 = new javax.swing.JLabel();
        jButton_QuayLai = new javax.swing.JButton();
        jButton_Them = new javax.swing.JButton();
        jButton_Xoa = new javax.swing.JButton();
        jButton_ChinhSua = new javax.swing.JButton();
        jButton_XuatFileExcel = new javax.swing.JButton();
        jButton_ThongKe = new javax.swing.JButton();

        jLabel_Ten.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Ten.setText("Họ và tên: ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("Mã số:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("CCCD: ");

        jTextField_TenKhoanThuong.setText("jTextField1");
        jTextField_TenKhoanThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TenKhoanThuongActionPerformed(evt);
            }
        });

        jLabel_MaHo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaHo.setText("Mã hộ:");

        searchText_CCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_CCCDActionPerformed(evt);
            }
        });

        jTextField_MaSoKhoanThuong.setText("jTextField2");

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
                "Họ và tên", "CCCD", "Mã hộ", "Trường học", "Thành tích", "Minh chứng", "Trạng thái phát thưởng", "Giá trị phần quà", "Ngày thưởng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSachChiTiet);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setText("Tên khoản thưởng:");

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

        jButton_ChinhSua.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ChinhSua.setText("Chỉnh sửa");
        jButton_ChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChinhSuaActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_XuatFileExcel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton_ThongKe)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton_Them)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton_ChinhSua)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton_QuayLai))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField_TenKhoanThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_MaSoKhoanThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Ten)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_MaHo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_TimKiem)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField_TenKhoanThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField_MaSoKhoanThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Ten)
                    .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MaHo)
                    .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Them)
                    .addComponent(jButton_ChinhSua)
                    .addComponent(jButton_Xoa)
                    .addComponent(jButton_QuayLai)
                    .addComponent(jButton_ThongKe)
                    .addComponent(jButton_XuatFileExcel))
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_TenKhoanThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TenKhoanThuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TenKhoanThuongActionPerformed

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

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        Form_ThemDanhSachHocTap formThemDanhSachHocTap = new Form_ThemDanhSachHocTap();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThemDanhSachHocTap);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jButton_ChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChinhSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ChinhSuaActionPerformed

    private void jButton_XuatFileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatFileExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XuatFileExcelActionPerformed

    private void jButton_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThongKeActionPerformed
        Form_ThongKeThuongHocTap formThongKeThuongHocTap= new Form_ThongKeThuongHocTap();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThongKeThuongHocTap);

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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel_MaHo;
    private javax.swing.JLabel jLabel_Ten;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_MaSoKhoanThuong;
    private javax.swing.JTextField jTextField_TenKhoanThuong;
    private com.raven.swing.SearchText searchText_CCCD;
    private com.raven.swing.SearchText searchText_MaHo;
    private com.raven.swing.SearchText searchText_Ten;
    private com.raven.swing.Table table_DanhSachChiTiet;
    // End of variables declaration//GEN-END:variables
}
