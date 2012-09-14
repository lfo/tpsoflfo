package com.bissy.distrib.bookstore.server;

import javax.xml.ws.Endpoint;

/**
 *
 * @author lforet
 */
public class BookStoreServerMain {

    public static void main(String... args) throws InterruptedException {
        System.out.println("Starting Server");
        BookStoreWS webSerbiceImpl = new BookStoreWS();
        String address = "http://localhost:9000/bookStore";
        Endpoint.publish(address, webSerbiceImpl);
        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
