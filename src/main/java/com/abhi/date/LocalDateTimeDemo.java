package com.abhi.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalDateTimeDemo {

    public static void main(String[] args) {
        String str = "2021-07-01T12:44:47.486656Z";
        Date dt;
        try {
            dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e) {
            dt = null;
        }
        System.out.println(dt);
    }
}
