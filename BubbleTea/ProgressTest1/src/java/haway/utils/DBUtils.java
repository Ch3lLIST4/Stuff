/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author haway
 */
public class DBUtils implements Serializable {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //1. Load Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. Create Connection String
            String url ="jdbc:sqlserver://localhost:1433;databaseName=Project1;instanceName=MSSQLSERVER";
            //3. Open connection
            conn = DriverManager.getConnection(url, "sa", "KawaiiNeko1@#"); // I use this password for my bank account
        } catch (Exception e) {
        }
        return conn;
    }
}
