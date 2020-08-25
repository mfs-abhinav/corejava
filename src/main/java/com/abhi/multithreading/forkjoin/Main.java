package com.abhi.multithreading.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<100; i++) {
			list.add(i*i);
		}
		
		CalculateSum task = new CalculateSum(list, 0, list.size()-1);
		ForkJoinPool pool = ForkJoinPool.commonPool();
		int result = pool.invoke(task);
		
		System.out.println("Sum of array using forkjoin is " + result);
		System.out.println("Sum of array using stream method is " + list.stream().reduce(0, Integer::sum));
		
		int sum=0;
		for (int i: list) {
			sum += i;
		}
		System.out.println("Sum of array using loop is " + sum);
	}

}

class CalculateSum extends RecursiveTask<Integer> {
	
	private static final long serialVersionUID = 1L;
	private final List<Integer> list;
	private final int startIndex;
	private final int lastIndex;
	private final int taskThreashold = 4;
	
	public CalculateSum(List<Integer> list, int startIndex, int lastIndex) {
		this.list = list;
		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
	}

	@Override
	protected Integer compute() {
		
		if (lastIndex - startIndex < taskThreashold) {
			return doCompute();
		}
		
		int midPoint = (startIndex + lastIndex)/2;
		
		CalculateSum leftSum = new CalculateSum(list, startIndex, midPoint);
		CalculateSum rightSum = new CalculateSum(list, midPoint+1, lastIndex);
		
		leftSum.fork();
		return rightSum.compute() + leftSum.join();
	}
	
	private Integer doCompute() {
		return IntStream.rangeClosed(startIndex, lastIndex)
				.map(i -> list.get(i))
				.sum();
	}

	
}
