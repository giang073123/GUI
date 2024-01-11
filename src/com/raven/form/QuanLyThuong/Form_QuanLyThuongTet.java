
package com.raven.form.QuanLyThuong;

import com.raven.form.QuanLyThuong.Form_LichSuDanhSachThuongTet;
import com.raven.form.QuanLyThuong.Form_ThemKhoanThuongTet;
import com.raven.form.QuanLyThuong.Form_DanhSachThuongTet;
import com.raven.model.QuanLyThuongTetdata;
import com.raven.model.QuanLyThuongTetDAO;
import java.awt.Container;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.sql.SQLException;
import com.raven.model.QuanLyThuongTetDAO;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author PC Giang
 */
public class Form_QuanLyThuongTet extends javax.swing.JPanel {

    /**
     * Creates new form Form_QuanLyThuongTet
     */
    public Form_QuanLyThuongTet() {
        initComponents();
        loadKhoanThuongData();
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
    public void loadKhoanThuongData() {
        QuanLyThuongTetDAO dao = new QuanLyThuongTetDAO();
        try {
            Vector<Vector<Object>> data = dao.layTatCaKhoanThuong();
            DefaultTableModel model = (DefaultTableModel) table_DanhSachKhoanThuong.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ
            for (Vector<Object> row : data) {
                model.addRow(row); // Thêm dữ liệu mới
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi
        }
    }
    public void loadEndedAwards() {
        QuanLyThuongTetDAO dao = new QuanLyThuongTetDAO();
        try {
            Vector<Vector<Object>> endedAwards = dao.layKhoanThuongDaKetThuc(); // Sử dụng phương thức này để lấy dữ liệu
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            for (Vector<Object> award : endedAwards) {
                model.addRow(award); // Thêm dữ liệu mới vào bảng
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu: " + ex.getMessage());
        }
    }


    public void showPanel(javax.swing.JPanel panelToShow) {
        // Add the specified panel to the parent container
        Container parentContainer = this.getParent();
        parentContainer.remove(this);
        parentContainer.add(panelToShow);
        parentContainer.revalidate();
        parentContainer.repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
                        "Mã số", "Tên", "Giá trị phần quà", "Ngày tạo", "Ngày kết thúc", "Tổng thưởng", "Ghi chú"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jLabel_DanhSach.setText("Danh sách các khoản thưởng Tết");

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

        jTabbedPane1.addTab("Khoản thưởng lễ Tết", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(855, 683));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Mã số", "Tên", "Giá trị phần quà", "Ngày tạo", "Ngày kết thúc", "Tổng thưởng", "Ghi chú"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jLabel_TieuDe.setText("Danh sách lịch sử các khoản thưởng tết");

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

        jTabbedPane1.addTab("Lịch sử thưởng lễ Tết", jPanel2);

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
    }// </editor-fold>

    private void jButton_XemChiTiet1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Lấy chỉ số dòng được chọn
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            // Lấy dữ liệu từ dòng được chọn
            Integer msKThg = (Integer) table.getValueAt(selectedRow, 0); // Mã số khoản thưởng
            String tenKThg = (String) table.getValueAt(selectedRow, 1); // Tên khoản thưởng

            // Tạo đối tượng Form_LichSuDanhSachThuongTet với dữ liệu đã lấy
            Form_LichSuDanhSachThuongTet formLichSu = new Form_LichSuDanhSachThuongTet(msKThg, tenKThg);

            // Hiển thị form mới
            showPanel(formLichSu);
        } else {
            // Hiển thị thông báo nếu không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng từ bảng.");
        }
    }



    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Sử dụng jDateChooser1 để lấy ngày bắt đầu
        java.util.Date startDate = jDateChooser1.getDate();

        // Đặt ngày kết thúc bằng ngày bắt đầu để tìm khoản thưởng trong ngày đó
        java.util.Date endDate = startDate;

        if (startDate == null) {
            // Hiển thị thông báo nếu ngày bắt đầu chưa được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày.");
            return;
        }

        try {
            // Chuyển đổi từ java.util.Date sang java.sql.Date
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

            QuanLyThuongTetDAO dao = new QuanLyThuongTetDAO();
            List<QuanLyThuongTetdata> awards = dao.searchLetetAwardsByDate(sqlStartDate, sqlEndDate);

            // Cập nhật dữ liệu vào bảng
            updateAwardsTable(awards);
        } catch (SQLException e) {
            e.printStackTrace();
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }
    private void updateAwardsTable(List<QuanLyThuongTetdata> awards) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (QuanLyThuongTetdata award : awards) {
            Vector<Object> row = new Vector<>();
            row.add(award.getMsKThg()); // Mã số
            row.add(award.getTenKhoanThuong()); // Tên khoản thưởng
            row.add(award.getGiaTriPhanQua()); // Giá trị phần quà
            row.add(award.getNgayTao()); // Ngày tạo
            row.add(award.getNgayKetThuc()); // Ngày kết thúc
            row.add(award.getTongThuong()); // Tổng thưởng
            row.add(award.getGhiChu()); // Ghi chú
            model.addRow(row);
        }
    }


