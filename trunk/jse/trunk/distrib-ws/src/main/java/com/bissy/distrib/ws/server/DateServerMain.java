package com.bissy.distrib.ws.server;

import javax.xml.ws.Endpoint;

/**
 *
 * @author lforet
 */
public class DateServerMain {
    
    
    public static void main(String... args) throws InterruptedException {
         System.out.println("Starting Server");
        DateServiceWS webSerbiceImpl = new DateServiceWS();
        String address = "http://localhost:9000/dateService";
        Endpoint.publish(address, webSerbiceImpl);
        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
