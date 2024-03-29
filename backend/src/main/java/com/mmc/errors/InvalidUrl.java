package com.mmc.errors;

import com.mmc.processors.AAPIProcessor;
import com.mmc.responce.AResponce;
import com.mmc.responce.StringResponce;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class InvalidUrl extends AAPIProcessor {

    public InvalidUrl(HttpExchange t) {
        super(t);
    }

    @Override
    public AResponce processRequest() throws UnsupportedEncodingException, IOException {
        return new StringResponce(t,"ERROR", "Ivalid request operation.", "{}");
    }

}
