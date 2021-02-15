/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.tbl_tea;

import haway.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author haway
 */
public class Tbl_TeaDAO implements Serializable {
    
    private List<Tbl_TeaDTO> listProducts;

    public List<Tbl_TeaDTO> getListProducts() {
        return listProducts;
    }
    
    public void getAllProduct () 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "SELECT teaID, name, price FROM tbl_tea";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process
                while (rs.next()) {
                    String teaID = rs.getString("teaID");
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");
                    
                    Tbl_TeaDTO dto = new Tbl_TeaDTO(teaID, name, price, 0);
                    if (this.listProducts == null) {
                        this.listProducts = new ArrayList<>();
                    }
                    this.listProducts.add(dto);
                } //end while
            } //end if con
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean insertRecord (String teaID, String name, float price) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "INSERT INTO tbl_tea(teaID, name, price)"
                        + " VALUES(?,?,?)";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, teaID);
                stm.setString(2, name);
                stm.setFloat(3, price);
                
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
    
}
