/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi;

import com.raven.form.QuanLyThuPhi.Form_DanhSachPhiTuNguyen;
import java.awt.Container;

/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiTheoDot extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThuPhiTheoDot
     */
    public Form_ThuPhiTheoDot() {
        initComponents();
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        table1.addRow(new Object[]{"12431", "Thu phí", "27/12/2023","27/02/2024","1000000","Không"});
        jButton_XemChiTiet1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_XemChiTiet1ActionPerformed(evt);
        }
    });
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_XemChiTietActionPerformed(evt);
        }
    });
        jButton_TaoKhoanThu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_TaoKhoanThuActionPerformed(evt);
        }
    });
    }
private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_LichSuDanhSachTuNguyen formLichSuDanhSachTuNguyen= new Form_LichSuDanhSachTuNguyen();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formLichSuDanhSachTuNguyen);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}
private void jButton_XemChiTiet1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_DanhSachPhiTuNguyen formDanhSachPhiTuNguyen = new Form_DanhSachPhiTuNguyen();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDanhSachPhiTuNguyen);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}
private void jButton_TaoKhoanThuActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_TaoKhoanThuTuNguyen formTaoKhoanThuTuNguyen = new Form_TaoKhoanThuTuNguyen();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formTaoKhoanThuTuNguyen);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}

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
        jButton_XuatFile = new javax.swing.JButton();
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
        ));
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

        jButton_XuatFile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFile.setText("Xuất file");

        jButton_XemChiTiet1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet1.setText("Xem chi tiết");

        jButton_TaoKhoanThu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TaoKhoanThu.setText("Thêm khoản thu mới");

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe.setText("jLabel_TieuDe");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_TieuDe)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_TaoKhoanThu)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addComponent(jButton_XemChiTiet1)
                            .addGap(15, 15, 15)
                            .addComponent(jButton_XuatFile)
                            .addGap(15, 15, 15)
                            .addComponent(jButton_KetThucKT)
                            .addGap(15, 15, 15)
                            .addComponent(jButton_XoaKT))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel_TieuDe)
                .addGap(18, 18, 18)
                .addComponent(jButton_TaoKhoanThu)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XoaKT)
                    .addComponent(jButton_KetThucKT)
                    .addComponent(jButton_XuatFile)
                    .addComponent(jButton_XemChiTiet1))
                .addGap(35, 35, 35))
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
        ));
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
                .addContainerGap(52, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_KetThucKT;
    private javax.swing.JButton jButton_TaoKhoanThu;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XemChiTiet1;
    private javax.swing.JButton jButton_XoaKT;
    private javax.swing.JButton jButton_XuatFile;
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
