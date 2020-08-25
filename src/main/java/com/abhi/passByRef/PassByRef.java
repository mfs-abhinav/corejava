package com.abhi.passByRef;

public class PassByRef {
	private Bar bar;

	public PassByRef() {
		this.bar = new Bar();
	}

	public Bar getBar() {
		return bar;
	}

	void makeChange(Bar obj){
		obj.setBarNum(99);
		System.out.println("bar num is " + obj.getBarNum());

		// We changed reference to refer some other location
		// now any changes made to reference are not reflected
		// back in main
		obj = new Bar();
		obj.setBarNum(200);
		System.out.println("new bar num is " + obj.getBarNum());
	}
	
	public static void main(String[] args){
		// passByRef is a reference
		PassByRef passByRef = new PassByRef();
		
		System.out.println("original bar num is " + passByRef.getBar().getBarNum());

		// Reference is passed and a copy of reference
		// is created in makeChange()
		passByRef.makeChange(passByRef.getBar());
		
		System.out.println("original bar num is " + passByRef.getBar().getBarNum());

		Integer i = new Integer(10);
		Integer j = new Integer(20);
		swap(i, j);
		System.out.println("i = " + i + ", j = " + j);
	}

	// swap() doesn't swap i and j
	public static void swap(Integer i, Integer j) {
		Integer temp = new Integer(i);
		i = j;
		j = temp;
	}
}

class Bar{
	private int barNum;

	public int getBarNum() {
		return barNum;
	}

	public void setBarNum(int barNum) {
		this.barNum = barNum;
	}
}
