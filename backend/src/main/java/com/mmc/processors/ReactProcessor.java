
package com.mmc.processors;

import com.mmc.backend.MainClass;
import com.mmc.responce.AResponce;
import com.mmc.responce.FileStreamResponce;
import com.sun.net.httpserver.HttpExchange;
import java.io.InputStream;
import java.io.OutputStream;



public class ReactProcessor extends AAPIProcessor {
    public ReactProcessor(HttpExchange t) {
        super(t);
    }

    @Override
    public AResponce processRequest() throws Exception {
        //InputStream is = MainClass.class.getClassLoader().getResourceAsStream(fileName);
           String fileName = t.getRequestURI().toString();
            if (fileName.equals("/") || !fileName.startsWith("/static")) {
                fileName = "/index.html";
            }
            fileName = "WEB-INF" + fileName.replace("/test", ""); //not sure why we need this
            System.out.println("    FileName=" + fileName);
            //OutputStream os = t.getResponseBody();
            InputStream is = MainClass.class.getClassLoader().getResourceAsStream(fileName);
            //ByteArrayOutputStream bos = new ByteArrayOutputStream();
            if(fileName.endsWith(".js")){
                t.getResponseHeaders().set("Content-Type", "text/javascript");
            }
            if(fileName.endsWith(".css")){
                t.getResponseHeaders().set("Content-Type", "text/css");
            }
            if(fileName.endsWith(".html")){
                t.getResponseHeaders().set("Content-Type", "text/html");
            }          
             //t.getResponseHeaders().set("Content-Type", "text/html");        
       return new FileStreamResponce(t,is);
    }

}
