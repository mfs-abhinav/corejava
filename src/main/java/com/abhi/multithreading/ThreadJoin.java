package com.abhi.multithreading;

public class ThreadJoin extends Thread {
	
	public ThreadJoin(String name) {
		super.setName(name);
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " value is " + i);
		}
	}

	public static void main(String args[]) {
		ThreadJoin t1 = new ThreadJoin("Thread 1");
		ThreadJoin t2 = new ThreadJoin("Thread 2");
		ThreadJoin t3 = new ThreadJoin("Thread 3");
		t1.start();
		t2.start();
		try {
			t1.join(1500);
		} catch (Exception e) {
			System.out.println(e);
		}

		t3.start();
	}
}
