package com.interview.promoengine.service;

import java.util.List;
import java.util.Scanner;

import com.interview.promoengine.exception.NotValidNumberException;
import com.interview.promoengine.exception.ProductNotFoundException;
import com.interview.promoengine.model.Product;

/**
 * Product service to handle all the operations for product
 * 
 *
 */

public interface ProductService {

	float getTotalPrice(List<Product> products);

	int getNumberOfProducts(Scanner scanner) throws NotValidNumberException;

	List<Product> getProductTypes(Scanner scanner, int noOfProduct, List<Product> products)
			throws ProductNotFoundException;
}
