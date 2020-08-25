package com.abhi.exception;

public class Main {
	public static void main(String[] args) {

//		try {
//			Calculation obj = new Calculation();
//			obj.divide(10, 0);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		try  
        {  
            throw new Cal();   
        }  
        catch(Cal c){  
            c.add(10,20);  
        }  
	}
}

class Cal extends RuntimeException  
{  
    public Cal()   
    {  
        System.out.println("Calculation class is instantiated");  
    }  
    public void add(int a, int b)  
    {  
        System.out.println("The sum is "+(a+b));  
    }  
} 