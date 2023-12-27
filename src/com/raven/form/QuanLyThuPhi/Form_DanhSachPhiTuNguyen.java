/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi;

import java.awt.Container;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author PC Giang
 */
public class Form_DanhSachPhiTuNguyen extends javax.swing.JPanel {

    /**
     * Creates new form Form_DanhSachPhiTuNguyen
     */
    public Form_DanhSachPhiTuNguyen() {
        initComponents();
        addSampleRows();
        

        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThoatActionPerformed(evt);
        }
    });
                jButton_ThemDong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThemDongActionPerformed(evt);
        }
    });
    }

private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_ThuPhiTheoDot formThuPhiTheoDot = new Form_ThuPhiTheoDot();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThuPhiTheoDot);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}
private void jButton_ThemDongActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_ThemDongDanhSachTuNguyen formThemDongDanhSachTuNguyen = new Form_ThemDongDanhSachTuNguyen();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThemDongDanhSachTuNguyen);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jLabel_TenKT = new javax.swing.JLabel();
        jButton_CapNhat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel6 = new javax.swing.JLabel();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel_MaKT = new javax.swing.JLabel();
        jButton_Thoat = new javax.swing.JButton();
        jButton_ThemDong = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_TenKT1 = new javax.swing.JLabel();
        jButton_XuatFile2 = new javax.swing.JButton();
        jButton_CapNhat1 = new javax.swing.JButton();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số tiền", "Ngày thu"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT.setText("Danh sách thu tiền tự nguyện");

        jButton_CapNhat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat.setText("Cập nhật danh sách");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Mã số khoản thu:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");

        jLabel_MaKT.setText("jLabel_MaKT");

        jButton_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Thoat.setText("Thoát");

        jButton_ThemDong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ThemDong.setText("Thêm vào danh sách");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Tên khoản thu:");

        jLabel_TenKT1.setText("jLabel_TenKT");

        jButton_XuatFile2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFile2.setText("Xuất file");
        jButton_XuatFile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XuatFile2ActionPerformed(evt);
            }
        });

        jButton_CapNhat1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat1.setText("Xóa khỏi danh sách");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_XuatFile2)
                        .addGap(5, 5, 5)
                        .addComponent(jButton_ThemDong)
                        .addGap(5, 5, 5)
                        .addComponent(jButton_CapNhat)
                        .addGap(5, 5, 5)
                        .addComponent(jButton_CapNhat1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton_Thoat))
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_TimKiem))
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_TenKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                            .addGap(74, 74, 74)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_TenKT1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_MaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel_TenKT)
                .addGap(27, 27, 27)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel_TenKT1))
                .addGap(15, 15, 15)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_MaKT))
                .addGap(15, 15, 15)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton_TimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_CapNhat)
                    .addComponent(jButton_Thoat)
                    .addComponent(jButton_ThemDong)
                    .addComponent(jButton_XuatFile2)
                    .addComponent(jButton_CapNhat1))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_XuatFile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatFile2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XuatFile2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JButton jButton_CapNhat1;
    private javax.swing.JButton jButton_ThemDong;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_XuatFile2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_MaKT;
    private javax.swing.JLabel jLabel_TenKT;
    private javax.swing.JLabel jLabel_TenKT1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
