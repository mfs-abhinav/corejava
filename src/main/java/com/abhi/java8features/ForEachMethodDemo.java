package com.abhi.java8features;

import java.util.ArrayList;
import java.util.List;

public class ForEachMethodDemo {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("test1");
        items.add("vhjbj");
        items.add("vhjvj");

        items.forEach((x) -> System.out.println(x));
        items.forEach(System.out::println);
    }
}
