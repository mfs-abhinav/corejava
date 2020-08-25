package com.abhi.string;
// in additional to string all wrapper class object also are immutable in java.
public class StringTest {
	public static void main(String[] args) {
		String s1 = new String("you can not change me!");
		String s2 = new String("you can not change me!");
		String s3 = "you can not change me!";
		String s4 = "you can not change me!";
		String s5 = "you can not " + "change me!";
		String s6 = "you can not ";
		String s7 = s6 + "change me!";
		final String s8 = "you can not ";
		String s9 = s8 + "change me!";
		String s10 = s6.concat("change me!");
		
		
		
		System.out.println(s1==s2);//false
		System.out.println(s3==s4);//true
		System.out.println(s1==s3);//false
		System.out.println(s4==s5);//true--both are constant and resolved at compile time
		System.out.println(s4==s7);//false--here one is constant and other is variable.It is not final, it may change
		System.out.println(s4==s9);//true--varible is final so both is constant and reselove at compile time.
		System.out.println(s10==s4);//false--here concat is perform at runtime and new obj is created in heap.
		
		
		String s11 = s1.intern();//intern point to the scp refernece of heap object
		System.out.println(s1==s11);//false
		System.out.println(s3==s11);//true
		
		String s12 = new String("Abhinav");
		String s13 = s12.concat("Kumar");
		String s14 = s13.intern();//intern point to the scp refernece of heap object if not found new one is created and its ref is passed.
		String s15 = "AbhinavKumar";
		System.out.println(s13==s14);//true; 
		System.out.println(s13==s15);//true;
		System.out.println(s14==s15);//true;
	}

}
