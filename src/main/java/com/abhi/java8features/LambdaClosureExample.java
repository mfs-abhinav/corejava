package com.abhi.java8features;

import java.util.function.Consumer;

public class LambdaClosureExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        doProcess(a, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
//                b = 40; value cann't be changed
                System.out.println(a + b); // here b variable is available, this is type of clousre
            }
        });
        doProcess(a, (i) -> System.out.println(i + b));
    }
    private static void doProcess(int a, Consumer<Integer> consumer) {
        consumer.accept(a);
    }
}
