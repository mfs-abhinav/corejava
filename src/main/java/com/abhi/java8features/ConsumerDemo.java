package com.abhi.java8features;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c1 = (s1) -> System.out.println("Print from consumer1: " + s1);
        c1.accept("Hello World");

        Consumer<String> c2 = (s2) -> System.out.println("Print from consumer2: " + s2);
        Consumer<String> c3 = c1.andThen(c2);
        c3.accept("Hello");

        BiConsumer<String, Integer> biConsumer = (x, y) -> System.out.println("Name is: " + x + " and age is: " + y);
        biConsumer.accept("Abhinav", 31);
    }
}
