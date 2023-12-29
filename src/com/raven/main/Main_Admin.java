/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;

import Model.NhanKhau.*;

import Model.ThuPhi.*;
import com.raven.event.EventHeader;
import com.raven.form.QuanLyNhanKhau.Form_TamTruTamVang;
import com.raven.form.QuanLyNhanKhau.Form_ThongKeNhanKhau;
import com.raven.form.QuanLyNhanKhau.Form_ThongTinHo;
import com.raven.form.QuanLyNhanKhau.Form_ThongTinNhanKhau;
import com.raven.form.QuanLyTaiKhoan.Form_QuanLyTaiKhoan;
import com.raven.form.QuanLyThuPhi.Form_ThuPhiChungCu;
import com.raven.form.QuanLyThuPhi.Form_ThuPhiDienNuoc;
import com.raven.form.QuanLyThuPhi.Form_ThuPhiGuiXe;
import com.raven.form.QuanLyThuPhi.Form_ThuPhiTheoDot;
import com.raven.form.QuanLyThuong.Form_QuanLyThuongHocTap;
import com.raven.form.QuanLyThuong.Form_QuanLyThuongTet;
import com.raven.swing.MenuEvent;
import java.awt.Component;

/**
 *
 * @author PC Giang
 */
public class Main_Admin extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main_Admin() {
        initComponents();
        Model_HoKhau model_nk= new Model_HoKhau();
        Model_ThuPhi model_tp = new Model_ThuPhi();
        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0 && subIndex == 1) {
                    showForm(new Form_ThongTinHo(model_nk));
                } 
                else if (index == 0 && subIndex == 2) {
                    showForm(new Form_ThongTinNhanKhau(model_nk));
                } 
                else if (index == 0 && subIndex == 3) {
                    showForm(new Form_TamTruTamVang());
                } 
                else if (index == 0 && subIndex == 4) {
                    showForm(new Form_ThongKeNhanKhau());
                } 
                else if (index == 1 && subIndex == 1) {
                    showForm(new Form_ThuPhiChungCu(model_tp));
                } 
                else if (index == 1 && subIndex == 2) {
                    showForm(new Form_ThuPhiTheoDot(model_tp));
                }
                else if (index == 1 && subIndex == 3) {
                    showForm(new Form_ThuPhiGuiXe(model_tp));
                } 
                else if (index == 1 && subIndex == 4) {
                    showForm(new Form_ThuPhiDienNuoc(model_tp));
                } 
                else if (index == 2 && subIndex == 1) {
                    showForm(new Form_QuanLyThuongTet());
                   
                } 
                else if (index == 2 && subIndex == 2) {
                    showForm(new Form_QuanLyThuongHocTap());
                } 
                else {
                    System.out.println("Form : " + index + " " + subIndex);
                }
            }
        });
        EventHeader eventHeader = new EventHeader() {
            @Override
            public void selected(int index) {
                 if(index == 0){
                    showForm(new Form_ThongTinHo(model_nk));
                }
                 else if(index == 1){
                    showForm(new Form_QuanLyTaiKhoan());
                }

            }
        };
        header1.init(eventHeader);
        showForm(new Form_ThongTinHo(model_nk));
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        body = new javax.swing.JPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        menu1 = new com.raven.swing.Menu();
        header1 = new com.raven.component.Header_QuanLyTaiKhoan();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roundPanel1.setBackground(new java.awt.Color(245, 245, 245));

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private com.raven.component.Header_QuanLyTaiKhoan header1;
    private com.raven.swing.Menu menu1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
