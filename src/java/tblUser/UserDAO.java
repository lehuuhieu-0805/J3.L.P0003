/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class UserDAO {

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

    public boolean create(UserDTO dto) throws Exception {
        boolean check = false;

        try {
            String sql = "insert into [User] values (?,?,?,?,?,?,?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getEmail());
            pst.setString(2, dto.getPhone());
            pst.setString(3, dto.getName());
            pst.setString(4, dto.getAddress());
            pst.setTimestamp(5, dto.getCreateDate());
            pst.setString(6, dto.getStatus());
            pst.setString(7, dto.getPassword());
            pst.setString(8, dto.getRole());
            check = pst.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public UserDTO login(String email, String password) throws Exception {
        UserDTO dto = new UserDTO();

        try {
            String sql = "select name, role\n"
                    + "from [User]\n"
                    + "where email = ? and password = ? and status = 'active' and role = 'user'";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String role = rs.getString(2);
                dto = new UserDTO(email, null, name, null, null, null, null, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
