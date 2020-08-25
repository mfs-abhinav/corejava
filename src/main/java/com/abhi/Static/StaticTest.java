package com.abhi.Static;

public class StaticTest {
	
	static int counter;
	
	StaticTest() {
		counter++;
	}
	
	public static void display(){
		System.out.println("no of object is "+ counter);
	}
	
	public static void main(String []args){
		new StaticTest();
		new StaticTest();
		new StaticTest();
		
		display();
	}
	
}


