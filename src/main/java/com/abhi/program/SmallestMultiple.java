package com.abhi.program;

public class SmallestMultiple {

	public static void main(String[] args) {
		long num = 1;
		while (num > 0) {
			int counter = 0;
			for (int i = 1; i <= 20; i++) {
				if (num % i != 0) {
					break;
				} else {
					counter++;
				}
			}
			if(counter==20){
				break;
			} else {
				num++;
			}
		}
		System.out.println(num);

	}
}
