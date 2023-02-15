/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblOrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class OrderDetailDAO {

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

    public void create(OrderDetailDTO dto) throws Exception {
        try {
            String sql = "insert into OrderDetail values (?,?,?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, dto.getPrice());
            pst.setInt(2, dto.getAmount());
            pst.setInt(3, dto.getOrderId());
            pst.setInt(4, dto.getRoomId());
            pst.executeUpdate();
        } finally {
            closeConnection();
        }
    }

    public List<OrderDetailDTO> findByOrderId(int orderId) throws Exception {
        List<OrderDetailDTO> list = new ArrayList<>();
        try {
            String sql = "select od.id, od.price, od.amount, od.roomId, r.type, h.name\n"
                    + "from OrderDetail od\n"
                    + "inner join Room r on r.id= od.roomId\n"
                    + "inner join Hotel h on h.id = r.hotelId\n"
                    + "where od.orderId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int price = rs.getInt(2);
                int amount = rs.getInt(3);
                int roomId = rs.getInt(4);
                String type = rs.getString(5);
                String name = rs.getString(6);
                list.add(new OrderDetailDTO(id, price, amount, orderId, roomId, name, type));
            }
        } finally {
            closeConnection();
        }

        return list;
    }
}
