package com.abhi.program;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

	public static void main(String[] args) {
		long number = 600851475143l;
		List<Long> list = new ArrayList<Long>();

		for (long i = 2; i < number; i++) {
			if (number % i == 0) {
				list.add(i);
				number = number / i;
			}
		}
		list.add(number);
		
	}

}
