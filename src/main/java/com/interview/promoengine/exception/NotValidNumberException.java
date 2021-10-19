package com.interview.promoengine.exception;

/**
 * Exception to handle if user enters other than numbers
 */
public class NotValidNumberException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NotValidNumberException() {
		super("Enter valid number ");
	}

}
