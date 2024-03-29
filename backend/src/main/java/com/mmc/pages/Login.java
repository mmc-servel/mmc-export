package com.mmc.pages;

import com.mmc.processors.AAPIProcessor;
import com.mmc.db.DB1;
import com.mmc.responce.AResponce;
import com.mmc.responce.StringResponce;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import org.json.*;

public class Login extends AAPIProcessor {

    public Login(HttpExchange t) {
        super(t);
    }

    @Override
    public AResponce processRequest() throws UnsupportedEncodingException, IOException, ClassNotFoundException {
        DB1 db = new DB1();
        JSONObject requestBodyJson = getrequestBodyString();
        //return new HTTPApiResponce(db.runAction("sec_login", null, requestBodyJson));
        String dbResponce;
        try {
            dbResponce = db.runAction("app_security.getsessionid", null, requestBodyJson);
            if (dbResponce.startsWith("ERRORMSG=")) {//login faild, the error message comes from DB function
                return new StringResponce(t, "ERROR", dbResponce.replace("ERRORMSG=", ""), "{}");
            } else {
                return new StringResponce(t, "OK", "SuccessMessage", "{\"sessionid\":\"" + dbResponce.replace("SESSIONID=", "") + "\"}");
            }

        } catch (SQLException ex) {

            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return new StringResponce(t, "ERROR", "Service unavailable", "{}");
        }

    }
}
