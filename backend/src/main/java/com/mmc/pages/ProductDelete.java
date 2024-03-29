
package com.mmc.pages;

import com.mmc.processors.AAPIProcessor;
import com.mmc.db.Db;
import com.mmc.responce.AResponce;
import com.mmc.responce.StringResponce;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;

public class ProductDelete extends AAPIProcessor{
    public ProductDelete(HttpExchange t) {
        super(t);
    }
    @Override
    public AResponce processRequest() throws Exception {
        JSONObject reqJsonObj = getrequestBodyString();
        Db db = new Db();
        db.deleteProduct(reqJsonObj.getInt("product_id"));
        return new StringResponce(t,"OK", "Product delete success.", "{}");
    }
    
}
