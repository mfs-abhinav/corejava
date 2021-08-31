package com.abhi.Interface;

public interface ITest1 {
	int item = 10;
	void display();
	default int print(int i) {
		System.out.println("print form ITest1 " + i);
		return 20;
	}
}
