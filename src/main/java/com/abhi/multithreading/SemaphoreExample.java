package com.abhi.multithreading;

import java.util.concurrent.Semaphore;

class NightClub {
	private Semaphore sem;

	public NightClub() {
		this.sem = new Semaphore(2);
	}

	public void enterIntoClub() throws InterruptedException {
		this.sem.acquire();
		System.out.println(Thread.currentThread().getName() + " entered into night club");
	}

	public void leaveFromClub() {
		this.sem.release();
		System.out.println(Thread.currentThread().getName() + " leaved from night club");
	}
}

public class SemaphoreExample implements Runnable {
	
	private static NightClub nightClub;
	
	public static void main(String[] args) {
		nightClub = new NightClub();
		
		for(int i=0; i<5; i++) {
			new Thread(new SemaphoreExample()).start();
		}
	}

	@Override
	public void run() {
		// while(true) {
			try {
				nightClub.enterIntoClub();
				
				nightClub.leaveFromClub();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// }
	}

}
