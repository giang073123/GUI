package Model.NhanKhau;
import Service.connectDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Model_nhankhaudraft {

    private final Connection conn;

    public Model_nhankhaudraft() {
        connectDB conndb = new connectDB();
        conn = conndb.connect();

    }


}
