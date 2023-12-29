/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi;

import Model.ThuPhi.Model_ThuPhi;
import com.raven.form.QuanLyThuPhi.Form_TaoKhoanThuGuiXe;
import com.raven.form.QuanLyThuPhi.Form_DanhSachPhiGuiXe;
import java.awt.Container;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiGuiXe extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    /**
     * Creates new form Form_ThuPhiTuNguyen
     */
    public Form_ThuPhiGuiXe(Model_ThuPhi tp) {
        initComponents();
        myModel=tp;
        addSampleRows();
        checkRowCount();
        jButton_TaoKT2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_TaoKT2ActionPerformed(evt);
        }
    });
                jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_XemChiTietActionPerformed(evt);
        }
    });
    }
    private void addSampleRows() {
        table1.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String[]{"Đã thu", "Chưa thu"})));
        table1.addRow(new Object[]{"12431", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431", "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        table1.addRow(new Object[]{"12431",  "1000000","Ðã thu","22/12/2023"});
        
    }
        private void checkRowCount() {
        if (table1.getRowCount() == 0) {
            jLabel13.setVisible(false); 
            jLabel14.setText("Chưa có khoản thu nào"); 
            jLabel15.setVisible(false); 
            jLabel16.setVisible(false); 
            jLabel17.setVisible(false);
            searchText3.setVisible(false);
            jButton_TimKiem2.setVisible(false);
            jButton_TaoKT2.setVisible(true); // Hiển thị nút Tạo khoản thu mới
            jLabel_TenKT2.setVisible(false);
            jLabel_MaKT2.setVisible(false);
            jLabel_PhiXeDap.setVisible(false);
            jLabel_PhiXeMay.setVisible(false);
            jLabel_PhiOTo.setVisible(false);
            jScrollPane1.setVisible(false);
            jButton_CapNhat2.setVisible(false);
            jButton_XuatFile2.setVisible(false);
            jButton_KetThucKT2.setVisible(false);
            jButton_XoaKT2.setVisible(false);
        } else {
            jLabel13.setVisible(true); 
            jLabel14.setText("Nhập mã hộ để tìm kiếm:"); 
            jLabel15.setVisible(true); 
            jLabel16.setVisible(true); 
            jLabel17.setVisible(true); 
            searchText3.setVisible(true);
            jButton_TimKiem2.setVisible(true);
            jButton_TaoKT2.setVisible(false); 
            jLabel_TenKT2.setVisible(true);
            jLabel_MaKT2.setVisible(true);
            jLabel_PhiXeDap.setVisible(true);
            jLabel_PhiXeMay.setVisible(true);
            jLabel_PhiOTo.setVisible(true);
            jScrollPane1.setVisible(true);
            jButton_CapNhat2.setVisible(true);
            jButton_XuatFile2.setVisible(true);
            jButton_KetThucKT2.setVisible(true);
            jButton_XoaKT2.setVisible(true);
            
        }
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
        jLabel_TenKT2 = new javax.swing.JLabel();
        jButton_XoaKT2 = new javax.swing.JButton();
        jButton_KetThucKT2 = new javax.swing.JButton();
        jButton_TaoKT2 = new javax.swing.JButton();
        jButton_CapNhat2 = new javax.swing.JButton();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table5 = new com.raven.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_XemChiTiet = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        roundPanel8 = new com.raven.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new com.raven.swing.Table();
        jButton_CapNhat3 = new javax.swing.JButton();
        searchText4 = new com.raven.swing.SearchText();
        jLabel19 = new javax.swing.JLabel();
        jButton_TimKiem3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số tiền", "Trạng thái thu", "Ngày thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT2.setText("jLabel_TenKT");

        jButton_XoaKT2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XoaKT2.setText("Xóa khoản thu");

        jButton_KetThucKT2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThucKT2.setText("Kết thúc khoản thu");
        jButton_KetThucKT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucKT2ActionPerformed(evt);
            }
        });

        jButton_TaoKT2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TaoKT2.setText("Tạo khoản thu mới");

        jButton_CapNhat2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat2.setText("Cập nhật danh sách");

        jButton_XuatFile2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XuatFile2.setText("Xuất file");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("Mã số khoản thu:");

        searchText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText3ActionPerformed(evt);
            }
        });

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
                        .addComponent(jButton_TimKiem2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_TaoKT2))
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addComponent(jButton_XuatFile2)
                            .addGap(15, 15, 15)
                            .addComponent(jButton_CapNhat2)
                            .addGap(15, 15, 15)
                            .addComponent(jButton_KetThucKT2)
                            .addGap(15, 15, 15)
                            .addComponent(jButton_XoaKT2))
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
                .addGap(30, 30, 30))
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
                    .addComponent(jButton_TimKiem2)
                    .addComponent(jButton_TaoKT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XoaKT2)
                    .addComponent(jButton_KetThucKT2)
                    .addComponent(jButton_CapNhat2)
                    .addComponent(jButton_XuatFile2))
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

        jTabbedPane1.addTab("Theo dõi các khoản thu phí gửi xe hiện tại", jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Chọn tháng:");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton6.setText("Tìm kiếm");

        roundPanel3.setBackground(new java.awt.Color(250, 250, 250));

        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khoản thu", "Tên khoản thu", "Phí xe đạp", "Phí xe máy", "Phí xe ô tô", "Ngày tạo", "Ngày kết thúc", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(table5);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Danh sách các khoản thu");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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
                .addContainerGap(23, Short.MAX_VALUE))
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
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử các khoản thu phí gửi xe theo tháng", jPanel2);

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số lượng xe đạp", "Số lượng xe máy", "Số lượng xe ô tô"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table3);

        jButton_CapNhat3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_CapNhat3.setText("Cập nhật");
        jButton_CapNhat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhat3ActionPerformed(evt);
            }
        });

        searchText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText4ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem3.setText("Tìm kiếm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Bảng đăng ký xe");

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_CapNhat3)
                    .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(roundPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(18, 18, 18)
                            .addComponent(searchText4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_TimKiem3))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jButton_TimKiem3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton_CapNhat3)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý đăng ký xe", jPanel6);

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

    private void jButton_KetThucKT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KetThucKT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_KetThucKT2ActionPerformed

    private void searchText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText3ActionPerformed

    private void searchText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText4ActionPerformed

    private void jButton_CapNhat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhat3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CapNhat3ActionPerformed
