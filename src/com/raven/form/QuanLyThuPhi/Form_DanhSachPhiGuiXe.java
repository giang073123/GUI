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
public class Form_DanhSachPhiGuiXe extends javax.swing.JPanel {

    /**
     * Creates new form Form_DanhSachPhiGuiXe
     */
    public Form_DanhSachPhiGuiXe() {
        initComponents();
        table1.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String[]{"Đã thu", "Chưa thu"})));
        table1.addRow(new Object[]{"12431", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1000000","Ðã thu","22/12/2023"});
                jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThoatActionPerformed(evt);
        }
    });
    }
private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_ThuPhiGuiXe formThuPhiGuiXe = new Form_ThuPhiGuiXe();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThuPhiGuiXe);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jLabel_TenKT2 = new javax.swing.JLabel();
        jButton_Thoat = new javax.swing.JButton();
        jButton_XuatFile2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        searchText3 = new com.raven.swing.SearchText();
        jLabel14 = new javax.swing.JLabel();
        jButton_TimKiem2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel_MaKT2 = new javax.swing.JLabel();
        jLabel_PhiXeDap = new javax.swing.JLabel();
        jLabel_PhiOTo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel_PhiXeMay = new javax.swing.JLabel();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số tiền", "Ngày thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT2.setText("jLabel_TenKT");

        jButton_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Thoat.setText("Thoát");

        jButton_XuatFile2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFile2.setText("Xuất file");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("Mã số khoản thu:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem2.setText("Tìm kiếm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setText("Phí xe đạp:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("Phí xe ô tô:");

        jLabel_MaKT2.setText("jLabel_MaKT");

        jLabel_PhiXeDap.setText("jLabel_PhiXeDap");

        jLabel_PhiOTo.setText("jLabel_PhiOTo");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("Phí xe máy:");

        jLabel_PhiXeMay.setText("jLabel_PhiXeMay");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(searchText3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TimKiem2))
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addComponent(jButton_XuatFile2)
                            .addGap(15, 15, 15)
                            .addComponent(jButton_Thoat))
                        .addComponent(jLabel_TenKT2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17))
                        .addGap(74, 74, 74)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MaKT2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_PhiXeMay))
                        .addGap(52, 52, 52)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_PhiXeDap)
                            .addComponent(jLabel_PhiOTo))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel_TenKT2)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel_PhiXeDap)
                    .addComponent(jLabel13)
                    .addComponent(jLabel_MaKT2))
                .addGap(13, 13, 13)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel_PhiOTo)
                    .addComponent(jLabel17)
                    .addComponent(jLabel_PhiXeMay))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jButton_TimKiem2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Thoat)
                    .addComponent(jButton_XuatFile2))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem2;
    private javax.swing.JButton jButton_XuatFile2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel_MaKT2;
    private javax.swing.JLabel jLabel_PhiOTo;
    private javax.swing.JLabel jLabel_PhiXeDap;
    private javax.swing.JLabel jLabel_PhiXeMay;
    private javax.swing.JLabel jLabel_TenKT2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.SearchText searchText3;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
