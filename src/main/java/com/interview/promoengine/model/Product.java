package com.interview.promoengine.model;

public class Product {

	private String SkuId;

	private float price;

	public Product(String skuId) {
		super();
		SkuId = skuId;
	}

	public String getSkuId() {
		return SkuId;
	}

	public void setSkuId(String skuId) {
		SkuId = skuId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
