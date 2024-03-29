package com.mmc.db;

import com.mmc.api.utils.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Db {
    
    Connection conn;
    //TO DO: Use connection pooling.

    public String getSessionID(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(Config.getValueByKey("postgres.conn_str"), "user1", "user1");
        PreparedStatement pstmt = conn.prepareStatement("SELECT gen_random_uuid() from accounts where email=? and pwd_hash=?");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        String sessionID = null;
        if (rs.next()) {
            sessionID = rs.getString(1);
        }
        conn.close();
        return sessionID;
    }
    
    public String getProductTable() throws ClassNotFoundException, SQLException {
        conn = DriverManager.getConnection(Config.getValueByKey("postgres.conn_str"), "user1", "user1");
        //PreparedStatement pstmt = conn.prepareStatement("SELECT product_id,name,description,category,mesure_unit,quantity,price,created_on,updated_on from products");
        PreparedStatement pstmt = conn.prepareStatement("SELECT product_id,name,description,quantity,price from products");
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        String productTable = "";
        while (rs.next()) {
            String rowLine = "";
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                rowLine = rowLine + "\"" + rsmd.getColumnName(i) + "\":\"" + rs.getString(rsmd.getColumnName(i)) + "\",";
            }
            productTable = productTable + "{" + rowLine.substring(0, rowLine.length() - 1) + "},";
        }
        if (productTable.endsWith(",")) {//remove last "," if it exists (it doesn't exists in case no rows returns)
            productTable = productTable.substring(0, productTable.length() - 1);            
        }
        productTable = "[" + productTable + "]";
        conn.close();
        return productTable;
    }
    
    public void deleteProduct(int product_id) throws SQLException {
        conn = DriverManager.getConnection(Config.getValueByKey("postgres.conn_str"), "user1", "user1");
        PreparedStatement pstmt = conn.prepareStatement("delete from products where product_id=?");
        pstmt.setInt(1, product_id);
        int nrOfRowsAffected = pstmt.executeUpdate();
        if (nrOfRowsAffected > 0) {
            System.out.println("    product_id=" + product_id + " deleted");
        } else {
            System.out.println("    No rows deleted (this should nevere happen).");
        }
        conn.close();
        
    }
}