    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
     */
    package com.raven.form.QuanLyThuong;

    import com.raven.form.QuanLyThuong.Form_DanhSachThuongTet;
    import java.awt.Container;
    import javax.swing.JOptionPane;
    import com.raven.model.ThongKeThuongLeTetDAO;
    import com.raven.model.NhanKhau;
    import com.raven.model.DanhSachThuongTet;
    import com.raven.model.DanhSachThuongTetDAO;
    import com.raven.model.ThongKeThuongLeTet;
    import java.util.List;
    import javax.swing.table.DefaultTableModel;
    import java.sql.SQLException;

    public class Form_ThongKeThuongTet extends javax.swing.JPanel {
        private Integer ms_kthg;
        private String tenKthg;
        public Form_ThongKeThuongTet() {
            initComponents();
            jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuayLaiActionPerformed(evt);
            }
        });
        }
        public Form_ThongKeThuongTet(Integer ms_kthg, String tenKthg) {
            this.ms_kthg = ms_kthg;
            this.tenKthg = tenKthg;
            initComponents();
            displayThongKeThuongHocTap();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

            jLabel_TieuDe = new javax.swing.JLabel();
            jScrollPane2 = new javax.swing.JScrollPane();
            table_ThongKe = new com.raven.swing.Table();
            jButton_XuatFile = new javax.swing.JButton();
            jButton_QuayLai = new javax.swing.JButton();
            searchText_MaHo = new com.raven.swing.SearchText();
            jButton_TimKiem = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();

            jLabel_TieuDe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            jLabel_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel_TieuDe.setText("Thống kê số lượng thưởng tết");

            jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            table_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã hộ", "Tên chủ hộ", "Số lượng phần quà đã nhận"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane2.setViewportView(table_ThongKe);

            jButton_XuatFile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jButton_XuatFile.setText("Xuất File");
            jButton_XuatFile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_XuatFileActionPerformed(evt);
                }
            });

            jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jButton_QuayLai.setText("Quay lại");
            jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_QuayLaiActionPerformed(evt);
                }
            });

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

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
            jLabel1.setText("Nhập mã hộ:");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton_XuatFile)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton_TimKiem)
                                .addGap(355, 355, 355))))
                    .addGap(24, 24, 24))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_TimKiem)
                        .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_QuayLai)
                        .addComponent(jButton_XuatFile))
                    .addGap(33, 33, 33))
            );
        }// </editor-fold>//GEN-END:initComponents

        private void jButton_XuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatFileActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_jButton_XuatFileActionPerformed

        private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {
            // Make sure ms_kthg and tenKthg are not null
            if (this.ms_kthg != null && this.tenKthg != null) {
                Form_DanhSachThuongTet formDanhSachThuongTet = new Form_DanhSachThuongTet(this.ms_kthg, this.tenKthg);

                // Get the parent container (JFrame or another container)
                Container parentContainer = this.getParent();

                // Remove the current panel (this Form_ThongKeThuongTet) from the parent container
                parentContainer.remove(this);

                // Add the new panel (Form_DanhSachThuongTet) to the parent container
                parentContainer.add(formDanhSachThuongTet);

                // Repaint the container to reflect the changes
                parentContainer.revalidate();
                parentContainer.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Mã số khoản thưởng hoặc tên khoản thưởng không có sẵn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        private void displayThongKeThuongHocTap() {
            ThongKeThuongLeTetDAO dao = new ThongKeThuongLeTetDAO();
            try {
                List<ThongKeThuongLeTet> thongKeList = dao.thongKeThuongLeTet(this.ms_kthg);

                DefaultTableModel model = (DefaultTableModel) table_ThongKe.getModel();
                model.setRowCount(0); // Clear existing data

                for (ThongKeThuongLeTet thongKe : thongKeList) {
                    model.addRow(new Object[]{
                            thongKe.getMaHo(),
                            thongKe.getTenChuHo(),
                            thongKe.getSoLuongPhanQua(),
                            // Add other attributes if necessary
                    });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error in database operation: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }




        private void searchText_MaHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MaHoActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_searchText_MaHoActionPerformed

        private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_jButton_TimKiemActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton_QuayLai;
        private javax.swing.JButton jButton_TimKiem;
        private javax.swing.JButton jButton_XuatFile;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel_TieuDe;
        private javax.swing.JScrollPane jScrollPane2;
        private com.raven.swing.SearchText searchText_MaHo;
        private com.raven.swing.Table table_ThongKe;
        // End of variables declaration//GEN-END:variables
    }
