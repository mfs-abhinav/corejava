package com.abhi.program;

import java.util.TreeSet;

public class Palindrome {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		for (int i = 100; i < 1000; i++) {
			for(int j=999; j>=100; j--){
				if (i*j == reverse(i*j)) {
					//list.add(i*j);
					treeSet.add(i*j);
				}
			}
		}
		System.out.println(treeSet.last());
	}

	public static int reverse(int number) {
		int reverseNumber = 0;

		while (number > 0) {
			int temp = number % 10;
			reverseNumber = reverseNumber * 10 +  temp;
			number = number/10;
		}

		return reverseNumber;
	}
}
