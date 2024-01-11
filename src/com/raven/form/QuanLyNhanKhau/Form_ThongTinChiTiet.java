package com.raven.form.QuanLyNhanKhau;

import com.raven.form.QuanLyNhanKhau.Form_KhaiBaoTamVang;
import com.raven.form.QuanLyNhanKhau.Form_LichSu;
import java.awt.Container;
import Model.NhanKhau.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Form_ThongTinChiTiet extends javax.swing.JPanel {

    Model_NhanKhau myModel;
    private ho_gia_dinh family;
    private ArrayList<nhan_khau> members;

    public Form_ThongTinChiTiet(int Ma_Ho, Model_NhanKhau model) {
        initComponents();
        table1.setDefaultEditor(Object.class, null);


       
        jButton_Tachho.setVisible(true);
        jButton4.setVisible(true);

        myModel = model;
        this.family = myModel.ho_gia_dinh_getfamily(Ma_Ho);
        update_members();
        update_family_info();

        // XEM LỊCH SỬ THAY ĐỔI
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

//        jButton_Tachho.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton_TachhoActionPerformed(evt);
//            }
//        });

//        jButton4.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton4ActionPerformed(evt);
//            }
//        });
        jButton_Xemchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemchitietActionPerformed(evt);
            }
        });
    }

    //UPDATE FAMILY INFO
    private void update_family_info() {
        int i = 0; int checkchuho=0;
        for (nhan_khau m : members) {  // Lấy thông tin chủ hộ
            if(m.getQH_chuho()==null) continue;
            if (m.getQH_chuho().compareTo("Chủ hộ") == 0) {
                checkchuho=1;
                break;
            }
            i++;
        }
        
        if(checkchuho==0){  
            jLabel10.setText("Cần bổ sung thông tin chủ hộ");  
            jLabel11.setText("Cần bổ sung thông tin chủ hộ");
        }
        else{ jLabel10.setText(members.get(i).getHo_ten());
         jLabel11.setText(family.getCCCD_Chuho());
        }
        jLabel9.setText(Integer.toString(family.getMa_Ho()));
        
        
        jTextField1.setText(Integer.toString(family.getSo_nha()));
        jTextField2.setText(family.getDuong_());
        jTextField3.setText(family.getPhuong_());
        jTextField4.setText(family.getQuan_());
        jTextField5.setText(Double.toString(Math.round(family.getDien_tich())));
    }

    //UPDATE TABLE
    private void update_members() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        members = myModel.ho_gia_dinh_getmembers(family.getMa_Ho());

        for (nhan_khau m : members) {
            table1.addRow(new Object[]{m.getHo_ten(), m.getCCCD(), m.getGioi_tinh(), m.getNgay_sinh(), m.getQH_chuho()});

        }
    }

    // CẬP NHẬT THÔNG TIN HỘ
//    private void jButton_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {  -> phải viết ở trong init
//        
//        
//        
//        
//    }
//    // THÊM NHÂN KHẨU
//    private void jButton1ActionPerformed(ActionEvent evt) {
//         if (searchText1.getText().length() < 1) {
//                return;
//            }
//
//        Object[] options = {"Xác nhận", "Hủy"};
//        int choosen = JOptionPane.showOptionDialog(null,
//                "Bạn có chắc chắn muốn thêm nhân khẩu này",
//                "Xác nhận",
//                JOptionPane.YES_NO_CANCEL_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[0]);
//        if (choosen == JOptionPane.YES_OPTION) {
//           
//            nhan_khau nk = myModel.nhan_khau_get(searchText1.getText());
//             
//            if (nk == null) {
//                JOptionPane.showMessageDialog(null, "Không tồn tại số CCCD này trong dữ liệu nhân khẩu");
//                return;
//            } else if (nk.getMa_Ho() > 0) {
//                JOptionPane.showMessageDialog(null, "Nhân khẩu này đã thuộc một hộ khác");
//                return;
//            } else if (myModel.check_samestring(nk.getTrang_thai_nhan_khau(), "Đã xóa")) {
//                JOptionPane.showMessageDialog(null, "Nhân khẩu này không thường trú trên địa bàn");
//                return;
//            } else if (myModel.check_samestring(nk.getTrang_thai_nhan_khau(), "khai tử")) {
//                JOptionPane.showMessageDialog(null, "Nhân khẩu này đã được khai tử");
//                return;
//            }
//
//            nk.setMa_Ho(family.getMa_Ho());
//            myModel.nhan_khau_update(nk);
//            update_members();
//
//            return;
//        } else if (choosen == JOptionPane.NO_OPTION) {
//            return;
//        } else if (choosen == JOptionPane.CANCEL_OPTION) {
//            return;
//        } else {
//            return;
//        }
//
//    }

    private void jButton_XemchitietActionPerformed(ActionEvent evt) {
        if (table1.getSelectedRow() < 0) {
            return;
        }
        int i = table1.getSelectedRow();
        // JOptionPane.showMessageDialog(null,i+myList.get(i).getHo_ten());
        nhan_khau nk = myModel.nhan_khau_get(table1.getValueAt(i, 1).toString());
        Form_ChiTietNhanKhau2 formChiTietNhanKhau = new Form_ChiTietNhanKhau2(myModel, nk);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formChiTietNhanKhau);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();

    }
//-------------------------------------------------------------------------------------------------

// LỊCH SỬ THAY ĐỔI
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        // Create an instance of Form_ThongTinChiTiet
        Form_LichSu formLichSu = new Form_LichSu(family.getMa_Ho(), myModel);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formLichSu);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }
//-------------------------------------------------------------------------------------------------

