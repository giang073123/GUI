/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Phitunguyen;

import com.raven.form.QuanLyThuPhi.*;
import Model.ThuPhi.*;
import java.awt.Container;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiTheoDot extends javax.swing.JPanel {

    Model_ThuPhi myModel;

    ArrayList<khoan_thu_khac> current = new ArrayList<>();
    ArrayList<khoan_thu_khac> history = new ArrayList<>();

    /**
     * Creates new form Form_ThuPhiTheoDot
     */
    public Form_ThuPhiTheoDot(Model_ThuPhi tp) {
        initComponents();
       // jButton_XoaKT.setVisible(false); jButton_KetThucKT.setVisible(false);
        myModel = tp;

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
                if(idx<0) return;
                Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc chắn muốn xóa khoản thu này",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (choosen == JOptionPane.YES_OPTION) {
                   
                    myModel.khoan_thu_Xoa("khoan_thu_khac", current.get(idx).getMS_KThu());
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(idx);
                    JOptionPane.showMessageDialog(null, "Đã xóa khoản thu");

                    return;
                } else if (choosen == JOptionPane.NO_OPTION) {
                    return;
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                    return;
                } else {
                    return;
                }

            }
        });

        // KẾT THÚC KHOẢN THU 
        jButton_KetThucKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int idx = table1.getSelectedRow();
                if (idx < 0) {
                    return;
                }

                Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc chắn muốn kết thúc khoản thu này",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (choosen == JOptionPane.YES_OPTION) {
                    myModel.khoan_thu_Ketthuc("khoan_thu_khac", current.get(idx).getMS_KThu());
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(idx);
                    JOptionPane.showMessageDialog(null, "Đã kết thúc khoản thu");

                    return;
                } else if (choosen == JOptionPane.NO_OPTION) {
                    return;
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                    return;
                } else {
                    return;
                }

            }
        });

        // TÌM KIẾM KHOẢN THU TRONG PHẦN LỊCH SỬ THEO THÁNG
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (jDateChooser1.getDate() != null) {
                    Date choosen_Date = jDateChooser1.getDate();
                    int i = 0;
                    for (khoan_thu_khac kt : history) {
                        if (kt.getNgaytao_KThu().getMonth() == choosen_Date.getMonth()) {
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
    private void getdata1() {
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_khac(), "Chưa kết thúc");
        if (tmplist.size() == 0) {
            return;
        }

        for (khoan_thu kt : tmplist) {
            khoan_thu_khac k = (khoan_thu_khac) kt;
            if (k.getLoai_KThu().compareTo("Đóng góp tự nguyện") == 0) {
                current.add(k);
            }

        }
    }

    private void updateTable1(ArrayList<khoan_thu_khac> list) {
        if (list.size() == 0) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        int i = 1;
        // "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
        for (khoan_thu_khac kt : list) {
            table1.addRow(new Object[]{kt.getMS_KThu(), kt.getTen_KThu(), kt.getNgaytao_KThu(), kt.getTong_thu(), kt.getGhi_chu()});
        }

    }

    // CÁC METHOD CỦA TRANG LỊCH SỬ KHOẢN THU
    private void getHistory() {
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_khac(), "Đã kết thúc");
        if (tmplist.size() == 0) {
            return;
        }

        for (khoan_thu kt : tmplist) {
            khoan_thu_khac k = (khoan_thu_khac) kt;
            if (k.getLoai_KThu().compareTo("Đóng góp tự nguyện") == 0) {
                history.add(k);
            }
        }
    }

    private void updateTable3() {  // Vì sao ở trên cần truyền vào list mà ở đây lại không -> Vì ở trên cop từ bảng nhân khẩu, cần dùng 2 list cho chức năng tìm kiếm
        DefaultTableModel model = (DefaultTableModel) table3.getModel();
        model.setRowCount(0);

        for (khoan_thu_khac kt : history) {
            table3.addRow(new Object[]{kt.getMS_KThu(), kt.getTen_KThu(), kt.getNgaytao_KThu(), kt.getTong_thu(), kt.getGhi_chu()});
        }
    }

    private void jButton_XemChiTiet1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Create an instance of Form_ThongTinChiTiet
        if(table1.getSelectedRow()<0) return;
        Form_DanhSachPhiTuNguyen formDanhSachPhiTuNguyen = new Form_DanhSachPhiTuNguyen(myModel, current.get(table1.getSelectedRow()).getMS_KThu());

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formDanhSachPhiTuNguyen);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    } // XEM CHI TIẾT KHOẢN THU HIỆN TẠI -> có sự kiện, chưa hoàn thiện form  

    private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {
        // Create an instance of Form_ThongTinChiTiet
        Form_LichSuDanhSachTuNguyen formLichSuDanhSachTuNguyen = new Form_LichSuDanhSachTuNguyen(myModel, history.get(table3.getSelectedRow()));

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formLichSuDanhSachTuNguyen);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }  // XEM CHI TIẾT KHOẢN THU TRONG LỊCH SỬ -> -> có sự kiện, chưa hoàn thiện form

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jButton_XoaKT = new javax.swing.JButton();
        jButton_KetThucKT = new javax.swing.JButton();
        jButton_XemChiTiet1 = new javax.swing.JButton();
        jButton_TaoKhoanThu = new javax.swing.JButton();
        jLabel_TieuDe = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new com.raven.swing.Table();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_XemChiTiet = new javax.swing.JButton();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khoản thu", "Tên khoản thu", "Ngày tạo", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(table1);

        jButton_XoaKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XoaKT.setText("Xóa khoản thu");

        jButton_KetThucKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThucKT.setText("Kết thúc khoản thu");
        jButton_KetThucKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucKTActionPerformed(evt);
            }
        });

        jButton_XemChiTiet1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet1.setText("Xem chi tiết");

        jButton_TaoKhoanThu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TaoKhoanThu.setText("Thêm khoản thu");
        jButton_TaoKhoanThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TaoKhoanThuActionPerformed(evt);
            }
        });

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe.setText("DANH SÁCH CÁC KHOẢN THU TỰ NGUYỆN");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_TieuDe)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton_XoaKT)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_KetThucKT)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_XemChiTiet1)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TaoKhoanThu))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_TieuDe)
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_TaoKhoanThu)
                    .addComponent(jButton_XemChiTiet1)
                    .addComponent(jButton_KetThucKT)
                    .addComponent(jButton_XoaKT))
                .addGap(49, 49, 49))
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

        jTabbedPane1.addTab("Theo dõi các khoản thu phí tự nguyện", jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Chọn tháng:");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton6.setText("Tìm kiếm");

        roundPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Danh sách các khoản thu");

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khoản thu", "Tên khoản thu", "Ngày tạo", "Ngày kết thúc", "Tổng thu", "Ghi chú"
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
        jScrollPane3.setViewportView(table3);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(583, Short.MAX_VALUE))
            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel3Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(400, 400, 400))
            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel3Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

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
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử các khoản thu phí tự nguyện", jPanel2);

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

    private void jButton_TaoKhoanThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TaoKhoanThuActionPerformed
        // TODO add your handling code here:
        // Create an instance of Form_ThongTinChiTiet
        Form_TaoKhoanThuTuNguyen formTaoKhoanThuTuNguyen = new Form_TaoKhoanThuTuNguyen(myModel);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formTaoKhoanThuTuNguyen);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }//GEN-LAST:event_jButton_TaoKhoanThuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_KetThucKT;
    private javax.swing.JButton jButton_TaoKhoanThu;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XemChiTiet1;
    private javax.swing.JButton jButton_XoaKT;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_TieuDe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.Table table1;
    private com.raven.swing.Table table3;
    // End of variables declaration//GEN-END:variables
}
