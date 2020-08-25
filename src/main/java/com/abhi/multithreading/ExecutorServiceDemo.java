package com.abhi.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
	
	public static void main(String[] args) {
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("No of processor is: " + coreCount);
		
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		
		for (int i = 0; i < 100; i++) {
			// service.execute(new CpuIntensiveTask());
			// service.submit(new CpuIntensiveTask());
			new Thread(new CpuIntensiveTask()).start();
		}
	}
	
	static class CpuIntensiveTask implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thread is running " + Thread.currentThread().getName());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
