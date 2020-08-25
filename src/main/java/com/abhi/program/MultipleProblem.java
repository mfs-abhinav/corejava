package com.abhi.program;

public class MultipleProblem {
	public static void main(String[] args){
		int firstMultiple = 3;
		int secMultiple = 5;
		
		int number = 1000;
		
		int sum=0;
		
		for(int i=1; i<number;i++){
			if(i%firstMultiple == 0){
				sum = sum + i;
			} else if(i%secMultiple == 0){
				sum = sum + i;
			}
		}
		System.out.println("Sum of multiple is " + sum);
	}

}
