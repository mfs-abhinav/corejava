package com.abhi.java8features;

public class LambdaRunnable {
    public static void main(String[] args) {
        // Traditional way
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                System.out.println("Sum using Traditional way: " + sum);
            }
        };
        new Thread(runnable).start();

        // Lambda approach
        Runnable runnable1 = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("Sum using Lambda way: " + sum);
        };
        new Thread(runnable1).start();

        // latest approach
        new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("Sum using latest way: " + sum);
        }).start();
    }
}
