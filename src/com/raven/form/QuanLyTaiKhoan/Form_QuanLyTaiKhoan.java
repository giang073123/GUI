/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyTaiKhoan;

import com.raven.form.QuanLyNhanKhau.Form_NhanKhauMoi;
import java.awt.Container;
import Model.TaiKhoan.*;
import Model.ThuPhi.khoan_thu_phichungcu;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
        
public class Form_QuanLyTaiKhoan extends javax.swing.JPanel {
    Model_TaiKhoan myModel;
    can_bo mycb;
    ArrayList<can_bo> myList = new ArrayList<>();
    int checkchange =0;
    
    
    public Form_QuanLyTaiKhoan(Model_TaiKhoan model) {
        initComponents();
        table_DanhSach.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String[]{"Tổ trưởng", "Tổ phó", "Cán bộ quản lý nhân khẩu","Cán bộ quản lý thu phí", "Cán bộ quản lý phát thưởng"})));
        table_DanhSach.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor( new JPasswordField()));
        myModel = model;
        mycb =model.getCb();
        
        updateinfo();
        getList();
        updateTable();
        if(mycb.getChuc_vu().compareTo("Tổ trưởng")!=0 && mycb.getChuc_vu().compareTo("Tổ phó")!=0) jTabbedPane1.removeTabAt(1);
        
        
        jButton_DoiMK.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_DoiMKActionPerformed(evt);
        }
    });
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThemActionPerformed(evt);
        }
    });
        
