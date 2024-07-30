/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Phitunguyen;

import Model.ThuPhi.*;
import com.raven.form.QuanLyThuPhi.Phitunguyen.Form_DanhSachPhiTuNguyen;
import java.awt.Container;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangk
 */
public class Form_LichSuDanhSachTuNguyen extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    khoan_thu_khac myKT;
    ArrayList<thu_tien_khac> myList = new ArrayList<>() ;
    /**
     * Creates new form Form_LichSuDanhSachTuNguyen
     */
    public Form_LichSuDanhSachTuNguyen(Model_ThuPhi model,khoan_thu_khac kt) {
        myModel=model;
        myKT=kt;
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
        ArrayList<thu_tien> tmpList = myModel.thu_tien_Danhsach(new thu_tien_khac(),myKT.getMS_KThu());
        for(thu_tien t:tmpList){
            myList.add((thu_tien_khac) t);
        }
    }

    private void updateTable(){
        DefaultTableModel model = (DefaultTableModel)table_DanhSach.getModel();
        model.setRowCount(0);
        for(thu_tien_khac tt : myList){
            table_DanhSach.addRow(new Object[]{tt.getMa_Ho(),tt.getSo_tien(),tt.getNgay_thu()});
        }
    }

    private void updateInfo(){
         jLabel_MaSoKT1.setText(Integer.toString(myKT.getMS_KThu()) );
         jLabel_TenKT2.setText(myKT.getTen_KThu());
         jLabel2.setText(Integer.toString(myKT.getTong_thu()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_MaSoKT1 = new javax.swing.JLabel();
        miniSearch_NhapMa = new com.raven.component.MiniSearch();
        jLabel_NhapMa = new javax.swing.JLabel();
        jButton_TimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSach = new com.raven.swing.Table();
        jLabel_MaSoKT = new javax.swing.JLabel();
        jLabel_TenKT2 = new javax.swing.JLabel();
        jButton_Thoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel_MaSoKT1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_MaSoKT1.setText("jLabel_MaKT");

        jLabel_NhapMa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_NhapMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_NhapMa.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số tiền", "Ngày thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSach);

        jLabel_MaSoKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSoKT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MaSoKT.setText("Mã số khoản thu:");

        jLabel_TenKT2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT2.setText("jLabel_TenKT");

        jButton_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Thoat.setText("Thoát");
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Tổng thu:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel_TenKT2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_NhapMa)
                                .addComponent(jLabel_MaSoKT))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_MaSoKT1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(miniSearch_NhapMa, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(jButton_TimKiem))
                                .addComponent(jLabel2)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton_Thoat)
                            .addGap(1, 1, 1))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_TenKT2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSoKT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MaSoKT1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_NhapMa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(miniSearch_NhapMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_Thoat)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
// ĐÃ CÓ CHỨC NĂNG CHO NÚT TÌM KIẾM
    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        // TODO add your handling code here:
          if (miniSearch_NhapMa.getText().length() < 1) {
//                    if (table1.getRowCount() > 1) {
//                    } else {
//                       // updateTable1(myList);   // Reset lại bảng, nhưng hiện tại dùng getViewport thì không cần lắm
//                    }
                } else {
                    int i = 0;
                    for (thu_tien_khac t : myList) {
                        if (t.getMa_Ho() == Integer.parseInt(miniSearch_NhapMa.getText())) {
                            Rectangle rect = table_DanhSach.getCellRect(i, 0, true);
                            jScrollPane2.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
                }
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThoatActionPerformed
    Form_ThuPhiTheoDot formThuPhiTheoDot = new Form_ThuPhiTheoDot(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThuPhiTheoDot);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_MaSoKT;
    private javax.swing.JLabel jLabel_MaSoKT1;
    private javax.swing.JLabel jLabel_NhapMa;
    private javax.swing.JLabel jLabel_TenKT2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.component.MiniSearch miniSearch_NhapMa;
    private com.raven.swing.Table table_DanhSach;
    // End of variables declaration//GEN-END:variables
}
