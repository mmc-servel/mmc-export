package com.mmc.backend;

import java.io.InputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.lang.*;
import java.net.URL;
import com.sun.net.httpserver.HttpsServer;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import com.sun.net.httpserver.*;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

import java.net.InetAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsExchange;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.flywaydb.core.Flyway;
import org.json.JSONObject;

public class MainClass {
    
    public static void main(String[] args) throws IOException {
        //System.setProperty("log.name", "mkyong");
        //java -jar C:\work\NetBeansProjects\ehk\backend\target\backend-1.0.0-jar-with-dependencies.jar c:\work\config.json
        if (args.length > 0) {
            com.mmc.api.utils.Config.create(args[0]); //see file example on backend/config.json
        } else {
            System.out.print("Please provide config file-name as a parameter.");
            System.exit(0);
        }

        //just check if index file exists
        InputStream is = MainClass.class.getClassLoader().getResourceAsStream("WEB-INF/index.html");
        if (is == null) {
            System.out.println("Error: InputStream is null");
            return;
        } else {
            is.close();
        }
        //https://www.tabnine.com/code/java/methods/org.flywaydb.core.Flyway/configure
        //Flyway flyway = Flyway.configure().dataSource(dataSource).locations("classpath:db/migration", "filesystem:db/migration").baselineOnMigrate(true).load();
        //TO DO - get connection string from config file
        /* Flyway flyway = Flyway.configure().dataSource("jdbc:oracle:thin:@localhost:1521/pdb01.endava.net", "user01", "user01").locations("classpath:WEB-INF/flyway").load();
        flyway.migrate();*/
        
        
        //435696******0781 - huge
        //402811******5323 - small
        HttpServer server = HttpServer.create(new InetSocketAddress(Integer.parseInt(com.mmc.api.utils.Config.getValueByKey("port"))), 0);
        //HttpsServer server = getHttpsServer(); //In case httpS protocol is wanted
        if (server == null) {
            System.out.println("ERROR: Error creating the server. Check log file.");
            System.exit(-1);
        }
        server.createContext("/", new HTTPProcessor());
        server.setExecutor(null); // creates a default executor      
        server.start();
        
        System.out.println("------END OF MAIN------");
    }
    
    public static HttpsServer getHttpsServer() {
        try {
            System.out.println("Address=" + InetAddress.getLocalHost().getHostAddress());
            // Set up the socket address
            InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8000);

            // Initialise the HTTPS server
            HttpsServer httpsServer = HttpsServer.create(address, 0);
            SSLContext sslContext = SSLContext.getInstance("TLS");

            // Initialise the keystore
            char[] password = "simulator".toCharArray();
            KeyStore ks = KeyStore.getInstance("JKS");
            
            InputStream fis = MainClass.class.getClassLoader().getResourceAsStream("WEB-INF/lig.keystore");
            ks.load(fis, password);

            // Set up the key manager factory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, password);

            // Set up the trust manager factory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks);

            // Set up the HTTPS context and parameters
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
            httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
                @Override
                public void configure(HttpsParameters params) {
                    try {
                        // Initialise the SSL context
                        SSLContext c = SSLContext.getDefault();
                        SSLEngine engine = c.createSSLEngine();
                        params.setNeedClientAuth(false);
                        params.setCipherSuites(engine.getEnabledCipherSuites());
                        params.setProtocols(engine.getEnabledProtocols());

                        // Get the default parameters
                        SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
                        params.setSSLParameters(defaultSSLParameters);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            return httpsServer;
            
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException ex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
