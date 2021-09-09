package com.abhi.java8features;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[10];
        numbers[1] = 1;
//        System.out.println(num);
        Optional<Integer> num = Optional.ofNullable(numbers[1]);

        Integer result = num.isPresent() ? num.get() : null;
        System.out.println("result = " + result);

        System.out.println("Optional of empty: " + getOptionalOfEmpty());

        Integer result1 = num.orElse(-1);
        System.out.println("result1 using: orElse = " + result1);

        Integer result2 = num.orElseGet(() -> -1);
        System.out.println("result2 using: orElseGet = " + result2);

        try {
            Integer result3 = num.orElseThrow(Exception::new);
            System.out.println("result3 using: orElseThrow = " + result3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        num.ifPresent((s) -> System.out.println("result4 using: ifPresent = " + s));

    }

    private static Optional<String> getOptionalOfEmpty() {
        String[] words = new String[10];
        Optional<String> num = Optional.ofNullable(words[1]);
        return num.isPresent() ? num : Optional.empty();
    }

}
