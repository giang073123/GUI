/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Diennuoc;

import Model.ThuPhi.Model_ThuPhi;
import Model.ThuPhi.khoan_thu;
import Model.ThuPhi.khoan_thu_khac;
import Model.ThuPhi.khoan_thu_phichungcu;
import Model.ThuPhi.thu_tien;
import Model.ThuPhi.thu_tien_khac;
import Model.ThuPhi.thu_tien_phichungcu;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangk
 */
public class Form_DanhSachDienNuocHienTai extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    khoan_thu_khac myKT;
     ArrayList<thu_tien_khac> myList = new ArrayList<>() ;
    /**
     * Creates new form Form_DanhSachDienNuocHienTai
     */
    public Form_DanhSachDienNuocHienTai( Model_ThuPhi model,khoan_thu_khac kt) {
        myModel=model;
        myKT=kt;
        initComponents();
        
         table1.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String[]{"Đã thu", "Chưa thu"})));
        //JOptionPane.showMessageDialog(null, kt.getMS_KThu());
        getdata();
        updateTable1(myList);
        updateInfo();
        
         
         // TABLE1 MODEL LISTENER 
        table1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int idx = e.getFirstRow();
                               
                if(e.getColumn()==2)    {           // THAY ĐỔI TRẠNG THÁI  
                if(table1.getRowCount()==0) return;
                
                 if (table1.getModel().getValueAt(idx, 2).toString().compareTo("Đã thu") == 0 && table1.getModel().getValueAt(idx, 3)!=null){ return;}
                 else if(table1.getModel().getValueAt(idx, 2).toString().compareTo("Chưa thu") == 0 && table1.getModel().getValueAt(idx, 3)==null){ return; }
                 
                 else if (table1.getModel().getValueAt(idx, 2).toString().compareTo("Đã thu") == 0 && table1.getModel().getValueAt(idx, 3)==null ) { 
                    myList.get(idx).setTrangthai_Thu(table1.getModel().getValueAt(idx, 2).toString());
                    myList.get(idx).setNgay_thu(java.sql.Date.valueOf(LocalDate.now()));
                    
                    
                    myModel.thu_tien_CapNhat(myList.get(idx),"Đã thu");
                    table1.getModel().setValueAt(myList.get(idx).getNgay_thu(),idx,3); 
                 } 
                else if(table1.getModel().getValueAt(idx, 2).toString().compareTo("Chưa thu") == 0 && table1.getModel().getValueAt(idx, 3)!=null){
                     table1.getModel().setValueAt("Đã thu",idx,2);
                     JOptionPane.showMessageDialog(null,"Đã thu, không thể sửa đổi");  // Đã thu rồi thì không sửa được
                    return; }
            } 
       }});
        
         // NÚT TÌM KIẾM TRONG PHẦN KHOẢN THU HIỆN TẠI
        jButton_TimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,searchText1.getText());
                if (miniSearch_NhapMa.getText().length() < 1) {
//                    if (table1.getRowCount() > 1) {
//                    } else {
//                       // updateTable1(myList);   // Reset lại bảng, nhưng hiện tại dùng getViewport thì không cần lắm
//                    }
                } else {
                    int i = 0;
                    for (thu_tien_khac t : myList) {
                        if (t.getMa_Ho() == Integer.parseInt(miniSearch_NhapMa.getText())) {
                            Rectangle rect = table1.getCellRect(i, 0, true);
                            jScrollPane2.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
                }
            }

        });
                
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        }); 
    }
    
    
    // CÁC METHOD CỦA TRANG KHOẢN THU HIỆN TẠI
    private void getdata(){
        ArrayList<thu_tien> list =myModel.thu_tien_Danhsach(new thu_tien_phichungcu(),myKT.getMS_KThu());
        Iterator<thu_tien> it = list.iterator();
        while(it.hasNext()) {
            myList.add((thu_tien_khac) it.next());
        }
    }

    private void updateTable1(ArrayList<thu_tien_khac> list) {
        if (list.size()==0) return;
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        for(thu_tien_khac tt : list){
            table1.addRow(new Object[]{tt.getMa_Ho(),tt.getSo_tien(),tt.getTrangthai_Thu(),tt.getNgay_thu()});
        }
        
    }



    private void updateInfo(){
        jLabel_MaSoKT1.setText(Integer.toString(myKT.getMS_KThu())); jLabel_TenKT1.setText(myKT.getTen_KThu()); jLabel_LoaiKT1.setText(myKT.getLoai_KThu());
    }
    
    
    private void checkRowCount() {
        if (table1.getRowCount() == 0) {
           jButton_Them.setVisible(true);
        } else {
             jButton_Them.setVisible(false);            
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_MaSoKT = new javax.swing.JLabel();
        jLabel_TenKT1 = new javax.swing.JLabel();
        jLabel_MaSoKT1 = new javax.swing.JLabel();
        jLabel_NhapMa = new javax.swing.JLabel();
        miniSearch_NhapMa = new com.raven.component.MiniSearch();
        jButton_TimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jButton_Them = new javax.swing.JButton();
        jLabel_LoaiKT = new javax.swing.JLabel();
        jLabel_LoaiKT1 = new javax.swing.JLabel();
        jButton_Thoat = new javax.swing.JButton();

        jLabel_MaSoKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSoKT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_MaSoKT.setText("Mã số khoản thu:");

        jLabel_TenKT1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT1.setText("jLabel_TenKT");

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

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số tiền", "Trạng thái thu", "Ngày thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

        jButton_Them.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Them.setText("Tải lên danh sách");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jLabel_LoaiKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_LoaiKT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_LoaiKT.setText("Loại:");

        jLabel_LoaiKT1.setText("jLabel_LoaiKT");

        jButton_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Thoat.setText("Thoát");
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_TenKT1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_LoaiKT)
                            .addComponent(jLabel_MaSoKT))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_MaSoKT1)
                            .addComponent(jLabel_LoaiKT1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_Thoat))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_NhapMa)
                        .addGap(18, 18, 18)
                        .addComponent(miniSearch_NhapMa, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton_TimKiem)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel_TenKT1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSoKT)
                    .addComponent(jLabel_MaSoKT1))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_LoaiKT)
                    .addComponent(jLabel_LoaiKT1))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(miniSearch_NhapMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_NhapMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Thoat)
                    .addComponent(jButton_Them))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThoatActionPerformed
         Form_ThuPhiDienNuoc formThuPhiDienNuoc= new Form_ThuPhiDienNuoc(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThuPhiDienNuoc);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Them;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JLabel jLabel_LoaiKT;
    private javax.swing.JLabel jLabel_LoaiKT1;
    private javax.swing.JLabel jLabel_MaSoKT;
    private javax.swing.JLabel jLabel_MaSoKT1;
    private javax.swing.JLabel jLabel_NhapMa;
    private javax.swing.JLabel jLabel_TenKT1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.component.MiniSearch miniSearch_NhapMa;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}