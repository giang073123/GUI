
package com.raven.form.QuanLyThuong;

import com.raven.form.QuanLyThuong.Form_ThemKhoanThuongHocTap;
import com.raven.model.QuanLyThuongHocTapDAO;
import com.raven.model.QuanLyThuongHocTap; // Adjust the package path if different.
import java.util.List;
import java.awt.Container;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.sql.SQLException;
import com.raven.model.QuanLyThuongTetDAO;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.event.ChangeListener;
import javax.swing.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.JTabbedPane;

public class Form_QuanLyThuongHocTap extends javax.swing.JPanel {

    private com.raven.swing.Table table_LichSuKhoanThuong;
    public Form_QuanLyThuongHocTap() {
        initComponents();
        loadActiveAwards();

        loadEndedAwards();
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_XemChiTietActionPerformed(evt);
        }
    });
                jButton_ThemKhoanThuong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_ThemKhoanThuongActionPerformed(evt);
        }
    });
                jButton_XemChiTiet1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_XemChiTiet1ActionPerformed(evt);
        }
    });
    }


    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton_KetThuc = new javax.swing.JButton();
        jButton_Xoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DanhSachKhoanThuong = new com.raven.swing.Table();
        jButton_XemChiTiet = new javax.swing.JButton();
        jLabel_DanhSach = new javax.swing.JLabel();
        jButton_ThemKhoanThuong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel_TieuDe = new javax.swing.JLabel();
        jButton_XemChiTiet1 = new javax.swing.JButton();

        jButton_KetThuc.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThuc.setText("Kết thúc khoản thưởng");
        jButton_KetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucActionPerformed(evt);
            }
        });

        jButton_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Xoa.setText("Xóa khoản thưởng");
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table_DanhSachKhoanThuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số", "Họ và tên", "Học sinh giỏi", "Học sinh tiên tiến", "Khác", "Ngày tạo", "Ngày kết thúc", "Tổng thưởng", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_DanhSachKhoanThuong);

        jButton_XemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet.setText("Xem chi tiết");
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTietActionPerformed(evt);
            }
        });

        jLabel_DanhSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_DanhSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_DanhSach.setText("Danh sách các khoản thưởng học tập");

        jButton_ThemKhoanThuong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ThemKhoanThuong.setText("Thêm khoản thưởng");
        jButton_ThemKhoanThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemKhoanThuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_DanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton_XemChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_ThemKhoanThuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton_KetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel_DanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_KetThuc)
                    .addComponent(jButton_Xoa)
                    .addComponent(jButton_XemChiTiet)
                    .addComponent(jButton_ThemKhoanThuong))
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Khoản thưởng học tập", jPanel1);


        jPanel2.setPreferredSize(new java.awt.Dimension(855, 683));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số", "Tên", "Học sinh giỏi", "Học sinh tiên tiến", "Khác", "Ngày tạo", "Tổng thưởng", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("Chọn ngày:");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton2.setText("Tìm kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TieuDe.setText("Danh sách lịch sử các khoản thưởng học tập");

        jButton_XemChiTiet1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet1.setText("Xem chi tiết");
        jButton_XemChiTiet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTiet1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_XemChiTiet1)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton_XemChiTiet1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử thưởng học tập", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
    }

    private void jButton_KetThucActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table_DanhSachKhoanThuong.getSelectedRow();
        if (selectedRow >= 0) {
            Integer ms_kthg = (Integer) table_DanhSachKhoanThuong.getValueAt(selectedRow, 0);
            try {
                QuanLyThuongHocTapDAO dao = new QuanLyThuongHocTapDAO();
                dao.ketThucKhoanThuong(ms_kthg);
                JOptionPane.showMessageDialog(this, "Khoản thưởng đã được kết thúc thành công.");
                loadActiveAwards(); // Làm mới danh sách khoản thưởng
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một khoản thưởng để kết thúc.");
        }
    }



    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the selected row index from the table.
        int selectedRow = table_DanhSachKhoanThuong.getSelectedRow();
        if (selectedRow >= 0) {
            // Confirm before deleting.
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn xóa khoản thưởng này không?",
                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            // If the user confirms the delete action.
            if (confirm == JOptionPane.YES_OPTION) {
                // Get the MS_KThg (ID) of the award from the table.
                Integer ms_kthg = (Integer) table_DanhSachKhoanThuong.getValueAt(selectedRow, 0);

                try {
                    // Create an instance of the DAO and call the delete method.
                    QuanLyThuongHocTapDAO dao = new QuanLyThuongHocTapDAO();
                    dao.deleteKhoanThuong(ms_kthg);

                    // Show success message.
                    JOptionPane.showMessageDialog(this, "Khoản thưởng đã được xóa thành công.");

                    // Reload the table data to reflect the deletion.
                    loadActiveAwards();
                } catch (SQLException ex) {
                    // Show error message if there's an exception.
                    JOptionPane.showMessageDialog(this, "Lỗi khi xóa khoản thưởng: " + ex.getMessage());
                }
            }
        } else {
            // If no row is selected, prompt the user to select a row.
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một khoản thưởng để xóa.");
        }
    }

    //siuu quan trong
    private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {
        // Bước 1 và 2: Bắt sự kiện và lấy mã số
        int selectedRow = table_DanhSachKhoanThuong.getSelectedRow();
        if (selectedRow >= 0) {
            Integer ms_kthg = (Integer) table_DanhSachKhoanThuong.getValueAt(selectedRow, 0); // Lấy mã số từ cột đầu tiên
            String tenKthg = (String) table_DanhSachKhoanThuong.getValueAt(selectedRow, 1);
            Form_DanhSachThuongHocTap formDanhSachThuongHocTap = new Form_DanhSachThuongHocTap(ms_kthg, tenKthg);
            Container parentContainer = this.getParent();
            parentContainer.remove(this);
            parentContainer.add(formDanhSachThuongHocTap);
            parentContainer.revalidate();
            parentContainer.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một khoản thưởng để xem chi tiết.");
        }
    }




    private void jButton_ThemKhoanThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemKhoanThuongActionPerformed
        Form_ThemKhoanThuongHocTap formThemKhoanThuongHocTap = new Form_ThemKhoanThuongHocTap();

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formThemKhoanThuongHocTap);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }//GEN-LAST:event_jButton_ThemKhoanThuongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_XemChiTiet1ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table.getSelectedRow(); // Use 'table' instead of 'table_DanhSach'
        if (selectedRow >= 0) {
            Integer msKthg = Integer.valueOf(table.getModel().getValueAt(selectedRow, 0).toString());
            String tenKthg = table.getModel().getValueAt(selectedRow, 1).toString();

            Form_LichSuDanhSachThuongHocTap formLichSuDanhSachThuongHocTap = new Form_LichSuDanhSachThuongHocTap(msKthg, tenKthg);

            Container parentContainer = this.getParent();
            parentContainer.remove(this);
            parentContainer.add(formLichSuDanhSachThuongHocTap);
            parentContainer.revalidate();
            parentContainer.repaint();
        }
    }


    private void loadActiveAwards() {
        try {
            QuanLyThuongHocTapDAO dao = new QuanLyThuongHocTapDAO();
            List<QuanLyThuongHocTap> activeAwards = dao.getActiveAwards();
            DefaultTableModel model = (DefaultTableModel) table_DanhSachKhoanThuong.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ khỏi bảng

            for (QuanLyThuongHocTap award : activeAwards) {
                Vector row = new Vector();
                row.add(award.getMsKThg());
                row.add(award.getTenKThg());
                row.add(award.getThuongHsgDacBiet());
                row.add(award.getThuongHstt());
                row.add(award.getThuongKhac());
                row.add(award.getNgayTaoKThg());
                row.add(award.getNgayKetThucKThg());
                row.add(award.getTongThuong());
                row.add(award.getGhiChu());

                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu: " + ex.getMessage());
        }
    }
    private void loadEndedAwards() {
        try {
            QuanLyThuongHocTapDAO dao = new QuanLyThuongHocTapDAO();
            List<QuanLyThuongHocTap> endedAwards = dao.getEndedAwards();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ

            for (QuanLyThuongHocTap award : endedAwards) {
                Vector<Object> row = new Vector<>();
                row.add(award.getMsKThg());
                row.add(award.getTenKThg());
                row.add(award.getThuongHsgDacBiet());
                row.add(award.getThuongHstt());
                row.add(award.getThuongKhac());
                row.add(award.getNgayTaoKThg());
                row.add(award.getNgayKetThucKThg());
                row.add(award.getTongThuong());
                row.add(award.getGhiChu());
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu: " + ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_KetThuc;
    private javax.swing.JButton jButton_ThemKhoanThuong;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XemChiTiet1;
    private javax.swing.JButton jButton_Xoa;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel_DanhSach;
    private javax.swing.JLabel jLabel_TieuDe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.Table table;
    private com.raven.swing.Table table_DanhSachKhoanThuong;
    // End of variables declaration//GEN-END:variables
}
