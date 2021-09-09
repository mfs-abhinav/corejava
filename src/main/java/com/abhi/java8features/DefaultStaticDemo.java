package com.abhi.java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultStaticDemo implements Calculator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Nita","Banti", "Rahul", "Abhinav", "Cat");

//        Collections.sort(names);
        names.sort(Comparator.naturalOrder());
        System.out.println(names);

        Calculator cal = new DefaultStaticDemo();
        System.out.println("Divide:" + Calculator.divide(4 , 3));
        System.out.println("Subtract:" + cal.subtract(10 , 3));
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("Subtract from override");
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        System.out.println("Multiply from override");
        return a * b;
    }
}

@FunctionalInterface
interface Calculator {

    int add(int a, int b);

    default int subtract(int a, int b) {
        return a - b;
    }

    default int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }

}