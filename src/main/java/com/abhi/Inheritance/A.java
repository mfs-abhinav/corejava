package com.abhi.Inheritance;

public class A extends Parent {
	private B item;
	int i = 20;

	public B getItem() {
		return item;
	}

	public void setItem(B item) {
		this.item = item;
	}
	
	

	public A display(){
		super.display();
		System.out.println("In A display method");
		return null;
	}
	
	public void printItem(B obj){
		System.out.println("In A printItem1" + obj);
	}
	
	public void printItem(Parent obj){
		System.out.println("In A printItem2" + obj);
	}

}
