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
    import javax.swing.JFileChooser;
    import javax.swing.filechooser.FileNameExtensionFilter;
    import java.io.File;
    import java.io.IOException;
    public class Form_DanhSachThuongTet extends javax.swing.JPanel {

        private DanhSachThuongTetDAO danhSachThuongTetDAO;
        private QuanLyThuongTetDAO quanLyThuongTetDAO;
        private com.raven.swing.Table table_DanhSachChiTiet;
        private javax.swing.JTable table_KhoanThuong;
        private Vector<String> columnNames;
        private Integer ms_kthg;
        private String tenKthg;
        private Form_QuanLyThuongTet formQuanLyThuongTetParent;

        public Form_DanhSachThuongTet() {
            initComponents();
            danhSachThuongTetDAO = new DanhSachThuongTetDAO();
            quanLyThuongTetDAO = new QuanLyThuongTetDAO();
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
        public Form_DanhSachThuongTet(Integer ms_kthg, String tenKthg) {
            this.ms_kthg = ms_kthg;
            this.tenKthg = tenKthg;
            initComponents();
            danhSachThuongTetDAO = new DanhSachThuongTetDAO(); // Initialize the DAO here
            loadDanhSachThuongTet(ms_kthg);
            jLabel_MaSo1.setText(ms_kthg.toString());
            jLabel_TenKT.setText(tenKthg);
            jButton_QuayLai.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_QuayLaiActionPerformed(evt);
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
            int selectedRow = table_DanhSachChiTiet.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để chỉnh sửa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Assuming the second column is the CCCD and the first column is MS_KThg
            String cccd = table_DanhSachChiTiet.getValueAt(selectedRow, 1).toString();
            int msKThg = ms_kthg;

            // Prompt user to enter new status
            String[] options = {"Đã hoàn thành", "Chưa hoàn thành"};
            int response = JOptionPane.showOptionDialog(this, "Chọn trạng thái phát thưởng:", "Chỉnh sửa Trạng thái",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (response != -1) {
                String newStatus = options[response];
                java.sql.Date newDate = (response == 0) ? new java.sql.Date(System.currentTimeMillis()) : null;

                try {
                    // Make sure danhSachThuongTetDAO is an instance variable of the class
                    danhSachThuongTetDAO.updateBonusStatus(cccd, msKThg, newStatus, newDate);
                    JOptionPane.showMessageDialog(this, "Trạng thái phát thưởng đã được cập nhật.");

                    // Optionally, refresh the data in the table to show updated status
                    loadDanhSachThuongTet(msKThg);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật trạng thái: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
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
            // Retrieve text from search fields
            String hoTen = searchText_Ten.getText().trim();
            String cccd = searchText_CCCD.getText().trim();
            String maHo = searchText_MaHo.getText().trim();

            // Perform the search and update the table with the results
            try {
                // Make sure ms_kthg is initialized and holds the correct value
                int msKThg = this.ms_kthg != null ? this.ms_kthg : -1;
                if (msKThg == -1) {
                    JOptionPane.showMessageDialog(this, "Mã số khoản thưởng không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Use the DAO to search with the provided parameters
                Vector<Vector<Object>> results = danhSachThuongTetDAO.searchDanhSachThuongTet(hoTen, cccd, maHo, msKThg);
                updateTableWithSearchResults(results);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Lỗi xảy ra trong quá trình tìm kiếm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }






        // Phương thức này cập nhật bảng với kết quả tìm kiếm




        private void loadDanhSachThuongTet(int ms_kthg) {
                try {
                    Vector<Vector<Object>> data = danhSachThuongTetDAO.layDanhSachThuongTetTheoMaKhoanThuong(ms_kthg);

                    Vector<String> columnNames = new Vector<>(Arrays.asList(
                            "Họ và tên", "CCCD", "Mã hộ", "Ngày sinh", "Giá trị phần quà", "Trạng thái phát thưởng", "Ngày thưởng"
                    ));

                    DefaultTableModel model = (DefaultTableModel) table_DanhSachChiTiet.getModel();
                    model.setDataVector(data, columnNames);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
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
            DefaultTableModel model = (DefaultTableModel) table_DanhSachChiTiet.getModel();
            model.setDataVector(data, columnNames);
        }



        private void themKhoanThuong(QuanLyThuongTetdata khoanThuong)
            {
                try {
                    quanLyThuongTetDAO.themKhoanThuong(khoanThuong);
                    JOptionPane.showMessageDialog(this, "Thêm khoản thưởng thành công!");
                    loadDanhSachThuongTet(ms_kthg); // Gọi phương thức để cập nhật bảng
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi thêm khoản thưởng: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {
            Form_ThemDanhSachTet formThemDanhSachTet = new Form_ThemDanhSachTet(ms_kthg, tenKthg);

            Container parentContainer = this.getParent();
            if (parentContainer != null) {
                parentContainer.remove(this);
                parentContainer.add(formThemDanhSachTet);
                parentContainer.revalidate();
                parentContainer.repaint();
            } else {
                System.err.println("parentContainer is null. Unable to switch panels.");
            }
        }

        private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {
            // Lấy hàng được chọn
            int selectedRow = table_DanhSachChiTiet.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Lấy CCCD và ms_kthg từ hàng được chọn
            String CCCD = table_DanhSachChiTiet.getValueAt(selectedRow, 1).toString(); // Giả sử CCCD nằm ở cột index 1
            int msKThg = this.ms_kthg; // Giả sử ms_kthg đã được lưu trữ trong class này

            // Xác nhận trước khi xóa
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bản ghi này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Thực hiện xóa
                    danhSachThuongTetDAO.xoaDanhSachThuongTet(msKThg, CCCD);
                    // Cập nhật lại bảng
                    loadDanhSachThuongTet(ms_kthg);
                    JOptionPane.showMessageDialog(this, "Đã xóa thành công bản ghi.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi xóa bản ghi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


        private void jButton_XuatFileExcelActionPerformed(java.awt.event.ActionEvent evt) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx"; // Append the file extension if not present
                }

                try {
                    // Assuming `table_DanhSachChiTiet.getModel()` returns the DefaultTableModel of your table
                    DefaultTableModel model = (DefaultTableModel) table_DanhSachChiTiet.getModel();
                    danhSachThuongTetDAO.exportTable(model, filePath);
                    JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Lỗi xuất file: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        private void jButton_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {
            // Ensure ms_kthg and tenKthg are initialized and hold the correct values
            if (this.ms_kthg != null && this.tenKthg != null) {
                Form_ThongKeThuongTet formThongKeThuongTet = new Form_ThongKeThuongTet(this.ms_kthg, this.tenKthg);
                Container parentContainer = this.getParent();
                if (parentContainer != null) {
                    parentContainer.remove(this);
                    parentContainer.add(formThongKeThuongTet);
                    parentContainer.revalidate();
                    parentContainer.repaint();
                } else {
                    System.err.println("Cannot switch panels because the parent container is null.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mã số khoản thưởng hoặc tên khoản thưởng không có sẵn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
