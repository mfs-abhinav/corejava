package com.abhi.string;

final class TestImutable {
	private int i;
	
	public TestImutable(int i) {
		this.i = i;
	}
	
	public TestImutable modify(int i) {
		if (this.i == i) {
			return this;
		} else {
			return new TestImutable(i);
		}
	}
}

public class Imutable {
	public static void main(String[] args) {
		TestImutable obj1 = new TestImutable(10);
		TestImutable obj2 = obj1.modify(100);
		TestImutable obj3 = obj1.modify(10);
		
		System.out.println(obj1==obj2);
		System.out.println(obj1==obj3);
	}
}

class StringImutable {
	private String str;
	
	public StringImutable(String str) {
		this.str = str;
	}
	
}