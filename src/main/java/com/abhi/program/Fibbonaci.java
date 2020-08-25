package com.abhi.program;

import java.util.ArrayList;
import java.util.List;

public class Fibbonaci {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		int number = 0;
		int sum = 0;
		
		while (number >= 0) {
			number = list.get(list.size() - 1) + list.get(list.size() - 2);
			if (number > 4000000) {
				break;
			}
			list.add(number);
			if(number % 2 == 0) {
				sum = sum + number;
			}
		}
		
		System.out.println(sum);
	}
}
