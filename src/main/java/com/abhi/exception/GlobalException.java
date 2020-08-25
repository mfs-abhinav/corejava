package com.abhi.exception;

@SuppressWarnings("serial")
public class GlobalException extends RuntimeException {
	
	public GlobalException() {
		System.out.println("Exception is occured.");
	}
	
	public GlobalException(String message) {
		super(message);	
	}
}
