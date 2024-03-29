package com.mmc.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import com.mmc.api.utils.Config;

public class DB1 {
//TO DO: Connection pooling

    public String runAction(String actionName, String sessionid, JSONObject json) throws SQLException, ClassNotFoundException {
        String arguments = "";//p_sessionid=>?,";
        JSONArray key = json.names();
        for (int i = 0; i < key.length(); ++i) {
            arguments = arguments + "p_" + key.getString(i) + "=>?,";
        }
        arguments = arguments.substring(0, arguments.length() - 1);//remove last comma

        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(Config.getJson().getJSONObject("postgres").getString("conn_str"), Config.getJson().getJSONObject("postgres").getString("user"), Config.getJson().getJSONObject("postgres").getString("pass"));
        System.out.println("DATABSE---> { ? = call " + actionName + "(" + arguments + ") }");
        CallableStatement dbFunction = conn.prepareCall("{ ? = call " + actionName + "(" + arguments + ") }");
        dbFunction.registerOutParameter(1, Types.VARCHAR);
        dbFunction.setString(2, sessionid);
        for (int i = 0; i < key.length(); ++i) {
            String keys = key.getString(i);
            dbFunction.setString(i + 2, json.getString(keys));
        }
        dbFunction.execute();
        return dbFunction.getString(1);

    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(Config.getJson().getJSONObject("postgres").getString("conn_str"), Config.getJson().getJSONObject("postgres").getString("user"), Config.getJson().getJSONObject("postgres").getString("pass"));
    }
}
