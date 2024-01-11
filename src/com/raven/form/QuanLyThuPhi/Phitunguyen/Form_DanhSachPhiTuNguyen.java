/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Phitunguyen;

import Model.ThuPhi.*;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC Giang
 */
public class Form_DanhSachPhiTuNguyen extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    khoan_thu_khac myKT;
    ArrayList<thu_tien_khac> myList = new ArrayList<>() ;
    
    /**
     * Creates new form Form_DanhSachPhiTuNguyen
     */
    public Form_DanhSachPhiTuNguyen( Model_ThuPhi model, int MS_KTHU) {
        myModel=model;
        myKT=  (khoan_thu_khac)myModel.khoan_thu_Get(new khoan_thu_khac(), MS_KTHU);
        initComponents();
        
        
        updateData();
        updateTable();
        updateInfo();
        
       
        
        
        
         // TÌM KIẾM HỘ TRONG TRANG DANH SÁCH
        jButton_TimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if (searchText1.getText().length() < 1) {
//                    if (table1.getRowCount() > 1) {
//                    } else {
//                       // updateTable1(myList);   // Reset lại bảng, nhưng hiện tại dùng getViewport thì không cần lắm
//                    }
                } else {
                    int i = 0;
                    for (thu_tien_khac t : myList) {
                        if (t.getMa_Ho() == Integer.parseInt(searchText1.getText())) {
                            Rectangle rect = table1.getCellRect(i, 0, true);
                            jScrollPane1.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
                }
            }
        });
        
        // THÊM DÒNG VÀO DANH SÁCH
        jButton_ThemDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton_ThemDongActionPerformed(evt);
            }
         });
        //jButton_XoaDong.setVisible(false);
        // XÓA DÒNG KHỎI DANH SÁCH
        jButton_XoaDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
               int idx = table1.getSelectedRow();
                if (idx < 0)
                    return;

                Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc chắn muốn xóa thông tin này",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(choosen == JOptionPane.YES_OPTION){
                       
                    
                       
                        myModel.thu_tien_XoaDong(myList.get(idx));
                        myKT.setTong_thu(myKT.getTong_thu()- myList.get(idx).getSo_tien());
                        myList.remove(idx);
                        updateTable();
                        updateInfo();
                       JOptionPane.showMessageDialog(null, "Đã xóa hộ đóng góp");
                      
                      return;
                }else if (choosen == JOptionPane.NO_OPTION){
                      return;
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                      return;
                }else {
                    return;
                }

                
                
               
               
            }
         });
        
         // NÚT THOÁT
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
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        for(thu_tien_khac tt : myList){
            table1.addRow(new Object[]{tt.getMa_Ho(),tt.getSo_tien(),tt.getNgay_thu()});
        }
    }

    private void updateInfo(){
       // myKT = (khoan_thu_khac) myModel.khoan_thu_Get(new khoan_thu_khac(), myKT.getMS_KThu());
         jLabel_MaKT.setText(Integer.toString(myKT.getMS_KThu()) );
         jLabel_TenKT.setText(myKT.getTen_KThu());
         jLabel2.setText(Integer.toString(myKT.getTong_thu()));
    }

private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
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
}
private void jButton_ThemDongActionPerformed(java.awt.event.ActionEvent evt) {   
   
    // Create an instance of Form_ThongTinChiTiet
    Form_ThemDongDanhSachTuNguyen formThemDongDanhSachTuNguyen = new Form_ThemDongDanhSachTuNguyen(myModel,myKT);

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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jLabel_TenKT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel6 = new javax.swing.JLabel();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel_MaKT = new javax.swing.JLabel();
        jButton_Thoat = new javax.swing.JButton();
        jButton_ThemDong = new javax.swing.JButton();
        jButton_XoaDong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT.setText("Danh sách thu tiền tự nguyện");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Mã số khoản thu:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");

        jLabel_MaKT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_MaKT.setText("jLabel_MaKT");

        jButton_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Thoat.setText("Thoát");

        jButton_ThemDong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ThemDong.setText("Thêm vào danh sách");

        jButton_XoaDong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XoaDong.setText("Xóa khỏi danh sách");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Tổng thu:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_TenKT, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addComponent(jButton_ThemDong)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_XoaDong, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_Thoat))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel_MaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TimKiem)))
                .addGap(50, 50, 50))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_TenKT)
                .addGap(34, 34, 34)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_MaKT))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton_TimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Thoat)
                    .addComponent(jButton_ThemDong)
                    .addComponent(jButton_XoaDong))
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
    private javax.swing.JButton jButton_ThemDong;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_XoaDong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_MaKT;
    private javax.swing.JLabel jLabel_TenKT;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
