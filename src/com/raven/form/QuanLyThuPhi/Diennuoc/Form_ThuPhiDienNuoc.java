/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Diennuoc;

import Model.ThuPhi.Model_ThuPhi;
import Model.ThuPhi.khoan_thu;
import Model.ThuPhi.khoan_thu_khac;
import com.raven.form.QuanLyThuPhi.Diennuoc.Form_LichSuDanhSachDienNuoc;
import com.raven.form.QuanLyThuPhi.Diennuoc.Form_ThemKhoanThuDienNuoc;
import com.raven.form.QuanLyThuPhi.Diennuoc.Form_DanhSachDienNuocHienTai;
import java.awt.Container;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiDienNuoc extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    ArrayList<khoan_thu_khac> current = new ArrayList<>();
    ArrayList<khoan_thu_khac> history = new ArrayList<>();
    /**
     * Creates new form Form_ThuPhiDienNuoc
     */
    public Form_ThuPhiDienNuoc(Model_ThuPhi tp) {
        initComponents();
        myModel=tp;
        
        getdata1();
        updateTable1(current);
        
        getHistory();
        updateTable3();
        
        
         jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton_XemChiTietActionPerformed(evt);
            }
         });
         
        jButton_XemChiTiet1.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton_XemChiTiet1ActionPerformed(evt);
             }
         });
        
        // TẠO KHOẢN THU -> -> có sự kiện, chưa hoàn thiện form
        jButton_TaoKhoanThu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_TaoKhoanThuActionPerformed(evt);
        }
    });
        
         // XÓA KHOẢN THU -> Đã có
        jButton_XoaKT.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            int idx = table1.getSelectedRow();
            myModel.khoan_thu_Xoa("khoan_thu_khac",current.get(idx).getMS_KThu());            
             DefaultTableModel model = (DefaultTableModel)table1.getModel();
             model.removeRow(idx);
             JOptionPane.showMessageDialog(null,"Đã xóa khoản thu");
        }
    });
        
        // KẾT THÚC KHOẢN THU 
        jButton_KetThucKT.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            int idx = table1.getSelectedRow();
            myModel.khoan_thu_Ketthuc("khoan_thu_khac",current.get(idx).getMS_KThu());
             DefaultTableModel model = (DefaultTableModel)table1.getModel();
             model.removeRow(idx);
             JOptionPane.showMessageDialog(null,"Đã kết thúc khoản thu");
        }
    });
        
        // TÌM KIẾM KHOẢN THU TRONG PHẦN LỊCH SỬ THEO THÁNG
        jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
              if(jDateChooser1.getDate()!=null){
               Date choosen_Date = jDateChooser1.getDate();
                int i = 0;
                    for (khoan_thu_khac kt : history) {
                        if (kt.getNgaytao_KThu().getMonth() == choosen_Date.getMonth() ) {
                            Rectangle rect = table3.getCellRect(i, 0, true);
                            jScrollPane3.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
               
                }
        }
    });
        
}
    
     // CÁC METHOD CỦA TRANG KHOẢN THU HIỆN TẠI
    private void getdata1(){
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_khac(),"Chưa kết thúc");
        if (tmplist.size()==0) return;

        for(khoan_thu kt:tmplist){  
            khoan_thu_khac k = (khoan_thu_khac) kt;
            if(k.getLoai_KThu().compareTo("Đóng góp tự nguyện")!=0){current.add(k);}
            
        }
    }

    private void updateTable1(ArrayList<khoan_thu_khac> list) {
        if (list.size()==0) return;
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        int i=1;
       // "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
        for(khoan_thu_khac kt : list){
            table1.addRow(new Object[]{kt.getMS_KThu(),kt.getTen_KThu(),kt.getLoai_KThu(),kt.getNgaytao_KThu(),kt.getTong_thu(),kt.getGhi_chu()});
        }
        
    }

    
     // CÁC METHOD CỦA TRANG LỊCH SỬ KHOẢN THU
    
    private void getHistory(){
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_khac(),"Đã kết thúc");
        if (tmplist.size()==0) return;
        
        for(khoan_thu kt:tmplist){  
            khoan_thu_khac k = (khoan_thu_khac) kt;
            if(k.getLoai_KThu().compareTo("Đóng góp tự nguyện")!=0){history.add(k);};
            
        }
    }
    
    private void updateTable3(){  // Vì sao ở trên cần truyền vào list mà ở đây lại không -> Vì ở trên cop từ bảng nhân khẩu, cần dùng 2 list cho chức năng tìm kiếm
        DefaultTableModel model = (DefaultTableModel)table3.getModel();
        model.setRowCount(0);

        for(khoan_thu_khac kt : history){
            table3.addRow(new Object[]{kt.getMS_KThu(),kt.getTen_KThu(),kt.getLoai_KThu(),kt.getNgaytao_KThu(),kt.getTong_thu(),kt.getGhi_chu()});
        }
    }
    
    
   

   

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel_TieuDe = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jButton_KetThucKT = new javax.swing.JButton();
        jButton_XemChiTiet = new javax.swing.JButton();
        jButton_XoaKT = new javax.swing.JButton();
        jButton_TaoKhoanThu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton_XemChiTiet1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table3 = new com.raven.swing.Table();
        jLabel_ChonNgay1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jLabel_TieuDe1 = new javax.swing.JLabel();

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Các khoản thu tiền điện, nước, Internet hiện tại");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số", "Tên ", "Loại", "Ngày tạo", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table1);

        jButton_KetThucKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThucKT.setText("Kết thúc khoản thu");
        jButton_KetThucKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucKTActionPerformed(evt);
            }
        });

        jButton_XemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet.setText("Xem chi tiết");
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTietActionPerformed(evt);
            }
        });

        jButton_XoaKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XoaKT.setText("Xóa khoản thu");
        jButton_XoaKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaKTActionPerformed(evt);
            }
        });

        jButton_TaoKhoanThu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TaoKhoanThu.setText("Thêm khoản thu");
        jButton_TaoKhoanThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TaoKhoanThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_XemChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_TaoKhoanThu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_KetThucKT)
                        .addGap(12, 12, 12)
                        .addComponent(jButton_XoaKT))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XoaKT)
                    .addComponent(jButton_TaoKhoanThu)
                    .addComponent(jButton_XemChiTiet)
                    .addComponent(jButton_KetThucKT))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Theo dõi các khoản thu phí điện, nước, Internet hiện tại", jPanel3);

        jButton_XemChiTiet1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet1.setText("Xem chi tiết");
        jButton_XemChiTiet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTiet1ActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số", "Tên ", "Loại", "Ngày tạo", "Ngày kết thúc", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(table3);

        jLabel_ChonNgay1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_ChonNgay1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ChonNgay1.setText("Chọn ngày:");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton6.setText("Tìm kiếm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel_TieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe1.setText("Lịch sử các khoản thu tiền điện, nước, Internet");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_XemChiTiet1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel_ChonNgay1)
                            .addGap(18, 18, 18)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(jButton6))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel_ChonNgay1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_XemChiTiet1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử các khoản thu phí điện, nước, Internet", jPanel1);

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

    private void jButton_XemChiTiet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XemChiTiet1ActionPerformed
        Form_LichSuDanhSachDienNuoc formLichSuDanhSachDienNuoc = new Form_LichSuDanhSachDienNuoc(myModel,history.get(table3.getSelectedRow()));

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formLichSuDanhSachDienNuoc);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_XemChiTiet1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton_TaoKhoanThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TaoKhoanThuActionPerformed
        Form_ThemKhoanThuDienNuoc formThemKhoanThuDienNuoc = new Form_ThemKhoanThuDienNuoc(myModel);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formThemKhoanThuDienNuoc);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }//GEN-LAST:event_jButton_TaoKhoanThuActionPerformed
// 3 PHƯƠNG THỨC DƯỚI ĐÂY ĐÃ ĐƯỢC TẠO PHÍA TRÊN
    private void jButton_XoaKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaKTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_XoaKTActionPerformed

    private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XemChiTietActionPerformed
        // Create an instance of Form_ThongTinChiTiet
    Form_DanhSachDienNuocHienTai form = new Form_DanhSachDienNuocHienTai(myModel,current.get(table1.getSelectedRow()));

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(form);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_XemChiTietActionPerformed

    private void jButton_KetThucKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KetThucKTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_KetThucKTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_KetThucKT;
    private javax.swing.JButton jButton_TaoKhoanThu;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XemChiTiet1;
    private javax.swing.JButton jButton_XoaKT;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel_ChonNgay1;
    private javax.swing.JLabel jLabel_TieuDe;
    private javax.swing.JLabel jLabel_TieuDe1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.Table table1;
    private com.raven.swing.Table table3;
    // End of variables declaration//GEN-END:variables
}
