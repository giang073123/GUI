/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.form.QuanLyNhanKhau;
import Model.NhanKhau.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class test {
     public static void main(String args[]) {
         Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc muốn lưu sinh viên này",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(choosen == JOptionPane.YES_OPTION){
                    System.out.println(choosen);
                }else if (choosen == JOptionPane.NO_OPTION){
                     System.out.println(choosen);
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                      System.out.println(choosen);
                }else {
                    return;
                }

    }
}
