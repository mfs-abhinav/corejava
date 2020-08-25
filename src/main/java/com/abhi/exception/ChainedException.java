package com.abhi.exception;

class MyException extends RuntimeException {
	private String exceptionMsg;
	
	MyException() {
		super();
	}
	
	MyException(String msg) {
		super(msg);
		this.exceptionMsg = msg;
	}

	@Override
	public String toString() {
		return "Exception occured " + exceptionMsg;
	}
	
	
}

public class ChainedException {
	
	static void doSomeStuff() {
		
		MyException ex = new MyException("some error occured while processing");
		//ex.initCause(new ArithmeticException("cause"));
		
		throw ex;
	}
	
	public static void main(String [] args) throws MyException {
		try {
			doSomeStuff();
		} catch (MyException e) {
			System.out.println(e);
			System.out.println(e.getCause());
			//throw new MyException("some error occured while processing in main");
		}
	}

}
