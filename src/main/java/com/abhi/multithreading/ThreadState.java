package com.abhi.multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadState {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread is " + Thread.currentThread().getState());
		
		Runnable task = () -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Running long task");
		};
		
		Thread t = new Thread(task);
		System.out.println("State of thread before start is " + t.getState());
		
		t.start();
		System.out.println("State of thread after start is " + t.getState());
		
		t.join();
		System.out.println("State of thread after finishing is " + t.getState());
		
		Runnable synTask = () -> {
			synchronized (ThreadState.class) {
				System.out.println("Running long task in synchronized");
				
				while(true) {
					
				}
			}
		};

		Thread t1 = new Thread(synTask);
		Thread t2 = new Thread(synTask);
		t1.start();
		t2.start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("State of thread " + t1.getState() + " " + t2.getState());
		
		// demoBlockedState();
		
	}
	
	public static void demoBlockedState() {
		System.out.println();
		final Object lock = new Object();

		Runnable waitALittle = () -> {
			synchronized (lock) {
				System.out.println("Wait a little...");
				while (true) {
					// it will take forever!
					// let's block everything!!
				}
			}
		};

		Thread iAmBusy = new Thread(waitALittle);
		Thread iAmBusyToo = new Thread(waitALittle);

		iAmBusy.start();
		iAmBusyToo.start();

		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("First thread: " + iAmBusy.getState());
		System.out.println("Second thread: " + iAmBusyToo.getState());
	}

}
