package com.abhi.Inheritance;

public class Horse extends Animal{
	Horse(){
		super(0);
		System.out.println("In Horse default constructor");
	}
	Horse(int count){
		super(10);
		System.out.println("In Horse arg constructor"+count);
	}
	public void print(){
		System.out.println("In Horse print method");
	}

}
