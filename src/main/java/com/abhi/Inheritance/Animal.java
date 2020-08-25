package com.abhi.Inheritance;

public class Animal {
	Animal(){
		System.out.println("In animal default constructor");
	}
	
	Animal(int count){
		System.out.println("In animal arg constructor"+count);
	}
	
	public void print() {
		System.out.println("In Animal print method");
	}
}
