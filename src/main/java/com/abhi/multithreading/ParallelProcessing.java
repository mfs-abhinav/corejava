package com.abhi.multithreading;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MyTask {
    private final int duration;
    public MyTask(int duration) {
        this.duration = duration;
    }
    public int calculate() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(duration * 1000);
        } catch (final InterruptedException e) {
            throw  new RuntimeException(e);
        }
        return duration;
    }
}

class GetTaskList {
    public static List<MyTask> getTaskList() {
        return IntStream.range(0,10).mapToObj(i -> new MyTask(1)).collect(Collectors.toList());
    }
}

public class ParallelProcessing {
    public static void main(String[] args) {
        List<MyTask> tasks = GetTaskList.getTaskList();
        sequentialApproach(tasks);
        parallelStreamApproach(tasks);
        completableFutureApproach(tasks);
        completableFutureWithCustomExecutorApproach(tasks);
    }

    private static void completableFutureWithCustomExecutorApproach(List<MyTask> tasks) {
        long start = System.nanoTime();
        ExecutorService executors = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Integer>> futures = tasks.stream()
                .map(t -> CompletableFuture.supplyAsync(() -> t.calculate(), executors)).collect(Collectors.toList());

        List<Integer> result = futures.stream().map(f -> f.join()).collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.printf("completableFutureWithCustomExecutorApproach:- processed %d task in %d millis\n", tasks.size(), duration);
        System.out.println(result);

    }

    private static void completableFutureApproach(List<MyTask> tasks) {
        long start = System.nanoTime();
        List<CompletableFuture<Integer>> futures = tasks.stream()
                .map(t -> CompletableFuture.supplyAsync(() -> t.calculate())).collect(Collectors.toList());
        List<Integer> result = futures.stream().map(f -> f.join()).collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.printf("completableFutureApproach:- processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
    }

    private static void parallelStreamApproach(List<MyTask> tasks) {
        long start = System.nanoTime();
        List<Integer> result = tasks.parallelStream().map(MyTask::calculate).collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.printf("parallelStreamApproach:- Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
    }

    private static void sequentialApproach(List<MyTask> tasks) {
        long start = System.nanoTime();
        List<Integer> result = tasks.stream().map(MyTask::calculate).collect(Collectors.toList());
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.printf("sequentialApproach:- Processed %d tasks in %d millis\n", tasks.size(), duration);
        System.out.println(result);
    }
}
