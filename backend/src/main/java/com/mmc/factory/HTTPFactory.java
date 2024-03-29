package com.mmc.factory;

import com.mmc.processors.AAPIProcessor;
import com.sun.net.httpserver.HttpExchange;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class HTTPFactory {

    final static HashMap<String, String> PROCESSOR_API_LIST = new HashMap<String, String>();

    static {
        PROCESSOR_API_LIST.put("/api/login", "com.mmc.pages.Login");
        PROCESSOR_API_LIST.put("/api/products", "com.mmc.pages.Products");
        PROCESSOR_API_LIST.put("/api/products/delete", "com.mmc.pages.ProductDelete");
        PROCESSOR_API_LIST.put("/react", "com.mmc.processors.ReactProcessor");
        PROCESSOR_API_LIST.put("/file", "com.mmc.processors.FileProcessor");
        PROCESSOR_API_LIST.put("/report", "com.mmc.processors.ReportProcessor");
    }

    public static AAPIProcessor getApiProcessor(HttpExchange t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = Class.forName(PROCESSOR_API_LIST.get(t.getRequestURI().toString()) == null ? "com.mmc.errors.InvalidUrl" : PROCESSOR_API_LIST.get(t.getRequestURI().toString()));
        Constructor<?> cons = cls.getConstructor(HttpExchange.class);
        return (AAPIProcessor) cons.newInstance(t);
    }

    public static AAPIProcessor getProcessor(HttpExchange t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

        /*
            FIX -> fiexed predifined list of values
            XXX -> and be anything (any string)
            
            http[s]://localhost:8080/           <- index.html (go to React Request)
            http[s]://localhost:8080/api/FIX    <- API request
            http[s]://localhost:8080/file/XXX   <- file request
            http[s]://localhost:8080/report     <- report request (reportName is in body request)
            http[s]://localhost:8080/static/XXX <- React Request
            
         */
        String className = "";
        if (t.getRequestURI().toString().equals("/") || t.getRequestURI().toString().startsWith("/static")|| t.getRequestURI().toString().startsWith("/merchants")) {
            className = "/react";
        }
        if (t.getRequestURI().toString().startsWith("/api")) { //expected example: /api/login
            className = t.getRequestURI().toString();//in this case the value is /api/login
        }
        if (t.getRequestURI().toString().startsWith("/file")) {
            className = "/file";
        }
        if (t.getRequestURI().toString().startsWith("/report")) {
            className = "/report";
        }        
        System.out.println("     className=" + className);
        Class<?> cls = Class.forName(PROCESSOR_API_LIST.get(className) == null ? "com.mmc.errors.InvalidUrl" : PROCESSOR_API_LIST.get(className));
        Constructor<?> cons = cls.getConstructor(HttpExchange.class);
        return (AAPIProcessor) cons.newInstance(t);
    }
}
