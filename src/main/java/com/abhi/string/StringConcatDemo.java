package com.abhi.string;

import java.util.Date;

public class StringConcatDemo extends Object {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        long time1 = new Date().getTime();
        for (int i=0; i<100000; i++) {
            s1 = s1 + s2;
        }
        System.out.print("Time taken with string concat: ");
        System.out.println(new Date().getTime() - time1);

        StringBuffer s3 = new StringBuffer("Hello");
        String s4 = "World";
        long time2 = new Date().getTime();
        for (int i=0; i<100000; i++) {
            s3.append(s4);
        }
        System.out.print("Time taken with stringbuffer concat: ");
        System.out.print(new Date().getTime() - time2);
    }
}
