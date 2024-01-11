/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.TaiKhoan;

import Service.Validater;
import Service.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Model_TaiKhoan {

    private Connection conn;
    private Validater val = new Validater();
    private can_bo cb;

    public Model_TaiKhoan() {
//        try {        -> TẠI MỖI PHƯƠNG THỨC ĐỀU open và close rồi
//            open_conn();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void open_conn() throws SQLException {
        connectDB conndb = new connectDB();
        conn = conndb.connect();
    }

    public void close_conn() throws SQLException {
        conn.close();
    }

    public Validater getVal() {
        return val;
    }

    public void setCb(can_bo cb) {
        this.cb = cb;
    }

    public can_bo getCb() {
        return cb;
    }

    public ArrayList<can_bo> getds() {
        ArrayList<can_bo> list = new ArrayList<>();

        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }

        String query = "select * from can_bo";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            // Set parameters for the query

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                can_bo canBo = new can_bo();
                canBo.setMa_CB(resultSet.getInt("Ma_CB"));
                canBo.setCCCD(resultSet.getString("CCCD"));
                canBo.setUsername(resultSet.getString("username"));
                canBo.setPassword(resultSet.getString("password"));
                canBo.setTen_CB(resultSet.getString("Ten_CB"));
                canBo.setChuc_vu(resultSet.getString("Chuc_vu"));
                list.add(canBo);
                // Execute the update
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Model_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void update_cb(can_bo canBo) {
        try {
            open_conn();
        } catch (SQLException ex) {
            Logger.getLogger(Model_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "UPDATE can_bo SET CCCD=?, username=?, password=?, Ten_CB=?, Chuc_vu=? WHERE Ma_CB=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            // Set parameters for the query
            preparedStatement.setString(1, canBo.getCCCD());
            preparedStatement.setString(2, canBo.getUsername());
            preparedStatement.setString(3, canBo.getPassword());
            preparedStatement.setString(4, canBo.getTen_CB());
            preparedStatement.setString(5, canBo.getChuc_vu());
            preparedStatement.setInt(6, canBo.getMa_CB());

            // Execute the update
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Model_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
