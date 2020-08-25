package com.abhi.multithreading.atomicvariable;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariable {
	private volatile int counter;
	
	public void increment() {
		counter++;
	}
	
	public int getCounter() {
		return this.counter;
	}
}


class Main {
	private static AtomicInteger counter;
	public static void main(String[] args) {
		counter = new AtomicInteger();
		counter.incrementAndGet();
	}
}