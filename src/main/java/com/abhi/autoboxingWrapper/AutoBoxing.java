package com.abhi.autoboxingWrapper;

public class AutoBoxing {
	
	static Integer i;
	
	public static void print(int i) {
		System.out.println("In print int method: " + i);
	}
	
	public static void print(Long i) {
		System.out.println("In print long method: " + i);
	}
	
	public static void print(Object obj) {
		System.out.println("In print object method: " + obj);
	}
	

	
	public static void main(String[] args) {
		Integer x1 = 10;
		int x = 123;
		/*Integer y1 = 10;
		System.out.println(x1==y1);//true, -128 to 127 pre object is created once class is loaded.

		Integer x2 = 10;
		Integer y2 = new Integer(10);
		System.out.println(x2==y2);//false

		Integer x3 = 1000;
		Integer y3 = 1000;
		System.out.println(x3==y3);//false
		
		Integer x4 = 1000;
		Integer y4 = x4;
		System.out.println(x4==y4);//true
		
		Integer x5 = 1000;
		Integer y5 = Integer.valueOf(1000);
		System.out.println(x5==y5);//false
		
		Integer x6 = 100;
		Integer y6 = Integer.valueOf(100);
		System.out.println(x6==y6);//true
*/		
		Integer y = i;
		System.out.println(y);
		print(x);//widening has preference over autoboxing/unboxing and autoboxing/unboxing has prefrence over var-args.
	}
}

