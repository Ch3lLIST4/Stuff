/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.tbl_orderDetail;

import haway.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author haway
 */
public class Tbl_OrderDetailDAO implements Serializable {
    
    public boolean insertRecord (String productID, int quantity, float unitPrice, float total, int orderID) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "INSERT INTO tbl_orderDetail(productID, quantity, unitPrice, total, orderID)"
                        + " VALUES(?,?,?,?,?)";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, productID);
                stm.setInt(2, quantity);
                stm.setFloat(3, unitPrice);
                stm.setFloat(4, total);
                stm.setInt(5, orderID);
                
                //4. Execute Query
                int row = stm.executeUpdate();
                
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) 
                stm.close();
            if (con != null) 
                con.close();
        }
        return false;
    }
    
    
    
}