//        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
//        public void actionPerformed(java.awt.event.ActionEvent evt) {
//            
//
//            
//            
//            
//            
//            
//        }
//    });
        
        table_DanhSach.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                //DefaultTableModel model = (DefaultTableModel)table_DanhSach.getModel();
                if(checkchange==1) return;
                int idx = e.getFirstRow();
                myList.get(idx).setCCCD(table_DanhSach.getValueAt(idx,1).toString());
                myList.get(idx).setChuc_vu(table_DanhSach.getValueAt(idx,5 ).toString());
                myList.get(idx).setTen_CB(table_DanhSach.getValueAt(idx, 2).toString());
                myList.get(idx).setPassword(table_DanhSach.getValueAt(idx,4 ).toString());         
                
                myModel.update_cb( myList.get(idx));
                JOptionPane.showMessageDialog(null, "Đã thay đổi thông tin");
            }
         });        
        
        
    }
    
    
    private void updateinfo(){
        jLabel_CCCD1.setText(mycb.getCCCD());
        jLabel_ChucVu1.setText(mycb.getChuc_vu());
        jLabel_MaCB1.setText(Integer.toString(mycb.getMa_CB()));
        jLabel_TenCB1.setText(mycb.getTen_CB());
    
    }
    
    private void getList(){
        myList= myModel.getds();   
    }
    
    
    private void updateTable(){
        DefaultTableModel model = (DefaultTableModel)table_DanhSach.getModel();
        checkchange=1;
        model.setRowCount(0);
         
         for(can_bo cb : myList){
            table_DanhSach.addRow(new Object[]{cb.getMa_CB(),cb.getCCCD(),cb.getTen_CB(),cb.getUsername(),cb.getPassword(),cb.getChuc_vu()});
        }
        checkchange=0;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jLabel_MaCB = new javax.swing.JLabel();
        jLabel_TenCB = new javax.swing.JLabel();
        jLabel_ChucVu = new javax.swing.JLabel();
        jButton_DoiMK = new javax.swing.JButton();
        jLabel_MaCB1 = new javax.swing.JLabel();
        jLabel_TenCB1 = new javax.swing.JLabel();
        jLabel_ChucVu1 = new javax.swing.JLabel();
        jLabel_CCCD = new javax.swing.JLabel();
        jLabel_CCCD1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton_Xoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSach = new com.raven.swing.Table();
        jButton_Them = new javax.swing.JButton();
        jLabel_TieuDe1 = new javax.swing.JLabel();

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Thông tin tài khoản cá nhân");

        jLabel_MaCB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_MaCB.setText("Mã cán bộ:");

        jLabel_TenCB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenCB.setText("Tên cán bộ:");

        jLabel_ChucVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_ChucVu.setText("Chức vụ:");

        jButton_DoiMK.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_DoiMK.setText("Thay đổi mật khẩu");
        jButton_DoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DoiMKActionPerformed(evt);
            }
        });

        jLabel_MaCB1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaCB1.setText("jLabel_MaCB");

        jLabel_TenCB1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenCB1.setText("jLabel_TenCB");

        jLabel_ChucVu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_ChucVu1.setText("jLabel_ChucVu");

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_CCCD.setText("CCCD:");

        jLabel_CCCD1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_CCCD1.setText("jLabel_CCCD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_TenCB)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel_MaCB)
                                        .addGap(140, 140, 140))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel_ChucVu, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_CCCD, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_CCCD1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_TenCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_ChucVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_MaCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_DoiMK)
                        .addGap(100, 100, 100))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaCB)
                    .addComponent(jLabel_MaCB1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenCB)
                    .addComponent(jLabel_TenCB1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ChucVu)
                    .addComponent(jLabel_ChucVu1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(jLabel_CCCD1))
                .addGap(218, 218, 218)
                .addComponent(jButton_DoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        jTabbedPane1.addTab("Thông tin cá nhân", jPanel3);

        jButton_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Xoa.setText("Xóa");
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã cán bộ", "CCCD", "Họ và tên", "Tên tài khoản", "Mật khẩu", "Chức vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSach);

        jButton_Them.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Them.setText("Thêm");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jLabel_TieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_TieuDe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe1.setText("Danh sách cán bộ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Them)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Xoa))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Them)
                    .addComponent(jButton_Xoa))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách tài khoản cán bộ", jPanel1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jButton_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DoiMKActionPerformed
       Form_DoiMatKhau formDoiMatKhau = new Form_DoiMatKhau(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDoiMatKhau);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_DoiMKActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        // TODO add your handling code here:
        if(table_DanhSach.getSelectedRow()<0) return;
            
            
            Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc chắn muốn xóa cán bộ này ",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(choosen == JOptionPane.YES_OPTION){
                     int i= table_DanhSach.getSelectedRow();
                    int cnt=0;
                      for(can_bo cb: myList){
                         if(cb.getChuc_vu().compareTo("Tổ trưởng")==0 || cb.getChuc_vu().compareTo("Tổ phó")==0 )
                         { cnt++; }
                      }
                      
                      if(cnt<=1 && (myList.get(i).getChuc_vu().compareTo("Tổ trưởng")==0 || myList.get(i).getChuc_vu().compareTo("Tổ phó")==0) ){
                          JOptionPane.showMessageDialog(null, "Danh sách cán bộ cần có ít nhất tổ trưởng hoặc tổ phó"); return;
                      }
                      
                      myModel.delete_cb(myList.get(i));
                      
                      myList= myModel.getds();  
                      updateTable();
                      
                      return;
                }else if (choosen == JOptionPane.NO_OPTION){
                      return;
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                      return;
                }else {
                    return;
                }
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        Form_ThemCanBo formThemCanBo= new Form_ThemCanBo(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formThemCanBo);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DoiMK;
    private javax.swing.JButton jButton_Them;
    private javax.swing.JButton jButton_Xoa;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_CCCD1;
    private javax.swing.JLabel jLabel_ChucVu;
    private javax.swing.JLabel jLabel_ChucVu1;
    private javax.swing.JLabel jLabel_MaCB;
    private javax.swing.JLabel jLabel_MaCB1;
    private javax.swing.JLabel jLabel_TenCB;
    private javax.swing.JLabel jLabel_TenCB1;
    private javax.swing.JLabel jLabel_TieuDe;
    private javax.swing.JLabel jLabel_TieuDe1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.Table table_DanhSach;
    // End of variables declaration//GEN-END:variables
}
