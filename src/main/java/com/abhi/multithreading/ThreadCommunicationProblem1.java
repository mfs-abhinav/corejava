package com.abhi.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
There are two threads A, B operating on same resource R, A needs to inform B that some important changes
has happened in R, what technique should be used
 */

class MySharedResource<T> {
    private final int capacity;
    Queue<T> queue;

    public MySharedResource(int capacity) {
        this.queue= new LinkedList<>(); // here blocking queue can be used in that case no need to synchronized put/take method because its already thread safe
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(element);
        notify();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        T element = queue.remove();
        notify();
        return element;
    }

}

public class ThreadCommunicationProblem1 {
    private static final int QUEUE_SIZE = 4;
    public static void main(String[] args) {
        MySharedResource<Integer> queue = new MySharedResource<>(QUEUE_SIZE);

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    int i = new Random().nextInt(1000);
                    System.out.println("Producing " + i);
                    queue.put(i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    int j = queue.take();
                    System.out.println("consuming " + j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();

    }
}
