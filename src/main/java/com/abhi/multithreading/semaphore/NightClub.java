package com.abhi.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class NightClub {
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
