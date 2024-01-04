    package com.raven.form.QuanLyThuong;

    import java.awt.Container;

    import com.raven.model.DanhSachThuongTetDAO;
    import com.raven.model.ThongKeThuongTetDAO;
    import java.util.Vector;
    import javax.swing.table.DefaultTableModel;
    import javax.swing.JTable;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
    import com.raven.model.QuanLyThuongTetDAO;
    import com.raven.model.QuanLyThuongTetdata;
    import java.sql.ResultSet;
    import java.util.Arrays;
    import java.sql.SQLException;
    import javax.swing.JFrame;
    import javax.swing.SwingUtilities;
    import javax.swing.JPanel;

    public class Form_DanhSachThuongTet extends javax.swing.JPanel {

        private DanhSachThuongTetDAO danhSachThuongTetDAO;
        private QuanLyThuongTetDAO quanLyThuongTetDAO;
        private com.raven.swing.Table table_DanhSachChiTiet;
        private javax.swing.JTable table_KhoanThuong;
        private Vector<String> columnNames;
        private int msKThg;
        private Form_QuanLyThuongTet formQuanLyThuongTetParent;

        public Form_DanhSachThuongTet() {
            initComponents();
            danhSachThuongTetDAO = new DanhSachThuongTetDAO();
            quanLyThuongTetDAO = new QuanLyThuongTetDAO();
            loadDanhSachThuongTet();
            table_ThongKe = new javax.swing.JTable();
            jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_QuayLaiActionPerformed(evt);
                }
            });
            jButton_Them.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_ThemActionPerformed(evt);
                }
            });
            jButton_ThongKe.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_ThongKeActionPerformed(evt);
                }
            });
            jButton_ChinhSua.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_ChinhSuaActionPerformed(evt);
                }
            });
        }
        public class SomeClass {
            private DanhSachThuongTetDAO danhSachThuongTetDAO;

            public SomeClass() {
                danhSachThuongTetDAO = new DanhSachThuongTetDAO();
                // Bây giờ bạn có thể gọi danhSachThuongTetDAO.layDanhSachThuongTetTheoMaKhoanThuong(msKThg) mà không gặp lỗi NullPointerException
            }
        }


        public Form_DanhSachThuongTet(Form_QuanLyThuongTet parent, int msKThg, String tenKhoanThuong) {
            this.formQuanLyThuongTetParent = parent;
            initComponents();
            this.danhSachThuongTetDAO = new DanhSachThuongTetDAO(); // Thêm dòng này để khởi tạo DAO
            this.msKThg = msKThg;
            this.jLabel_TenKT.setText(tenKhoanThuong); // Set the name of the reward
            this.jLabel_MaSo.setText(String.valueOf(msKThg)); // Set the reward code with the desired format
            loadDanhSachNhanThuong(msKThg);
        }





        private void jButton_QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {
            formQuanLyThuongTetParent.showPanel(this);
        }



        @SuppressWarnings("unchecked")
            // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
            private void initComponents() {
                table_DanhSachChiTiet = new com.raven.swing.Table();
                searchText_CCCD = new com.raven.swing.SearchText();
                searchText_Ten = new com.raven.swing.SearchText();
                searchText_MaHo = new com.raven.swing.SearchText();
                jButton_TimKiem = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                jButton_ChinhSua = new javax.swing.JButton();
                jLabel_Ten = new javax.swing.JLabel();
                jLabel_MaSo = new javax.swing.JLabel();
                jLabel_TenKhoanThuongTet = new javax.swing.JLabel();
                jLabel_CCCD = new javax.swing.JLabel();
                jLabel_MaHo = new javax.swing.JLabel();
                jButton_QuayLai = new javax.swing.JButton();
                jButton_Them = new javax.swing.JButton();
                jButton_Xoa = new javax.swing.JButton();
                jButton_XuatFileExcel = new javax.swing.JButton();
                jButton_ThongKe = new javax.swing.JButton();
                jLabel_TenKT = new javax.swing.JLabel();
                jLabel_MaSo1 = new javax.swing.JLabel();



                searchText_Ten.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        searchText_TenActionPerformed(evt);
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

                jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                table_DanhSachChiTiet.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
                });
                 jScrollPane2.setViewportView(table_DanhSachChiTiet);

                jButton_ChinhSua.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jButton_ChinhSua.setText("Chỉnh sửa");
                jButton_ChinhSua.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton_ChinhSuaActionPerformed(evt);
                    }
                });


                jLabel_Ten.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jLabel_Ten.setText("Họ và tên: ");

                jLabel_MaSo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jLabel_MaSo.setText("Mã số: ");

                jLabel_TenKhoanThuongTet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jLabel_TenKhoanThuongTet.setText("Tên khoản thưởng:");


                jLabel_CCCD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jLabel_CCCD.setText("CCCD: ");

                jLabel_MaHo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jLabel_MaHo.setText("Mã hộ:");

                jButton_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jButton_QuayLai.setText("Quay lại");

                jButton_Them.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jButton_Them.setText("Thêm");
                jButton_Them.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton_ThemActionPerformed(evt);
                    }
                });

                jButton_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jButton_Xoa.setText("Xóa");
                jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton_XoaActionPerformed(evt);
                    }
                });

                jButton_XuatFileExcel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jButton_XuatFileExcel.setText("Xuất File");
                jButton_XuatFileExcel.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton_XuatFileExcelActionPerformed(evt);
                    }
                });

                jButton_ThongKe.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
                jButton_ThongKe.setText("Thống kê");
                jButton_ThongKe.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton_ThongKeActionPerformed(evt);
                    }
                });

                jLabel_TenKT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel_TenKT.setText("jLabel_TenKT");

                jLabel_MaSo1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel_MaSo1.setText("jLabel_MaSo");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Ten)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_CCCD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_MaHo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_TimKiem))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_TenKhoanThuongTet)
                                    .addComponent(jLabel_MaSo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_MaSo1)
                                    .addComponent(jLabel_TenKT))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_XuatFileExcel)
                                .addGap(15, 15, 15)
                                .addComponent(jButton_ThongKe)
                                .addGap(15, 15, 15)
                                .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButton_ChinhSua)
                                .addGap(15, 15, 15)
                                .addComponent(jButton_Xoa)
                                .addGap(15, 15, 15)
                                .addComponent(jButton_QuayLai))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_TenKhoanThuongTet)
                            .addComponent(jLabel_TenKT))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_MaSo)
                            .addComponent(jLabel_MaSo1))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Ten)
                            .addComponent(searchText_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_CCCD)
                            .addComponent(searchText_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_MaHo)
                            .addComponent(searchText_MaHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_TimKiem))
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_ChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_QuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_XuatFileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(37, Short.MAX_VALUE))
                );
            }// </editor-fold>//GEN-END:initComponents
        public void onRowSelected(int selectedRow) {
            int msKThg = (Integer) table_KhoanThuong.getValueAt(selectedRow, 0); // Giả sử cột 0 là cột chứa mã số
            loadDanhSachNhanThuong(msKThg);
        }

        private void jButton_ChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {
            JOptionPane.showMessageDialog(this, "Chỉnh sửa button clicked!");
        }
            // Hàm xử lý sự kiện nhập tên
            private void searchText_TenActionPerformed(java.awt.event.ActionEvent evt) {
                timKiemDanhSachThuongTet(searchText_Ten.getText().trim());
            }

            // Phương thức tìm kiếm thông tin thưởng Tết dựa trên từ khóa
            private void timKiemDanhSachThuongTet(String tuKhoa) {
                try {
                    Vector<Vector<Object>> data = quanLyThuongTetDAO.timKiemDanhSachThuongTet(tuKhoa);
                    DefaultTableModel model = (DefaultTableModel) table_ThongKe.getModel();
                    model.setRowCount(0); // Xóa dữ liệu cũ
                    for (Vector<Object> row : data) {
                        model.addRow(row); // Thêm dữ liệu mới
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm thông tin: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }



            private void timKiemDanhSachThuongTetTheoMaHo(String maHo) {
                try {
                    int maHoInt = Integer.parseInt(maHo); // Chuyển đổi mã hộ từ String sang Integer
                    Vector<Vector<Object>> data = quanLyThuongTetDAO.timKiemDanhSachThuongTetTheoMaHo(maHoInt);
                    DefaultTableModel model = (DefaultTableModel) table_ThongKe.getModel();
                    model.setRowCount(0); // Xóa dữ liệu cũ
                    for (Vector<Object> row : data) {
                        model.addRow(row); // Thêm dữ liệu mới
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Mã hộ phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm thông tin: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        private void searchText_CCCDActionPerformed(java.awt.event.ActionEvent evt) {
            timKiemDanhSachThuongTet(searchText_CCCD.getText().trim());
        }
        private void searchText_MaHoActionPerformed(java.awt.event.ActionEvent evt) {
            int maHoInt = Integer.parseInt(searchText_MaHo.getText().trim());

        }


        // Phương thức này được gọi khi người dùng nhấn nút tìm kiếm
        private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {
            String hoTen = searchText_Ten.getText().trim();
            String cccd = searchText_CCCD.getText().trim();
            String maHo = searchText_MaHo.getText().trim();
            int msKThg = this.msKThg;
            try {
                Vector<Vector<Object>> results = danhSachThuongTetDAO.searchDanhSachThuongTet(hoTen, cccd, maHo, msKThg);
                updateTableWithSearchResults(results);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error occurred during search: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }





        // Phương thức này cập nhật bảng với kết quả tìm kiếm




        private void loadDanhSachThuongTet() {
            if (danhSachThuongTetDAO != null) {
                try {
                    Vector<Vector<Object>> data = danhSachThuongTetDAO.layDanhSachThuongTetTheoMaKhoanThuong(msKThg);

                    Vector<String> columnNames = new Vector<>(Arrays.asList(
                            "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
                    ));

                    // Cập nhật model cho bảng
                    DefaultTableModel model = (DefaultTableModel) table_DanhSachChiTiet.getModel();
                    model.setDataVector(data, columnNames); // Sử dụng biến 'result' thay vì 'data'
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        private void setupTableSelectionListener() {
            table_KhoanThuong.getSelectionModel().addListSelectionListener(event -> {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table_KhoanThuong.getSelectedRow();
                    if (selectedRow != -1) {
                        int msKThg = (Integer) table_KhoanThuong.getValueAt(selectedRow, 0); // Lấy mã số từ cột đầu tiên của hàng được chọn
                        loadDanhSachNhanThuong(msKThg); // Gọi phương thức để hiển thị danh sách nhận thưởng
                    }
                }
            });
        }

        private void loadDanhSachNhanThuong(int msKThg) {
            try {
                Vector<Vector<Object>> data = danhSachThuongTetDAO.layDanhSachThuongTetTheoMaKhoanThuong(msKThg);
                Vector<String> columnNames = new Vector<>(Arrays.asList(
                        "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
                ));
                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                table_DanhSachChiTiet.setModel(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void updateTableWithSearchResults(Vector<Vector<Object>> data) {
            Vector<String> columnNames = new Vector<>(Arrays.asList(
                    "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
            ));
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table_DanhSachChiTiet.setModel(model);
        }



        private void themKhoanThuong(QuanLyThuongTetdata khoanThuong)
            {
                try {
                    quanLyThuongTetDAO.themKhoanThuong(khoanThuong);
                    JOptionPane.showMessageDialog(this, "Thêm khoản thưởng thành công!");
                    loadDanhSachThuongTet(); // Gọi phương thức để cập nhật bảng
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi thêm khoản thưởng: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
            private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
                Form_ThemDanhSachTet formThemDanhSachTet = new Form_ThemDanhSachTet();

            // Get the parent container (JFrame or another container)
            Container parentContainer = this.getParent();

            // Remove the current panel (Form_ThongTinHo) from the parent container
            parentContainer.remove(this);

            // Add the new panel (Form_ThongTinChiTiet) to the parent container
            parentContainer.add(formThemDanhSachTet);

            // Repaint the container to reflect the changes
            parentContainer.revalidate();
            parentContainer.repaint();
            }//GEN-LAST:event_jButton_ThemActionPerformed

            private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
                // TODO add your handling code here:
            }//GEN-LAST:event_jButton_XoaActionPerformed

            private void jButton_XuatFileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XuatFileExcelActionPerformed
                // TODO add your handling code here:
            }//GEN-LAST:event_jButton_XuatFileExcelActionPerformed

        private void jButton_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {
            Form_ThongKeThuongTet formThongKeThuongTet = new Form_ThongKeThuongTet();
            Container parentContainer = this.getParent();
            if (parentContainer != null) {
                parentContainer.remove(this);
                parentContainer.add(formThongKeThuongTet);
                parentContainer.revalidate();
                parentContainer.repaint();
            } else {
                // Log or handle the error that parent container is null
                System.err.println("Cannot switch panels because the parent container is null.");
            }
        }


        // Variables declaration - do not modify//GEN-BEGIN:variables
            private javax.swing.JTable table_ThongKe;
            private javax.swing.JButton jButton_ChinhSua;
            private javax.swing.JButton jButton_QuayLai;
            private javax.swing.JButton jButton_Them;
            private javax.swing.JButton jButton_ThongKe;
            private javax.swing.JButton jButton_TimKiem;
            private javax.swing.JButton jButton_Xoa;
            private javax.swing.JButton jButton_XuatFileExcel;
            private javax.swing.JLabel jLabel_CCCD;
            private javax.swing.JLabel jLabel_MaHo;
            private javax.swing.JLabel jLabel_MaSo;
            private javax.swing.JLabel jLabel_MaSo1;
            private javax.swing.JLabel jLabel_Ten;
            private javax.swing.JLabel jLabel_TenKT;
            private javax.swing.JLabel jLabel_TenKhoanThuongTet;
            private javax.swing.JScrollPane jScrollPane2;
            private com.raven.swing.SearchText searchText_CCCD;
            private com.raven.swing.SearchText searchText_MaHo;
            private com.raven.swing.SearchText searchText_Ten;
            private com.raven.swing.Table tableachChiTiet;
            // End of variables declaration//GEN-END:variables
        }
