
package com.raven.form.QuanLyThuong;
import java.awt.Container;
import com.raven.model.DanhSachThuongTetDAO;
import com.raven.model.DanhSachThuongTet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Form_ThemDanhSachTet extends javax.swing.JPanel {

    private Integer ms_kthg;
    private String tenKthg;
    private DanhSachThuongTetDAO dao;

    public Form_ThemDanhSachTet() {
        initComponents();
        dao = new DanhSachThuongTetDAO();
         jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_HuyActionPerformed(evt);
        }
    });
    }
    public Form_ThemDanhSachTet(Integer ms_kthg, String tenKthg) {
        this.ms_kthg = ms_kthg;
        this.tenKthg = tenKthg;
        dao = new DanhSachThuongTetDAO();
        initComponents();
        jLabel_TenKT1.setText(tenKthg);
        jLabel_MaSo2.setText(ms_kthg.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_CCCD = new javax.swing.JLabel();
        jLabel_MaSo = new javax.swing.JLabel();
        searchText_CCCD = new com.raven.swing.SearchText();
        jLabel_TenKhoanThuong = new javax.swing.JLabel();
        jButton_XacNhan = new javax.swing.JButton();
        jButton_Huy = new javax.swing.JButton();
        jLabel_TrangThai = new javax.swing.JLabel();
        jComboBox_TrangThai = new javax.swing.JComboBox<>();
        jLabel_TenKT1 = new javax.swing.JLabel();
        jLabel_MaSo2 = new javax.swing.JLabel();
        jLabel_TongThuong1 = new javax.swing.JLabel();
        jLabel_TongThuong = new javax.swing.JLabel();

        jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_CCCD.setText("CCCD:");

        jLabel_MaSo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_MaSo.setText("Mã số:");

        jLabel_TenKhoanThuong.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TenKhoanThuong.setText("Tên khoản thưởng:");

        jButton_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XacNhan.setText("Xác nhận");
        jButton_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XacNhanActionPerformed(evt);
            }
        });

        jButton_Huy.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_Huy.setText("Hủy");
        jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyActionPerformed(evt);
            }
        });

        jLabel_TrangThai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TrangThai.setText("Trạng thái:");

        jComboBox_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã hoàn thành", "Chưa hoàn thành" }));
        jComboBox_TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TrangThaiActionPerformed(evt);
            }
        });

        jLabel_TenKT1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TenKT1.setText("jLabel_TenKT");

        jLabel_MaSo2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_MaSo2.setText("jLabel_MaSo");

        jLabel_TongThuong1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TongThuong1.setText("Tổng thưởng: ");

        jLabel_TongThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_TongThuong.setText("jLabel_TongThuong");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel_TrangThai)
                                .addGap(71, 71, 71)
                                .addComponent(jComboBox_TrangThai, 0, 544, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel_CCCD)
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_TongThuong)
                                            .addComponent(jLabel_MaSo2))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_XacNhan)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Huy)))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_TongThuong1)
                    .addComponent(jLabel_MaSo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_TenKhoanThuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_TenKT1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TenKhoanThuong)
                    .addComponent(jLabel_TenKT1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_TongThuong1)
                    .addComponent(jLabel_TongThuong))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaSo)
                    .addComponent(jLabel_MaSo2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CCCD)
                    .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_TrangThai)
                    .addComponent(jComboBox_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Huy)
                    .addComponent(jButton_XacNhan))
                .addGap(82, 82, 82))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {
        // Extract necessary information from the form fields
        String CCCD = searchText_CCCD.getText();
        String trangThaiPhatThuong = jComboBox_TrangThai.getSelectedItem().toString();

        try {
            dao.themDanhSachThuongTet(CCCD, ms_kthg, trangThaiPhatThuong);

            // Display a success message
            JOptionPane.showMessageDialog(this, "Thêm danh sách thưởng Tết thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            // Optional: Refresh the form or redirect to another form as needed
            // ...

        } catch (SQLException ex) {
            // Display an error message in case of an exception
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm danh sách thưởng Tết: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void jButton_HuyActionPerformed(java.awt.event.ActionEvent evt) {
        // Tạo một instance mới của Form_DanhSachThuongTet và truyền ms_kthg và tenKthg vào constructor
        Form_DanhSachThuongTet formDanhSachThuongTet = new Form_DanhSachThuongTet(this.ms_kthg, this.tenKthg);

        // Lấy container chứa panel hiện tại
        Container parentContainer = this.getParent();

        // Xóa panel hiện tại ra khỏi container
        parentContainer.remove(this);

        // Thêm form danh sách thưởng Tết mới vào container
        parentContainer.add(formDanhSachThuongTet);

        // Cập nhật lại container để phản ánh sự thay đổi
        parentContainer.revalidate();
        parentContainer.repaint();
    }


    private void jComboBox_TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Huy;
    private javax.swing.JButton jButton_XacNhan;
    private javax.swing.JComboBox<String> jComboBox_TrangThai;
    private javax.swing.JLabel jLabel_CCCD;
    private javax.swing.JLabel jLabel_MaSo;
    private javax.swing.JLabel jLabel_MaSo2;
    private javax.swing.JLabel jLabel_TenKT1;
    private javax.swing.JLabel jLabel_TenKhoanThuong;
    private javax.swing.JLabel jLabel_TongThuong;
    private javax.swing.JLabel jLabel_TongThuong1;
    private javax.swing.JLabel jLabel_TrangThai;
    private com.raven.swing.SearchText searchText_CCCD;
    // End of variables declaration//GEN-END:variables
}
