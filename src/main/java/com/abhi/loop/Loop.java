package com.abhi.loop;

public class Loop {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// print odd number
		/*
		 * for (int i = 0; i < 100; i++) { if(i%2==0){ continue; }
		 * System.out.println(i); }
		 */

		// print even number
		for (int i = 1; i < 100; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
}
