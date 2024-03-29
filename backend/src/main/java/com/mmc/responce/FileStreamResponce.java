
package com.mmc.responce;

import com.mmc.backend.HTTPProcessor;
import com.mmc.backend.MainClass;
import com.sun.net.httpserver.HttpExchange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileStreamResponce  extends AResponce{
    public FileStreamResponce(HttpExchange t,InputStream is) {
        super(t,is);
    }
    @Override
    public void sendResponce(){
        try {
            OutputStream os = t.getResponseBody();
            t.sendResponseHeaders(200, 0); //t.sendResponseHeaders(httpStatus, msg.length);
            byte[] fileData = new byte[1024 * 1024];
            int nRead;           
            while ((nRead = is.read(fileData, 0, fileData.length)) != -1) {
                os.write(fileData, 0, nRead);
            
            }
            os.close();
            is.close();
            t.close();
            System.out.println("End processing");
            //sendResponce(t,200, bos.toByteArray(), contentType);
        } catch (IOException eex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, eex);
        }
    }
    
}
