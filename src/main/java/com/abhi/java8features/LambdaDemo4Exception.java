package com.abhi.java8features;

import java.util.function.BiConsumer;

public class LambdaDemo4Exception {
    public static void main(String[] args) {
        int[] numbers = { 1 };
        int key = 0;

        // one way to handle exception is here, but in this way code is not clean
        // 2nd option is handle exception in wrapperlambda function, it can be made generic
//        performOperation(numbers, key, (n, k) -> {
//            try {
//                System.out.println(n / k);
//            } catch (ArithmeticException e) {
//                System.out.println("ArithmeticException occurred " + e.getMessage());
//            }
//        });
//        performOperation(numbers, key, (n, k) -> System.out.println(n / k));
        performOperation(numbers, key, wrapperLambdaGeneric((n, k) -> System.out.println(n / k)));
    }

    private static void performOperation(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int num : numbers) {
            // one way to handle exception here, but this should not be recommended.
//            try {
//                consumer.accept(num, key);
//            } catch (ArithmeticException e) {
//                System.out.println("ArithmeticException occurred " + e.getMessage());
//            }
            consumer.accept(num, key);
        }
    }

    // TODO- convert below method in generic form
    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (n, k) -> {
            try {
                consumer.accept(n, k);
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException caught in wrapper lambda " + e.getMessage());
            }
        };
    }

    private static <T, G> BiConsumer<T, G> wrapperLambdaGeneric(BiConsumer<T, G> consumer) {
        return (n, k) -> {
            try {
                consumer.accept(n, k);
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException caught in wrapper lambda " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
}
