/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.event.EventHeader;
import com.raven.event.EventHeader;
import com.raven.swing.ButtonMenu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class Header extends javax.swing.JPanel {
    private EventHeader event; 
    public Header() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(51, 51, 51));
        
//        setLayout(new MigLayout("inset 0","[fill,  70]","[fill, 40]"));
    setLayout(new MigLayout("inset 0", "[fill, 70][grow, right]", "[fill, 40]"));

    }
    public void init(EventHeader event){
        this.event = event;
        addMenu("Quản lý nhân khẩu", 0);
        addMenu("Quản lý tài khoản",1);
            add(buttonBadges1, "cell 1 0");
    add(buttonBadges2, "cell 1 0");

        
    }


    public void addMenu(String name, int index){
        ButtonMenu menu = new ButtonMenu();
        menu.setEffectColor(new Color(173,209,255));
        menu.setForeground(new Color(219,219,219));
        menu.setText(name);
//        panelHeaderMenu.add(menu);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.selected(index);
            }
        });
        add(menu, "cell 0 0");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBadges1 = new com.raven.swing.ButtonBadges();
        buttonBadges2 = new com.raven.swing.ButtonBadges();

        buttonBadges1.setBackground(new java.awt.Color(25, 25, 25));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/noti.png"))); // NOI18N
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        buttonBadges2.setBackground(new java.awt.Color(25, 25, 25));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Avatar.png"))); // NOI18N
        buttonBadges2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(801, Short.MAX_VALUE)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(852, Short.MAX_VALUE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonBadges1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBadges1ActionPerformed

    private void buttonBadges2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBadges2ActionPerformed
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        area.add(new Area(new Rectangle2D.Double(0, 20, getWidth(), getHeight())));
        g2.fill(area);
        g2.dispose();
        super.paint(g); 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ButtonBadges buttonBadges1;
    private com.raven.swing.ButtonBadges buttonBadges2;
    // End of variables declaration//GEN-END:variables
}
