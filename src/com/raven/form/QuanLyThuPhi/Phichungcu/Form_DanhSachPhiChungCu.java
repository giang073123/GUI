/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Phichungcu;

import Model.ThuPhi.*;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC Giang
 */
public class Form_DanhSachPhiChungCu extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    ArrayList<thu_tien_phichungcu> myList = new ArrayList<>() ;
    int myMS;
    khoan_thu_phichungcu myKT;
    /**
     * Creates new form Form_DanhSachPhiChungCu
     */
    public Form_DanhSachPhiChungCu( Model_ThuPhi model,khoan_thu_phichungcu kthu) {
        myModel=model;
        myKT = kthu;
        myMS=myKT.getMS_KThu();

       // myList = (thu_tien_phichungcu) myModel.thu_tien_Danhsach(new thu_tien_phichungcu(),MS_KThu);
        initComponents();
        updateData();
        updateTable();

        updateInfo();

                jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThoatActionPerformed(evt);
        }
    });

    }

    private void updateData(){
        ArrayList<thu_tien> tmpList = myModel.thu_tien_Danhsach(new thu_tien_phichungcu(),myMS);
        for(thu_tien t:tmpList){
            myList.add((thu_tien_phichungcu) t);

        }
    }

    private void updateTable(){
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        int i=1;
        // "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
        for(thu_tien_phichungcu tt : myList){
            table1.addRow(new Object[]{tt.getMa_Ho(),tt.getDien_tich(),tt.getSo_tien(),tt.getTrangthai_Thu(),tt.getNgay_thu()});
        }
    }

    private void updateInfo(){
         jLabel_MaKT.setText(Integer.toString(myKT.getMS_KThu()) );
         jLabel_TenKT.setText(myKT.getTen_KThu());
         jLabel_PhiDV.setText(Integer.toString(myKT.getPhi_dichvu()));
        jLabel_PhiQL.setText(Integer.toString(myKT.getPhi_quanly()));
         jLabel2.setText(Integer.toString(myKT.getTong_thu()));
    }

private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_ThuPhiChungCu formThuPhiChungCu = new Form_ThuPhiChungCu(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThuPhiChungCu);

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
        jLabel_TenKT = new javax.swing.JLabel();
        jButton_Thoat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel6 = new javax.swing.JLabel();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_MaKT = new javax.swing.JLabel();
        jLabel_PhiDV = new javax.swing.JLabel();
        jLabel_PhiQL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Diện tích", "Số tiền", "Ngày thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT.setText("jLabel_TenKT");

        jButton_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Thoat.setText("Thoát");

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

        jLabel_MaKT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_MaKT.setText("jLabel_MaKT");

        jLabel_PhiDV.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhiDV.setText("jLabel_PhiDV");

        jLabel_PhiQL.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhiQL.setText("jLabel_PhiQL");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Tổng thu:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("jLabel2");

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
                        .addComponent(jButton_TimKiem))
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Thoat)
                        .addComponent(jLabel_TenKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(132, 132, 132)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_PhiQL))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_PhiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(jLabel_PhiQL)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton_TimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton_Thoat)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_MaKT;
    private javax.swing.JLabel jLabel_PhiDV;
    private javax.swing.JLabel jLabel_PhiQL;
    private javax.swing.JLabel jLabel_TenKT;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
