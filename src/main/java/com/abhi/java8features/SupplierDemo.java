package com.abhi.java8features;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Integer> randomNum = () -> (int) (Math.random()*100);
        System.out.println(randomNum.get());
        System.out.println(randomNum.get());
    }
}
