/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author lehuuhieu
 */
public class ConnectDB implements Serializable{
    
    public static Connection makeConnnection() throws SQLException, NamingException {
        Context context = new InitialContext();
        Context evnContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) evnContext.lookup("DB");
        Connection con = ds.getConnection();
        
        return con;
    }
}
