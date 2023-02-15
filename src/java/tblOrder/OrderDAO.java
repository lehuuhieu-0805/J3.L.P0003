/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class OrderDAO {

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

    public int create(OrderDTO dto) throws Exception {
        int orderId = -1;

        try {
            String sql = "insert into [Order] values (?,?,?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setTimestamp(1, dto.getDate());
            pst.setInt(2, dto.getTotalPrice());
            pst.setString(3, dto.getUserEmail());
            pst.setString(4, dto.getStatus());
            pst.executeUpdate();

            sql = "select IDENT_CURRENT('Order')";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                orderId = rs.getInt(1);
            }
        } finally {
            closeConnection();
        }

        return orderId;
    }

    public List<OrderDTO> findByEmail(String email) throws Exception {
        List<OrderDTO> list = new ArrayList<>();

        try {
            String sql = "select id, date, totalPrice\n"
                    + "from [Order]\n"
                    + "where userEmail = ? and status = 'active'";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Timestamp date = rs.getTimestamp(2);
                int totalPrice = rs.getInt(3);
                list.add(new OrderDTO(id, totalPrice, email, null, date));
            }
        } finally {
            closeConnection();
        }

        return list;
    }

}
