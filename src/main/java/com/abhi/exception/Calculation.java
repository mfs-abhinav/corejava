package com.abhi.exception;

public class Calculation {
	
	public int divide(int a, int b) {
		if (b == 0) {
			throw new GlobalException("divide by zero");
		}
		return a/b;
	}
}