// NÚT KHAI BÁO TAM VẮNG
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Create an instance of Form_ThongTinChiTiet
        if (table1.getSelectedRow() < 0) {
            return;
        }
        // JOptionPane.showMessageDialog(null,table1.getSelectedRow());
        int idx = table1.getSelectedRow();
        if (myModel.tam_vang_check(members.get(idx).getCCCD(), java.sql.Date.valueOf(LocalDate.now()))) {
              JOptionPane.showMessageDialog(null,"Nhân khẩu hiện đang tạm vắng"); return;
          }
        
        Form_KhaiBaoTamVang formKhaiBaoTamVang = new Form_KhaiBaoTamVang(members.get(table1.getSelectedRow()), myModel);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formKhaiBaoTamVang);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }

    
    // CHUYỂN HỘ
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

        if (table1.getSelectedRow() < 0) {
            return;
        }

        Object[] options = {"Xác nhận", "Hủy"};
        int choosen = JOptionPane.showOptionDialog(null,
                "Bạn có chắc chắn muốn chuyển nhân khẩu này",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choosen == JOptionPane.YES_OPTION) {
            int s = table1.getSelectedRow();
            
            Form_Chuyenho fch = new Form_Chuyenho(myModel, members.get(s));
                     // Get the parent container (JFrame or another contai
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(fch);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
            
        } else if (choosen == JOptionPane.NO_OPTION) {
            return;
        } else if (choosen == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            return;
        }

    }

    private void searchText1ActionPerformed(java.awt.event.ActionEvent evt) { // Không làm gì cả, để fix lỗi vì không sửa được code của searchText1

    }

//---------------------------------------------------------------------------------------------
//    // XÓA NHÂN KHẨU
//    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

//    }//GEN-LAST:event_jButton4ActionPerformed
//    //---------------------------------------------------------------------------------------------
    // THOÁT
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        Form_ThongTinHo formThongTinHo = new Form_ThongTinHo(myModel);

        // Get the parent container (JFrame or another contai
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formThongTinHo);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }//GEN-LAST:event_jButton6ActionPerformed

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton_CapNhat = new javax.swing.JButton();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton_Xemchitiet = new javax.swing.JButton();
        jButton_Tachho = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin chi tiết về hộ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Mã hộ gia đình:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Họ và tên chủ hộ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Số CMT/CCCD của chủ hộ:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Địa chỉ :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Số nhà: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Phường:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setText("jLabel9");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setText("jLabel9");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setText("Đường:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("Quận:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField1.setText("jTextField1");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField2.setText("jTextField2");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField3.setText("jTextField3");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField4.setText("jTextField4");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Diện tích");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField5.setText("jTextField5");

        jButton_CapNhat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat.setText("Cập nhật thông tin");
        jButton_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel9))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel10)))
                        .addContainerGap())
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel7)
                                .addGap(4, 4, 4))
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                                .addComponent(jButton_CapNhat)
                                .addGap(130, 130, 130))))))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGap(10, 10, 10)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton_CapNhat)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton2.setText("Khai báo tạm vắng");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton3.setText("Lịch sử thay đổi");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ tên", "CMT/CCCD", "Giới tính", "Ngày tháng năm sinh", "Quan hệ với chủ hộ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton4.setText("Chuyển hộ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton6.setText("Thoát");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton_Xemchitiet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Xemchitiet.setText("Xem chi tiết");

        jButton_Tachho.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Tachho.setText("Tách hộ");
        jButton_Tachho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TachhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_Tachho)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addComponent(jButton_Xemchitiet, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Xemchitiet)
                .addGap(32, 32, 32)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton_Tachho))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Xác nhận", "Hủy"};
        int choosen = JOptionPane.showOptionDialog(null,
                "Bạn có chắc chắn muốn cập nhật thông tin này",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choosen == JOptionPane.YES_OPTION) {

            try {
                Integer.parseInt(jTextField1.getText());
                Float.parseFloat(jTextField5.getText());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Các giá trị số không hợp lệ hoặc chưa được nhập ");
                update_family_info();
                return;
            }

            if (jTextField2.getText().length() < 1 || jTextField3.getText().length() < 1 || jTextField4.getText().length() < 1) {
                JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin");
                update_family_info();
                return;
            }

            family.setSo_nha(Integer.valueOf(jTextField1.getText()));
            family.setDien_tich(Float.valueOf(jTextField5.getText()));
            family.setDuong_(jTextField2.getText());
            family.setPhuong_(jTextField3.getText());
            family.setQuan_(jTextField4.getText());
            myModel.ho_gia_dinh_update(family);
            JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin");
            update_family_info();
            return;
        } else if (choosen == JOptionPane.NO_OPTION) {
            return;
        } else if (choosen == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            return;
        }

    }//GEN-LAST:event_jButton_CapNhatActionPerformed

    private void jButton_TachhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TachhoActionPerformed
        // TODO add your handling code here:
         if (table1.getSelectedRow() < 0) {
            return;
        }

        Object[] options = {"Xác nhận", "Hủy"};
        int choosen = JOptionPane.showOptionDialog(null,
                "Bạn có chắc chắn muốn tách nhân khẩu này ra một hộ mới",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choosen == JOptionPane.YES_OPTION) {
            int s = table1.getSelectedRow();
            
            Form_ThemHo fth = new Form_ThemHo(myModel, members.get(s));
                     // Get the parent container (JFrame or another contai
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(fth);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
            
        } else if (choosen == JOptionPane.NO_OPTION) {
            return;
        } else if (choosen == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            return;
        }
        
    }//GEN-LAST:event_jButton_TachhoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JButton jButton_Tachho;
    private javax.swing.JButton jButton_Xemchitiet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables

}
