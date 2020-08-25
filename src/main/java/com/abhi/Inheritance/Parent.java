package com.abhi.Inheritance;

public class Parent {
	int i = 10;
		
	public Parent display(){
		System.out.println("In parent display method");
		return null;
	}
	
	public static void main(String args[]) {
		Parent obj = new A();
		System.out.println(obj.i);
	}
	
}
