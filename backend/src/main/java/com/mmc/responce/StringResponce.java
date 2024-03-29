package com.mmc.responce;

import com.mmc.api.utils.Convert;
import com.mmc.backend.HTTPProcessor;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class StringResponce extends AResponce {

    JSONObject responce = null;
    //String responce = null;

    public StringResponce(HttpExchange t, String status, String message, String data) {
        super(t,null);
        responce = Convert.getInstance().stringToJson("{\"responce\":\"" + status + "\",\"message\":\"" + message + "\",\"data\":" + data + "}");
    }

    @Override
    public void sendResponce() {
         System.out.println("    ResponceJSON=" + responce);
        OutputStream os = t.getResponseBody();
        //t.getResponseHeaders().put("Content-Type", Collections.singletonList(contentType));
        t.getResponseHeaders().set("Content-Type", "application/json");
        byte[] responceByte = responce.toString().getBytes();
        try {
            t.sendResponseHeaders(200, responceByte.length);
            os.write(responceByte, 0, responceByte.length);
            os.close();
            System.out.println("End processing");
        } catch (IOException ex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
