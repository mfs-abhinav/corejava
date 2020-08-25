package com.abhi.multithreading;

class SharedCode {
	// public synchronized void process(int n) {
//	public void process(int n) {
//		synchronized(this) {
//			for(int i=1; i<=5; i++) {
//				System.out.println(i*n);
//				try {
//					Thread.sleep(400);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	public static void process(int n) {
		synchronized(SharedCode.class) {
			for(int i=1; i<=5; i++) {
				System.out.println("Thread name is-" + Thread.currentThread().getName() + " Value is- " + i*n);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

public class SynchronizedDemo {

	public static void main(String args[]) {
//		SharedCode obj1 = new SharedCode();
//		SharedCode obj2 = new SharedCode();
		
		Thread t1 = new Thread() {
			public void run() {
				// obj1.process(5);
				SharedCode.process(5);
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				// obj1.process(100);
				SharedCode.process(100);
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				// obj2.process(5);
				SharedCode.process(5);
			}
		};
		
		Thread t4 = new Thread() {
			public void run() {
				// obj2.process(100);
				SharedCode.process(100);
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
