
package com.mmc.responce;

import com.sun.net.httpserver.HttpExchange;
import java.io.InputStream;

public abstract class AResponce {
    public final HttpExchange t;
    public final InputStream is;
    public AResponce(HttpExchange t,InputStream is) {
        this.t = t;
        this.is=is;
    }    
    abstract public void sendResponce();
}
