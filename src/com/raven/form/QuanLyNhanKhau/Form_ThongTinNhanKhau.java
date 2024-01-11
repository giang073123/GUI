/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyNhanKhau;

import Model.NhanKhau.*;
import com.raven.form.QuanLyNhanKhau.Form_ChiTietNhanKhau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author PC Giang
 */
public class Form_ThongTinNhanKhau extends javax.swing.JPanel {

    Model_NhanKhau myModel;
    ArrayList<nhan_khau> myList = new ArrayList<>();
    int cnt;

    /**
     * Creates new form Form_ThongTinNhanKhau
     */
    public Form_ThongTinNhanKhau(Model_NhanKhau model) {
        initComponents();
        myModel = model;
        updateMyList();
        updateTable(myList);
        
        cnt = myModel.count_nk();
        jLabel6.setText(Integer.toString(cnt));
        // Link the jButton2ActionPerformed method to the "Xem chi tiết" button
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
    }

    private void updateMyList() {
        myList = myModel.nhan_khau_getds();
        
    }

    private ArrayList<nhan_khau> updateSearchList() {
        ArrayList<nhan_khau> searchList = new ArrayList<>();
        for (nhan_khau nk : myList) {
            searchList.add(nk.clone_());
        }

        if (miniSearch1.getText().length() > 0) {

            int maho = Integer.parseInt(miniSearch1.getText());

            Iterator<nhan_khau> it = searchList.iterator();
            while (it.hasNext()) {
                nhan_khau f = it.next();
                if (f.getMa_Ho() != maho) {
                    it.remove();
                }

            }
        }

        if (miniSearch2.getText().length() > 0) {
            String hoten = miniSearch2.getText();

            Iterator<nhan_khau> it = searchList.iterator();
            while (it.hasNext()) {
                nhan_khau f = it.next();
                if (f.getHo_ten().compareTo(hoten) != 0) {
                    it.remove();
                }
            }
        }

        if (miniSearch3.getText().length() > 0) {
            String CCCD = miniSearch3.getText();

            Iterator<nhan_khau> it = searchList.iterator();
            while (it.hasNext()) {
                nhan_khau f = it.next();
                if (f.getCCCD().compareTo(CCCD) != 0) {
                    it.remove();
                }
            }
        }

        return searchList;

    }

    private void updateTable(ArrayList<nhan_khau> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (nhan_khau nk : list) {
            //nhan_khau chuho = myModel.nhan_khau_get(f.getCCCD_Chuho());
            table.addRow(new Object[]{nk.getMa_Ho(), nk.getHo_ten(), nk.getCCCD()});
        }
    }

    //  TÌM KIẾM NHÂN KHẨU
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        updateTable(updateSearchList());
    }//GEN-LAST:event_jButton1ActionPerformed

    // THÊM NHÂN KHẨU MỚI
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Create an instance of Form_ThongTinChiTiet
        Form_NhanKhauMoi formNhanKhauMoi = new Form_NhanKhauMoi(myModel);

        // Get the parent container (JFrame or another container)
        Container parentContainer = this.getParent();

        // Remove the current panel (Form_ThongTinHo) from the parent container
        parentContainer.remove(this);

        // Add the new panel (Form_ThongTinChiTiet) to the parent container
        parentContainer.add(formNhanKhauMoi);

        // Repaint the container to reflect the changes
        parentContainer.revalidate();
        parentContainer.repaint();
    }
//-------------------------------------------------------------------------------------------------

    // XEM CHI TIẾT
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Create an instance of Form_ThongTinChiTiet
        if (table.getSelectedRow() < 0) {
            return;
        } else {
            int i = table.getSelectedRow();
            // JOptionPane.showMessageDialog(null,i+myList.get(i).getHo_ten());
            nhan_khau nk = myModel.nhan_khau_get(table.getValueAt(i, 2).toString());
            Form_ChiTietNhanKhau formChiTietNhanKhau = new Form_ChiTietNhanKhau(myModel, nk);

            // Get the parent container (JFrame or another container)
            Container parentContainer = this.getParent();

            // Remove the current panel (Form_ThongTinHo) from the parent container
            parentContainer.remove(this);

            // Add the new panel (Form_ThongTinChiTiet) to the parent container
            parentContainer.add(formChiTietNhanKhau);

            // Repaint the container to reflect the changes
            parentContainer.revalidate();
            parentContainer.repaint();
        }
    }

    //XÓA NHÂN KHẨU
    private void jButton4ActionPerformed(ActionEvent evt) {
        if (table.getSelectedRow() < 0) {
            return;
        }

        Object[] options = {"Xác nhận", "Hủy"};
        int choosen = JOptionPane.showOptionDialog(null,
                "Bạn có chắc chắn muốn xóa nhân khẩu này",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choosen == JOptionPane.YES_OPTION) {

            int i = table.getSelectedRow();
           // JOptionPane.showMessageDialog(null, myList.get(i).getCCCD());

            nhan_khau nk = myModel.nhan_khau_get(table.getValueAt(i, 2).toString());
            myModel.nhan_khau_delete(nk);
            //myList.remove();
            updateMyList();
            updateTable(myList);
            cnt--;
            jLabel6.setText(Integer.toString(cnt));
            JOptionPane.showMessageDialog(null, "Đã xóa nhân khẩu");
            return;
        } else if (choosen == JOptionPane.NO_OPTION) {
            return;
        } else if (choosen == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            return;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        miniSearch1 = new com.raven.component.MiniSearch();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        miniSearch2 = new com.raven.component.MiniSearch();
        miniSearch3 = new com.raven.component.MiniSearch();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        roundPanel2.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách nhân khẩu");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ khẩu", "Họ và tên", "CMT/CCCD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã hộ khẩu ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Họ tên ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CCCD");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton2.setText("Xem chi tiết");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton3.setText("Thêm nhân khẩu");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton4.setText("Xóa nhân khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tổng số nhân khẩu trên địa bàn:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(25, 25, 25)
                .addComponent(jButton3)
                .addGap(25, 25, 25)
                .addComponent(jButton2)
                .addGap(33, 33, 33))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(miniSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(miniSearch2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(miniSearch3, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addComponent(jButton1))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel6)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miniSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miniSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miniSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.component.MiniSearch miniSearch1;
    private com.raven.component.MiniSearch miniSearch2;
    private com.raven.component.MiniSearch miniSearch3;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
