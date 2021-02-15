/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.tbl_order;

import haway.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author haway
 */
public class Tbl_OrderDAO implements Serializable {
    
    public boolean insertRecord (String orderDate, String custID, float total, String address, String phone) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "INSERT INTO tbl_order(orderDate,custID,total,address,phone)"
                        + " VALUES(?,?,?,?,?)";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, orderDate);
                stm.setString(2, custID);
                stm.setFloat(3, total);
                stm.setString(4, address);
                stm.setString(5, phone);
                
                //4. Execute Query
                int row = stm.executeUpdate();
                
                if (row > 0) {
                    return true;
                }
            } //end if con
        } finally {
            if (stm != null)
                stm.close();
            if (con != null)
                con.close();
        }
        return false;
    }
    
    public int getOrderIDfromOrderID () 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;        
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "SELECT TOP 1 orderID FROM tbl_order ORDER BY orderID DESC";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process
                while (rs.next()) {
                    return rs.getInt("orderID");
                }
            }
        } finally {
            if (rs != null)
                rs.close();
            if (stm != null)
                stm.close();
            if (con != null)
                con.close();            
        }
        return -1;
    }
    
}
