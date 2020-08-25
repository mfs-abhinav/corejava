package com.abhi.assertion;

public class TestAssertion {
	public static void main(String[] args) {
		methodA(0);
	}
	
	static void methodA(int num){
		assert (num>=0);
		System.out.println(num);
	}
}
