package com.interview.promoengine.exception;

/**
 * Exception to handle if other products are entered by user
 */
public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String productType) {
		super("Entered product is invalid " + productType);
	}

}
