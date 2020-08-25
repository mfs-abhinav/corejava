package com.abhi.multithreading.semaphore;

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
