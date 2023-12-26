/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import java.awt.Container;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiChungCu extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThuPhiChungCu
     */
    public Form_ThuPhiChungCu() {
        initComponents();
        addSampleRows();
        checkRowCount();
        
        jButton_TaoKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        }); 
                jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_XemChiTietActionPerformed(evt);
        }
    });

    }

    private void addSampleRows() {
        table1.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String[]{"Đã thu", "Chưa thu"})));
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1", "1000000","Ðã thu","22/12/2023"});
        
    }
        private void checkRowCount() {
        if (table1.getRowCount() == 0) {
            jLabel5.setVisible(false); 
            jLabel6.setText("Chưa có khoản thu nào"); 
            jLabel7.setVisible(false); 
            jLabel8.setVisible(false); 
            searchText1.setVisible(false);
            jButton_TimKiem.setVisible(false);
            jButton_TaoKT.setVisible(true); // Hiển thị nút Tạo khoản thu mới
            jLabel_TenKT.setVisible(false);
            jLabel_MaKT.setVisible(false);
            jLabel_PhiDV.setVisible(false);
            jLabel_PhiQL.setVisible(false);
            jScrollPane1.setVisible(false);
            jButton_CapNhat.setVisible(false);
            jButton_XuatFile.setVisible(false);
            jButton_KetThucKT.setVisible(false);
            jButton_XoaKT.setVisible(false);
        } else {
            jLabel5.setVisible(true); 
            jLabel6.setText("Nhập mã hộ để tìm kiếm:"); 
            jLabel7.setVisible(true); 
            jLabel8.setVisible(true); 
            searchText1.setVisible(true);
            jButton_TimKiem.setVisible(true);
            jButton_TaoKT.setVisible(false); 
            jLabel_TenKT.setVisible(true);
            jLabel_MaKT.setVisible(true);
            jLabel_PhiDV.setVisible(true);
            jLabel_PhiQL.setVisible(true);
            jScrollPane1.setVisible(true);
            jButton_CapNhat.setVisible(true);
            jButton_XuatFile.setVisible(true);
            jButton_KetThucKT.setVisible(true);
            jButton_XoaKT.setVisible(true);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jLabel_TenKT = new javax.swing.JLabel();
        jButton_XoaKT = new javax.swing.JButton();
        jButton_KetThucKT = new javax.swing.JButton();
        jButton_TaoKT = new javax.swing.JButton();
        jButton_CapNhat = new javax.swing.JButton();
        jButton_XuatFile = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel6 = new javax.swing.JLabel();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_MaKT = new javax.swing.JLabel();
        jLabel_PhiDV = new javax.swing.JLabel();
        jLabel_PhiQL = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.raven.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_XemChiTiet = new javax.swing.JButton();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT.setText("jLabel_TenKT");

        jButton_XoaKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XoaKT.setText("Xóa khoản thu");

        jButton_KetThucKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThucKT.setText("Kết thúc khoản thu");
        jButton_KetThucKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucKTActionPerformed(evt);
            }
        });

        jButton_TaoKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TaoKT.setText("Tạo khoản thu mới");

        jButton_CapNhat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat.setText("Cập nhật danh sách");

        jButton_XuatFile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFile.setText("Xuất file");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Mã số khoản thu:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Phí dịch vụ:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Phí quản lý:");

        jLabel_MaKT.setText("jLabel_MaKT");

        jLabel_PhiDV.setText("jLabel_PhiDV");

        jLabel_PhiQL.setText("jLabel_PhiQL");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_TaoKT))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton_XuatFile)
                                    .addGap(15, 15, 15)
                                    .addComponent(jButton_CapNhat)
                                    .addGap(15, 15, 15)
                                    .addComponent(jButton_KetThucKT)
                                    .addGap(15, 15, 15)
                                    .addComponent(jButton_XoaKT))
                                .addComponent(jLabel_TenKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel_MaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_PhiQL))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_PhiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel_TenKT)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel_PhiDV)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_MaKT))
                .addGap(13, 13, 13)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_PhiQL))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton_TimKiem)
                    .addComponent(jButton_TaoKT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XoaKT)
                    .addComponent(jButton_KetThucKT)
                    .addComponent(jButton_CapNhat)
                    .addComponent(jButton_XuatFile))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Theo dõi các khoản thu phí chung cư hiện tại", jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Chọn tháng:");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton6.setText("Tìm kiếm");

        roundPanel3.setBackground(new java.awt.Color(250, 250, 250));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khoản thu", "Tên khoản thu", "Phí dịch vụ", "Phí quản lý", "Ngày tạo", "Ngày kết thúc", "Tổng thu", "Ghi chú"
            }
        ));
        jScrollPane2.setViewportView(table2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Danh sách các khoản thu");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jButton_XemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet.setText("Xem chi tiết");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_XemChiTiet)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jButton6))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_XemChiTiet)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử các khoản thu phí chung cư theo tháng", jPanel2);

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

    private void jButton_KetThucKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KetThucKTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_KetThucKTActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_TaoKhoanThuChungCu formTaoKhoanThuMoi = new Form_TaoKhoanThuChungCu();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formTaoKhoanThuMoi);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}
private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_DanhSachPhiChungCu formDanhSachPhiChungCu= new Form_DanhSachPhiChungCu();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDanhSachPhiChungCu);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JButton jButton_KetThucKT;
    private javax.swing.JButton jButton_TaoKT;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XoaKT;
    private javax.swing.JButton jButton_XuatFile;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_MaKT;
    private javax.swing.JLabel jLabel_PhiDV;
    private javax.swing.JLabel jLabel_PhiQL;
    private javax.swing.JLabel jLabel_TenKT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.Table table1;
    private com.raven.swing.Table table2;
    // End of variables declaration//GEN-END:variables
}
