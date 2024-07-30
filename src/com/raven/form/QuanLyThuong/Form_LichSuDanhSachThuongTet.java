/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuong;

import com.raven.form.QuanLyThuong.Form_DanhSachThuongTet;
import com.raven.form.QuanLyThuong.Form_QuanLyThuongTet;
import java.awt.Container;
import javax.swing.JTabbedPane;


import com.raven.model.DanhSachThuongTetDAO;
import com.raven.model.ThongKeThuongTetDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.raven.model.QuanLyThuongTetdata;
import java.sql.ResultSet;
import java.util.Arrays;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author dangk
 */
public class Form_LichSuDanhSachThuongTet extends javax.swing.JPanel {

    private JTabbedPane tabbedPane;
    private Integer ms_kthg;
    private String tenKthg;
    private DanhSachThuongTetDAO danhSachThuongTetDAO;
    public Form_LichSuDanhSachThuongTet() {
        this.tabbedPane = tabbedPane;
        initComponents();
         jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_QuayLaiActionPerformed(evt);
        }
    });
    }
    Form_LichSuDanhSachThuongTet(Integer ms_kthg, String tenKthg)
    {
        this.ms_kthg = ms_kthg;
        this.tenKthg = tenKthg;
        initComponents();
        jLabel_TenKT1.setText(tenKthg);
        jLabel_MaSo2.setText(String.valueOf(ms_kthg));
        loadDanhSachThuongTet(ms_kthg); // Gọi hàm để tải dữ liệu vào bảng
        danhSachThuongTetDAO = new DanhSachThuongTetDAO();
        this.danhSachThuongTetDAO = new DanhSachThuongTetDAO();
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSach = new com.raven.swing.Table();
        jLabel_Ten = new javax.swing.JLabel();
        searchText_Ten = new com.raven.swing.SearchText();
        jLabel_CCCD = new javax.swing.JLabel();
        searchText_CCCD = new com.raven.swing.SearchText();
        jLabel_MaHo = new javax.swing.JLabel();
        searchText_MaHo = new com.raven.swing.SearchText();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel_TenKhoanThuong = new javax.swing.JLabel();
        jLabel_MaSo = new javax.swing.JLabel();
        jButton_QuayLai = new javax.swing.JButton();
        jLabel_TenKT1 = new javax.swing.JLabel();
        jLabel_MaSo2 = new javax.swing.JLabel();

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPane2.setViewportView(table_DanhSach);

        jLabel_Ten.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Ten.setText("Họ và tên: ");

        searchText_Ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_TenActionPerformed(evt);
            }
        });

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_CCCD.setText("CCCD:");

        searchText_CCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_CCCDActionPerformed(evt);
            }
        });

        jLabel_MaHo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaHo.setText("Mã hộ:");

        searchText_MaHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText_MaHoActionPerformed(evt);
            }
        });

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jLabel_TenKhoanThuong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TenKhoanThuong.setText("Tên khoản thưởng: ");

        jLabel_MaSo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSo.setText("Mã số:");

        jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_QuayLai.setText("Quay lại");
        jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        });

        jLabel_TenKT1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenKT1.setText("jLabel_TenKT");

        jLabel_MaSo2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaSo2.setText("jLabel_MaSo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_TenKhoanThuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel_Ten)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_MaSo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_MaSo2))
                            .addComponent(jLabel_TenKT1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel_CCCD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_MaHo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton_TimKiem)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_QuayLai)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenKhoanThuong)
                    .addComponent(jLabel_TenKT1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSo)
                    .addComponent(jLabel_MaSo2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Ten)
                    .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MaHo)
                    .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton_QuayLai)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchText_TenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_TenActionPerformed

    private void searchText_CCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_CCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_CCCDActionPerformed

    private void searchText_MaHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MaHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText_MaHoActionPerformed

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {
        // Retrieve text from search fields
        String hoTen = searchText_Ten.getText().trim();
        String cccd = searchText_CCCD.getText().trim();
        String maHo = searchText_MaHo.getText().trim();

        // Perform the search and update the table with the results
        try {
            // Ensure ms_kthg is not null and has a valid value
            if (ms_kthg == null) {
                JOptionPane.showMessageDialog(this, "Mã số khoản thưởng không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Use the DAO to search with the provided parameters
            Vector<Vector<Object>> results = danhSachThuongTetDAO.searchDanhSachThuongTet(hoTen, cccd, maHo, ms_kthg);
            updateTableWithSearchResults(results);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi xảy ra trong quá trình tìm kiếm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTableWithSearchResults(Vector<Vector<Object>> data) {
        Vector<String> columnNames = new Vector<>(Arrays.asList(
                "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
        ));
        DefaultTableModel model = (DefaultTableModel) table_DanhSach.getModel();
        model.setDataVector(data, columnNames);
    }

    private void loadDanhSachThuongTet(int msKThg) {
        try {
            DanhSachThuongTetDAO dao = new DanhSachThuongTetDAO();
            Vector<Vector<Object>> data = dao.layDanhSachThuongTetTheoMaKhoanThuong(msKThg);
            DefaultTableModel model = (DefaultTableModel) table_DanhSach.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ
            for (Vector<Object> row : data) {
                model.addRow(row); // Thêm dữ liệu mới
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu: " + e.getMessage());
        }
    }

    private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuayLaiActionPerformed
        Form_QuanLyThuongTet formQuanLyThuongTet = new Form_QuanLyThuongTet();

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formQuanLyThuongTet);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
    }//GEN-LAST:event_jButton_QuayLaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_QuayLai;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_MaHo;
    private javax.swing.JLabel jLabel_MaSo;
    private javax.swing.JLabel jLabel_MaSo2;
    private javax.swing.JLabel jLabel_Ten;
    private javax.swing.JLabel jLabel_TenKT1;
    private javax.swing.JLabel jLabel_TenKhoanThuong;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.SearchText searchText_CCCD;
    private com.raven.swing.SearchText searchText_MaHo;
    private com.raven.swing.SearchText searchText_Ten;
    private com.raven.swing.Table table_DanhSach;
    // End of variables declaration//GEN-END:variables
}
