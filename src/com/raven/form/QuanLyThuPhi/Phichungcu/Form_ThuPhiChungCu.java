/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form.QuanLyThuPhi.Phichungcu;


import Model.NhanKhau.ho_gia_dinh;
import Model.NhanKhau.nhan_khau;
import Model.ThuPhi.*;
import com.raven.form.QuanLyThuPhi.Phichungcu.Form_TaoKhoanThuChungCu;
import com.raven.form.QuanLyThuPhi.Phichungcu.Form_DanhSachPhiChungCu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC Giang
 */
public class Form_ThuPhiChungCu extends javax.swing.JPanel {
    Model_ThuPhi myModel;
    khoan_thu_phichungcu myKT;
    ArrayList<thu_tien_phichungcu> myList = new ArrayList<>();
    ArrayList<khoan_thu_phichungcu> history = new ArrayList<>();


    /**
     * Creates new form Form_ThuPhiChungCu
     */
    public Form_ThuPhiChungCu(Model_ThuPhi tp) {
        myModel = tp;
        initComponents();
        table1.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox<>(new String[]{"Đã thu", "Chưa thu"})));
        getdata();  // get data for mylist

        updateTable1(myList);
        checkRowCount();
        updateInfo();

        getHistory();
        updateTable2();

        
        // NÚT TẠO KHOẢN THU
        jButton_TaoKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        // NÚT XEM CHI TIẾT TRONG PHẦN LỊCH SỬ
        jButton_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XemChiTietActionPerformed(evt);
            }
        });

        // TABLE1 MODEL LISTENER 
        table1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int idx = e.getFirstRow();
                
                
                if(e.getColumn()==3)    {           // THAY ĐỔI TRẠNG THÁI  
                if(table1.getRowCount()==0) return;
                
                 if (table1.getModel().getValueAt(idx, 3).toString().compareTo("Đã thu") == 0 && table1.getModel().getValueAt(idx, 4)!=null){ return;}
                 else if(table1.getModel().getValueAt(idx, 3).toString().compareTo("Chưa thu") == 0 && table1.getModel().getValueAt(idx, 4)==null){ return; }
                 
                 else if (table1.getModel().getValueAt(idx, 3).toString().compareTo("Đã thu") == 0 && table1.getModel().getValueAt(idx, 4)==null ) { 
                    myList.get(idx).setTrangthai_Thu(table1.getModel().getValueAt(idx, 3).toString());
                    myList.get(idx).setNgay_thu(java.sql.Date.valueOf(LocalDate.now()));
                    
                    
                    myModel.thu_tien_CapNhat(myList.get(idx),"Đã thu");
                    table1.getModel().setValueAt(myList.get(idx).getNgay_thu(),idx,4); 
                 } 
                else if(table1.getModel().getValueAt(idx, 3).toString().compareTo("Chưa thu") == 0 && table1.getModel().getValueAt(idx, 4)!=null){
                     table1.getModel().setValueAt("Đã thu",idx,3);
                     JOptionPane.showMessageDialog(null,"Đã thu, không thể sửa đổi");  // Đã thu rồi thì không sửa được
                    return; }
            } 
                
                else if(e.getColumn()==1){         // THAY ĐỔI DIỆN TÍCH
                    
                    
                   if(table1.getRowCount()==0) return;
                    JOptionPane.showMessageDialog(null,"Thay đổi diện tích"); 
                   // Chỉnh sửa các thông tin
                   float dien_tich = (float)table1.getModel().getValueAt(idx, 1);
                   int sotien = (int)  dien_tich*(myKT.getPhi_dichvu()+myKT.getPhi_quanly());
                   myList.get(idx).setDien_tich(dien_tich);
                   myList.get(idx).setSo_tien(sotien);
                   myList.get(idx).setNgay_thu(null);
                   myList.get(idx).setTrangthai_Thu("Chưa thu");
                   
                   myModel.thu_tien_CapNhat(myList.get(idx), "Chưa thu");
                   
                   table1.getModel().setValueAt(null,idx,4);  // Set null cho ngày thu trước số tiền
                   table1.getModel().setValueAt(sotien,idx,2);  
                   table1.getModel().setValueAt("Chưa thu",idx,3);                                                                                  
                }
                myKT= (khoan_thu_phichungcu) myModel.khoan_thu_Get(new khoan_thu_phichungcu(), myKT.getMS_KThu());
                jLabel1.setText(Integer.toString(myKT.getTong_thu()));
            }
         });        
                                       
        
        
        // NÚT TÌM KIẾM TRONG PHẦN KHOẢN THU HIỆN TẠI
        jButton_TimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,searchText1.getText());
                if (searchText1.getText().length() < 1) {
//                    if (table1.getRowCount() > 1) {
//                    } else {
//                       // updateTable1(myList);   // Reset lại bảng, nhưng hiện tại dùng getViewport thì không cần lắm
//                    }
                } else {
                    int i = 0;
                    for (thu_tien_phichungcu t : myList) {
                        if (t.getMa_Ho() == Integer.parseInt(searchText1.getText())) {
                            Rectangle rect = table1.getCellRect(i, 0, true);
                            jScrollPane1.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
                }
            }

        });

        // KET THUC KHOAN THU
        jButton_KetThucKT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
                      
                      myModel.khoan_thu_Ketthuc("khoan_thu_phichungcu", myKT.getMS_KThu());
                      myKT.setNgaykthuc_KThu(java.sql.Date.valueOf(LocalDate.now())); 
                      history.add(myKT);
                      table2.addRow(new Object[]{myKT.getMS_KThu(),myKT.getTen_KThu(),myKT.getPhi_dichvu(),myKT.getPhi_quanly(),myKT.getNgaytao_KThu(),myKT.getNgaykthuc_KThu(),myKT.getTong_thu(),myKT.getGhi_chu()});
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

                
                
            }
        });
        
        
        // XÓA KHOẢN THU 
         jButton_XoaKT.addActionListener(new ActionListener() {
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
                      model.setRowCount(0);
                      checkRowCount();
                    
                      JOptionPane.showMessageDialog(null,"Đã xóa khoản thu");
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


       // TÌM KIẾM KHOẢN THU TRONG PHẦN LỊCH SỬ
       
       jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jDateChooser1.getDate()!=null){
               Date choosen_Date = jDateChooser1.getDate();
                int i = 0;
                    for (khoan_thu_phichungcu kt : history) {
                        if (kt.getNgaytao_KThu().getMonth() == choosen_Date.getMonth() ) {
                            Rectangle rect = table2.getCellRect(i, 0, true);
                            jScrollPane2.getViewport().scrollRectToVisible(rect);
                            
                            break;
                        }
                        i++;
                    }
               
                }
            }
        });
    }

    // CÁC METHOD CỦA TRANG KHOẢN THU HIỆN TẠI
    private void getdata(){
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_phichungcu(),"Chưa kết thúc");
        if (tmplist.size()==0) return;
        ArrayList<thu_tien> list =myModel.thu_tien_Danhsach(new thu_tien_phichungcu(),tmplist.get(0).getMS_KThu());
        Iterator<thu_tien> it = list.iterator();
        while(it.hasNext()) {
            myList.add((thu_tien_phichungcu) it.next());
        }
    }

    private void updateTable1(ArrayList<thu_tien_phichungcu> list) {
        if (list.size()==0) return;
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.setRowCount(0);
        int i=1;
       // "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
        for(thu_tien_phichungcu tt : list){
            table1.addRow(new Object[]{tt.getMa_Ho(),tt.getDien_tich(),tt.getSo_tien(),tt.getTrangthai_Thu(),tt.getNgay_thu()});
        }
        
    }



    private void updateInfo(){
        if (myList.size()==0) return;
        myKT = (khoan_thu_phichungcu) myModel.khoan_thu_Danhsach(new khoan_thu_phichungcu(),"Chưa kết thúc" ).get(0);
        jLabel_MaKT.setText(Integer.toString(myKT.getMS_KThu())); jLabel_TenKT.setText(myKT.getTen_KThu()); jLabel_PhiQL.setText(Integer.toString(myKT.getPhi_quanly())); jLabel_PhiDV.setText(Integer.toString(myKT.getPhi_dichvu()));
        jLabel1.setText(Integer.toString(myKT.getTong_thu()));
    }
    
    
    private void checkRowCount() {
        if (table1.getRowCount() == 0) {
            jLabel5.setVisible(false); 
            jLabel6.setText("Chưa có khoản thu nào"); 
            jLabel7.setVisible(false); 
            jLabel8.setVisible(false); 
            searchText1.setVisible(false);
            jButton_TimKiem.setVisible(false);
            jButton_TaoKT.setVisible(true); // Hiển thị nút Tạo khoản thu mới
            jLabel_TenKT.setVisible(false);
            jLabel_MaKT.setVisible(false);
            jLabel_PhiDV.setVisible(false);
            jLabel_PhiQL.setVisible(false);
            jScrollPane1.setVisible(false);
            
           // jButton_XuatFile.setVisible(false);
            jButton_KetThucKT.setVisible(false);
            jButton_XoaKT.setVisible(false);
            jLabel1.setVisible(false);
            jLabel_Tongthu.setVisible(false);
        } else {
            jLabel5.setVisible(true); 
            jLabel6.setText("Nhập mã hộ để tìm kiếm:"); 
            jLabel7.setVisible(true); 
            jLabel8.setVisible(true); 
            searchText1.setVisible(true);
            jButton_TimKiem.setVisible(true);
            jButton_TaoKT.setVisible(false); 
            jLabel_TenKT.setVisible(true);
            jLabel_MaKT.setVisible(true);
            jLabel_PhiDV.setVisible(true);
            jLabel_PhiQL.setVisible(true);
            jScrollPane1.setVisible(true);
      
          //  jButton_XuatFile.setVisible(true);
            jButton_KetThucKT.setVisible(true);
            jButton_XoaKT.setVisible(true);
            jLabel1.setVisible(true);
            jLabel_Tongthu.setVisible(true);
            
        }
    }

    
    // CÁC METHOD CỦA TRANG LỊCH SỬ KHOẢN THU
    
    private void updateTable2(){
        DefaultTableModel model = (DefaultTableModel)table2.getModel();
        model.setRowCount(0);
        int i=1;
        for(khoan_thu_phichungcu kt : history){
            table2.addRow(new Object[]{kt.getMS_KThu(),kt.getTen_KThu(),kt.getPhi_dichvu(),kt.getPhi_quanly(),kt.getNgaytao_KThu(),kt.getNgaykthuc_KThu(),kt.getTong_thu(),kt.getGhi_chu()});
        }
    }
    
    private void getHistory(){
        ArrayList<khoan_thu> tmplist = myModel.khoan_thu_Danhsach(new khoan_thu_phichungcu(),"Đã kết thúc");
        if (tmplist.size()==0) return;
     //   ArrayList<thu_tien> list =myModel.thu_tien_Danhsach(new thu_tien_phichungcu(),tmplist.get(0).getMS_KThu());
        Iterator<khoan_thu> it = tmplist.iterator();
        while(it.hasNext()) {
            history.add((khoan_thu_phichungcu) it.next());
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
        jLabel_TenKT = new javax.swing.JLabel();
        jButton_XoaKT = new javax.swing.JButton();
        jButton_KetThucKT = new javax.swing.JButton();
        jButton_TaoKT = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel6 = new javax.swing.JLabel();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_MaKT = new javax.swing.JLabel();
        jLabel_PhiDV = new javax.swing.JLabel();
        jLabel_PhiQL = new javax.swing.JLabel();
        jLabel_Tongthu = new javax.swing.JLabel();
        jLabel_Tongthu2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.raven.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_XemChiTiet = new javax.swing.JButton();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ", "Diện tích", "Số tiền", "Trạng thái thu", "Ngày thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel_TenKT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_TenKT.setText("jLabel_TenKT");

        jButton_XoaKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_XoaKT.setText("Xóa khoản thu");

        jButton_KetThucKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_KetThucKT.setText("Kết thúc khoản thu");
        jButton_KetThucKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KetThucKTActionPerformed(evt);
            }
        });

        jButton_TaoKT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TaoKT.setText("Tạo khoản thu mới");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Mã số khoản thu:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Nhập mã hộ để tìm kiếm:");

        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Phí dịch vụ:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Phí quản lý:");

        jLabel_MaKT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_MaKT.setText("jLabel_MaKT");

        jLabel_PhiDV.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhiDV.setText("jLabel_PhiDV");

        jLabel_PhiQL.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_PhiQL.setText("jLabel_PhiQL");

        jLabel_Tongthu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_Tongthu.setText("Tổng thu:");

        jLabel_Tongthu2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_TaoKT))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton_KetThucKT)
                                    .addGap(15, 15, 15)
                                    .addComponent(jButton_XoaKT))
                                .addComponent(jLabel_TenKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel_Tongthu, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel_Tongthu2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_MaKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_PhiQL))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_PhiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel_TenKT)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel_PhiDV)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_MaKT))
                .addGap(13, 13, 13)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_PhiQL)
                    .addComponent(jLabel_Tongthu)
                    .addComponent(jLabel_Tongthu2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton_TimKiem)
                    .addComponent(jButton_TaoKT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_XoaKT)
                    .addComponent(jButton_KetThucKT))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Theo dõi các khoản thu phí chung cư hiện tại", jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Chọn tháng:");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton6.setText("Tìm kiếm");

        roundPanel3.setBackground(new java.awt.Color(250, 250, 250));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khoản thu", "Tên khoản thu", "Phí dịch vụ", "Phí quản lý", "Ngày tạo", "Ngày kết thúc", "Tổng thu", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử các khoản thu phí chung cư theo tháng", jPanel2);

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

    private void jButton_KetThucKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KetThucKTActionPerformed
        // TODO add your handling code here:
        // ĐÃ CÓ Ở BÊN TRÊN RỒI
    }//GEN-LAST:event_jButton_KetThucKTActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet
    Form_TaoKhoanThuChungCu formTaoKhoanThuMoi = new Form_TaoKhoanThuChungCu(myModel);

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formTaoKhoanThuMoi);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}   // ĐÃ XONG -> TẠO KHOẢN THU MỚI
private void jButton_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Create an instance of Form_ThongTinChiTiet


    Form_DanhSachPhiChungCu formDanhSachPhiChungCu= new Form_DanhSachPhiChungCu(myModel,history.get(table2.getSelectedRow()));

    // Get the parent container (JFrame or another container)
    Container parentContainer = this.getParent();

    // Remove the current panel (Form_ThongTinHo) from the parent container
    parentContainer.remove(this);

    // Add the new panel (Form_ThongTinChiTiet) to the parent container
    parentContainer.add(formDanhSachPhiChungCu);

    // Repaint the container to reflect the changes
    parentContainer.revalidate();
    parentContainer.repaint();
}  // ĐÃ XONG

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_KetThucKT;
    private javax.swing.JButton jButton_TaoKT;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_XemChiTiet;
    private javax.swing.JButton jButton_XoaKT;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_MaKT;
    private javax.swing.JLabel jLabel_PhiDV;
    private javax.swing.JLabel jLabel_PhiQL;
    private javax.swing.JLabel jLabel_TenKT;
    private javax.swing.JLabel jLabel_Tongthu;
    private javax.swing.JLabel jLabel_Tongthu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.SearchText searchText1;
    private com.raven.swing.Table table1;
    private com.raven.swing.Table table2;
    // End of variables declaration//GEN-END:variables
}
