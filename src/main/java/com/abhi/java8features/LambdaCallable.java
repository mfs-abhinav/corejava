package com.abhi.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class LambdaCallable {
    private static int[] arr = IntStream.rangeClosed(0,5000).toArray();
    private static long arrSum = IntStream.rangeClosed(0,5000).sum();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Traditional way
        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                long sum = 0;
                for (int i = 0; i<=5000; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future result =  executorService.submit(callable1);
        System.out.println("array sum using method: " + arrSum + " and using traditional: "+ result.get());

        // lambda way
        Callable callable2 = () -> {
            long sum = 0;
            for (int i = 0; i<arr.length/2; i++) {
                sum += arr[i];
            }
            return sum;
        };

        Callable callable3 = () -> {
            long sum = 0;
            for (int i = arr.length/2; i<arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        };
        List<Callable<Long>> tasks = Arrays.asList(callable2, callable3);
        List<Future<Long>> futureResults = executorService.invokeAll(tasks);

        long futureSum = 0;
        for (Future<Long> futureResult : futureResults) {
            futureSum += futureResult.get();
        }
        System.out.println("array sum using method: " + arrSum + " and using lambda: "+ futureSum);
        executorService.shutdown();
    }
}