private void jButton_TaoKT2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_TaoKhoanThuGuiXe formTaoKhoanThuMoi = new Form_TaoKhoanThuGuiXe(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formTaoKhoanThuMoi);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}
private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_DanhSachPhiGuiXe formDanhSachPhiGuiXe = new Form_DanhSachPhiGuiXe(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDanhSachPhiGuiXe);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_CapNhat2;
    private javax.swing.JButton jButton_CapNhat3;
    private javax.swing.JButton jButton_KetThucKT2;
    private javax.swing.JButton jButton_TaoKT2;
    private javax.swing.JButton jButton_TimKiem2;
    private javax.swing.JButton jButton_TimKiem3;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XoaKT2;
    private javax.swing.JButton jButton_XuatFile2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_MaKT2;
    private javax.swing.JLabel jLabel_PhiOTo;
    private javax.swing.JLabel jLabel_PhiXeDap;
    private javax.swing.JLabel jLabel_PhiXeMay;
    private javax.swing.JLabel jLabel_TenKT2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.RoundPanel roundPanel8;
    private com.raven.swing.SearchText searchText3;
    private com.raven.swing.SearchText searchText4;
    private com.raven.swing.Table table1;
    private com.raven.swing.Table table3;
    private com.raven.swing.Table table5;
    // End of variables declaration//GEN-END:variables
}
