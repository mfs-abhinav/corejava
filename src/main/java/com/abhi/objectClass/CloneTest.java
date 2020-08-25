package com.abhi.objectClass;

class B {
	public int x;

	public B(int no) {
		x = no;
	}
	
	@Override
	public String toString() {
		return "[B: x=" + x + "]";
	}
}

class A implements Cloneable {
	public B b;
	public int y;

	public A(B b, int no) {
		this.b = b;
		y = no;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		//return super.clone();//object class clone method do 'shallow coloning'
		return new A(new B(this.b.x),this.y);//this is called 'deep cloning'
	}
	
	@Override
	public String toString() {
		return "[A: b=" + b.toString() + " and y=" + y + "]";
	}
}

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		A obj = new A(new B(10), 20);
		System.out.println("Original object is: " + obj);
		A cObj = (A) obj.clone();
		System.out.println("Clone object is: " + cObj);
		cObj.y = 50;
		cObj.b.x = 100;
		System.out.println("After object manupulation");
		
		System.out.println("Original object is: " + obj);
		System.out.println("Clone object is: " + cObj);
		
	}
}
