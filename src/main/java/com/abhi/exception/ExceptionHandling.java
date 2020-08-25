package com.abhi.exception;

public class ExceptionHandling {
	public static void main(String[] args) throws BadFoodException{
		//doStuff();
		checkFood("salty");
	}
	
	static public void checkFood(String food) throws BadFoodException{
		if(food == "sweet") {
			System.out.println("I like the sweet food");
		} else {
			throw new BadFoodException();
		}
	}

	static void doStuff() {
		try {
			doMoreStuff();
		} catch (Exception th) {
			System.out.println("In catch block" + th.getMessage());
		} finally {
			System.out.println("In finally block");
		}
	}

	static void doMoreStuff() throws Exception {
		throw new Exception();
	}

	/*static public void doStuff() throws Exception {
		try {
			// risky IO things
		} catch (Exception ex) {
			// can't handle it
			throw ex; // Can't throw it unless you declare it
		}
	}*/
}
