package com.abhi.multithreading;

class MyThread1 implements Runnable {
	Thread th;
	String name;

	MyThread1(String name) {
		th = new Thread(this, name);
		th.start();
	}

	public void run() {
		System.out.println("My thread1 is running " + th.getName());
		
	}
			
}

class MyThread2 extends Thread {
	
	MyThread2(String name) {
		super(name);
		start();
	}
	
	public void run() {
		System.out.println("My thread2 is running " + this.getName());
		
	}
	
}

public class ThreadBasic {

	public static void main(String [] args) {
		Thread th = Thread.currentThread();
		
		//System.out.println(th.getName());
		
		//th.setName("AbhiMainThread");
		//System.out.println(th.getName());
		
		//System.out.println(th.getThreadGroup());
		
		// Thread.sleep(1000);
		
		new MyThread1("AbhiThread1");
		
		new MyThread2("AbhiThread2");
		
		
		// create thread using anonymous class 
		Thread t = new Thread(()->{
			System.out.println("anonymous thread is running");
			
		},"Annonymus");
		
		t.start();
		
		System.out.println(th.getName());
		
	}
}
