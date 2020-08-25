package com.abhi.passByRef;

public class PassByRef {
	Bar bar = new Bar();
	
	void makeChange(Bar obj){
		obj.setBarNum(99);
		System.out.println("bar num is" + obj.getBarNum());
		
		obj = new Bar();
		obj.setBarNum(200);
		System.out.println("new bar num is" + obj.getBarNum());
		
	}
	
	public static void main(String[] args){
		PassByRef passByRef = new PassByRef();
		
		System.out.println("original bar num is" + passByRef.bar.getBarNum());
		
		passByRef.makeChange(passByRef.bar);
		
		System.out.println("original bar num is" + passByRef.bar.getBarNum());
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
