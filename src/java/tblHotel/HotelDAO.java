/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblHotel;

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
public class HotelDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private ResultSet rs1;

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (rs1 != null) {
            rs1.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<HotelDTO> search(String search, int amount) throws Exception {
        List<HotelDTO> list = new ArrayList<>();

        try {
            if (search.length() == 0 && amount == 0) {
                String sql = "select name, area, id, (select sum(amount) from Room r where r.HotelId = h.Id) as amount\n"
                        + "from Hotel h";
                con = ConnectDB.makeConnnection();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(4) > 0) {
                        String name = rs.getString(1);
                        String area = rs.getString(2);
                        int id = rs.getInt(3);
                        HotelDTO dto = new HotelDTO(id, name, area);
                        list.add(dto);
                    }
                }
            } else if (search.length() != 0 && amount == 0) {
                String sql = "select name, area, id, (select sum(amount) from Room r where r.HotelId = h.Id) as amount\n"
                        + "from Hotel h\n"
                        + "where name like ? or area like ?";
                con = ConnectDB.makeConnnection();
                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + search + "%");
                pst.setString(2, "%" + search + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(4) > 0) {
                        String name = rs.getString(1);
                        String area = rs.getString(2);
                        int id = rs.getInt(3);
                        HotelDTO dto = new HotelDTO(id, name, area);
                        list.add(dto);
                    }
                }
            } else if (search.length() != 0 && amount != 0) {
                String sql = "select name, area, id, (select sum(amount) from Room r where r.HotelId = h.Id) as amount\n"
                        + "from Hotel h\n"
                        + "where name like ? or area like ?";
                con = ConnectDB.makeConnnection();
                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + search + "%");
                pst.setString(2, "%" + search + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(4) >= amount) {
                        String name = rs.getString(1);
                        String area = rs.getString(2);
                        int id = rs.getInt(3);
                        list.add(new HotelDTO(id, name, area));
                    }
                }
            } else if (search.length() == 0 && amount != 0) {
                String sql = "select name, area, id, (select sum(amount) from Room r where r.HotelId = h.Id) as amount\n"
                        + "from Hotel h\n";
                con = ConnectDB.makeConnnection();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(4) >= amount) {
                        String name = rs.getString(1);
                        String area = rs.getString(2);
                        int id = rs.getInt(3);
                        list.add(new HotelDTO(id, name, area));
                    }
                }
            }

        } finally {
            closeConnection();
        }

        return list;
    }
}
