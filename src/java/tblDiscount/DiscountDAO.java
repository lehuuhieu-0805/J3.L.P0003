/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblDiscount;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class DiscountDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public int checkCode(String code) throws Exception {
        int value = 0;

        try {
            String sql = "select expiryDate, value\n"
                    + "from Discount\n"
                    + "where code = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, code);
            rs = pst.executeQuery();
            while (rs.next()) {
                Timestamp expiryDate = rs.getTimestamp(1);
                java.util.Date date = new java.util.Date();
                Timestamp currentDate = new Timestamp(date.getTime());
                if (expiryDate.after(currentDate)) {
                    value = rs.getInt(2);
                }
            }
        } finally {
            closeConnection();
        }

        return value;
    }
}
