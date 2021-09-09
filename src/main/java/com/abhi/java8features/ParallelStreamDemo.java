package com.abhi.java8features;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        System.out.println("Time taken for Sum using sequential: " + measureSumPerf(ParallelStreamDemo::sumSequential, 20));
        System.out.println("Time taken for Sum using parallel: " + measureSumPerf(ParallelStreamDemo::sumParallel, 20));

        System.out.println("Time taken for Sort using sequential: " + measureSortPerf(ParallelStreamDemo::sortSequential, 20));
        System.out.println("Time taken for Sort using parallel: " + measureSortPerf(ParallelStreamDemo::sortParallel, 20));
    }

    private static long sumSequential() {
        return IntStream.rangeClosed(0, 50000).sum();
    }

    private static long sumParallel() {
        return IntStream.rangeClosed(0, 50000).parallel().sum();
    }

    private static long measureSumPerf(Supplier<Long> supplier, int loopCount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            supplier.get();
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long sortSequential() {
        List<RandomId> randomIdList = LongStream.rangeClosed(0, 50000)
                .mapToObj(i -> new RandomId(i, ThreadLocalRandom.current().nextInt(50000)))
                .collect(Collectors.toList());

        randomIdList.stream().sorted(Comparator.comparing(RandomId::getToken));

        return -1;
    }

    private static long sortParallel() {
        List<RandomId> randomIdList = LongStream.rangeClosed(0, 50000)
                .parallel()
                .mapToObj(i -> new RandomId(i, ThreadLocalRandom.current().nextInt(50000)))
                .collect(Collectors.toList());

        randomIdList.stream().parallel().sorted(Comparator.comparing(RandomId::getToken));

        return -1;
    }

    private static long measureSortPerf(Supplier<Long> supplier, int loopCount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            supplier.get();
        }
        return System.currentTimeMillis() - startTime;
    }
}

class RandomId {
    private long id;
    private long token;

    public RandomId(long id, long token) {
        this.id = id;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }
}
