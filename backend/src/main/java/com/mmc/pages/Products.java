
package com.mmc.pages;

import com.mmc.processors.AAPIProcessor;
import com.mmc.db.Db;
import com.mmc.responce.AResponce;
import com.mmc.responce.StringResponce;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import org.json.JSONObject;

public class Products extends AAPIProcessor {
    
    public Products(HttpExchange t) {
        super(t);
    }
    
    @Override
    public AResponce processRequest() throws UnsupportedEncodingException, IOException, ClassNotFoundException, SQLException {
            JSONObject reqJsonObj= getrequestBodyString();
            Db db = new Db();
            String productTable = db.getProductTable();
            return new StringResponce(t,"OK", "Product table.", productTable);
    }  
}
