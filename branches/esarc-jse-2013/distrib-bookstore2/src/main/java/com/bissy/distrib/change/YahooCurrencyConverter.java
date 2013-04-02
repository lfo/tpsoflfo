package com.bissy.distrib.change;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class YahooCurrencyConverter {

    public static float convert(String currencyFrom, String currencyTo) throws Exception {
        URL url = new URL("http://quote.yahoo.com/d/quotes.csv?s=" + currencyFrom + currencyTo + "=X&f=l1&e=.csv");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        String read = new BufferedReader(new InputStreamReader((InputStream) urlConnection.getContent())).readLine();
        return Float.parseFloat(read);
    }

    public static void main(String[] args) {
        YahooCurrencyConverter ycc = new YahooCurrencyConverter();
        try {
            float current = ycc.convert("USD", "EUR");
            System.out.println(current);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
