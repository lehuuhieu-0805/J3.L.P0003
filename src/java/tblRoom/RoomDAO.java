/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblRoom;

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
public class RoomDAO {

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

    public List<RoomDTO> findByHotelId(int hotelId) throws Exception {
        List<RoomDTO> list = new ArrayList<>();

        try {
            String sql = "select id, type, amount, price\n"
                    + "from Room\n"
                    + "where hotelId = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, hotelId);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(3) > 0) {
                    int id = rs.getInt(1);
                    String type = rs.getString(2);
                    int amount = rs.getInt(3);
                    int price = rs.getInt(4);
                    list.add(new RoomDTO(id, amount, price, hotelId, type));
                }
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public RoomDTO findById(int id) throws Exception {
        RoomDTO dto = null;
        try {
            String sql = "select r.type, r.amount, r.price, r.hotelId, h.name\n"
                    + "from Room r\n"
                    + "inner join Hotel h on h.Id = r.hotelId\n"
                    + "where r.id = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(3) > 0) {
                    String type = rs.getString(1);
                    int amount = rs.getInt(2);
                    int price = rs.getInt(3);
                    int hotelId = rs.getInt(4);
                    String hotelName = rs.getString(5);
                    dto = new RoomDTO(id, amount, price, hotelId, type, hotelName);
                }
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public int getAmount(int id) throws Exception {
        int amount = -1;
        try {
            String sql = "select amount\n"
                    + "from Room\n"
                    + "where id = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                amount = rs.getInt(1);
            }
        } finally {
            closeConnection();
        }
        return amount;
    }
}
