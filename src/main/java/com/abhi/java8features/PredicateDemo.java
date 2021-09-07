package com.abhi.java8features;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> p1 = (x) -> x > 0;
        System.out.println(p1.test(10));

        Predicate<Integer> p2 = (x) -> x % 2 == 0;
        System.out.println(p1.and(p2).test(20));
        System.out.println(p1.and(p2.negate()).test(20));
        System.out.println(p1.and(p2.negate()).test(21));
        System.out.println(p1.or(p2).test(21));

        BiPredicate<String, Integer> p3 = (x, y) -> x.length() > 5 && y > 20;
        System.out.println(p3.test("Abhinav", 30));
        System.out.println(p3.test("Abhi", 30));

    }
}
