    package com.raven.form.QuanLyThuong;

    import com.raven.form.QuanLyThuong.Form_DanhSachThuongTet;
    import com.raven.form.QuanLyThuong.Form_QuanLyThuongTet;
    import com.raven.model.QuanLyThuongTetDAO;
    import javax.swing.JOptionPane; // Add this line
    import java.awt.Container;
    import java.util.Vector;
    import javax.swing.table.DefaultTableModel;
    import java.sql.SQLException;
    import javax.swing.JPanel;
    import javax.swing.event.ChangeEvent;
    import javax.swing.event.ChangeListener;
    import javax.swing.JTabbedPane;
    import javax.swing.*;
    import java.awt.*;

    /**
     *
     * @author dangk
     */
    public class Form_LichSuDanhSachThuongTet extends JPanel {
        private String[] columnNames = {"Mã số", "Tên", "Giá trị phần quà", "Ngày tạo", "Ngày kết thúc", "Tổng thưởng", "Ghi chú"};
        private JTabbedPane jTabbedPane1; // This should be initialized where your tabs are created
        private DefaultTableModel model;
        private JTable table_LichSuThuongLeTet;

        // Constructor
        public Form_LichSuDanhSachThuongTet(JTabbedPane tabbedPane) {
            this.jTabbedPane1 = tabbedPane; // Initialized via constructor
            initComponents();
            setupChangeListener();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    loadLichSuKhoanThuongDaKetThuc();
                }
            });
        }
        private void setupChangeListener() {
            jTabbedPane1.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent evt) {
                    if (jTabbedPane1.getSelectedIndex() == tabIndexForLichSuThuongLeTet) {
                        loadLichSuKhoanThuongDaKetThuc();
                    }
                }
            });
        }

        private static final int tabIndexForLichSuThuongLeTet = 1;
        private void searchText_TenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_TenActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_searchText_TenActionPerformed

        private void searchText_CCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_CCCDActionPerformed
            // TODO add your handling code here:
        }

        private void searchText_MaHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText_MaHoActionPerformed
            // TODO add your handling code here:
        }
        private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {
        }

        private void loadLichSuKhoanThuongDaKetThuc() {
            QuanLyThuongTetDAO dao = new QuanLyThuongTetDAO();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Vector<Vector<Object>> data = dao.layKhoanThuongDaKetThuc();
                        model.setRowCount(0); // Clear the existing data
                        for (Vector<Object> row : data) {
                            model.addRow(row); // Add new data row by row
                        }
                        // Assuming that 'model' is already set as the model for 'table_LichSuThuongLeTet'
                        table_LichSuThuongLeTet.repaint();
                        table_LichSuThuongLeTet.revalidate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(Form_LichSuDanhSachThuongTet.this, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }



        public void showPanel(JPanel panelToShow) {
            Container parentContainer = this.getParent();
            if (panelToShow instanceof Form_LichSuDanhSachThuongTet) {
                ((Form_LichSuDanhSachThuongTet) panelToShow).loadLichSuKhoanThuongDaKetThuc();
            }

        }
        private void initComponents() {
            this.model = new DefaultTableModel(columnNames, 0);
            this.table_LichSuThuongLeTet.setModel(model);
            JScrollPane scrollPane = new JScrollPane(table_LichSuThuongLeTet);
            add(scrollPane);
            JScrollPane jScrollPane2 = new JScrollPane(table_LichSuThuongLeTet);
            JLabel jLabel_Ten = new JLabel();
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

            // ... (initialize other components)

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    // ... (layout settings)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    // ... (layout settings)
            );
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
