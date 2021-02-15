/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.tbl_user;

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
public class Tbl_UserDAO implements Serializable {
    public String checkLogin (String userID, String password) 
            throws SQLException, NamingException {
        String role = "failed";
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "SELECT role FROM tbl_user WHERE userID=? AND password=?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process
                if (rs.next()) {
                    role = rs.getString("role");
                }
            } //end if con   
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
        return role;
    }
    
    private List<Tbl_UserDTO> listAccounts;

    public List<Tbl_UserDTO> getListAccounts() {
        return listAccounts;
    }

    public void searchFullName (String searchValue) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "SELECT userID, password, fullName, role FROM tbl_user WHERE fullName LIKE ?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                //4. Execute Query
                rs = stm.executeQuery();
                //5. process
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    String role = rs.getString("role");
                    
                    Tbl_UserDTO dto = new Tbl_UserDTO(userID, password, fullName, role);
                    if (this.listAccounts == null) {
                        this.listAccounts = new ArrayList<>();
                    }
                    this.listAccounts.add(dto);
                } //end while
            } //end if con
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
    
    public boolean deleteAccount (String userID) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "DELETE FROM tbl_user WHERE userID = ?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                
                //4. Execute Query
                int row = stm.executeUpdate();
                
                if (row > 0) {
                    return true;
                }
            } //end if con
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }     
        }
        return false;
    }
    
    public boolean updatePassRole (String userID, String password, String role) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1.Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "UPDATE tbl_user SET password = ?, role = ? WHERE userID = ?";
                //3.Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, role);
                stm.setString(3, userID);
                
                //3. Execute Query
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
    
    public boolean insertRecord(String userID, String password, String fullName, String role) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            //1. Make Connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2. Create SQL
                String sql = "INSERT INTO tbl_user(userID, password, fullName, role)"
                        + " VALUES(?,?,?,?)";
                
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setString(4, role);
                
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
