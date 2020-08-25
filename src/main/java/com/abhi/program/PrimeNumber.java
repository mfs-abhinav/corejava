package com.abhi.program;

public class PrimeNumber {
	
	public static void main(String[] args){
		//int number= Integer.parseInt(args[0]);
		int number= 143;
		boolean isPrime = true;
		
		for(int i=2;i<number/2;i++){
			if(number%i==0){
				isPrime = false;
				break;
			}
		}
		System.out.println(number + " is prime ? " + isPrime);
	}

}
