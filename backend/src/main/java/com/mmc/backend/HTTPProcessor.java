package com.mmc.backend;

import com.mmc.factory.HTTPFactory;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPProcessor implements HttpHandler {

    public static HashMap<String, String> sessionMap = new HashMap<String, String>();
    private int i = 0;

    @Override
    public void handle(HttpExchange t) {
        i++;
        //TO DO Would be a good idea to spawn a new Thread to process the request.
        String fileName = t.getRequestURI().toString();
        System.out.println("Start processing req:(" + i + ") " + fileName);
        try {
            HTTPFactory.getProcessor(t).processRequest().sendResponce();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
