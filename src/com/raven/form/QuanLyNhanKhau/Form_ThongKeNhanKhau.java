/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyNhanKhau;
import com.raven.model.NhanKhauDAO;
import com.raven.model.NhanKhau;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

public class Form_ThongKeNhanKhau extends javax.swing.JPanel {

    /**
     * Creates new form Form_ThongKeNhanKhau
     */
    public Form_ThongKeNhanKhau() {
        initComponents();
        setOpaque(false);
        init();
    }
    private void init() {
        // Create an instance of NhanKhauDAO
        NhanKhauDAO dao = new NhanKhauDAO();
        try {
            Map<String, Map<String, Integer>> stats = dao.getStatisticsByAgeAndGender();

            chart2.addLegend("Nam", new Color(5, 125, 0), new Color(95, 209, 69)); // Green shades for male
            chart2.addLegend("Nữ", new Color(186, 37, 37), new Color(241, 100, 120)); // Red shades for female
       for (String ageGroup : stats.keySet()) {
                Map<String, Integer> genderCounts = stats.get(ageGroup);
                double maleCount = genderCounts.getOrDefault("Nam", 0);
                double femaleCount = genderCounts.getOrDefault("Nữ", 0);
                chart2.addData(new ModelChart(ageGroup, new double[]{maleCount, femaleCount}));
            }
            chart2.start();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        chart2 = new com.raven.chart.Chart();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Thống kê nhân khẩu theo độ tuổi và giới tính ", jPanel2);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.Chart chart2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
