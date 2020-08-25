package com.abhi.multithreading.callable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<100; i++) {
			list.add(i*i);
		}
		
		Calculate task1 = new Calculate(list.subList(0, 20));
		Calculate task2 = new Calculate(list.subList(20, 60));
		Calculate task3 = new Calculate(list.subList(60, 90));
		Calculate task4 = new Calculate(list.subList(90, 100));
		
		ForkJoinPool pool = ForkJoinPool.commonPool();
		List<Future<Integer>> results = pool.invokeAll(Arrays.asList(task1, task2, task3, task4));

		int sum = 0;
		for(Future<Integer> result: results) {
			try {
				System.out.println("Sum of sublist " + result.get().intValue());
				sum += result.get().intValue();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Sum of array using callable method " + sum);
	}

}

class Calculate implements Callable<Integer> {
	
	private List<Integer> list;
	
	public Calculate(List<Integer> list) {
		this.list = list;
	}

	@Override
	public Integer call() throws Exception {
		if (list.size() == 10) {
			int x = 10/0;
		}
		return list.stream().reduce(0, Integer::sum);
	}
	
}
