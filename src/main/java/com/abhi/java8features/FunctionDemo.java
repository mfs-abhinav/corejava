package com.abhi.java8features;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> sqrt = (x) -> (int) Math.sqrt(x);
        System.out.println(sqrt.apply(81));

        Function<Integer, Integer> incrementby5 = (x) -> x+5;
        System.out.println(incrementby5.compose(sqrt).apply(84));

        BiFunction<Integer, Integer, Integer> add = (x,y) -> x+y;
        System.out.println(add.apply(10,18));

    }
}