    private void jButton_ThemKhoanThuongActionPerformed(java.awt.event.ActionEvent evt) {
        Form_ThemKhoanThuongTet formThemKhoanThuongTet = new Form_ThemKhoanThuongTet();
        Container parentContainer = this.getParent();
        if (parentContainer != null) {
            parentContainer.remove(this);
            parentContainer.add(formThemKhoanThuongTet);
            parentContainer.revalidate();
            parentContainer.repaint();
        } else {
            System.out.println("parentContainer is null. Unable to switch panels.");
        }
    }


    private int selectedMsKThg; // Biến để lưu trữ mã số khoản thưởng được chọn

    private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table_DanhSachKhoanThuong.getSelectedRow(); // Use 'table' instead of 'table_DanhSach'
        if (selectedRow >= 0) {
            Integer msKthg = Integer.valueOf(table_DanhSachKhoanThuong.getModel().getValueAt(selectedRow, 0).toString());
            String tenKthg = table_DanhSachKhoanThuong.getModel().getValueAt(selectedRow, 1).toString();

            Form_DanhSachThuongTet formDanhSachThuongTet = new Form_DanhSachThuongTet(msKthg, tenKthg);

            Container parentContainer = this.getParent();
            parentContainer.remove(this);
            parentContainer.add(formDanhSachThuongTet);
            parentContainer.revalidate();
            parentContainer.repaint();
        }
    }


    private void openDetailScreen(Form_DanhSachThuongTet form) {
        Container parentContainer = this.getParent();
        if (parentContainer != null) {
            parentContainer.remove(this);
            parentContainer.add(form);
            parentContainer.revalidate();
            parentContainer.repaint();
        }
    }



    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {
        // Lấy chỉ số hàng được chọn trong bảng
        int selectedRow = table_DanhSachKhoanThuong.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if (selectedRow != -1) {
            // Lấy giá trị của cột "Mã số" (MS_KThg) từ hàng được chọn
            int msKThg = (int) table_DanhSachKhoanThuong.getValueAt(selectedRow, 0);

            // Thực hiện xóa khoản thưởng từ CSDL
            QuanLyThuongTetDAO dao = new QuanLyThuongTetDAO();
            try {
                dao.xoaKhoanThuong(msKThg);
                System.out.println("Xóa khoản thưởng thành công!");

                // Sau khi xóa, cập nhật lại dữ liệu trong bảng
                loadKhoanThuongData();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Lỗi khi xóa khoản thưởng: " + ex.getMessage());
            }
        } else {
            System.out.println("Vui lòng chọn một khoản thưởng để xóa.");
        }
    }


    private void jButton_KetThucActionPerformed(java.awt.event.ActionEvent evt) {
        // Lấy chỉ số hàng được chọn trong bảng
        int selectedRow = table_DanhSachKhoanThuong.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if (selectedRow != -1) {
            // Lấy giá trị của cột "Mã số" (MS_KThg) từ hàng được chọn
            int msKThg = (int) table_DanhSachKhoanThuong.getValueAt(selectedRow, 0);

            // Thực hiện kết thúc khoản thưởng từ CSDL
            QuanLyThuongTetDAO dao = new QuanLyThuongTetDAO();
            try {
                dao.ketThucKhoanThuong(msKThg);
                System.out.println("Kết thúc khoản thưởng thành công!");

                // Sau khi kết thúc, cập nhật lại dữ liệu trong bảng
                loadKhoanThuongData();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Lỗi khi kết thúc khoản thưởng: " + ex.getMessage());
            }
        } else {
            System.out.println("Vui lòng chọn một khoản thưởng để kết thúc.");
        }
    }



    // Variables declaration - do not modify
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
    // End of variables declaration
}