package com.abhi.string;

import java.net.MalformedURLException;
import java.net.URL;

public class ExtractHostName {
    public static void main(String[] args) throws MalformedURLException {
        String urlString = "http://localhost/ssoemulator";
        java.net.URL url = new URL(urlString);
        System.out.println(url.getProtocol() + "://" + url.getHost());
    }
}
