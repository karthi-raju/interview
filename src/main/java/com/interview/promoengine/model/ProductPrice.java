package com.interview.promoengine.model;

/**
 * Enum to have the product with its price
 */

public enum ProductPrice {

	A(50),
	B(30),
	C(20),
	D(15),
	COMBOPRICE_C_AND_D(30);

	private float price;

	ProductPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

}
