/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Phiguixe;

import Model.ThuPhi.Model_ThuPhi;
import Model.ThuPhi.*;
import com.raven.form.QuanLyThuPhi.Phiguixe.Form_TaoKhoanThuGuiXe;
import com.raven.form.QuanLyThuPhi.Phiguixe.Form_DanhSachPhiGuiXe;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiGuiXe extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    
    khoan_thu_guixe myKT;
    ArrayList<thu_tien_guixe> myList = new ArrayList<>();
    ArrayList<khoan_thu_guixe> history = new ArrayList<>();
    ArrayList<dang_ky_xe> dangky = new ArrayList<>();
    /**
     * Creates new form Form_ThuPhiTuNguyen
     */
    public Form_ThuPhiGuiXe(Model_ThuPhi tp) {
        initComponents();
        table1.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String[]{"Đã thu", "Chưa thu"})));
        
        myModel=tp;
        
        getdata();  // get data for mylist

        updateTable1(myList);
        checkRowCount();
        updateInfo();
        
        getHistory();
        updateTable5();
        
        getDKxe();
        updateTable3();
        
        
        
        
        jButton_TaoKT2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_TaoKT2ActionPerformed(evt);
        }
    });
        
        
        
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_XemChiTietActionPerformed(evt);
        }
    });
        
        // TÌM KIẾM HỘ TRONG TRANG KHOẢN THU HIỆN TẠI
        jButton_TimKiem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if (searchText3.getText().length() < 1) {
//                    if (table1.getRowCount() > 1) {
//                    } else {
//                       // updateTable1(myList);   // Reset lại bảng, nhưng hiện tại dùng getViewport thì không cần lắm
//                    }
                } else {
                    int i = 0;
                    for (thu_tien_guixe t : myList) {
                        if (t.getMa_Ho() == Integer.parseInt(searchText3.getText())) {
                            Rectangle rect = table1.getCellRect(i, 0, true);
                            jScrollPane1.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
                }
            }
        });
        
        // XÓA KHOẢN THU Ở TRANG KHOẢN THU HIỆN TẠI
        jButton_XoaKT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                  Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc chắn muốn xóa khoản thu này",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(choosen == JOptionPane.YES_OPTION){
                      myModel.khoan_thu_Xoa(myKT.getTable_name(), myKT.getMS_KThu());                    
                      DefaultTableModel model = (DefaultTableModel)table1.getModel();
                      JOptionPane.showMessageDialog(null,"Đã xóa khoản thu");
                      model.setRowCount(0);
                      checkRowCount();
                    
                      
                      return;
                }else if (choosen == JOptionPane.NO_OPTION){
                      return;
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                      return;
                }else {
                    return;
                }
                
            }
        });
        
        
        // TÌM KIẾM KHOẢN THU TRONG LỊCH SỬ
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jDateChooser1.getDate()!=null){
               Date choosen_Date = jDateChooser1.getDate();
                int i = 0;
                    for (khoan_thu_guixe kt : history) {
                        if (kt.getNgaytao_KThu().getMonth() == choosen_Date.getMonth() ) {
                            Rectangle rect = table5.getCellRect(i, 0, true);
                            jScrollPane5.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
               
                }
            }
        });
        
        
         // TABLE1 MODEL LISTENER -> Danh sách thu tiền hiện tại
        table1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int idx = e.getFirstRow();
                
                
                if(e.getColumn()==5)    {           // THAY ĐỔI TRẠNG THÁI  
                if(table1.getRowCount()==0) return;
                
                 if (table1.getModel().getValueAt(idx, 5).toString().compareTo("Đã thu") == 0 && table1.getModel().getValueAt(idx, 6)!=null){ return;}
                 else if(table1.getModel().getValueAt(idx, 5).toString().compareTo("Chưa thu") == 0 && table1.getModel().getValueAt(idx, 6)==null){ return; }
                 
                 else if (table1.getModel().getValueAt(idx, 5).toString().compareTo("Đã thu") == 0 && table1.getModel().getValueAt(idx, 6)==null ) { 
                    myList.get(idx).setTrangthai_Thu(table1.getModel().getValueAt(idx, 5).toString());
                    myList.get(idx).setNgay_thu(java.sql.Date.valueOf(LocalDate.now()));
                    
                    
                    myModel.thu_tien_CapNhat(myList.get(idx),"Đã thu");
                    table1.getModel().setValueAt(myList.get(idx).getNgay_thu(),idx,6); 
                 } 
                else if(table1.getModel().getValueAt(idx, 5).toString().compareTo("Chưa thu") == 0 && table1.getModel().getValueAt(idx, 6)!=null){
                     table1.getModel().setValueAt("Đã thu",idx,5);
                     JOptionPane.showMessageDialog(null,"Đã thu, không thể sửa đổi");  // Đã thu rồi thì không sửa được
                    return; }
            } 
                
                else if(e.getColumn()==1 || e.getColumn()==2 || e.getColumn()==3 ){         // THAY ĐỔI Số lượng xe
                    
                    
                   if(table1.getRowCount()==0 ) return;
                    JOptionPane.showMessageDialog(null,"Thay đổi số lượng xe"); 
                   // Chỉnh sửa các thông tin
                   int so_xedap = (int) table1.getModel().getValueAt(idx, 1);
                   int so_xemay = (int) table1.getModel().getValueAt(idx, 2);
                   int so_xeoto = (int) table1.getModel().getValueAt(idx, 3);
                   myList.get(idx).setSo_luong_xedap(so_xedap); myList.get(idx).setSo_luong_xemay(so_xemay); myList.get(idx).setSo_luong_oto(so_xeoto);
                   int sotien = (int)  so_xedap*myKT.getPhi_xe_dap() 
                                     + so_xemay*myKT.getPhi_xe_may()
                                     + so_xeoto*myKT.getPhi_xe_oto();
                   
                   myList.get(idx).setSo_tien(sotien);
                   myList.get(idx).setNgay_thu(null);
                   myList.get(idx).setTrangthai_Thu("Chưa thu");
                   
                   myModel.thu_tien_CapNhat(myList.get(idx), "Chưa thu");
                   
                   table1.getModel().setValueAt(null,idx,6);  // Set null cho ngày thu trước số tiền
                   table1.getModel().setValueAt(sotien,idx,4);  
                   table1.getModel().setValueAt("Chưa thu",idx,5);      
                       
                    
                   
                   
                }
                
                myKT= (khoan_thu_guixe) myModel.khoan_thu_Get(new khoan_thu_guixe(), myKT.getMS_KThu());
                jLabel6.setText(Integer.toString(myKT.getTong_thu()));
            }
         });        
        
        
        // TABLE3 MODEL LISTENER  -> Cập nhật đăng ký xe
        
        table3.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int idx = e.getFirstRow();
                
                dang_ky_xe dk = new dang_ky_xe();                       
                dk.setMa_Ho((int)table3.getModel().getValueAt(idx, 0));
                dk.setSo_luong_xedap((int)table3.getModel().getValueAt(idx, 1));
                dk.setSo_luong_xemay((int)table3.getModel().getValueAt(idx, 2));
                dk.setSo_luong_oto((int)table3.getModel().getValueAt(idx, 3));
                
            myModel.dang_ky_xe_update(dk);
             JOptionPane.showMessageDialog(null,"Đã cập nhật"); 
            } 
        
        });
        
        
    }
    
    // CÁC METHOD CỦA TRANG KHOẢN THU HIỆN TẠI
    private void getdata(){
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_guixe(),"Chưa kết thúc");
        if (tmplist.size()==0) return;
        ArrayList<thu_tien> list =myModel.thu_tien_Danhsach(new thu_tien_guixe(),tmplist.get(0).getMS_KThu());
        Iterator<thu_tien> it = list.iterator();
        while(it.hasNext()) {
            myList.add((thu_tien_guixe) it.next());
        }
    }

    private void updateTable1(ArrayList<thu_tien_guixe> list) {
        if (list.size()==0) return;
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        int i=1;
       // "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
        for(thu_tien_guixe tt : list){
            table1.addRow(new Object[]{tt.getMa_Ho(),tt.getSo_luong_xedap(),tt.getSo_luong_xemay(),tt.getSo_luong_oto(),tt.getSo_tien(),tt.getTrangthai_Thu(),tt.getNgay_thu()});
        }
        
    }

    private void updateInfo(){
        if (myList.size()==0) return;
        myKT = (khoan_thu_guixe) myModel.khoan_thu_Danhsach(new khoan_thu_guixe(),"Chưa kết thúc" ).get(0);
        jLabel_MaKT2.setText(Integer.toString(myKT.getMS_KThu())); jLabel_TenKT2.setText(myKT.getTen_KThu()); 
        jLabel_PhiXeDap.setText(Integer.toString(myKT.getPhi_xe_dap())); jLabel_PhiXeMay.setText(Integer.toString(myKT.getPhi_xe_may()));
        jLabel_PhiOTo.setText(Integer.toString(myKT.getPhi_xe_oto()));
        jLabel6.setText(Integer.toString(myKT.getTong_thu()));
    }
        
    private void checkRowCount() {
        if (table1.getRowCount() == 0) {
            jLabel13.setVisible(false); 
            jLabel14.setText("Chưa có khoản thu nào"); 
            jLabel15.setVisible(false); 
            jLabel16.setVisible(false); 
            jLabel17.setVisible(false);
            searchText3.setVisible(false);
            jButton_TimKiem2.setVisible(false);
            jButton_TaoKT2.setVisible(true); // Hiển thị nút Tạo khoản thu mới
            jLabel_TenKT2.setVisible(false);
            jLabel_MaKT2.setVisible(false);
            jLabel_PhiXeDap.setVisible(false);
            jLabel_PhiXeMay.setVisible(false);
            jLabel_PhiOTo.setVisible(false);
            jScrollPane1.setVisible(false);
           // jButton_CapNhat2.setVisible(false);
          //  jButton_XuatFile2.setVisible(false);
            jButton_KetThucKT2.setVisible(false);
            jButton_XoaKT2.setVisible(false);
            jLabel4.setVisible(false);
            jLabel6.setVisible(false);
        } else {
            jLabel13.setVisible(true); 
            jLabel14.setText("Nhập mã hộ để tìm kiếm:"); 
            jLabel15.setVisible(true); 
            jLabel16.setVisible(true); 
            jLabel17.setVisible(true); 
            searchText3.setVisible(true);
            jButton_TimKiem2.setVisible(true);
            jButton_TaoKT2.setVisible(false); 
            jLabel_TenKT2.setVisible(true);
            jLabel_MaKT2.setVisible(true);
            jLabel_PhiXeDap.setVisible(true);
            jLabel_PhiXeMay.setVisible(true);
            jLabel_PhiOTo.setVisible(true);
            jScrollPane1.setVisible(true);
           // jButton_CapNhat2.setVisible(true);
           // jButton_XuatFile2.setVisible(true);
            jButton_KetThucKT2.setVisible(true);
            jButton_XoaKT2.setVisible(true);
            jLabel4.setVisible(true);
            jLabel6.setVisible(true);
            
        }
    }
    
    
    
    // CÁC METHOD CỦA TRANG LỊCH SỬ KHOẢN THU
    
    private void getHistory(){
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_guixe(),"Đã kết thúc");
        if (tmplist.size()==0) return;
     //   ArrayList<thu_tien> list =myModel.thu_tien_Danhsach(new thu_tien_phichungcu(),tmplist.get(0).getMS_KThu());
        Iterator<khoan_thu> it = tmplist.iterator();
        while(it.hasNext()) {
            history.add((khoan_thu_guixe) it.next());
        }
    }
    
    private void updateTable5(){
        DefaultTableModel model = (DefaultTableModel)table5.getModel();
        model.setRowCount(0);
    
        for(khoan_thu_guixe kt : history){
            table5.addRow(new Object[]{kt.getMS_KThu(),kt.getTen_KThu(),kt.getPhi_xe_dap(),kt.getPhi_xe_may(),kt.getPhi_xe_oto(),kt.getNgaytao_KThu(),kt.getNgaykthuc_KThu(),kt.getTong_thu(),kt.getGhi_chu()});
        }
    }
    
  
    // CÁC METHOD CỦA TRANG ĐĂNG KÝ XE
    
    private void getDKxe(){
       dangky = myModel.getDKxe();    
    }
    
    private void updateTable3(){
       DefaultTableModel model = (DefaultTableModel)table3.getModel();
        model.setRowCount(0);
   
       // "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
        for(dang_ky_xe d : dangky){
            table3.addRow(new Object[]{d.getMa_Ho(),d.getSo_luong_xedap(),d.getSo_luong_xemay(),d.getSo_luong_oto()});
        }
    }
    
    

    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        jLabel_TenKT2 = new javax.swing.JLabel();
        jButton_XoaKT2 = new javax.swing.JButton();
        jButton_KetThucKT2 = new javax.swing.JButton();
        jButton_TaoKT2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        searchText3 = new com.raven.swing.SearchText();
        jLabel14 = new javax.swing.JLabel();
        jButton_TimKiem2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel_MaKT2 = new javax.swing.JLabel();
        jLabel_PhiXeDap = new javax.swing.JLabel();
        jLabel_PhiOTo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel_PhiXeMay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table5 = new com.raven.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_XemChiTiet = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        roundPanel8 = new com.raven.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new com.raven.swing.Table();
        searchText4 = new com.raven.swing.SearchText();
        jLabel19 = new javax.swing.JLabel();
        jButton_TimKiem3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số xe đạp", "Số xe máy", "Số ô tô", "Số tiền", "Trạng thái thu", "Ngày thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT2.setText("jLabel_TenKT");

        jButton_XoaKT2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XoaKT2.setText("Xóa khoản thu");

        jButton_KetThucKT2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThucKT2.setText("Kết thúc khoản thu");
        jButton_KetThucKT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucKT2ActionPerformed(evt);
            }
        });

        jButton_TaoKT2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TaoKT2.setText("Tạo khoản thu mới");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("Mã số khoản thu:");

        searchText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem2.setText("Tìm kiếm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setText("Phí xe đạp:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("Phí xe ô tô:");

        jLabel_MaKT2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_MaKT2.setText("jLabel_MaKT");

        jLabel_PhiXeDap.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhiXeDap.setText("jLabel_PhiXeDap");

        jLabel_PhiOTo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhiOTo.setText("jLabel_PhiOTo");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("Phí xe máy:");

        jLabel_PhiXeMay.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhiXeMay.setText("jLabel_PhiXeMay");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Tổng thu:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(searchText3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_TimKiem2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_TaoKT2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton_KetThucKT2)
                                .addGap(179, 179, 179))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel_MaKT2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(54, 54, 54)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_PhiXeDap)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel_PhiOTo)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel17)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel_PhiXeMay)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_TenKT2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_XoaKT2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel_TenKT2)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel_PhiXeDap)
                    .addComponent(jLabel13)
                    .addComponent(jLabel_MaKT2))
                .addGap(13, 13, 13)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel_PhiOTo)
                    .addComponent(jLabel17)
                    .addComponent(jLabel_PhiXeMay)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jButton_TimKiem2)
                    .addComponent(jButton_TaoKT2))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XoaKT2)
                    .addComponent(jButton_KetThucKT2))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 852, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Theo dõi các khoản thu phí gửi xe hiện tại", jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Chọn tháng:");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton6.setText("Tìm kiếm");

        roundPanel3.setBackground(new java.awt.Color(250, 250, 250));

        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khoản thu", "Tên khoản thu", "Phí xe đạp", "Phí xe máy", "Phí xe ô tô", "Ngày tạo", "Ngày kết thúc", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(table5);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Danh sách các khoản thu");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jButton_XemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XemChiTiet.setText("Xem chi tiết");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_XemChiTiet)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jButton6))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_XemChiTiet)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử các khoản thu phí gửi xe theo tháng", jPanel2);

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Số lượng xe đạp", "Số lượng xe máy", "Số lượng xe ô tô"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table3);

        searchText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText4ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem3.setText("Tìm kiếm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Bảng đăng ký xe");

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(roundPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(searchText4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TimKiem3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jButton_TimKiem3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý đăng ký xe", jPanel6);

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

    private void jButton_KetThucKT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KetThucKT2ActionPerformed
        // TODO add your handling code here:
        
                
                
                Object[] options = {"Xác nhận", "Hủy"};
                int choosen = JOptionPane.showOptionDialog(null,
                        "Bạn có chắc chắn muốn kết thúc khoản thu này",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(choosen == JOptionPane.YES_OPTION){
                      
                      myModel.khoan_thu_Ketthuc("khoan_thu_guixe", myKT.getMS_KThu());
                      myKT.setNgaykthuc_KThu(java.sql.Date.valueOf(LocalDate.now())); 
                      history.add(myKT);
                      table5.addRow(new Object[]{myKT.getMS_KThu(),myKT.getTen_KThu(),myKT.getPhi_xe_dap(),myKT.getPhi_xe_may(),myKT.getPhi_xe_oto(),myKT.getNgaytao_KThu(),myKT.getNgaykthuc_KThu(),myKT.getTong_thu(),myKT.getGhi_chu()});
                      JOptionPane.showMessageDialog(null,"Đã kết thúc khoản thu");
                      DefaultTableModel model = (DefaultTableModel)table1.getModel();
                      model.setRowCount(0);
                      checkRowCount();
                
                      return;
                }else if (choosen == JOptionPane.NO_OPTION){
                      return;
                } else if (choosen == JOptionPane.CANCEL_OPTION) {
                      return;
                }else {
                    return;
                }
                
                
                
                
    }//GEN-LAST:event_jButton_KetThucKT2ActionPerformed

    private void searchText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText3ActionPerformed

    private void searchText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText4ActionPerformed
private void jButton_TaoKT2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_TaoKhoanThuGuiXe formTaoKhoanThuMoi = new Form_TaoKhoanThuGuiXe(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formTaoKhoanThuMoi);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}   // ĐÃ ĐƯỢC VIẾT
private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {                                     
    // Create an instance of Form_ThongTinChiTiet
    
    Form_DanhSachPhiGuiXe formDanhSachPhiGuiXe = new Form_DanhSachPhiGuiXe(myModel,history.get(table5.getSelectedRow()) );

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDanhSachPhiGuiXe);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}   // ĐÃ ĐƯỢC ĐƯỢC VIẾT, NHƯNG CHƯA CHỈNH TRANG DANH SACH PHI GUI XE  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_KetThucKT2;
    private javax.swing.JButton jButton_TaoKT2;
    private javax.swing.JButton jButton_TimKiem2;
    private javax.swing.JButton jButton_TimKiem3;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XoaKT2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_MaKT2;
    private javax.swing.JLabel jLabel_PhiOTo;
    private javax.swing.JLabel jLabel_PhiXeDap;
    private javax.swing.JLabel jLabel_PhiXeMay;
    private javax.swing.JLabel jLabel_TenKT2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.RoundPanel roundPanel8;
    private com.raven.swing.SearchText searchText3;
    private com.raven.swing.SearchText searchText4;
    private com.raven.swing.Table table1;
    private com.raven.swing.Table table3;
    private com.raven.swing.Table table5;
    // End of variables declaration//GEN-END:variables
}
